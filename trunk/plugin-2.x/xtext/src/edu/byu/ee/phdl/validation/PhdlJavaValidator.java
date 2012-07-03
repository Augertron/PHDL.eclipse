package edu.byu.ee.phdl.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import com.google.inject.Inject;

import edu.byu.ee.phdl.phdl.Assignable;
import edu.byu.ee.phdl.phdl.Attr;
import edu.byu.ee.phdl.phdl.Concatenation;
import edu.byu.ee.phdl.phdl.Connection;
import edu.byu.ee.phdl.phdl.ConnectionAssign;
import edu.byu.ee.phdl.phdl.ConnectionName;
import edu.byu.ee.phdl.phdl.ConnectionRef;
import edu.byu.ee.phdl.phdl.Design;
import edu.byu.ee.phdl.phdl.DesignElement;
import edu.byu.ee.phdl.phdl.Device;
import edu.byu.ee.phdl.phdl.DeviceElement;
import edu.byu.ee.phdl.phdl.Import;
import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.NewAttr;
import edu.byu.ee.phdl.phdl.Package;
import edu.byu.ee.phdl.phdl.PhdlPackage;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PortAssign;
import edu.byu.ee.phdl.phdl.RefAttr;
import edu.byu.ee.phdl.phdl.RefTail;
import edu.byu.ee.phdl.phdl.SubAttr;
import edu.byu.ee.phdl.utils.PhdlUtils;

public class PhdlJavaValidator extends AbstractPhdlJavaValidator {

	@Inject
	IContainer.Manager containermanager;

	@Inject
	IResourceDescriptions resourceDescriptions;

	final String[] reqAttrs = { "REFPREFIX", "LIBRARY", "FOOTPRINT" };

	protected void checkAlreadyAssigned(String ref, EObject assign, Map<String, EObject> refs, EStructuralFeature feature) {
		if (refs.get(ref) != null) {
			error("'" + ref + "' already assigned.", assign, feature, -1, IssueCodes.ALREADY_ASSIGNED);
			error("Original assignment '" + ref + "'.", refs.get(ref), feature, -1, IssueCodes.ORIGINAL_ASSIGNMENT);
		} else
			refs.put(ref, assign);
	}

	protected void checkAlreadyAssigned(String instName, int index, Map<String, EObject> refs, EObject assign, EStructuralFeature feature) {
		String indices = "(" + index + ").";
		String ref;
		ref = (assign instanceof PinAssign) ? ((PinAssign) assign).getRef().getName() : ((PortAssign) assign).getRef().getName();
		checkAlreadyAssigned(instName + indices + ref, assign, refs, feature);
	}

	protected void checkAlreadyAssigned(String instName, int index, Map<String, EObject> refs, EObject assign, int slice,
			EStructuralFeature feature) {
		String indices = "(" + index + ").";
		String slices = "[" + slice + "]";
		String ref;
		ref = (assign instanceof PinAssign) ? ((PinAssign) assign).getRef().getName() : ((PortAssign) assign).getRef().getName();
		checkAlreadyAssigned(instName + indices + ref + slices, assign, refs, feature);
	}

	protected void checkAlreadyAssigned(String instName, Map<String, EObject> refs, EObject assign, EStructuralFeature feature) {
		String ref;
		ref = (assign instanceof PinAssign) ? ((PinAssign) assign).getRef().getName() : ((PortAssign) assign).getRef().getName();
		checkAlreadyAssigned(instName + "." + ref, assign, refs, feature);
	}

	protected void checkAlreadyAssigned(String instName, Map<String, EObject> refs, EObject assign, Integer slice,
			EStructuralFeature feature) {
		String slices = "[" + slice + "]";
		String ref;
		ref = (assign instanceof PinAssign) ? ((PinAssign) assign).getRef().getName() : ((PortAssign) assign).getRef().getName();
		checkAlreadyAssigned(instName + "." + ref + slices, assign, refs, feature);
	}

	@Check(CheckType.FAST)
	public void checkConcatenationReplications(Concatenation concat) {
		if (concat.isReplicated()) {
			ConnectionRef ref = concat.getReplicate();
			Connection con = (Connection) ref.getRef().eContainer();
			if (ref.getSlices() != null) {
				if (!con.getVector().isVector()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
					error("Array not declared.", ref, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
					return;
				}
				if (ref.getSlices().isVector()) {
					int msb = ref.getSlices().getMsb();
					int lsb = ref.getSlices().getLsb();
					if ((Math.abs(msb - lsb) + 1) != 1) {
						EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
						error("Cannot replicate array.", ref, f, -1, IssueCodes.CANNOT_REPLICATE_ARRAY);
					}
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), msb))
						invalidMsbError(ref.getSlices(), PhdlPackage.Literals.SLICES__MSB);
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), lsb))
						invalidLsbError(ref.getSlices(), PhdlPackage.Literals.SLICES__LSB);
				} else {
					if (ref.getSlices().getSlices().size() != 1) {
						EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
						error("Cannot replicate slices.", ref, f, -1, IssueCodes.CANNOT_REPLICATE_SLICES);
					}
					for (Integer i : ref.getSlices().getSlices()) {
						if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), i))
							invalidIndexError(ref.getSlices(), ref.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
					}
				}
			} else {
				if (con.getVector().isVector()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
					error("Cannot replicate array.", ref, f, -1, IssueCodes.CANNOT_REPLICATE_ARRAY);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkConnectionAssignWidths(ConnectionAssign assign) {

		Connection c = (Connection) assign.getRef().eContainer();
		if (assign.getSlices() != null) {
			if (!c.getVector().isVector()) {
				EStructuralFeature f = PhdlPackage.Literals.CONNECTION_ASSIGN__REF;
				error("Array not declared.", assign, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
				return;
			}
			if (assign.getSlices().isVector()) {
				if (!PhdlUtils.isValidIndex(c.getVector().getMsb(), c.getVector().getLsb(), assign.getSlices().getMsb()))
					invalidMsbError(assign.getSlices(), PhdlPackage.Literals.SLICES__MSB);
				if (!PhdlUtils.isValidIndex(c.getVector().getMsb(), c.getVector().getLsb(), assign.getSlices().getLsb()))
					invalidLsbError(assign.getSlices(), PhdlPackage.Literals.SLICES__LSB);
			} else {
				for (Integer i : assign.getSlices().getSlices())
					if (!PhdlUtils.isValidIndex(c.getVector().getMsb(), c.getVector().getLsb(), i))
						invalidIndexError(assign.getSlices(), assign.getSlices().getSlices().indexOf(i),
								PhdlPackage.Literals.SLICES__SLICES);
			}
		}

		if (assign.getConcatenation().isReplicated() || assign.getConcatenation().isOpen())
			return;

		int leftWidth = getAssignLeftWidth(assign);
		int rightWidth = 0;

		for (ConnectionRef ref : assign.getConcatenation().getConnections()) {
			Connection con = (Connection) ref.getRef().eContainer();
			if (ref.getSlices() != null) {
				if (!con.getVector().isVector()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
					error("Array not declared.", ref, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
					return;
				}
				if (ref.getSlices().isVector()) {
					int msb = ref.getSlices().getMsb();
					int lsb = ref.getSlices().getLsb();
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), msb))
						invalidMsbError(ref, PhdlPackage.Literals.SLICES__MSB);
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), lsb))
						invalidLsbError(ref, PhdlPackage.Literals.SLICES__LSB);
					rightWidth += Math.abs(msb - lsb) + 1;
				} else {
					for (Integer i : ref.getSlices().getSlices())
						if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), i))
							invalidIndexError(ref, ref.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
					rightWidth += ref.getSlices().getSlices().size();
				}
			} else {
				if (con.getVector().isVector())
					rightWidth += Math.abs(con.getVector().getMsb() - con.getVector().getLsb()) + 1;
				else
					rightWidth++;
			}
		}
		if (leftWidth != rightWidth) {
			EStructuralFeature f = PhdlPackage.Literals.DESIGN__ELEMENTS;
			int index = ((Design) assign.eContainer()).getElements().indexOf(assign);
			error("Assignment width mismatch.  Left=" + leftWidth + ", right=" + rightWidth + ".", assign.eContainer(), f, index,
					IssueCodes.ASSIGNMENT_WIDTH_MISMATCH, Integer.toString(index), Integer.toString(leftWidth),
					Integer.toString(rightWidth));
		}
	}

	@Check(CheckType.NORMAL)
	public void checkDesignConnectionDecls(Design d) {
		SortedMap<String, CountableConnection> cons = new TreeMap<String, CountableConnection>();
		for (DesignElement element : d.getElements()) {
			if (element instanceof Connection) {
				Connection c = (Connection) element;
				for (ConnectionName n : c.getNames()) {
					if (c.getVector().isVector())
						for (Integer i : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
							cons.put(n.getName() + "[" + i + "]", new CountableConnection(n, c.getNames().indexOf(n)));
					else
						cons.put(n.getName(), new CountableConnection(n, c.getNames().indexOf(n)));
				}
			}
		}

		for (DesignElement desElement : d.getElements()) {
			if (desElement instanceof Instance) {
				Instance i = (Instance) desElement;
				for (EObject instElement : i.getElements()) {
					if (instElement instanceof PinAssign) {
						PinAssign p = (PinAssign) instElement;
						incrementConnectionMap(i, p, cons);
					} else if (instElement instanceof PortAssign) {
						PortAssign p = (PortAssign) instElement;
						incrementConnectionMap(i, p, cons);
					}
				}
			}
		}

		// for (String name : cons.keySet())
		// System.out.println("key: " + name + ", value: [" + cons.get(name) +
		// "]");

		for (String name : cons.keySet()) {
			CountableConnection obj = cons.get(name);
			if (obj.getCount() == 0) {
				EStructuralFeature f = PhdlPackage.Literals.CONNECTION_NAME__NAME;
				int index = ((Connection) obj.getObject().eContainer()).getNames().indexOf(obj.getIndex());
				warning("Unused connection '" + name + "'", obj.getObject(), f, index, IssueCodes.UNUSED_CONNECTION_DECL);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkDesignForPorts(Design d) {
		if (d.isDesign()) {
			for (DesignElement element : d.getElements()) {
				if (element instanceof Connection && ((Connection) element).isPort()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION__PORT;
					error("Ports not allowed in designs.", element, f, -1, IssueCodes.PORT_NOT_ALLOWED);
				}
			}
		}
	}

	/**
	 * Checks the design hierarchy for cycles.
	 * 
	 * @param d The top-level design to check for cycles
	 * @return The list of paths of SubInstances that form cycles.
	 */
	@Check(CheckType.NORMAL)
	public List<List<Instance>> checkDesignHierarchy(Design d) {
		if (!d.isDesign())
			return null;
		List<List<Instance>> paths = new ArrayList<List<Instance>>();
		for (DesignElement element : d.getElements()) {
			if (element instanceof Instance && ((Instance) element).isSubInst()) {
				Instance i = (Instance) element;
				List<Instance> path = new ArrayList<Instance>();
				if (checkDesignHierarchyDFS(path, i))
					paths.add(path);
				else
					path = null;
			}
		}
		for (List<Instance> path : paths) {
			error("Hierarchy cycle detected.", d, PhdlPackage.Literals.DESIGN__NAME, -1);
			// System.out.print("Path(" + paths.indexOf(path) + "): ");
			// for (SubInstance s : path) {

			// FIXME This does not print out an error across file boundaries.
			// The solution might
			// be similar to checkUniqueDesignNames
			// error("SubInstance forms a hierarchy cycle.", s,
			// PhdlPackage.Literals.SUB_INSTANCE__SUB_DESIGN, -1);
			// System.out.print(s.getName() + " ");
			// }
			// System.out.println();
		}
		return paths;
	}

	private boolean checkDesignHierarchyDFS(List<Instance> path, Instance current) {
		path.add(current);
		for (DesignElement element : current.getSubDesign().getElements()) {
			if (element instanceof Instance && ((Instance) element).isSubInst()) {
				Instance i = (Instance) element;
				if (path.contains(i))
					return true;
				if (checkDesignHierarchyDFS(path, i))
					return true;
			}
		}
		path.remove(current);
		return false;
	}

	@Check(CheckType.NORMAL)
	public void checkDesignNameUnique(Design design) {
		List<Design> designs = new ArrayList<Design>();
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(design.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			for (IEObjectDescription eobjectDescription : container.getExportedObjects()) {
				EObject eObjectOrProxy = eobjectDescription.getEObjectOrProxy();
				if (eObjectOrProxy instanceof Design)
					designs.add((Design) eObjectOrProxy);
			}
		}

		int count = 0;
		for (Design d : designs) {
			if (d.eIsProxy())
				d = (Design) EcoreUtil.resolve(d, design);
			if (design.getName().equals(d.getName()))
				count++;
		}
		if (count > 1)
			error("Duplicate design in project.", PhdlPackage.Literals.DESIGN__NAME);
	}

	@Check(CheckType.FAST)
	public void checkDeviceAttributes(Device d) {
		for (DeviceElement element : d.getElements()) {
			if (element instanceof Attr) {
				Attr a = (Attr) element;
				if (!a.getName().toUpperCase().equals(a.getName()))
					warning("Only uppercase attribute names are recommended.", a, PhdlPackage.Literals.ATTR__NAME, -1,
							IssueCodes.NOT_UPPERCASE, a.getName());
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkDevicePhysicalPinNames(Device d) {
		Map<String, Pin> pinMap = new HashMap<String, Pin>();
		for (DeviceElement element : d.getElements()) {
			if (element instanceof Pin) {
				Pin p = (Pin) element;
				List<String> pinList = p.getPinNames();
				for (int i = 0; i < (pinList.size()); i++) {
					String pinNum = pinList.get(i);
					if (pinMap.containsKey(pinNum)) {
						EStructuralFeature f = PhdlPackage.Literals.PIN__PIN_NAMES;
						error("Duplicate physical pin name.", p, f, i);
						Pin orig = pinMap.get(pinNum);
						error("Duplicate physical pin name.", orig, f, orig.getPinNames().indexOf(pinNum));
					} else
						pinMap.put(pinNum, p);
				}
			}
		}
	}

	/**
	 * Checks that the appropriate quantity of pins in a device is declared, if the special PINCOUNT
	 * attribute has been declared in the device. If they do not match, an error is reported in the
	 * editor at the location of the PINCOUNT attribute.
	 * 
	 * @param d The current device to check
	 * @author Brad Riching
	 */
	@Check(CheckType.FAST)
	public void checkDevicePinCountAttribute(Device d) {
		for (DeviceElement element : d.getElements()) {
			if (element instanceof Attr) {
				Attr a = (Attr) element;
				if (a.getName().toUpperCase().equals("PINCOUNT")) {
					int pinCount = 0;
					try {
						pinCount = Integer.parseInt(a.getValue());
					} catch (NumberFormatException e) {
						EStructuralFeature f = PhdlPackage.Literals.ATTR__VALUE;
						error("PINCOUNT attribute must be an integer.", a, f, -1);
						return;
					}
					int numPins = 0;
					for (DeviceElement e : d.getElements()) {
						if (e instanceof Pin) {
							Pin p = (Pin) e;
							numPins += Math.abs(p.getVector().getMsb() - p.getVector().getLsb()) + 1;
						}
					}

					if (pinCount != numPins) {
						EStructuralFeature f = PhdlPackage.Literals.ATTR__NAME;
						error("Expected " + pinCount + " declared pins, found " + numPins + ".", a, f, -1);
					}
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkDevicePinDeclarations(Device d) {
		for (DeviceElement element : d.getElements()) {
			if (element instanceof Pin) {
				Pin p = (Pin) element;
				int index = d.getElements().indexOf(p);
				int width = (Math.abs(p.getVector().getMsb() - p.getVector().getLsb())) + 1;
				if (width != p.getPinNames().size())
					error("Invalid pin declaration.", d, PhdlPackage.Literals.DEVICE__ELEMENTS, d.getElements().indexOf(element),
							IssueCodes.INVALID_PIN_DECLARATION, Integer.toString(index), Boolean.toString(p.getVector().isVector()),
							Integer.toString(width), Integer.toString(p.getPinNames().size()));
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkDeviceRefPrefixAttribute(Device d) {
		for (DeviceElement element : d.getElements()) {
			if (element instanceof Attr) {
				Attr a = (Attr) element;
				if (a.getName().toUpperCase().equals("REFPREFIX")) {
					if (!a.getValue().toUpperCase().equals(a.getValue()))
						warning("Only uppercase REFPREFIX value recommended", a, PhdlPackage.Literals.ATTR__VALUE, -1);
				}
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkDeviceRequiredAttributes(Device d) {
		for (String reqAttr : reqAttrs) {
			boolean found = false;
			for (DeviceElement element : d.getElements()) {
				if (element instanceof Attr) {
					Attr a = (Attr) element;
					if (a.getName().toUpperCase().equals(reqAttr)) {
						found = true;
						break;
					}
				}
			}
			if (!found) {
				error("Required attribute '" + reqAttr + "' missing.", d, PhdlPackage.Literals.DEVICE__NAME, -1,
						IssueCodes.REQUIRED_ATTRIBUTE_MISSING, reqAttr);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkImports(Import i) {
		String namespace = i.getImportedNamespace();
		int index = namespace.indexOf('.');
		if (index < 0) {
			error("Invalid import.", i, PhdlPackage.Literals.IMPORT__IMPORTED_NAMESPACE, -1, IssueCodes.INVALID_IMPORT);
			return;
		}
		// System.out.println(0);
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(i.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			for (IEObjectDescription eobjectDescription : container.getExportedObjects()) {
				EObject eObjectOrProxy = eobjectDescription.getEObjectOrProxy();
				if (eObjectOrProxy instanceof Package) {
					Package p = (Package) eObjectOrProxy;
					if (p.eIsProxy()) {
						// System.out.println(p.getName() + " 1");
						p = (Package) EcoreUtil.resolve(p, i);
						// System.out.println(p.getName() + " 2");
					}
					if (i.getImportedNamespace().endsWith(".*")) {
						if (p.getName().equals(namespace.substring(0, index))) {
							// System.out.println(p.getName() + " 3");
							return;
						}
					} else {
						String importPackageName = namespace.substring(0, index);
						String importElementName = namespace.substring(namespace.indexOf('.') + 1);
						// System.out.println(importPackageName + " " + importElementName);
						if (p.getName().equals(importPackageName)) {
							for (Device d : p.getDevices())
								if (d.getName().equals(importElementName))
									return;
							for (Design d : p.getDesigns())
								if (d.getName().equals(importElementName))
									return;
						}
					}

				}
			}
		}
		error("Invalid import.", i, PhdlPackage.Literals.IMPORT__IMPORTED_NAMESPACE, -1, IssueCodes.INVALID_IMPORT);
	}

	@Check(CheckType.NORMAL)
	public void checkInstanceNewAttributes(Instance i) {
		if (i.isSubInst())
			return;
		SortedMap<String, EObject> attrs = new TreeMap<String, EObject>();
		// populate the maps with attributes from device definition and
		// initialize all overwritten attributes to false
		if (i.getArray().isArray()) {
			for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {
				for (DeviceElement element : i.getDevice().getElements()) {
					if (element instanceof Attr) {
						Attr a = (Attr) element;
						attrs.put(i.getName() + "(" + index + ")." + a.getName().toUpperCase(), a);
					}
				}
			}
			for (EObject element : i.getElements()) {
				if (element instanceof NewAttr) {
					NewAttr a = (NewAttr) element;
					if (!a.getName().equals(a.getName().toUpperCase()))
						warning("Only uppercase attribute names are recommended.", a, PhdlPackage.Literals.NEW_ATTR__NAME, -1,
								IssueCodes.NOT_UPPERCASE, a.getName());
					if (a.getQualifier() != null) {
						if (a.getQualifier().getIndices().isArray()) {
							int msb = a.getQualifier().getIndices().getMsb();
							int lsb = a.getQualifier().getIndices().getLsb();
							// check the msb
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
								invalidMsbError(a, PhdlPackage.Literals.INDICES__MSB);
							// check the lsb
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
								invalidLsbError(a, PhdlPackage.Literals.INDICES__LSB);
							// check for already declared attributes
							for (Integer index : PhdlUtils.getIndices(msb, lsb)) {
								String attr = i.getName() + "(" + index + ")." + a.getName().toUpperCase();
								if (attrs.get(attr) != null) {
									EStructuralFeature f = PhdlPackage.Literals.NEW_ATTR__NAME;
									error("Attribute already declared.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_DECLARED);
								} else
									attrs.put(attr, a);
							}
						} else { // !a.isArray()
							for (Integer index : a.getQualifier().getIndices().getIndices()) {
								// check all arbitrary indices
								if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), index))
									invalidIndexError(a.getQualifier().getIndices(),
											a.getQualifier().getIndices().getIndices().indexOf(index),
											PhdlPackage.Literals.INDICES__INDICES);
								// check for already declared attributes
								String attr = i.getName() + "(" + index + ")." + a.getName().toUpperCase();
								if (attrs.get(attr) != null) {
									EStructuralFeature f = PhdlPackage.Literals.NEW_ATTR__NAME;
									error("Attribute already declared.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_DECLARED);
								} else
									attrs.put(attr, a);
							}
						}
					} else { // !a.isQualified()
						for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {
							String attr = i.getName() + "(" + index + ")." + a.getName().toUpperCase();
							if (attrs.get(attr) != null) {
								EStructuralFeature f = PhdlPackage.Literals.NEW_ATTR__NAME;
								error("Attribute already declared.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_DECLARED);
							} else
								attrs.put(attr, a);
						}
					}
				}
			}
		} else { // !i.isArray()
			for (DeviceElement element : i.getDevice().getElements()) {
				if (element instanceof Attr) {
					Attr a = (Attr) element;
					attrs.put(i.getName() + "." + a.getName().toUpperCase(), a);
				}
			}
			for (EObject element : i.getElements()) {
				if (element instanceof NewAttr) {
					NewAttr a = (NewAttr) element;
					if (!a.getName().equals(a.getName().toUpperCase()))
						warning("Only uppercase attribute names are recommended.", a, PhdlPackage.Literals.NEW_ATTR__NAME, -1,
								IssueCodes.NOT_UPPERCASE, a.getName());
					if (a.getQualifier() != null)
						qualifierNotAllowedError(a, PhdlPackage.Literals.NEW_ATTR__QUALIFIER);
					String attr = i.getName() + "." + a.getName().toUpperCase();
					if (attrs.get(attr) != null) {
						EStructuralFeature f = PhdlPackage.Literals.NEW_ATTR__NAME;
						error("Attribute already declared.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_DECLARED);
					} else
						attrs.put(attr, a);
				}
			}
		}
	}

	/**
	 * Checks that all pins inside each instance have exactly one and only one assignment. The check
	 * is performed with the aid of a map consisting of PinAssigns, keyed by their expected name
	 * from the device declaration. The name key strings are formed by the instance name, its index
	 * (if it exists), a period separator, the PinAssign name, and pin slices (if the pin is
	 * declared as an array in the device.) After the map is initialized, each pin is added to the
	 * map if the place-holder value was initially null. If the place-holder value contains a
	 * reference to a PinAssign, then the pin has been assigned twice, and an error is reported.
	 * After all pins have been added to the map, the map keyset is iterated over. If any values are
	 * null, those pins are reported with errors as not assigned.
	 * 
	 * @param i The current instance to check
	 * @see #checkAlreadyAssigned(String, EObject, Map, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, Map, EObject, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, int, Map, EObject, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, Map, EObject, Integer, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, int, Map, EObject, int, EStructuralFeature)
	 * @author Brad Riching
	 */
	@Check(CheckType.NORMAL)
	public void checkInstancePinAssigns(Instance i) {
		if (i.isSubInst())
			return;
		EStructuralFeature pFeature = PhdlPackage.Literals.PIN_ASSIGN__REF;
		EStructuralFeature iFeature = PhdlPackage.Literals.INSTANCE__NAME;
		if (i.getArray().isArray()) {
			for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {

				// A new map is constructed for each instance, keyed with names
				// of expected pins and all values initialized to null.
				SortedMap<String, EObject> pins = new TreeMap<String, EObject>();
				for (DeviceElement element : i.getDevice().getElements()) {
					if (element instanceof Pin) {
						Pin p = (Pin) element;
						for (Integer slice : PhdlUtils.getIndices(p.getVector().getMsb(), p.getVector().getLsb()))
							if (p.getVector().isVector())
								pins.put(i.getName() + "(" + index + ")." + p.getName() + "[" + slice + "]", null);
							else
								pins.put(i.getName() + "(" + index + ")." + p.getName(), null);
					}
				}

				for (EObject element : i.getElements()) {
					if (element instanceof PinAssign) {
						PinAssign p = (PinAssign) element;
						if (p.getQualifier() != null) {
							if (p.getQualifier().getIndices().isArray()) {
								if (PhdlUtils.isValidIndex(p.getQualifier().getIndices().getMsb(), p.getQualifier().getIndices().getLsb(),
										index)) {
									if (p.getSlices() != null) {
										if (p.getSlices().isVector()) {
											if (p.getRef().getVector().isVector())
												for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
													checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
										} else { // !p.isSliceArrayed()
											if (p.getRef().getVector().isVector())
												for (Integer slice : p.getSlices().getSlices())
													checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
										}
									} else { // !p.isSliced()
										if (p.getRef().getVector().isVector())
											for (Integer slice : PhdlUtils.getIndices(p.getRef().getVector().getMsb(), p.getRef()
													.getVector().getLsb()))
												checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
										else
											checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
									}
								}
							} else { // !p.isQualArrayed()
								if (p.getQualifier().getIndices().getIndices().contains(index)) {
									if (p.getSlices() != null) {
										if (p.getSlices().isVector()) {
											if (p.getRef().getVector().isVector())
												for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
													checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
										} else { // !p.isSliceArrayed()
											if (p.getRef().getVector().isVector())
												for (Integer slice : p.getSlices().getSlices())
													checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
										}
									} else { // !p.isSliced()
										if (p.getRef().getVector().isVector())
											for (Integer slice : PhdlUtils.getIndices(p.getRef().getVector().getMsb(), p.getRef()
													.getVector().getLsb()))
												checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
										else
											checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
									}
								}
							}
						} else { // !p.isQualified()
							if (p.getSlices() != null) {
								if (p.getSlices().isVector()) {
									if (p.getRef().getVector().isVector())
										for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
											checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
									else
										checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
								} else {
									if (p.getRef().getVector().isVector())
										for (Integer slice : p.getSlices().getSlices())
											checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
									else
										checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
								}
							} else { // !p.isSliced()
								if (p.getRef().getVector().isVector())
									for (Integer slice : PhdlUtils.getIndices(p.getRef().getVector().getMsb(), p.getRef().getVector()
											.getLsb()))
										checkAlreadyAssigned(i.getName(), index, pins, p, slice, pFeature);
								else
									checkAlreadyAssigned(i.getName(), index, pins, p, pFeature);
							}
						}
					}
				}
				for (String pin : pins.keySet())
					if (pins.get(pin) == null)
						error("Unassigned pin '" + pin + "'.", i, iFeature, -1, IssueCodes.UNASSIGNED_PIN, pin);
			}
		} else { // !i.isArray()
			SortedMap<String, EObject> pins = new TreeMap<String, EObject>();
			for (DeviceElement element : i.getDevice().getElements()) {
				if (element instanceof Pin) {
					Pin p = (Pin) element;
					for (Integer slice : PhdlUtils.getIndices(p.getVector().getMsb(), p.getVector().getLsb()))
						if (p.getVector().isVector())
							pins.put(i.getName() + "." + p.getName() + "[" + slice + "]", null);
						else
							pins.put(i.getName() + "." + p.getName(), null);
				}
			}
			for (EObject element : i.getElements()) {
				if (element instanceof PinAssign) {
					PinAssign p = (PinAssign) element;
					if (p.getSlices() != null) {
						if (p.getSlices().isVector()) {
							if (p.getRef().getVector().isVector()) {
								for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
									checkAlreadyAssigned(i.getName(), pins, p, slice, pFeature);
							} else
								checkAlreadyAssigned(i.getName(), pins, p, pFeature);
						} else { // !p.isSliceArrayed()
							if (p.getRef().getVector().isVector()) {
								for (Integer slice : p.getSlices().getSlices())
									checkAlreadyAssigned(i.getName(), pins, p, slice, pFeature);
							} else
								checkAlreadyAssigned(i.getName(), pins, p, pFeature);
						}
					} else {
						if (p.getRef().getVector().isVector()) {
							for (Integer slice : PhdlUtils.getIndices(p.getRef().getVector().getMsb(), p.getRef().getVector().getLsb()))
								checkAlreadyAssigned(i.getName(), pins, p, slice, pFeature);
						} else
							checkAlreadyAssigned(i.getName(), pins, p, pFeature);
					}
				}
			}
			for (String pin : pins.keySet())
				if (pins.get(pin) == null)
					error("Unassigned pin '" + pin + "'.", i, iFeature, -1, IssueCodes.UNASSIGNED_PIN, pin);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkInstanceRefAttributes(Instance i) {
		if (i.isSubInst())
			return;
		SortedMap<String, RefAttr> attrs = new TreeMap<String, RefAttr>();
		if (i.getArray().isArray()) {
			for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {
				for (DeviceElement element : i.getDevice().getElements()) {
					if (element instanceof Attr) {
						Attr a = (Attr) element;
						attrs.put(i.getName() + "(" + index + ")." + a.getName(), null);
					}
				}
			}
			for (EObject element : i.getElements()) {
				if (element instanceof RefAttr) {
					RefAttr a = (RefAttr) element;
					if (a.getQualifier() != null) {
						if (a.getQualifier().getIndices().isArray()) {
							// check the msb
							int msb = a.getQualifier().getIndices().getMsb();
							int lsb = a.getQualifier().getIndices().getLsb();
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
								invalidMsbError(a, PhdlPackage.Literals.INDICES__MSB);
							// check the lsb
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
								invalidLsbError(a, PhdlPackage.Literals.INDICES__LSB);
							// check for already overwritten attributes
							for (Integer index : PhdlUtils.getIndices(msb, lsb)) {
								String attr = i.getName() + "(" + index + ")." + a.getRef().getName();
								if (attrs.get(attr) != null) {
									EStructuralFeature f = PhdlPackage.Literals.REF_ATTR__REF;
									warning("Attribute '" + attr + "' already overwritten.", a, f, -1,
											IssueCodes.ATTRIBUTE_ALREADY_OVERWRITTEN);
									warning("Initial overwritten attribute '" + attr + "'.", attrs.get(attr), f, -1,
											IssueCodes.INITIAL_OVERWRITTEN_ATTRIBUTE);
								} else
									attrs.put(attr, a);
							}
						} else { // !a.isArray()
							for (Integer index : a.getQualifier().getIndices().getIndices()) {
								// check all arbitrary indices
								if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), index))
									invalidIndexError(a, a.getQualifier().getIndices().getIndices().indexOf(index),
											PhdlPackage.Literals.INDICES__INDICES);
								// check for already overwritten attributes
								String attr = i.getName() + "(" + index + ")." + a.getRef().getName();
								if (attrs.get(attr) != null) {
									EStructuralFeature f = PhdlPackage.Literals.REF_ATTR__REF;
									warning("Attribute '" + attr + "' already overwritten.", a, f, -1,
											IssueCodes.ATTRIBUTE_ALREADY_OVERWRITTEN);
									warning("Initial overwritten attribute '" + attr + "'.", attrs.get(attr), f, -1,
											IssueCodes.INITIAL_OVERWRITTEN_ATTRIBUTE);
								} else
									attrs.put(attr, a);
							}
						}
					} else { // !a.isQualified()
						for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {
							String attr = i.getName() + "(" + index + ")." + a.getRef().getName();
							if (attrs.get(attr) != null) {
								EStructuralFeature f = PhdlPackage.Literals.REF_ATTR__REF;
								warning("Attribute '" + attr + "' already overwritten.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_OVERWRITTEN);
								warning("Initial overwritten attribute '" + attr + "'.", attrs.get(attr), f, -1,
										IssueCodes.INITIAL_OVERWRITTEN_ATTRIBUTE);
							} else
								attrs.put(attr, a);
						}
					}
				}
			}

		} else { // !i.isArray()
			for (DeviceElement element : i.getDevice().getElements()) {
				if (element instanceof Attr) {
					Attr a = (Attr) element;
					attrs.put(i.getName() + "." + a.getName(), null);
				}
			}
			for (EObject element : i.getElements()) {
				if (element instanceof RefAttr) {
					RefAttr a = (RefAttr) element;
					if (a.getQualifier() != null)
						qualifierNotAllowedError(a, PhdlPackage.Literals.REF_ATTR__QUALIFIER);
					String attr = i.getName() + "." + a.getRef().getName();
					if (attrs.get(attr) != null) {
						EStructuralFeature f = PhdlPackage.Literals.REF_ATTR__REF;
						warning("Attribute '" + attr + "' already overwritten.", a, f, -1, IssueCodes.ATTRIBUTE_ALREADY_OVERWRITTEN);
						warning("Initial overwritten attribute '" + attr + "'.", attrs.get(attr), f, -1,
								IssueCodes.INITIAL_OVERWRITTEN_ATTRIBUTE);
					} else
						attrs.put(attr, a);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkPackageNameUnique(Package pkg) {
		List<Package> packages = new ArrayList<Package>();
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(pkg.eResource().getURI());
		List<IContainer> visiblecontainers = containermanager.getVisibleContainers(resourceDescription, resourceDescriptions);
		for (IContainer container : visiblecontainers) {
			for (IEObjectDescription eobjectDescription : container.getExportedObjects()) {
				EObject eObjectOrProxy = eobjectDescription.getEObjectOrProxy();
				if (eObjectOrProxy instanceof Package)
					packages.add((Package) eObjectOrProxy);
			}
		}
		int count = 0;
		for (Package p : packages) {
			if (p.eIsProxy())
				p = (Package) EcoreUtil.resolve(p, pkg);
			if (pkg.getName().equals(p.getName()))
				count++;
		}
		if (count > 1)
			error("Duplicate package in project.", PhdlPackage.Literals.PACKAGE__NAME);
	}

	@Check(CheckType.FAST)
	public void checkPinAssignQualifiers(PinAssign p) {
		Instance i = (Instance) p.eContainer();
		if (i.getArray().isArray()) {
			if (p.getQualifier() != null) {
				if (p.getQualifier().getIndices().isArray()) {
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), p.getQualifier().getIndices().getMsb()))
						invalidMsbError(p.getQualifier().getIndices(), PhdlPackage.Literals.INDICES__MSB);
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), p.getQualifier().getIndices().getLsb()))
						invalidLsbError(p.getQualifier().getIndices(), PhdlPackage.Literals.INDICES__LSB);
				} else {
					for (Integer index : p.getQualifier().getIndices().getIndices())
						if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), index))
							invalidIndexError(p.getQualifier().getIndices(), p.getQualifier().getIndices().getIndices().indexOf(index),
									PhdlPackage.Literals.INDICES__INDICES);
				}
			}
		} else {
			if (p.getQualifier() != null)
				qualifierNotAllowedError(p, PhdlPackage.Literals.PIN_ASSIGN__QUALIFIER);
		}
	}

	@Check(CheckType.FAST)
	public void checkPinAssignWidths(PinAssign p) {

		Pin pin = p.getRef();
		if (p.getSlices() != null) {
			if (!pin.getVector().isVector()) {
				EStructuralFeature f = PhdlPackage.Literals.PIN_ASSIGN__REF;
				error("Array not declared.", p, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
				return;
			}
			if (p.getSlices().isVector()) {
				if (!PhdlUtils.isValidIndex(pin.getVector().getMsb(), pin.getVector().getLsb(), p.getSlices().getMsb()))
					invalidMsbError(p.getSlices(), PhdlPackage.Literals.SLICES__MSB);
				if (!PhdlUtils.isValidIndex(pin.getVector().getMsb(), pin.getVector().getLsb(), p.getSlices().getLsb()))
					invalidLsbError(p.getSlices(), PhdlPackage.Literals.SLICES__LSB);
			} else {
				for (Integer i : p.getSlices().getSlices())
					if (!PhdlUtils.isValidIndex(pin.getVector().getMsb(), pin.getVector().getLsb(), i))
						invalidIndexError(p.getSlices(), p.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
			}
		}

		if (p.getConcatenation().isReplicated() || p.getConcatenation().isOpen())
			return;

		int leftWidth = getAssignLeftWidth(p);
		int rightWidth = 0;

		for (ConnectionRef ref : p.getConcatenation().getConnections()) {
			Connection con = (Connection) ref.getRef().eContainer();
			if (ref.getSlices() != null) {
				if (!con.getVector().isVector()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
					error(".", ref, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
					return;
				}
				if (ref.getSlices().isVector()) {
					int msb = ref.getSlices().getMsb();
					int lsb = ref.getSlices().getLsb();
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), msb))
						invalidMsbError(ref, PhdlPackage.Literals.SLICES__MSB);
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), lsb))
						invalidLsbError(ref, PhdlPackage.Literals.SLICES__LSB);
					rightWidth += Math.abs(msb - lsb) + 1;
				} else {
					for (Integer i : ref.getSlices().getSlices())
						if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), i))
							invalidSliceError(ref.getSlices(), ref.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
					rightWidth += ref.getSlices().getSlices().size();
				}
			} else {
				if (con.getVector().isVector())
					rightWidth += Math.abs(con.getVector().getMsb() - con.getVector().getLsb()) + 1;
				else
					rightWidth++;
			}
		}
		if (leftWidth != rightWidth) {
			EStructuralFeature f = PhdlPackage.Literals.INSTANCE__ELEMENTS;
			int index = ((Instance) p.eContainer()).getElements().indexOf(p);
			error("Assignment width mismatch.  Left=" + leftWidth + ", right=" + rightWidth + ".", p.eContainer(), f, index,
					IssueCodes.ASSIGNMENT_WIDTH_MISMATCH, Integer.toString(index), Integer.toString(leftWidth),
					Integer.toString(rightWidth));
		}
	}

	@Check(CheckType.FAST)
	public void checkPortAssignQualifiers(PortAssign p) {
		Instance i = (Instance) p.eContainer();
		if (i.getArray().isArray()) {
			if (p.getQualifier() != null) {
				if (p.getQualifier().getIndices().isArray()) {
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), p.getQualifier().getIndices().getMsb()))
						invalidMsbError(p.getQualifier().getIndices(), PhdlPackage.Literals.INDICES__MSB);
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), p.getQualifier().getIndices().getLsb()))
						invalidLsbError(p.getQualifier().getIndices(), PhdlPackage.Literals.INDICES__LSB);
				} else {
					for (Integer index : p.getQualifier().getIndices().getIndices())
						if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), index))
							invalidIndexError(p.getQualifier().getIndices(), p.getQualifier().getIndices().getIndices().indexOf(index),
									PhdlPackage.Literals.INDICES__INDICES);
				}
			}
		} else {
			if (p.getQualifier() != null)
				qualifierNotAllowedError(p, PhdlPackage.Literals.PORT_ASSIGN__QUALIFIER);
		}
	}

	@Check(CheckType.FAST)
	public void checkPortAssignWidth(PortAssign p) {

		Connection port = (Connection) p.getRef().eContainer();
		if (p.getSlices() != null) {
			if (!port.getVector().isVector()) {
				EStructuralFeature f = PhdlPackage.Literals.PORT_ASSIGN__REF;
				error("Array not declared.", p, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
				return;
			}
			if (p.getSlices().isVector()) {
				if (!PhdlUtils.isValidIndex(port.getVector().getMsb(), port.getVector().getLsb(), p.getSlices().getMsb()))
					invalidMsbError(p.getSlices(), PhdlPackage.Literals.SLICES__MSB);
				if (!PhdlUtils.isValidIndex(port.getVector().getMsb(), port.getVector().getLsb(), p.getSlices().getLsb()))
					invalidLsbError(p.getSlices(), PhdlPackage.Literals.SLICES__LSB);
			} else {
				for (Integer i : p.getSlices().getSlices())
					if (!PhdlUtils.isValidIndex(port.getVector().getMsb(), port.getVector().getLsb(), i))
						invalidIndexError(p.getSlices(), p.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
			}
		}

		if (p.getConcatenation().isReplicated() || p.getConcatenation().isOpen())
			return;

		int leftWidth = getAssignLeftWidth(p);
		int rightWidth = 0;

		for (ConnectionRef ref : p.getConcatenation().getConnections()) {
			Connection con = (Connection) ref.getRef().eContainer();
			if (ref.getSlices() != null) {
				if (!con.getVector().isVector()) {
					EStructuralFeature f = PhdlPackage.Literals.CONNECTION_REF__REF;
					error("Array not declared.", ref, f, -1, IssueCodes.ARRAY_NOT_DECLARED);
					return;
				}
				if (ref.getSlices().isVector()) {
					int msb = ref.getSlices().getMsb();
					int lsb = ref.getSlices().getLsb();
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), msb))
						invalidMsbError(ref, PhdlPackage.Literals.SLICES__MSB);
					if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), lsb))
						invalidLsbError(ref, PhdlPackage.Literals.SLICES__LSB);
					rightWidth += Math.abs(msb - lsb) + 1;
				} else {
					for (Integer i : ref.getSlices().getSlices())
						if (!PhdlUtils.isValidIndex(con.getVector().getMsb(), con.getVector().getLsb(), i))
							invalidIndexError(ref, ref.getSlices().getSlices().indexOf(i), PhdlPackage.Literals.SLICES__SLICES);
					rightWidth += ref.getSlices().getSlices().size();
				}
			} else {
				if (con.getVector().isVector())
					rightWidth += Math.abs(con.getVector().getMsb() - con.getVector().getLsb()) + 1;
				else
					rightWidth++;
			}
		}
		if (leftWidth != rightWidth) {
			EStructuralFeature f = PhdlPackage.Literals.INSTANCE__ELEMENTS;
			int index = ((Instance) p.eContainer()).getElements().indexOf(p);
			error("Assignment width mismatch.  Left=" + leftWidth + ", right=" + rightWidth + ".", p.eContainer(), f, index,
					IssueCodes.ASSIGNMENT_WIDTH_MISMATCH, Integer.toString(index), Integer.toString(leftWidth),
					Integer.toString(rightWidth));
		}
	}

	@Check(CheckType.FAST)
	public void checkRefTails(RefTail r) {
		if (r.getTail() == null) {
			if (!(r.getRef() instanceof Attr || r.getRef() instanceof RefAttr || r.getRef() instanceof NewAttr)) {
				EStructuralFeature f = PhdlPackage.Literals.REF_TAIL__REF;
				error("Invalid attribute name.", r, f, -1);
			}
		}

		if (r.getRef() instanceof Instance && ((Instance) r.getRef()).isInst()) {
			Instance i = (Instance) r.getRef();
			if (r.getRefIndices() != null && i.getArray().isArray()) {
				if (r.getRefIndices().isArray()) {
					int msb = r.getRefIndices().getMsb();
					int lsb = r.getRefIndices().getLsb();
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
						invalidMsbError(r, PhdlPackage.Literals.INDICES__MSB);
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
						invalidLsbError(r, PhdlPackage.Literals.INDICES__LSB);
				} else {
					for (Integer j : r.getRefIndices().getIndices())
						if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), j))
							invalidIndexError(r.getRefIndices(), r.getRefIndices().getIndices().indexOf(j),
									PhdlPackage.Literals.INDICES__INDICES);
				}
			} else if (r.getRefIndices() != null && !i.getArray().isArray())
				indicesNotAllowedError(r.getRefIndices(), PhdlPackage.Literals.INDICES__INDICES);
		} else if (r.getRef() instanceof Instance && ((Instance) r.getRef()).isSubInst()) {
			Instance i = (Instance) r.getRef();
			if (r.getRefIndices() != null && i.getArray().isArray()) {
				if (r.getRefIndices().isArray()) {
					int msb = r.getRefIndices().getMsb();
					int lsb = r.getRefIndices().getLsb();
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
						invalidMsbError(r, PhdlPackage.Literals.INDICES__MSB);
					if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
						invalidLsbError(r, PhdlPackage.Literals.INDICES__LSB);
				} else {
					for (Integer j : r.getRefIndices().getIndices())
						if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), j))
							invalidIndexError(r, r.getRefIndices().getIndices().indexOf(j), PhdlPackage.Literals.INDICES__INDICES);
				}
			} else if (r.getRefIndices() != null && !i.getArray().isArray())
				indicesNotAllowedError(r.getRefIndices(), PhdlPackage.Literals.INDICES__INDICES);
		} else {
			if (r.getRefIndices() != null)
				indicesNotAllowedError(r, PhdlPackage.Literals.REF_TAIL__REF);
		}
	}

	@Check(CheckType.NORMAL)
	public void checkSubInstanceAttributes(Instance s) {
		for (EObject element : s.getElements()) {
			// check all sub attributes
			if (element instanceof SubAttr) {
				SubAttr a = (SubAttr) element;
				if (a.getQualifier() != null && s.getArray().isArray()) {
					if (a.getQualifier().getIndices().isArray()) {
						int msb = a.getQualifier().getIndices().getMsb();
						int lsb = a.getQualifier().getIndices().getLsb();
						if (!PhdlUtils.isValidIndex(s.getArray().getMsb(), s.getArray().getLsb(), msb))
							invalidMsbError(a, PhdlPackage.Literals.INDICES__MSB);
						if (!PhdlUtils.isValidIndex(s.getArray().getMsb(), s.getArray().getLsb(), lsb))
							invalidLsbError(a, PhdlPackage.Literals.INDICES__LSB);
					} else {
						for (Integer i : a.getQualifier().getIndices().getIndices())
							if (!PhdlUtils.isValidIndex(s.getArray().getMsb(), s.getArray().getLsb(), i))
								invalidIndexError(a.getQualifier().getIndices(), a.getQualifier().getIndices().getIndices().indexOf(i),
										PhdlPackage.Literals.INDICES__INDICES);
					}
				} else if (a.getQualifier() != null && !s.getArray().isArray())
					qualifierNotAllowedError(a, PhdlPackage.Literals.SUB_ATTR__QUALIFIER);

				if (a.getRef() instanceof Instance && ((Instance) a.getRef()).isInst()) {
					Instance i = (Instance) a.getRef();
					if (a.getRefIndices() != null && i.getArray().isArray()) {
						if (a.getRefIndices().isArray()) {
							int msb = a.getRefIndices().getMsb();
							int lsb = a.getRefIndices().getLsb();
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
								invalidMsbError(a, PhdlPackage.Literals.INDICES__MSB);
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
								invalidLsbError(a, PhdlPackage.Literals.INDICES__LSB);
						} else {
							for (Integer j : a.getRefIndices().getIndices())
								if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), j))
									invalidIndexError(a, a.getRefIndices().getIndices().indexOf(j), PhdlPackage.Literals.INDICES__INDICES);
						}
					} else if (a.getRefIndices() != null && !i.getArray().isArray())
						indicesNotAllowedError(a.getRefIndices(), PhdlPackage.Literals.INDICES__INDICES);
				} else if (a.getRef() instanceof Instance && ((Instance) a.getRef()).isSubInst()) {
					Instance i = (Instance) a.getRef();
					if (a.getRefIndices() != null && i.getArray().isArray()) {
						if (a.getRefIndices().isArray()) {
							int msb = a.getRefIndices().getMsb();
							int lsb = a.getRefIndices().getLsb();
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), msb))
								invalidMsbError(a, PhdlPackage.Literals.INDICES__MSB);
							if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), lsb))
								invalidLsbError(a, PhdlPackage.Literals.INDICES__LSB);
						} else {
							for (Integer j : a.getRefIndices().getIndices())
								if (!PhdlUtils.isValidIndex(i.getArray().getMsb(), i.getArray().getLsb(), j))
									invalidIndexError(a.getRefIndices(), a.getRefIndices().getIndices().indexOf(j),
											PhdlPackage.Literals.INDICES__INDICES);
						}
					} else if (a.getRefIndices() != null && !i.getArray().isArray())
						indicesNotAllowedError(a.getRefIndices(), PhdlPackage.Literals.INDICES__INDICES);
				}
			}
		}
	}

	@Check(CheckType.NORMAL)
	public void checkSubInstanceIsTop(Instance s) {
		if (s.getSubDesign().isDesign()) {
			EStructuralFeature f = PhdlPackage.Literals.INSTANCE__SUB_DESIGN;
			error("Cannot instance a top-level design.", s, f, -1);
		}
	}

	/**
	 * Checks that all ports inside each SubInstance have exactly one and only one assignment. The
	 * check is performed with the aid of a map consisting of PortAssigns, keyed by their expected
	 * name * from the device declaration. The name key strings are formed by the SubInstance name,
	 * its index (if it exists), a period separator, the PortAssign name, and port slices (if the
	 * port is declared as an array in the design.) After the map is initialized, each port is added
	 * to the map if the place-holder value was initially null. If the place-holder value contains a
	 * reference to a PortAssign, then the port has been assigned twice, and an error is reported.
	 * After all ports have been added to the map, the map keyset is iterated over. If any values
	 * are null, those pins are reported with errors as not assigned.
	 * 
	 * @param i The current instance to check
	 * @see #checkAlreadyAssigned(String, EObject, Map, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, Map, EObject, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, int, Map, EObject, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, Map, EObject, Integer, EStructuralFeature)
	 * @see #checkAlreadyAssigned(String, int, Map, EObject, int, EStructuralFeature)
	 * @author Brad Riching
	 */
	@Check(CheckType.NORMAL)
	public void checkSubInstancePortAssigns(Instance i) {
		if (i.isInst())
			return;
		EStructuralFeature pFeature = PhdlPackage.Literals.PORT_ASSIGN__REF;
		EStructuralFeature iFeature = PhdlPackage.Literals.INSTANCE__NAME;
		if (i.getArray().isArray()) {
			for (Integer index : PhdlUtils.getIndices(i.getArray().getMsb(), i.getArray().getLsb())) {

				// A new map is constructed for each instance, keyed with names
				// of expected pins and all values initialized to null.
				Map<String, EObject> ports = new HashMap<String, EObject>();
				for (DesignElement element : i.getSubDesign().getElements()) {

					if (element instanceof Connection && ((Connection) element).isPort()) {
						Connection connection = (Connection) element;
						for (ConnectionName name : connection.getNames()) {
							for (Integer slice : PhdlUtils.getIndices(connection.getVector().getMsb(), connection.getVector().getLsb()))
								if (connection.getVector().isVector())
									ports.put(i.getName() + "(" + index + ")." + name.getName() + "[" + slice + "]", null);
								else
									ports.put(i.getName() + "(" + index + ")." + name.getName(), null);
						}
					}
				}

				for (EObject element : i.getElements()) {
					if (element instanceof PortAssign) {
						PortAssign p = (PortAssign) element;
						Connection c = (Connection) p.getRef().eContainer();
						if (p.getQualifier() != null) {
							if (p.getQualifier().getIndices().isArray()) {
								if (PhdlUtils.isValidIndex(p.getQualifier().getIndices().getMsb(), p.getQualifier().getIndices().getLsb(),
										index)) {
									if (p.getSlices() != null) {
										if (p.getSlices().isVector()) {
											if (c.getVector().isVector())
												for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
													checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
										} else { // !p.isSliceArrayed()
											if (c.getVector().isVector())
												for (Integer slice : p.getSlices().getSlices())
													checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
										}
									} else { // !p.isSliced()
										if (((Connection) p.getRef().eContainer()).getVector().isVector())
											for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
												checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
										else
											checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
									}
								}
							} else { // !p.isQualArrayed()
								if (p.getQualifier().getIndices().getIndices().contains(index)) {
									if (p.getSlices() != null) {
										if (p.getSlices().isVector()) {
											if (c.getVector().isVector())
												for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
													checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
										} else { // !p.isSliceArrayed()
											if (c.getVector().isVector())
												for (Integer slice : p.getSlices().getSlices())
													checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
											else
												checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
										}
									} else { // !p.isSliced()
										if (c.getVector().isVector())
											for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
												checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
										else
											checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
									}
								}
							}
						} else { // !p.isQualified()
							if (p.getSlices() != null) {
								if (p.getSlices().isVector()) {
									if (c.getVector().isVector())
										for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
											checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
									else
										checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
								} else { // !p.isSliceArrayed()
									if (c.getVector().isVector())
										for (Integer slice : p.getSlices().getSlices())
											checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
									else
										checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
								}
							} else { // !p.isSliced()
								if (c.getVector().isVector())
									for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
										checkAlreadyAssigned(i.getName(), index, ports, p, slice, pFeature);
								else
									checkAlreadyAssigned(i.getName(), index, ports, p, pFeature);
							}
						}
					}
				}
				for (String port : ports.keySet())
					if (ports.get(port) == null)
						error("Unassigned port '" + port + "'.", i, iFeature, -1, IssueCodes.UNASSIGNED_PORT);
			}
		} else { // the sub instance is not an array
			SortedMap<String, EObject> ports = new TreeMap<String, EObject>();
			for (DesignElement element : i.getSubDesign().getElements()) {
				if (element instanceof Connection && ((Connection) element).isPort()) {
					Connection c = (Connection) element;
					for (ConnectionName name : c.getNames()) {
						for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
							if (c.getVector().isVector())
								ports.put(i.getName() + "." + name.getName() + "[" + slice + "]", null);
							else
								ports.put(i.getName() + "." + name.getName(), null);
					}
				}
			}

			for (EObject element : i.getElements()) {
				if (element instanceof PortAssign) {
					PortAssign p = (PortAssign) element;
					Connection c = (Connection) p.getRef().eContainer();
					if (p.getSlices() != null) {
						if (p.getSlices().isVector()) {
							if (c.getVector().isVector()) {
								for (Integer slice : PhdlUtils.getIndices(p.getSlices().getMsb(), p.getSlices().getLsb()))
									checkAlreadyAssigned(i.getName(), ports, p, slice, pFeature);
							} else
								checkAlreadyAssigned(i.getName(), ports, p, pFeature);
						} else { // !p.isSliceArrayed()
							if (c.getVector().isVector()) {
								for (Integer slice : p.getSlices().getSlices())
									checkAlreadyAssigned(i.getName(), ports, p, slice, pFeature);
							} else
								checkAlreadyAssigned(i.getName(), ports, p, pFeature);
						}
					} else {
						if (c.getVector().isVector()) {
							for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb()))
								checkAlreadyAssigned(i.getName(), ports, p, slice, pFeature);
						} else
							checkAlreadyAssigned(i.getName(), ports, p, pFeature);
					}
				}
			}
			for (String port : ports.keySet())
				if (ports.get(port) == null)
					error("Unassigned port '" + port + "'.", i, iFeature, -1, IssueCodes.UNASSIGNED_PORT);
		}
	}

	private int getAssignLeftWidth(Assignable assignable) {

		// Connection assignments are not part of an instance context, and width is easy to compute.
		if (assignable instanceof ConnectionAssign) {
			ConnectionAssign assignment = (ConnectionAssign) assignable;
			Connection connDecl = (Connection) assignment.getRef().eContainer();
			if (assignment.getSlices() != null) {
				if (assignment.getSlices().isVector())
					return (Math.abs(assignment.getSlices().getMsb() - assignment.getSlices().getLsb() + 1));
				else
					return assignment.getSlices().getSlices().size();
			} else {
				if (connDecl.getVector().isVector())
					return Math.abs(connDecl.getVector().getMsb() - connDecl.getVector().getLsb() + 1);
				else
					return 1;
			}
		}

		// obtain relevant flags and information from the pin or port assignments
		int numInsts = 0;
		boolean isQualified = false;
		boolean isCombined = false;
		boolean isVector = false;
		Indices indices = null;
		int msb = 0, lsb = 0;
		if (assignable instanceof PinAssign) {
			PinAssign assignment = (PinAssign) assignable;
			isCombined = assignment.isCombined();
			isQualified = assignment.getQualifier() != null;
			if (isQualified)
				indices = assignment.getQualifier().getIndices();
			Pin pin = assignment.getRef();
			isVector = pin.getVector().isVector();
			msb = pin.getVector().getMsb();
			lsb = pin.getVector().getLsb();
		} else if (assignable instanceof PortAssign) {
			PortAssign assignment = (PortAssign) assignable;
			isCombined = assignment.isCombined();
			isQualified = assignment.getQualifier() != null;
			if (isQualified)
				indices = assignment.getQualifier().getIndices();
			ConnectionName port = assignment.getRef();
			isVector = ((Connection) port.eContainer()).getVector().isVector();
			msb = ((Connection) port.eContainer()).getVector().getMsb();
			lsb = ((Connection) port.eContainer()).getVector().getLsb();
		} else
			return 0;

		// compute the number of relevant instances over which the assignment applies
		if (isQualified) {
			if (indices.isArray())
				numInsts = Math.abs(indices.getMsb() - indices.getLsb()) + 1;
			else
				numInsts = indices.getIndices().size();
		} else {
			Instance i = (Instance) assignable.eContainer();
			numInsts = Math.abs(i.getArray().getMsb() - i.getArray().getLsb()) + 1;
		}

		// compute the width of the referenced pin or connection on the left hand side
		int refWidth = 0;
		if (assignable.getSlices() != null) {
			if (assignable.getSlices().isVector())
				refWidth = Math.abs(assignable.getSlices().getMsb() - assignable.getSlices().getLsb()) + 1;
			else
				refWidth = assignable.getSlices().getSlices().size();
		} else {
			if (isVector)
				refWidth = Math.abs(msb - lsb) + 1;
			else
				refWidth = 1;
		}

		// the total width is a function of whether the assignment is combined
		int totalWidth = 0;
		if (isCombined) {
			totalWidth = numInsts * refWidth;
		} else
			totalWidth = refWidth;
		return totalWidth;
	}

	private int getNumberOfAssigned(Instance i, Assignable a) {
		int numAssigned = 0;
		boolean isCombined = false, isQualified = false;
		Indices indices = null;
		if (a instanceof PinAssign) {
			PinAssign assign = (PinAssign) a;
			isCombined = assign.isCombined();
			isQualified = assign.getQualifier() != null;
			indices = assign.getQualifier().getIndices();
		} else if (a instanceof PortAssign) {
			PortAssign assign = (PortAssign) a;
			isCombined = assign.isCombined();
			isQualified = assign.getQualifier() != null;
			indices = assign.getQualifier().getIndices();
		} else
			return 0;
		if (!isCombined) {
			if (isQualified) {
				if (indices.isArray()) {
					numAssigned = Math.abs(indices.getMsb() - indices.getLsb()) + 1;
				} else
					numAssigned = indices.getIndices().size();
			} else
				numAssigned = Math.abs(i.getArray().getMsb() - i.getArray().getLsb()) + 1;
		} else
			numAssigned = 1;
		return numAssigned;
	}

	private void incrementConnectionMap(Instance i, Assignable a, Map<String, CountableConnection> cons) {
		if (a.getConcatenation().isOpen())
			return;
		int numAssigned = getNumberOfAssigned(i, a);
		if (!a.getConcatenation().isReplicated()) {
			for (ConnectionRef ref : a.getConcatenation().getConnections()) {
				if (ref.getRef().getName() != null) {
					if (ref.getSlices() != null) {
						List<Integer> slices;
						if (ref.getSlices().isVector())
							slices = PhdlUtils.getIndices(ref.getSlices().getMsb(), ref.getSlices().getLsb());
						else
							slices = ref.getSlices().getSlices();
						for (Integer slice : slices) {
							CountableConnection found = cons.get(ref.getRef().getName() + "[" + slice + "]");
							found.setCount(found.getCount() + numAssigned);
							cons.put(ref.getRef().getName() + "[" + slice + "]", found);
						}
					} else {
						Connection c = (Connection) ref.getRef().eContainer();
						if (c.getVector().isVector()) {
							for (Integer slice : PhdlUtils.getIndices(c.getVector().getMsb(), c.getVector().getLsb())) {
								CountableConnection found = cons.get(ref.getRef().getName() + "[" + slice + "]");
								found.setCount(found.getCount() + numAssigned);
								cons.put(ref.getRef().getName() + "[" + slice + "]", found);
							}
						} else {
							CountableConnection found = cons.get(ref.getRef().getName());
							found.setCount(found.getCount() + numAssigned);
							cons.put(ref.getRef().getName(), found);
						}
					}
				}
			}
		} else {
			int leftWidth = getAssignLeftWidth(a);
			ConnectionRef ref = a.getConcatenation().getReplicate();
			if (ref.getRef().getName() != null) {
				if (ref.getSlices() != null && ref.getSlices().getSlices().size() == 1) {
					int slice = ref.getSlices().getSlices().get(0);
					CountableConnection found = cons.get(ref.getRef().getName() + "[" + slice + "]");
					found.setCount(leftWidth);
					cons.put(ref.getRef().getName() + "[" + slice + "]", found);
				} else {
					CountableConnection found = cons.get(ref.getRef().getName());
					found.setCount(leftWidth);
					cons.put(ref.getRef().getName(), found);
				}
			}
		}
	}

	protected void indicesNotAllowedError(EObject object, EStructuralFeature feature) {
		error("Indices not allowed.", object, feature, -1, IssueCodes.INDICES_NOT_ALLOWED);
	}

	protected void invalidIndexError(EObject object, int index, EStructuralFeature feature) {
		error("Invalid index.", object, feature, index, IssueCodes.INVALID_INDEX);
	}

	protected void invalidLsbError(EObject object, EStructuralFeature feature) {
		error("Invalid lsb.", object, feature, -1, IssueCodes.INVALID_LSB);
	}

	protected void invalidMsbError(EObject object, EStructuralFeature feature) {
		error("Invalid msb.", object, feature, -1, IssueCodes.INVALID_MSB);
	}

	protected void invalidSliceError(EObject object, int slice, EStructuralFeature feature) {
		error("Invalid slice.", object, feature, slice, IssueCodes.INVALID_SLICE);
	}

	protected void qualifierNotAllowedError(EObject object, EStructuralFeature feature) {
		error("Qualifier not allowed.", object, feature, -1, IssueCodes.QUALIFIER_NOT_ALLOWED);
	}
}

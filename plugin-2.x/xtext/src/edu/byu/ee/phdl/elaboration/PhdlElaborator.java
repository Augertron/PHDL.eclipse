package edu.byu.ee.phdl.elaboration;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;

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
import edu.byu.ee.phdl.phdl.Indices;
import edu.byu.ee.phdl.phdl.Info;
import edu.byu.ee.phdl.phdl.Instance;
import edu.byu.ee.phdl.phdl.InstanceElement;
import edu.byu.ee.phdl.phdl.NewAttr;
import edu.byu.ee.phdl.phdl.Pin;
import edu.byu.ee.phdl.phdl.PinAssign;
import edu.byu.ee.phdl.phdl.PortAssign;
import edu.byu.ee.phdl.phdl.RefAttr;
import edu.byu.ee.phdl.phdl.RefTail;
import edu.byu.ee.phdl.phdl.Slices;
import edu.byu.ee.phdl.phdl.SubAttr;
import edu.byu.ee.phdl.utils.PhdlUtils;

public class PhdlElaborator {

	public class Reference {
		private final String name;
		private final Indices indices;

		public Reference(String name, Indices indices) {
			this.name = name;
			this.indices = indices;
		}

		public Indices getIndices() {
			return indices;
		}

		public String getName() {
			return name;
		}

	}

	private static final Logger logger = Logger.getLogger(PhdlElaborator.class);

	/**
	 * Elaborates a Design. The elaboration process is essentially a graph
	 * transformation where the syntax graph represented by the Design is
	 * translated into a new circuit description graph represented by an
	 * ElaboratedDesign. The is because the Xtext model is not sufficient to
	 * represent the circuit with instanced devices, and multiple levels of
	 * hierarchy.
	 * 
	 * @param design
	 *            the Design to elaborate
	 * @return the elaborated design
	 */
	public EDesign elaborate(Design design) {
		EDesign eDesign = new EDesign(design.getName());
		elaborateDesignElements(eDesign, design);
		eDesign.flatten();
		eDesign.makeNetlist();
		logger.info("elaborated: " + design.getName());
		return eDesign;
	}

	private void elaborateAssign(EDesignUnit eDesign, ConnectionAssign connectionAssign) {
		ConnectionName ref = connectionAssign.getRef();
		List<EConnection> lVals = new ArrayList<EConnection>();
		if (connectionAssign.getSlices() != null) {
			for (Integer i : getSlices(connectionAssign.getSlices()))
				lVals.add(eDesign.getConnection(ref.getName(), i));
		} else
			lVals.addAll(eDesign.getConnectionsByName(ref.getName()));

		List<EConnection> rVals = getRelevantConnections(eDesign, connectionAssign.getConcatenation());
		for (int i = 0; i < lVals.size(); i++) {
			if (connectionAssign.getConcatenation().isReplicated()) {
				lVals.get(i).connectTo(rVals.get(0));
			} else {
				lVals.get(i).connectTo(rVals.get(i));
			}
		}
	}

	/**
	 * Iterates over all Connection declarations and elaborates them.
	 * 
	 * @param eDesign
	 * @param connection
	 */
	private void elaborateConnection(EDesignUnit eDesign, Connection connection) {
		for (ConnectionName connectionName : connection.getNames()) {
			if (connection.isNet()) {
				if (connection.getVector().isVector()) {
					for (Integer index : PhdlUtils.getIndices(connection.getVector().getMsb(), connection.getVector()
							.getLsb())) {
						ENet eNet = new ENet(eDesign, connectionName.getName());
						for (EObject element : connection.getElements()) {
							if (element instanceof Attr) {
								Attr attribute = (Attr) element;
								EAttribute eAttribute = new EAttribute(eNet);
								eAttribute.setName(attribute.getName());
								eAttribute.setValue(attribute.getValue());
								eNet.addAttribute(eAttribute);
							} else if (element instanceof Info) {
								Info info = (Info) element;
								eNet.appendInfo(info.getInfo());
							} else {
								logger.error("unrecognized connection element: " + element.getClass().getSimpleName());
							}
						}
						eNet.setIndex(index);
						eDesign.addConnection(eNet);
					}
				} else {
					ENet eNet = new ENet(eDesign, connectionName.getName());
					eDesign.addConnection(eNet);
				}
			} else if (connection.isPort()) {
				if (connection.getVector().isVector()) {
					for (Integer index : PhdlUtils.getIndices(connection.getVector().getMsb(), connection.getVector()
							.getLsb())) {
						EPort ePort = new EPort(eDesign, connectionName.getName());
						for (EObject element : connection.getElements()) {
							if (element instanceof Info) {
								Info info = (Info) element;
								ePort.appendInfo(info.getInfo());
							} else {
								logger.error("unrecognized connection element: " + element.getClass().getSimpleName());
							}
						}
						ePort.setIndex(index);
						eDesign.addConnection(ePort);
					}
				} else {
					EPort ePort = new EPort(eDesign, connectionName.getName());
					eDesign.addConnection(ePort);
				}
			} else {
				logger.error("unrecognized Connection: " + connection.getClass().getSimpleName());
			}
		}
	}

	/**
	 * Iterates over and Elaborates all DesignElements in a design. Unrecognized
	 * types are logged.
	 */
	private void elaborateDesignElements(EDesignUnit eDesign, Design design) {
		for (DesignElement element : design.getElements()) {
			if (element instanceof Connection) {
				Connection connection = (Connection) element;
				elaborateConnection(eDesign, connection);
			} else if (element instanceof Instance) {
				Instance instance = (Instance) element;
				if (instance.isInst()) {
					elaborateInstance(eDesign, instance);
				} else if (instance.isSubInst()) {
					elaborateSubInstance(eDesign, instance);
				} else {
					logger.error("unrecognized DesignElement: " + element.getClass().getSimpleName());
				}
			} else if (element instanceof ConnectionAssign) {
				ConnectionAssign connectionAssign = (ConnectionAssign) element;
				elaborateAssign(eDesign, connectionAssign);
			} else if (element instanceof Info) {
				Info info = (Info) element;
				eDesign.appendInfo(info.getInfo());
			} else {
				logger.error("unrecognized DesignElement: " + element.getClass().getSimpleName());
			}
		}
	}

	private EDevice elaborateDevice(Device device) {
		EDevice eDevice = new EDevice(device.getName());
		for (DeviceElement element : device.getElements()) {
			if (element instanceof Attr) {
				Attr attribute = (Attr) element;
				EAttribute eAttribute = new EAttribute(eDevice);
				eAttribute.setName(attribute.getName());
				eAttribute.setValue(attribute.getValue());
				eDevice.addAttribute(eAttribute);
			} else if (element instanceof Pin) {
				Pin pin = (Pin) element;
				EPinType pinType = elaboratePinType(pin);
				if (pin.getVector().isVector()) {
					int i = 0;
					for (Integer index : PhdlUtils.getIndices(pin.getVector().getMsb(), pin.getVector().getLsb())) {
						EPin ePin = new EPin(eDevice, pin.getName(), pinType);
						ePin.setIndex(index);
						ePin.setPinMapping(pin.getPinNames().get(i++));
						eDevice.addPin(ePin);
					}
				} else {
					EPin ePin = new EPin(eDevice, pin.getName(), pinType);
					ePin.setPinMapping(pin.getPinNames().get(0));
					eDevice.addPin(ePin);
				}
			} else if (element instanceof Info) {
				Info info = (Info) element;
				eDevice.appendInfo(info.getInfo());
			}
		}
		return eDevice;
	}

	private void elaborateInstance(EDesignUnit eDesign, Instance instance) {
		EDevice eDevice = elaborateDevice(instance.getDevice());
		if (instance.getArray().isArray()) {
			for (Integer index : PhdlUtils.getIndices(instance.getArray().getMsb(), instance.getArray().getLsb())) {
				EInstance eInstance = new EInstance(eDesign, eDevice, instance.getName());
				eInstance.setIndex(index);
				eDesign.addInstance(eInstance);
			}
		} else {
			EInstance eInstance = new EInstance(eDesign, eDevice, instance.getName());
			eDesign.addInstance(eInstance);
		}

		for (EObject element : instance.getElements()) {
			if (element instanceof RefAttr) {
				RefAttr refAttr = (RefAttr) element;
				for (EInstance inst : getRelevantInstances(eDesign, instance, refAttr))
					inst.getAttribute(refAttr.getRef().getName()).setValue(refAttr.getValue());
			} else if (element instanceof NewAttr) {
				NewAttr newAttr = (NewAttr) element;
				for (EInstance inst : getRelevantInstances(eDesign, instance, newAttr)) {
					EAttribute eAttribute = new EAttribute(inst, newAttr.getName(), newAttr.getValue());
					inst.addAttribute(eAttribute);
				}
			} else if (element instanceof PinAssign) {
				PinAssign pinAssign = (PinAssign) element;
				List<EInstance> insts = getRelevantInstances(eDesign, instance, pinAssign);
				List<EPin> pins = new ArrayList<EPin>();
				Concatenation concatenation = pinAssign.getConcatenation();
				List<EConnection> cons = getRelevantConnections(eDesign, concatenation);
				if (pinAssign.isCombined()) {
					if (pinAssign.getSlices() != null) {
						for (EInstance inst : insts)
							for (Integer i : getSlices(pinAssign.getSlices())) {
								pins.add(inst.getPin(pinAssign.getRef().getName(), i));
							}
					} else {
						for (EInstance inst : insts)
							pins.addAll(inst.getAllPins(pinAssign.getRef().getName()));
					}
					for (int i = 0; i < pins.size(); i++) {
						if (concatenation.isReplicated()) {
							pins.get(i).assignTo(cons.get(0));
						} else if (concatenation.isOpen()) {
							pins.get(i).setOpen(true);
						} else {
							pins.get(i).assignTo(cons.get(i));
						}
					}
				} else {
					for (EInstance inst : insts) {
						if (pinAssign.getSlices() != null) {
							for (Integer i : getSlices(pinAssign.getSlices()))
								pins.add(inst.getPin(pinAssign.getRef().getName(), i));
						} else
							pins.addAll(inst.getAllPins(pinAssign.getRef().getName()));
						for (int i = 0; i < pins.size(); i++) {
							if (concatenation.isReplicated()) {
								pins.get(i).assignTo(cons.get(0));
							} else if (concatenation.isOpen()) {
								pins.get(i).setOpen(true);
							} else {
								pins.get(i).assignTo(cons.get(i));
							}
						}
						pins.clear();
					}
				}
			}
		}
		for (EInstance i : eDesign.getInstancesByName(instance.getName())) {
			for (EAttribute a : i.getAttributes()) {
				if (a.getName().equals("REFPREFIX"))
					i.setRefPrefix(a.getValue());
				else if (a.getName().equals("REFDES"))
					i.setRefDes(a.getValue());
				else if (a.getName().equals("FOOTPRINT"))
					i.setFootprint(a.getValue());
				else if (a.getName().equals("LIBRARY"))
					i.setLibrary(a.getValue());
			}
		}
	}

	private EPinType elaboratePinType(Pin pin) {
		switch (pin.getType()) {
		case PIN:
			return EPinType.PIN;
		case INPUT:
			return EPinType.INPIN;
		case OUTPUT:
			return EPinType.OUTPIN;
		case IN_OUT:
			return EPinType.IOPIN;
		case OPEN_COLLECTOR:
			return EPinType.OCPIN;
		case OPEN_EMITTER:
			return EPinType.OEPIN;
		case PASSIVE:
			return EPinType.PASSPIN;
		case TRISTATE:
			return EPinType.TRIPIN;
		case POWER:
			return EPinType.PWRPIN;
		case SUPPLY:
			return EPinType.SUPPIN;
		case NO_CONNECT:
			return EPinType.NCPIN;
		default:
			logger.error("cannot elaborate pintype: " + pin.getType());
			return null;
		}
	}

	private void elaborateSubInstance(EDesignUnit eDesign, Instance subInstance) {
		ESubDesign eSubDesign = new ESubDesign(subInstance.getSubDesign().getName());
		elaborateDesignElements(eSubDesign, subInstance.getSubDesign());
		if (subInstance.getArray().isArray()) {
			for (Integer i : PhdlUtils.getIndices(subInstance.getArray().getMsb(), subInstance.getArray().getLsb())) {
				ESubInstance eSubInstance = new ESubInstance(eDesign, eSubDesign, subInstance.getName());
				eSubInstance.setIndex(i);
				eDesign.addSubInst(eSubInstance);
			}
		} else {
			ESubInstance eSubInstance = new ESubInstance(eDesign, eSubDesign, subInstance.getName());
			eDesign.addSubInst(eSubInstance);
		}

		for (EObject element : subInstance.getElements()) {
			if (element instanceof Attr) {
				Attr attr = (Attr) element;
				if (attr.getName().equalsIgnoreCase("REFPREFIX")) {
					List<ESubInstance> subInsts = eDesign.getSubInstancesByName(subInstance.getName());
					for (ESubInstance subInst : subInsts) {
						subInst.setRefPrefix(attr.getValue());
					}
				}
			} else if (element instanceof SubAttr) {
				SubAttr subAttr = (SubAttr) element;
				Stack<Reference> refStack = new Stack<Reference>();
				List<Reference> refList = getSubAttrRefs(subAttr);
				Reference lastRef = refList.remove(refList.size() - 1);
				for (int i = refList.size() - 1; i >= 0; i--)
					refStack.push(refList.get(i));

				List<ESubInstance> subInsts = new ArrayList<ESubInstance>();
				if (subAttr.getQualifier() != null) {
					for (Integer i : PhdlUtils.getIndices(subAttr.getQualifier().getIndices()))
						subInsts.add(eDesign.getSubInstance(subInstance.getName(), i));
				} else
					subInsts.addAll(eDesign.getSubInstancesByName(subInstance.getName()));
				for (ESubInstance subInst : subInsts)
					subInstAttr(subInst, refStack, lastRef.getName(), subAttr.getValue());
			} else if (element instanceof PortAssign) {
				PortAssign portAssign = (PortAssign) element;
				List<ESubInstance> subInsts = new ArrayList<ESubInstance>();
				if (portAssign.getQualifier() != null) {
					for (Integer i : PhdlUtils.getIndices(portAssign.getQualifier().getIndices()))
						subInsts.add(eDesign.getSubInstance(subInstance.getName(), i));
				} else
					subInsts.addAll(eDesign.getSubInstancesByName(subInstance.getName()));

				List<EPort> ports = new ArrayList<EPort>();
				Concatenation concatenation = portAssign.getConcatenation();
				List<EConnection> cons = getRelevantConnections(eDesign, concatenation);
				if (portAssign.isCombined()) {
					if (portAssign.getSlices() != null) {
						for (ESubInstance subInst : subInsts)
							for (Integer i : getSlices(portAssign.getSlices()))
								ports.add(subInst.getPort(portAssign.getRef().getName(), i));
					} else {
						for (ESubInstance subInst : subInsts)
							ports.addAll(subInst.getAllPorts(portAssign.getRef().getName()));
					}
					for (int i = 0; i < ports.size(); i++) {
						if (concatenation.isReplicated()) {
							ports.get(i).setAssignment(cons.get(0));
							cons.get(0).addConnection(ports.get(i));
						} else if (concatenation.isOpen()) {
							// do nothing
						} else {
							ports.get(i).setAssignment(cons.get(i));
							cons.get(i).addConnection(ports.get(i));
						}
					}
				} else {
					for (ESubInstance subInst : subInsts) {
						if (portAssign.getSlices() != null) {
							for (Integer i : getSlices(portAssign.getSlices()))
								ports.add(subInst.getPort(portAssign.getRef().getName(), i));
						} else
							ports.addAll(subInst.getAllPorts(portAssign.getRef().getName()));
						for (int i = 0; i < ports.size(); i++) {
							if (concatenation.isReplicated()) {
								ports.get(i).setAssignment(cons.get(0));
								cons.get(0).addConnection(ports.get(i));
							} else if (concatenation.isOpen()) {
								// do nothing
							} else {
								ports.get(i).setAssignment(cons.get(i));
								cons.get(i).addConnection(ports.get(i));
							}
						}
						ports.clear();
					}
				}
			}
		}
		if (subInstance.getPrefix() != null && !subInstance.getPrefix().equals("")) {
			List<ESubInstance> subInsts = eDesign.getSubInstancesByName(subInstance.getName());
			for (ESubInstance subInst : subInsts) {
				subInst.setRefPrefix(subInstance.getPrefix());
			}
		}
	}

	private List<EConnection> getRelevantConnections(EDesignUnit eDesign, Concatenation concatenation) {
		List<EConnection> connections = new ArrayList<EConnection>();
		if (!concatenation.isOpen() && !concatenation.isReplicated()) {
			for (ConnectionRef ref : concatenation.getConnections()) {
				if (ref.getSlices() != null) {
					for (Integer index : getSlices(ref.getSlices()))
						connections.add(eDesign.getConnection(ref.getRef().getName(), index));
				} else
					connections.addAll(eDesign.getConnectionsByName(ref.getRef().getName()));
			}
		} else if (concatenation.isReplicated()) {
			ConnectionRef ref = concatenation.getReplicate();
			if (ref.getSlices() != null) {
				for (Integer index : getSlices(ref.getSlices()))
					connections.add(eDesign.getConnection(ref.getRef().getName(), index));
			} else
				connections.addAll(eDesign.getConnectionsByName(ref.getRef().getName()));
		}
		return connections;
	}

	private List<EInstance> getRelevantInstances(EDesignUnit eDesign, Instance instance, InstanceElement element) {
		List<EInstance> instances = new ArrayList<EInstance>();
		boolean isQualified = false;
		Indices indices = null;
		if (element instanceof RefAttr) {
			isQualified = ((RefAttr) element).getQualifier() != null;
			if (isQualified)
				indices = ((RefAttr) element).getQualifier().getIndices();
		} else if (element instanceof NewAttr) {
			isQualified = ((NewAttr) element).getQualifier() != null;
			if (isQualified)
				indices = ((NewAttr) element).getQualifier().getIndices();
		} else if (element instanceof PinAssign) {
			isQualified = ((PinAssign) element).getQualifier() != null;
			if (isQualified)
				indices = ((PinAssign) element).getQualifier().getIndices();
		}
		if (indices != null) {
			for (Integer i : PhdlUtils.getIndices(indices))
				instances.add(eDesign.getInstance(instance.getName(), i));
		} else
			instances.addAll(eDesign.getInstancesByName(instance.getName()));
		return instances;
	}

	private List<Integer> getSlices(Slices slices) {
		List<Integer> indices = new ArrayList<Integer>();
		if (slices.isVector()) {
			int msb = slices.getMsb();
			int lsb = slices.getLsb();

			if (msb == lsb) {
				indices.add(msb);
				return indices;
			}

			if (msb < lsb)
				for (int i = msb; i <= lsb; i++)
					indices.add(i);
			else if (msb > lsb)
				for (int i = msb; i >= lsb; i--)
					indices.add(i);
			return indices;

		} else {
			for (Integer i : slices.getSlices())
				indices.add(i);
			return indices;
		}
	}

	private List<Reference> getSubAttrRefs(SubAttr subAttr) {
		List<Reference> refs = new ArrayList<Reference>();
		refs.add(new Reference(((Instance) subAttr.getRef()).getName(), subAttr.getRefIndices()));

		RefTail tail = subAttr.getTail();
		while (tail != null) {
			if (tail.getRef() instanceof Instance)
				refs.add(new Reference(((Instance) tail.getRef()).getName(), tail.getRefIndices()));
			else if (tail.getRef() instanceof Attr)
				refs.add(new Reference(((Attr) tail.getRef()).getName(), null));
			else if (tail.getRef() instanceof NewAttr)
				refs.add(new Reference(((NewAttr) tail.getRef()).getName(), null));
			else if (tail.getRef() instanceof RefAttr)
				refs.add(new Reference(((RefAttr) tail.getRef()).getRef().getName(), null));
			tail = tail.getTail();
		}
		return refs;
	}

	private void subInstAttr(ESubInstance subInst, Stack<Reference> refStack, String name, String value) {
		Reference currRef = refStack.pop();
		List<ESubInstance> subInsts = new ArrayList<ESubInstance>();
		List<EInstance> insts = new ArrayList<EInstance>();
		if (currRef.indices == null) {
			subInsts.addAll(subInst.getSubInstancesByName(currRef.getName()));
			insts.addAll(subInst.getInstancesByName(currRef.getName()));
		} else {
			for (Integer i : PhdlUtils.getIndices(currRef.getIndices())) {
				subInsts.add(subInst.getSubInstance(currRef.getName(), i));
				insts.add(subInst.getInstance(currRef.getName(), i));
			}
		}
		if (refStack.isEmpty()) {
			for (EInstance i : insts)
				i.getAttribute(name).setValue(value);
		} else {
			for (ESubInstance s : subInsts)
				subInstAttr(s, refStack, name, value);
		}
	}
}

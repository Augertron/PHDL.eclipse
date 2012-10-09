package edu.byu.ee.phdl.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

import edu.byu.ee.phdl.phdl.PhdlModel;

public class PhdlJavaCommandLineValidator extends PhdlJavaValidator {

	@Override
	@Check(CheckType.FAST)
	public void checkGlobalAttrs(PhdlModel model) {
		/*
		 * Resource resource = model.eResource(); Iterable<Attr> attrFilter =
		 * IterableExtensions.<Attr> filter( IteratorExtensions.<EObject>
		 * toIterable(resource.getAllContents()), Attr.class);
		 * 
		 * debug("Resource URI :" + resource.getURI().toString());
		 * 
		 * // Create a map of all the attributes in the current resource
		 * Map<String, List<Attr>> attrMap = new HashMap<String, List<Attr>>();
		 * for (Attr a : attrFilter) { if
		 * (attrMap.containsKey(a.getName().toUpperCase())) { List<Attr>
		 * crntList = attrMap.get(a.getName().toUpperCase()); crntList.add(a); }
		 * else { List<Attr> attrList = new LinkedList<Attr>(); attrList.add(a);
		 * attrMap.put(a.getName().toUpperCase(), attrList); } }
		 * 
		 * // If needed create the global map of attributes keyed by resource
		 * file if (globalAttrs == null) globalAttrs = new HashMap<String,
		 * Map<String, List<Attr>>>(); // Update the global Attribute map with
		 * this files current attributes
		 * globalAttrs.put(resource.getURI().toString(), new HashMap<String,
		 * List<Attr>>(attrMap));
		 * 
		 * debug("-------------------------------");
		 * 
		 * // generate a map of all the attributes in the global Attrs map
		 * Map<String, List<Attr>> allAttrsMap = new HashMap<String,
		 * List<Attr>>(); for (String uri : globalAttrs.keySet()) { for (String
		 * key : globalAttrs.get(uri).keySet()) { if
		 * (allAttrsMap.containsKey(key)) { for (Attr a :
		 * globalAttrs.get(uri).get(key)) allAttrsMap.get(key).add(a); } else
		 * allAttrsMap.put(key, new
		 * LinkedList<Attr>(globalAttrs.get(uri).get(key))); } }
		 * 
		 * // Throw a warning for every attribute with the same name but a //
		 * difference in case for (String key : allAttrsMap.keySet()) {
		 * List<Attr> crntAttrList = allAttrsMap.get(key); Map<String,
		 * List<Attr>> warningMap = new HashMap<String, List<Attr>>(); for (Attr
		 * a : crntAttrList) { if (warningMap.containsKey(a.getName())) {
		 * List<Attr> smallList = warningMap.get(a.getName()); smallList.add(a);
		 * warningMap.put(a.getName(), smallList); } else { List<Attr> smallList
		 * = new LinkedList<Attr>(); smallList.add(a);
		 * warningMap.put(a.getName(), smallList); } } if (warningMap.size() >
		 * 1) for (String key2 : warningMap.keySet()) if
		 * (!key2.equalsIgnoreCase("REFDES") &&
		 * !key2.equalsIgnoreCase("LIBRARY") &&
		 * !key2.equalsIgnoreCase("FOOTPRINT") &&
		 * !key2.equalsIgnoreCase("REFPREFIX"))
		 * warning("Attributes declared with same name, but different case: " +
		 * warningMap.get(key2).size() + " found with " + key2,
		 * warningMap.get(key2).get(0), PhdlPackage.Literals.ATTR__NAME, -1); }
		 */
		// debug("I just tested global attributes in the command-line version!");
	}
}

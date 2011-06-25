/*
 * Copyright (C) 2011 BYU Configurable Computing Lab
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.analyzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

import phdl.TestDriver;
import phdl.exception.InvalidDesignException;
import phdl.parser.DesignDecl;
import phdl.parser.ParsedDesigns;
import phdl.parser.PortAssign;
import phdl.parser.SubDecl;

/**
 * A class that represents a phdl design hierarchy.
 * 
 * The hierarchical structure of all designs is stored in a tree of nodes
 * containing design declarations.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 * 
 */
public class DesignHierarchy {

	/**
	 * The top design declaration node
	 */
	public DesignNode top;

	/**
	 * Default Constructor
	 * 
	 * @param top
	 *            Top design node
	 */
	public DesignHierarchy(DesignNode top) {
		this.top = top;
	}

	/**
	 * Secondary constructor
	 * 
	 * @param design
	 *            Top DesignDeclaration
	 */
	public DesignHierarchy(DesignDecl design) {
		this.top = new DesignNode(design);
	}

	public void setRoot(DesignDecl design) {
		this.top = new DesignNode(design);
	}

	public DesignDecl getRoot() {
		return top.getDesignDeclaration();
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public int size() {
		return getPostorder().size();
	}

	public void addDesign(DesignDecl parent, DesignDecl child) {
		addDesign(parent, child, null);
	}

	public void addDesign(DesignDecl parent, DesignDecl child,
			Set<PortAssign> pa) {
		DesignNode childNode = new DesignNode(child, pa);
		DesignNode parentNode = find(parent);
		parentNode.addChild(childNode);
	}

	private DesignNode find(DesignDecl design) {
		LinkedList<DesignNode> q = new LinkedList<DesignNode>();
		q.addFirst(top);
		while (!q.isEmpty()) {
			DesignNode node = q.removeLast();
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				q.add(sibling);
				sibling = sibling.getNextSibling();
			}
			if (node.equals(new DesignNode(design))) {
				return node;
			}
		}
		return null;
	}

	public Set<PortAssign> getPorts(DesignDecl design) {
		DesignNode node = find(design);
		return node.getPorts();
	}

	public boolean contains(DesignDecl design) {
		if (find(design) != null)
			return true;
		return false;
	}

	/**
	 * Returns a list of design declarations based on a breadth-first search of
	 * the design hierarchy
	 * 
	 * @return
	 */
	public ArrayList<DesignDecl> getBFS() {
		ArrayList<DesignDecl> list = new ArrayList<DesignDecl>();
		LinkedList<DesignNode> q = new LinkedList<DesignNode>();
		q.addFirst(top);
		while (!q.isEmpty()) {
			DesignNode node = q.removeLast();
			list.add(node.getDesignDeclaration());
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				q.addFirst(sibling);
				sibling = sibling.getNextSibling();
			}
		}
		return list;
	}

	/**
	 * Returns a list of design nodes based on a breadth-first search of the
	 * design hierarchy
	 * 
	 * @return
	 */
	public ArrayList<DesignNode> getBFSNodes() {
		ArrayList<DesignNode> list = new ArrayList<DesignNode>();
		LinkedList<DesignNode> q = new LinkedList<DesignNode>();
		q.addFirst(top);
		while (!q.isEmpty()) {
			DesignNode node = q.removeLast();
			list.add(node);
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				q.addFirst(sibling);
				sibling = sibling.getNextSibling();
			}
		}
		return list;
	}

	/**
	 * Returns a list of design declarations based on a post-order traversal of
	 * the design hierarchy
	 * 
	 * @return
	 */
	public ArrayList<DesignDecl> getPostorder() {
		ArrayList<DesignDecl> list = new ArrayList<DesignDecl>();
		list = postorder(top, list);
		return list;
	}

	/**
	 * Recursive internal method for getPostOrder
	 * 
	 * @param node
	 * @param list
	 * @return
	 */
	private ArrayList<DesignDecl> postorder(DesignNode node,
			ArrayList<DesignDecl> list) {
		if (node.hasChild()) {
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				list = postorder(sibling, list);
				sibling = sibling.getNextSibling();
			}
		}
		list.add(node.getDesignDeclaration());
		return list;
	}

	/**
	 * Returns a list of design declarations based on a pre-order traversal of
	 * the design hierarchy
	 * 
	 * @return
	 */
	public ArrayList<DesignDecl> getPreorder() {
		ArrayList<DesignDecl> list = new ArrayList<DesignDecl>();
		list = preorder(top, list);
		return list;
	}

	/**
	 * Recursive internal method for preorder
	 * 
	 * @param node
	 * @param list
	 * @return
	 */
	private ArrayList<DesignDecl> preorder(DesignNode node,
			ArrayList<DesignDecl> list) {
		list.add(node.getDesignDeclaration());
		if (node.hasChild()) {
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				list = preorder(sibling, list);
				sibling = sibling.getNextSibling();
			}
		}
		return list;
	}

	@Override
	public String toString() {
		String myString = "";
		return stringTraversal(myString, top, 0);
	}

	private String stringTraversal(String myString, DesignNode node, int level) {
		myString += "\n";
		for (int i = 0; i < level; i++) {
			myString += "\t";
		}
		myString += node.toString();
		DesignNode curChild = node.getFirstChild();
		while (curChild != null) {
			myString = stringTraversal(myString, curChild, level + 1);
			curChild = curChild.getNextSibling();
		}
		return myString;
	}

	/**
	 * Makes a design hierarchy tree using all designs contained in the
	 * {@link ParsedDesigns} object passed in.
	 * 
	 * @param pd
	 *            The parsed designs object containing all parsed designs
	 * @throws InvalidDesignException
	 * @see ParsedDesigns
	 */
	public void makeHierarchy(ParsedDesigns pd) throws InvalidDesignException {
		// for every sub-design in the top level design, add it's equivalent
		// design declaration as a child
		for (SubDecl s : top.getDesignDeclaration().getSubDecls()) {
			DesignDecl child = pd.getDesign(s);
			hierarchyMaker(top.getDesignDeclaration(), child, pd,
					s.getPortAssigns(), s);
		}
	}

	/**
	 * The recursive method that makes a design hierarchy
	 * 
	 * @param parent
	 *            The parent design
	 * @param child
	 *            The child design being added
	 * @param pd
	 *            The parsed designs object containing all available designs
	 * @throws InvalidDesignException
	 * @see ParsedDesigns
	 */
	public void hierarchyMaker(DesignDecl parent, DesignDecl child,
			ParsedDesigns pd, Set<PortAssign> set, SubDecl sd)
			throws InvalidDesignException {

		// throw an exception if the design reference is missing.
		if (child == null)
			throw new InvalidDesignException(sd,
					"design reference missing for sub-design: ");

		// add the design as a node in the hierarchy tree.
		addDesign(parent, child, set);

		// get each design declaration referenced by each sub-design and add add
		// it to the hierarchy.
		for (SubDecl s : child.getSubDecls()) {
			DesignDecl newChild = pd.getDesign(s);
			hierarchyMaker(child, newChild, pd, s.getPortAssigns(), sd);
		}
	}

	public static boolean unitTest() {
		boolean success = true;

		DesignDecl design1 = new DesignDecl();
		design1.setName("A");
		DesignDecl design2 = new DesignDecl();
		design2.setName("B");
		DesignDecl design3 = new DesignDecl();
		design3.setName("C");
		DesignDecl design4 = new DesignDecl();
		design4.setName("D");
		DesignDecl design5 = new DesignDecl();
		design5.setName("E");
		DesignDecl design6 = new DesignDecl();
		design6.setName("F");
		DesignDecl design7 = new DesignDecl();
		design7.setName("G");

		DesignHierarchy tree = new DesignHierarchy(design1);

		tree.addDesign(design1, design2); // A
		tree.addDesign(design2, design3); // B D
		tree.addDesign(design1, design4); // C F E G
		tree.addDesign(design4, design5); // Preorder: A B C F D E G
		tree.addDesign(design2, design6); // Postorder: C F B E G D A
		tree.addDesign(design4, design7); // BF : A B D C F E G

		if (tree.isEmpty()) {
			TestDriver.err("isEmpty()", "False", "True");
			success = false;
		}

		if (!tree.getRoot().equals(design1)) {
			TestDriver.err("getRoot()", "A", tree.getRoot().getName());
			success = false;
		}

		if (!tree.contains(design1)) {
			TestDriver.err("contains()", "contains A", "false");
			success = false;
		}
		if (!tree.contains(design2)) {
			TestDriver.err("contains()", "contains B", "false");
			success = false;
		}
		if (!tree.contains(design3)) {
			TestDriver.err("contains()", "contains C", "false");
			success = false;
		}
		if (!tree.contains(design4)) {
			TestDriver.err("contains()", "contains D", "false");
			success = false;
		}
		if (!tree.contains(design5)) {
			TestDriver.err("contains()", "contains E", "false");
			success = false;
		}
		if (!tree.contains(design6)) {
			TestDriver.err("contains()", "contains F", "false");
			success = false;
		}
		if (!tree.contains(design7)) {
			TestDriver.err("contains()", "contains G", "false");
			success = false;
		}

		if (tree.size() != 7) {
			TestDriver.err("size()", "7", tree.size() + "");
			success = false;
		}

		ArrayList<DesignDecl> preorder = tree.getPreorder();
		// Preorder: A B C F D E G

		if (preorder.size() != 7) {
			TestDriver.err("getPreorder()", "size of 7",
					"size of " + preorder.size());
			success = false;
		}
		if (!preorder.get(0).equals(design1)) {
			TestDriver.err("getPreorder()", "element 0 = A", preorder.get(0)
					.getName());
			success = false;
		}
		if (!preorder.get(1).equals(design2)) {
			TestDriver.err("getPreorder()", "element 1 = B", preorder.get(1)
					.getName());
			success = false;
		}
		if (!preorder.get(2).equals(design3)) {
			TestDriver.err("getPreorder()", "element 2 = C", preorder.get(2)
					.getName());
			success = false;
		}
		if (!preorder.get(3).equals(design6)) {
			TestDriver.err("getPreorder()", "element 3 = F", preorder.get(3)
					.getName());
			success = false;
		}
		if (!preorder.get(4).equals(design4)) {
			TestDriver.err("getPreorder()", "element 4 = D", preorder.get(4)
					.getName());
			success = false;
		}
		if (!preorder.get(5).equals(design5)) {
			TestDriver.err("getPreorder()", "element 5 = E", preorder.get(5)
					.getName());
			success = false;
		}
		if (!preorder.get(6).equals(design7)) {
			TestDriver.err("getPreorder()", "element 6 = F", preorder.get(6)
					.getName());
			success = false;
		}

		ArrayList<DesignDecl> postorder = tree.getPostorder();
		// Postorder: C F B E G D A

		if (postorder.size() != 7) {
			TestDriver.err("getPostorder()", "size = 7", postorder.size() + "");
			success = false;
		}
		if (!postorder.get(0).equals(design3)) {
			TestDriver.err("getPostorder()", "element 0 = C", postorder.get(0)
					.getName());
			success = false;
		}
		if (!postorder.get(1).equals(design6)) {
			TestDriver.err("getPostorder()", "element 1 = F", postorder.get(1)
					.getName());
			success = false;
		}
		if (!postorder.get(2).equals(design2)) {
			TestDriver.err("getPostorder()", "element 2 = B", postorder.get(2)
					.getName());
			success = false;
		}
		if (!postorder.get(3).equals(design5)) {
			TestDriver.err("getPostorder()", "element 3 = E", postorder.get(3)
					.getName());
			success = false;
		}
		if (!postorder.get(4).equals(design7)) {
			TestDriver.err("getPostorder()", "element 4 = G", postorder.get(4)
					.getName());
			success = false;
		}
		if (!postorder.get(5).equals(design4)) {
			TestDriver.err("getPostorder()", "element 5 = D", postorder.get(5)
					.getName());
			success = false;
		}
		if (!postorder.get(6).equals(design1)) {
			TestDriver.err("getPostorder()", "element 6 = A", postorder.get(6)
					.getName());
			success = false;
		}

		ArrayList<DesignDecl> BForder = tree.getBFS();
		// BF : A B D C F E G
		if (BForder.size() != 7) {
			TestDriver.err("getBF()", "size = 7", BForder.size() + "");
			success = false;
		}
		if (!BForder.get(0).equals(design1)) {
			TestDriver
					.err("getBF()", "element 0 = A", BForder.get(0).getName());
			success = false;
		}
		if (!BForder.get(1).equals(design2)) {
			TestDriver
					.err("getBF()", "element 1 = B", BForder.get(1).getName());
			success = false;
		}
		if (!BForder.get(2).equals(design4)) {
			TestDriver
					.err("getBF()", "element 2 = D", BForder.get(2).getName());
			success = false;
		}
		if (!BForder.get(3).equals(design3)) {
			TestDriver
					.err("getBF()", "element 3 = C", BForder.get(3).getName());
			success = false;
		}
		if (!BForder.get(4).equals(design6)) {
			TestDriver
					.err("getBF()", "element 4 = F", BForder.get(4).getName());
			success = false;
		}
		if (!BForder.get(5).equals(design5)) {
			TestDriver
					.err("getBF()", "element 5 = E", BForder.get(5).getName());
			success = false;
		}
		if (!BForder.get(6).equals(design7)) {
			TestDriver
					.err("getBF()", "element 6 = G", BForder.get(6).getName());
			success = false;
		}

		return success;
	}
}

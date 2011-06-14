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

import phdl.parser.DesignDeclaration;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * A class that represents a phdl design hierarchy. The hierarchical structure
 * of all designs is stored in a tree of design nodes.
 * 
 * @author Richard Black and Brad Riching
 * 
 */
public class DesignHierarchy {

	private class DesignNode {
		
		private DesignDeclaration design;
		private DesignNode firstChild;
		private DesignNode nextSibling;
		
		public DesignNode() {
			design = null;
			firstChild = null;
			nextSibling = null;
		}
		
		public DesignNode(DesignDeclaration design) {
			this.design = design;
			firstChild = null;
			nextSibling = null;
		}
		
		public boolean hasChild() {
			return (firstChild != null);
		}
		
		public boolean hasNextSibling() {
			return (nextSibling != null);
		}
		
		public DesignNode getFirstChild() {
			return firstChild;
		}
		
		public DesignNode getNextSibling() {
			return nextSibling;
		}
		
		public DesignDeclaration getDesignDeclaration() {
			return design;
		}
		
		public void setFirstChild(DesignNode child) {
			this.firstChild = child;
		}
		
		public void setDesignDeclaration(DesignDeclaration design) {
			this.design = design;
		}
		
		public void addChild(DesignNode child) {
			if (firstChild == null) {
				firstChild = child;
			}
			else {
				DesignNode nextChild = firstChild;
				while (nextChild.getNextSibling() != null) {
					nextChild = nextChild.getNextSibling();
				}
				nextChild.nextSibling = child;
			}
			child.nextSibling = null;
		}
		
		public boolean equals(DesignNode other) {
			return design.equals(other.getDesignDeclaration());
		}
		
	}
	
	public DesignNode root;

	public DesignHierarchy(DesignNode root) {
		this.root = root;
	}
	
	public DesignHierarchy(DesignDeclaration design) {
		this.root = new DesignNode(design);
	}

	public DesignNode getRoot() {
		return root;
	}
	
	public void addDesign(DesignDeclaration parent, DesignDeclaration child) {		
		DesignNode childNode = new DesignNode(child);
		DesignNode parentNode = find(parent);
		parentNode.addChild(childNode);
	}
	
	private DesignNode find(DesignDeclaration design) {
		LinkedList<DesignNode> q = new LinkedList<DesignNode>();
		q.addFirst(root);
		while(!q.isEmpty()) {
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
	
	public ArrayList<DesignDeclaration> getPostorder() {
		ArrayList<DesignDeclaration> list = new ArrayList<DesignDeclaration>();
		list = postorder(root, list);
		return list;
	}
	
	private ArrayList<DesignDeclaration> postorder(DesignNode node,
												ArrayList<DesignDeclaration> list) {
		if (!node.hasChild()) {
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				list = preorder(sibling, list);
				sibling = sibling.getNextSibling();
			}
		}
		list.add(node.getDesignDeclaration());
		return list;
	}
	
	public ArrayList<DesignDeclaration> getPreorder() {
		ArrayList<DesignDeclaration> list = new ArrayList<DesignDeclaration>();
		list = preorder(root, list);
		return list;
	}
	
	private ArrayList<DesignDeclaration> preorder(DesignNode node,
												ArrayList<DesignDeclaration> list) {
		list.add(node.getDesignDeclaration());
		if (!node.hasChild()) {
			DesignNode sibling = node.getFirstChild();
			while (sibling != null) {
				list = preorder(sibling, list);
				sibling = sibling.getNextSibling();
			}
		}
		return list;
	}
	
}

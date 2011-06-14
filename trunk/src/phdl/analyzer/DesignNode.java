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

import phdl.parser.DesignDeclaration;

public class DesignNode {

	protected DesignDeclaration design;
	protected ArrayList<DesignNode> children;

	public DesignNode(DesignDeclaration design) {
		this.design = design;
		this.children = new ArrayList<DesignNode>();
	}

	public ArrayList<DesignNode> getChildren() {
		return children;
	}

	public void addChild(DesignNode node) {
		this.children.add(node);
	}

}

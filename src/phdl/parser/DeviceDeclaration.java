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

package phdl.parser;

import java.util.HashSet;

public class DeviceDeclaration extends Declaration {

	protected HashSet<AttributeDeclaration> attributeDecls;
	protected HashSet<PinDeclaration> pinDecls;

	public DeviceDeclaration() {
		super();
		this.attributeDecls = new HashSet<AttributeDeclaration>();
		this.pinDecls = new HashSet<PinDeclaration>();
	}

	public HashSet<AttributeDeclaration> getAttributeDecls() {
		return attributeDecls;
	}

	public void addAttributeDecl(AttributeDeclaration a) {
		attributeDecls.add(a);
	}

	public HashSet<PinDeclaration> getPinDecls() {
		return pinDecls;
	}

	public void addPinDecl(PinDeclaration p) {
		pinDecls.add(p);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

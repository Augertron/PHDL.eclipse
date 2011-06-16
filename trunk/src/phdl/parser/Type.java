/*
Copyright (C) 2011  BYU Configurable Computing Lab

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package phdl.parser;

/**
 * Pin type enumeration for pin types in phdl. If no pin type is desired, the
 * default type "pin" must be declared in the source code.
 * 
 * @author Richard Black and Brad Riching
 * @version 0.1
 */
public enum Type {
	PIN {
		@Override
		public String toString() {
			return "pin";
		}
	},
	IN {
		@Override
		public String toString() {
			return "in";
		}
	},
	OUT {
		@Override
		public String toString() {
			return "out";
		}
	},
	INOUT {
		@Override
		public String toString() {
			return "inout";
		}
	},
	PASSIVE {
		@Override
		public String toString() {
			return "passive";
		}
	},
	SUPPLY {
		@Override
		public String toString() {
			return "supply";
		}
	},
	POWER {
		@Override
		public String toString() {
			return "power";
		}
	},
	OPEN {
		@Override
		public String toString() {
			return "open";
		}
	};

}
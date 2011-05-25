package phdl;

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A class that represents a netlist
 * 
 * Extends a HashSet to simplify the use of the data structure
 * 
 * @author Richard Black and Brad Riching
 *
 */

public class PHDLNetList extends HashMap<PHDLNet, HashSet<PHDLPin>> {
	
	@Override
	/**
	 * Still to be implemented; will add pins to nets that are already
	 * in the map
	 */
	public void putAll(Map m) {
		PHDLNetList nl = (PHDLNetList)m;
		HashSet<PHDLNet> netSet = (HashSet<PHDLNet>)nl.keySet();
		for (PHDLNet a : netSet){
			
		}
	}
	
}

package edu.byu.ee.phdl.erc;

import java.util.List;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EConnection;

public class ElectricalRuleChecker {

	private static final Logger logger = Logger.getLogger(ElectricalRuleChecker.class);

	public ElectricalRuleChecker(List<EConnection> netlist) {
		for (EConnection c : netlist) {
			if (c.getPins().size() < 2) {
				logger.error("dangling net '" + c.getHierarchyName() + "'");
			}
		}
	}

}

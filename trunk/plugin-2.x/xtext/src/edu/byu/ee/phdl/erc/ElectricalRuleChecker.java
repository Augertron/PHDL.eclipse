package edu.byu.ee.phdl.erc;

import java.util.List;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EPin;

public class ElectricalRuleChecker {

	public enum ERC {
		OK(1), WARN(2), ERROR(3);

		private final int value;

		ERC(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	private final int matrix[][] = { { 1 }, { 1, 3 }, { 1, 1, 1 }, { 1, 2, 1, 1, }, { 1, 1, 1, 1, 1 },
			{ 2, 2, 2, 2, 2, 2 }, { 1, 1, 1, 2, 1, 2, 1 }, { 1, 3, 2, 3, 1, 2, 1, 3 }, { 1, 3, 1, 2, 1, 2, 1, 3, 1 },
			{ 1, 3, 2, 2, 1, 2, 1, 3, 2, 2 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 } };

	private static final Logger logger = Logger.getLogger(ElectricalRuleChecker.class);

	public ElectricalRuleChecker(List<EConnection> netlist) {
		for (EConnection c : netlist) {
			if (c.getPins().size() < 2) {
				logger.error("dangling net '" + c.getHierarchyName() + "'");
			}

			for (EPin p : c.getPins()) {

			}
		}
	}

}

package edu.byu.ee.phdl.erc;

import java.util.List;

import org.apache.log4j.Logger;

import edu.byu.ee.phdl.elaboration.EConnection;
import edu.byu.ee.phdl.elaboration.EDesign;
import edu.byu.ee.phdl.elaboration.EInstance;
import edu.byu.ee.phdl.elaboration.EPin;
import edu.byu.ee.phdl.elaboration.EPinType;

public class ElectricalRuleChecker {

	private final int OK = 0;
	private final int WARN = 1;
	private final int ERROR = 2;

	private int numErrors = 0;
	private int numWarns = 0;

	private final int[][] matrix = new int[][] { { OK, OK, OK, OK, OK, WARN, OK, OK, OK, OK, ERROR },
			{ OK, ERROR, OK, WARN, OK, WARN, OK, ERROR, ERROR, ERROR, ERROR },
			{ OK, OK, OK, OK, OK, WARN, OK, WARN, OK, WARN, ERROR },
			{ OK, WARN, OK, OK, OK, WARN, WARN, ERROR, WARN, WARN, ERROR },
			{ OK, OK, OK, OK, OK, WARN, OK, OK, OK, OK, ERROR },
			{ WARN, WARN, WARN, WARN, WARN, OK, WARN, WARN, WARN, WARN, ERROR },
			{ OK, OK, OK, WARN, OK, WARN, OK, OK, OK, OK, ERROR },
			{ OK, ERROR, WARN, ERROR, OK, WARN, OK, ERROR, ERROR, ERROR, ERROR },
			{ OK, ERROR, OK, WARN, OK, WARN, OK, ERROR, OK, OK, ERROR },
			{ OK, ERROR, WARN, WARN, OK, WARN, OK, ERROR, OK, OK, ERROR },
			{ ERROR, ERROR, ERROR, ERROR, ERROR, ERROR, ERROR, ERROR, ERROR, ERROR, ERROR } };

	private static final Logger logger = Logger.getLogger(ElectricalRuleChecker.class);

	public ElectricalRuleChecker(EDesign design) {
		for (EConnection c : design.getNetlist()) {
			List<EPin> pins = c.getPins();
			if (pins.size() < 2) {
				logger.error("dangling net '" + c.getHierarchyName() + "'");
				numErrors++;
			}
			for (int i = 0; i < pins.size() - 1; i++) {
				for (int j = i + 1; j < pins.size(); j++) {
					int lookupValue = matrix[getIndex(pins.get(i).getPinType())][getIndex(pins.get(j).getPinType())];
					StringBuilder message = new StringBuilder();
					if (lookupValue != OK) {
						message.append("'" + c.getHierarchyName() + "' connects ");

						// first pin message
						message.append(pins.get(i).getPinType() + " '");
						message.append(((EInstance) pins.get(i).getParent()).getHierarchyPrefix());
						message.append(((EInstance) pins.get(i).getParent()).getNameIndex());
						message.append("/" + pins.get(i).getName() + "' to ");

						// second pin message
						message.append(pins.get(j).getPinType() + " '");
						message.append(((EInstance) pins.get(j).getParent()).getHierarchyPrefix());
						message.append(((EInstance) pins.get(j).getParent()).getNameIndex());
						message.append("/" + pins.get(j).getName() + "'.");
					}

					if (lookupValue == ERROR) {
						logger.error(message.toString());
						numErrors++;
					} else if (lookupValue == WARN) {
						logger.warn(message.toString());
						numWarns++;
					} else if (lookupValue == OK) {
						// do nothing
					} else {
						logger.error("unrecognized electrical rule check code in matrix: " + lookupValue);
						numErrors++;
					}
				}
			}
		}
		if (numErrors > 0) {
			logger.error("ERC (Electrical Rule Check) completed with errors: " + design.getName());
		} else if (numWarns > 0) {
			logger.warn("ERC (Electrical Rule Check) completed with warnings: " + design.getName());
		} else {
			logger.info("completed ERC (Electrical Rule Check) with no errors or warnings: " + design.getName());
		}
	}

	private int getIndex(EPinType pinType) {
		switch (pinType) {
		case INPIN:
			return 0;
		case OUTPIN:
			return 1;
		case IOPIN:
			return 2;
		case TRIPIN:
			return 3;
		case PASSPIN:
			return 4;
		case PIN:
			return 5;
		case PWRPIN:
			return 6;
		case SUPPIN:
			return 7;
		case OCPIN:
			return 8;
		case OEPIN:
			return 9;
		case NCPIN:
			return 10;
		default:
			return -1;
		}
	}

}

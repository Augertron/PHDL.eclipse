package edu.byu.ee.phdl.erc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static final Map<EPinType, Integer> types;
	static {
		Map<EPinType, Integer> map = new HashMap<EPinType, Integer>();
		map.put(EPinType.INPIN, 0);
		map.put(EPinType.OUTPIN, 1);
		map.put(EPinType.IOPIN, 2);
		map.put(EPinType.TRIPIN, 3);
		map.put(EPinType.PASSPIN, 4);
		map.put(EPinType.PIN, 5);
		map.put(EPinType.PWRPIN, 6);
		map.put(EPinType.SUPPIN, 7);
		map.put(EPinType.OCPIN, 8);
		map.put(EPinType.OEPIN, 9);
		map.put(EPinType.NCPIN, 10);
		types = Collections.unmodifiableMap(map);
	}

	private static final Logger logger = Logger.getLogger(ElectricalRuleChecker.class);

	public ElectricalRuleChecker(EDesign design) {
		int numErrors = 0;
		int numWarns = 0;

		for (EConnection c : design.getNetlist()) {
			List<EPin> pins = c.getPins();
			if (pins.size() < 2) {
				logger.error("dangling net '" + c.getHierarchyName() + "'");
				numErrors++;
			}
			for (int i = 0; i < pins.size() - 1; i++) {
				for (int j = i + 1; j < pins.size(); j++) {
					int lookupValue = matrix[types.get(pins.get(i).getPinType())][types.get(pins.get(j).getPinType())];
					StringBuilder message = new StringBuilder();
					if (lookupValue != OK) {
						message.append("'" + c.getHierarchyName() + "' connects ");

						EPin pinI = pins.get(i);
						message.append(pinI.getPinType() + " '");
						message.append(((EInstance) pinI.getParent()).getHierarchyPrefix());
						message.append(((EInstance) pinI.getParent()).getNameIndex());
						message.append("/" + pinI.getName() + "' to ");

						EPin pinJ = pins.get(j);
						message.append(pinJ.getPinType() + " '");
						message.append(((EInstance) pinJ.getParent()).getHierarchyPrefix());
						message.append(((EInstance) pinJ.getParent()).getNameIndex());
						message.append("/" + pinJ.getName() + "'.");

						if (lookupValue == ERROR) {
							logger.error(message.toString());
							numErrors++;
						} else if (lookupValue == WARN) {
							logger.warn(message.toString());
							numWarns++;
						} else {
							logger.error("unrecognized electrical rule check code in matrix: " + lookupValue);
							numErrors++;
						}
					}
				}
			}
		}
		if (numErrors > 0) {
			logger.error("ERC (Electrical Rule Check) completed with " + numErrors + " errors: " + design.getName());
		} else if (numWarns > 0) {
			logger.warn("ERC (Electrical Rule Check) completed with " + numWarns + " warnings: " + design.getName());
		} else {
			logger.info("completed ERC (Electrical Rule Check) with no errors or warnings: " + design.getName());
		}
	}

}

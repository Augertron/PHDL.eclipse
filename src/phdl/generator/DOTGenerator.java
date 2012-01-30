package phdl.generator;

import phdl.Configuration;
import phdl.graph.DesignUnit;

public class DOTGenerator {

	private final DesignUnit des;
	private final Configuration cfg;

	public DOTGenerator(DesignUnit des, Configuration cfg) {
		this.des = des;
		this.cfg = cfg;
	}

	public void generate() {
		if (cfg.isHierarchy()) {

		}
	}
}

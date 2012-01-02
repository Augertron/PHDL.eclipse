package phdl;

public class Switches {

	private boolean supWarn;
	private boolean dumpEn;
	private boolean verbose;
	private boolean eagle;
	private boolean clean;

	public boolean isClean() {
		return clean;
	}

	public boolean isDumpEn() {
		return dumpEn;
	}

	public boolean isEagle() {
		return eagle;
	}

	public boolean isSupWarn() {
		return supWarn;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public void setDumpEn(boolean dumpEn) {
		this.dumpEn = dumpEn;
	}

	public void setEagle(boolean eagle) {
		this.eagle = eagle;
	}

	public void setSupWarn(boolean supWarn) {
		this.supWarn = supWarn;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

}

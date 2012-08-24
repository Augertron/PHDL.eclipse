package edu.byu.ee.phdl.validation;

import edu.byu.ee.phdl.phdl.ConnectionName;

public class CountableConnection {
	private ConnectionName name;
	private int count;
	private int index;

	public CountableConnection(ConnectionName name, int index) {
		this.name = name;
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public int getIndex() {
		return index;
	}

	public ConnectionName getObject() {
		return name;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return name.getName() + ", index=" + index + ", count=" + count;
	}
}
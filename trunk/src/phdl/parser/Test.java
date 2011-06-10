package phdl.parser;

public class Test {
	public static void main(String[] args) {
		AttributeAssignment a = new AttributeAssignment();
		a.setName("myName");
		a.setLine(2);
		a.setPos(4);
		a.setLsb(5);
		a.setMsb(8);
		a.setIndex(5);
		a.setValue("myValue");

		System.out.println(a.getName());
		System.out.println(a.getLine());
		System.out.println(a.getPos());
		System.out.println(a.getMsb());
		System.out.println(a.getLsb());
		System.out.println(a.getIndex());
		System.out.println(a.getValue());
	}
}

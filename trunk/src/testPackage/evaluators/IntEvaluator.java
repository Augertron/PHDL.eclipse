package testPackage.evaluators;

public class IntEvaluator implements Evaluator {
	private int value;
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return value;
	}
	public IntEvaluator(int value) {
		this.value = value;
	}

	@Override
	public String toTreeString(String indent) {
		return '\n' + indent + "Int: " + value;
	}
}

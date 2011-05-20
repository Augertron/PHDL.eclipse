package testPackage.evaluators;

public class MultEvaluator implements Evaluator {
	private Evaluator op1;
	private Evaluator op2;
	
	public MultEvaluator(Evaluator op1, Evaluator op2) {
		this.op1 = op1;
		this.op2 = op2;
	}

	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return op1.evaluate() * op2.evaluate();
	}

	@Override
	public String toTreeString(String indent) {
		return '\n' + indent + "Mult" + 
			op1.toTreeString(indent + " ") +
			op2.toTreeString(indent + " ");
	}
}

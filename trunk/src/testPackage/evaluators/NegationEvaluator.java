package testPackage.evaluators;

public class NegationEvaluator implements Evaluator {
	private Evaluator op1;
	
	public NegationEvaluator(Evaluator op1) {
		this.op1 = op1;
	}

	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return -op1.evaluate();
	}

	@Override
	public String toTreeString(String indent) {
		return '\n' + indent + "Negation" + 
			op1.toTreeString(indent + " ");
	}
}

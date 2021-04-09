package apps.maths.derivatives;

public class TestDifferentiableFunction implements Differentiable
{
	@Override
	public double differentiableFunction(double x)
	{
		return x * x;
	}
}

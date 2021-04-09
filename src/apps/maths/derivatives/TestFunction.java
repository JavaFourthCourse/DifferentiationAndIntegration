package apps.maths.derivatives;

public class TestFunction implements Differentiable
{
	@Override
	public double differentiableFunction(double x)
	{
		return x * x;
	}
}

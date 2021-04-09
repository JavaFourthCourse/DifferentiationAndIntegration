package apps.maths.integration;

public class TestIntegrableFunction implements Integrable
{
	@Override
	public double integrableFunction(double x)
	{
		return Math.pow(x, 3) + 3 * x * x + 2 * x - 15;
	}
}

package apps.maths.integration;

public class TrapeziumMethod implements NumericalIntegration
{
	@Override
	public double calculateNumericalIntegration(int topLimit, int bottomLimit, Integrable function)
	{
		double h = topLimit - bottomLimit;
		
		return ((function.integrableFunction(bottomLimit) + function.integrableFunction(topLimit)) / 2) * h;
	}
}

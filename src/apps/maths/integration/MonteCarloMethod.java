package apps.maths.integration;

import java.util.concurrent.ThreadLocalRandom;

public class MonteCarloMethod implements NumericalIntegration
{
	private static final int N = 1000000;
	
	@Override
	public double calculateNumericalIntegration(int topLimit, int bottomLimit, Integrable function)
	{
		double result = 0;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		
		for (int i = 0; i <= N; i++)
		{
			result += function.integrableFunction(random.nextDouble(bottomLimit, topLimit + 1));
		}
		
		return result * (((double) (topLimit - bottomLimit)) / N);
	}
}

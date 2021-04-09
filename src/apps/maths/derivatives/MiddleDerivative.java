package apps.maths.derivatives;

public class MiddleDerivative
{
	public static double calculateMiddleDerivative(double x0, double accuracy, Differentiable function)
	{
		double delta = accuracy;
		double result = (function.differentiableFunction(x0 + delta) - function.differentiableFunction(x0 - delta)) / (2 * delta);
		
		while (true)
		{
			delta /= 5;
			
			double tem = (function.differentiableFunction(x0 + delta) - function.differentiableFunction(x0 - delta)) / (2 * delta);
			
			if (Math.abs(result - tem) < accuracy)
			{
				break;
			}
			
			result = tem;
		}
		
		return result;
	}
}

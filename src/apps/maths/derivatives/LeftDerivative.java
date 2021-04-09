package apps.maths.derivatives;

public class LeftDerivative
{
	public static double calculateLeftDerivative(double x0, double accuracy, Differentiable function)
	{
		double delta = accuracy;
		double result = (function.differentiableFunction(x0 - delta) - function.differentiableFunction(x0)) / delta;
		
		while (true)
		{
			delta /= 5;
			
			double tem = (function.differentiableFunction(x0 - delta) - function.differentiableFunction(x0)) / delta;
			
			if (Math.abs(result - tem) < accuracy)
			{
				break;
			}
			
			result = tem;
		}
		
		return result;
	}
}

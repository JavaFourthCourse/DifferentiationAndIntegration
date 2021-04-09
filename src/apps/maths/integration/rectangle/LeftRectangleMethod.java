package apps.maths.integration.rectangle;

import apps.maths.integration.Integrable;

public class LeftRectangleMethod extends RectangleMethod
{
	@Override
	public double calculateNumericalIntegration(int topLimit, int bottomLimit, Integrable function)
	{
		return function.integrableFunction(bottomLimit) * (topLimit - bottomLimit);
	}
	
	@Override
	public String getMethodName()
	{
		return "Метод левых прямоугольников";
	}
}

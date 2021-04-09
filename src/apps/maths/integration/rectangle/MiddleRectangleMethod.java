package apps.maths.integration.rectangle;

import apps.maths.integration.Integrable;

public class MiddleRectangleMethod extends RectangleMethod
{
	@Override
	public double calculateNumericalIntegration(int topLimit, int bottomLimit, Integrable function)
	{
		return function.integrableFunction(((double) (topLimit + bottomLimit)) / 2) * (topLimit - bottomLimit);
	}
	
	@Override
	public String getMethodName()
	{
		return "Метод средних прямоугольников";
	}
}

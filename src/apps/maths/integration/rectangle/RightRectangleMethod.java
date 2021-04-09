package apps.maths.integration.rectangle;

import apps.maths.integration.Integrable;

public class RightRectangleMethod extends RectangleMethod
{
   
   @Override
   public double calculateNumericalIntegration(int topLimit, int bottomLimit, Integrable function)
   {
      return function.integrableFunction(topLimit) * (topLimit - bottomLimit);
   }
   
   @Override
   public String getMethodName()
   {
      return "Метод правых прямоугольников";
   }
}

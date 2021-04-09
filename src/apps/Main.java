package apps;

import java.util.HashMap;
import java.util.Map;

import apps.maths.derivatives.Differentiable;
import apps.maths.derivatives.LeftDerivative;
import apps.maths.derivatives.MiddleDerivative;
import apps.maths.derivatives.TestFunction;

public class Main
{
	public static void main(String[] args)
	{
		firstTask();
	}
	
	private static void firstTask()
	{
		Differentiable anonymous = new Differentiable()
		{
			@Override
			public double differentiableFunction(double x)
			{
				return Math.sin(x);
			}
		};
		Differentiable lambda = (double x) -> x * x + 2 * x;
		HashMap<String, Differentiable> functions = new HashMap<>();
		double x0 = 5;
		double accuracy = 0.001;
		
		functions.put("sin(x)", anonymous);
		functions.put("x^2 + 2x", lambda);
		functions.put("x^2", new TestFunction());
		
		System.out.println("x0 = 5; eps = 0.001");
		
		for (Map.Entry<String, Differentiable> i : functions.entrySet())
		{
			System.out.print("Левая производная функции " + i.getKey() + ": ");
			System.out.println(LeftDerivative.calculateLeftDerivative(x0, accuracy, i.getValue()));
		}
		
		System.out.println();
		
		for (Map.Entry<String, Differentiable> i : functions.entrySet())
		{
			System.out.print("Центральная производная функции " + i.getKey() + ": ");
			System.out.println(MiddleDerivative.calculateMiddleDerivative(x0, accuracy, i.getValue()));
		}
	}
}

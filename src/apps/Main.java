package apps;

import java.util.HashMap;
import java.util.Map;

import apps.maths.derivatives.Differentiable;
import apps.maths.derivatives.LeftDerivative;
import apps.maths.derivatives.MiddleDerivative;
import apps.maths.derivatives.TestDifferentiableFunction;
import apps.maths.integration.Integrable;
import apps.maths.integration.MonteCarloMethod;
import apps.maths.integration.TestIntegrableFunction;
import apps.maths.integration.TrapeziumMethod;
import apps.maths.integration.rectangle.LeftRectangleMethod;
import apps.maths.integration.rectangle.MiddleRectangleMethod;
import apps.maths.integration.rectangle.RectangleMethod;
import apps.maths.integration.rectangle.RightRectangleMethod;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Первое задание:");
		
		firstTask();
		
		System.out.println("\nВторое задание");
		
		secondTask();
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
		functions.put("x^2", new TestDifferentiableFunction());
		
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
	
	private static void secondTask()
	{
		Integrable anonymous = new Integrable()
		{
			@Override
			public double integrableFunction(double x)
			{
				return Math.cos(x);
			}
		};
		Integrable lambda = (double x) -> Math.exp(x) * 0.2;
		HashMap<String, Integrable> functions = new HashMap<>();
		int topLimit = 10;
		int bottomLimit = -10;
		RectangleMethod[] rectangles = new RectangleMethod[]{new LeftRectangleMethod(), new RightRectangleMethod(), new MiddleRectangleMethod()};
		
		functions.put("cos(x)", anonymous);
		functions.put("exp(x) * 0.2", lambda);
		functions.put("x^3 + 3x^2 + 2x - 15", new TestIntegrableFunction());
		
		System.out.println("Верхний предел: 10; Нижний предел: -10");
		
		for (Map.Entry<String, Integrable> i : functions.entrySet())
		{
			System.out.print("Метод Монте-Карло для " + i.getKey() + ": ");
			System.out.println(new MonteCarloMethod().calculateNumericalIntegration(topLimit, bottomLimit, i.getValue()));
		}
		
		System.out.println();
		
		for (Map.Entry<String, Integrable> i : functions.entrySet())
		{
			for (RectangleMethod j : rectangles)
			{
				System.out.print(j.getMethodName() + " для " + i.getKey() + ": ");
				System.out.println(j.calculateNumericalIntegration(topLimit, bottomLimit, i.getValue()));
			}
		}
		
		System.out.println();
		
		for (Map.Entry<String, Integrable> i : functions.entrySet())
		{
			System.out.print("Метод трапеций для " + i.getKey() + ": ");
			System.out.println(new TrapeziumMethod().calculateNumericalIntegration(topLimit, bottomLimit, i.getValue()));
		}
	}
}

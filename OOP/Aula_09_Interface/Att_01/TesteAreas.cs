using System;

public class TesteAreas
{
	public static void Main(string[] args)
	{
		Quadrado square = new Quadrado(2);
		Retangulo rectangle = new Retangulo(4,5);
		Circulo circle = new Circulo(2);
		
		Console.WriteLine("Quadrado: " + square.calculaArea());
		Console.WriteLine("Retangulo: " + rectangle.calculaArea());
		Console.WriteLine("Circulo: " + circle.calculaArea());
	}
}

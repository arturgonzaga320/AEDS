public class Quadrado:AreaCalculavel
{
	private double lado;

	public Quadrado(double _l)
	{
		lado = _l;
	}
	public double calculaArea()
	{
		return lado*lado;
	}
}

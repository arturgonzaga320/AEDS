public class Circulo:AreaCalculavel
{
	private double raio;

	public Circulo(double _r)
	{
		raio = _r;
	}
	public double calculaArea()
	{
		return (3.14) * (raio * raio);
	}
}

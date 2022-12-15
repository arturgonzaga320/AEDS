public class Retangulo:AreaCalculavel
{
	private double altura;
	private double comprimento;

	public Retangulo(double _h,double _c)
	{
		altura = _h;
		comprimento = _c;
	}
	public double calculaArea()
	{
		return altura*comprimento;
	}
}

public class Amigo:Pessoa
{
	protected Data niver;

	public Data Niver
	{
		get { return niver; }
		set { niver = value; }
	}

	public Amigo()
	{
		niver = new();
	}
}

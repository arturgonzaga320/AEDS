public class Conhecido:Pessoa
{
	protected string email;

	public string Email
	{
		get { return email; }
		set { email = value; }
	}

	public Conhecido()
	{
		email = string.Empty;
	}
}

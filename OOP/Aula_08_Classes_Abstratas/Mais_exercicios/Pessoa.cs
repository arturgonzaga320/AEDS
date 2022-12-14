namespace Social
{
	public abstract class Pessoa
	{
	    protected string nome;
	    protected int idade;
	    
	    public string Nome
	    {
		get { return nome; }
		set { nome = value; }
	    }
	    public int Idade
	    { 
		get { return idade; } 
		set { idade = value; } 
	    }

	    public Pessoa()
	    {
		nome = string.Empty;
		idade= 0;
	    }
	    public Pessoa(string _nome, int _idade)
	    {
		nome = _nome;
		idade = _idade;
	    }
	    public abstract void SetAll();
	}
}

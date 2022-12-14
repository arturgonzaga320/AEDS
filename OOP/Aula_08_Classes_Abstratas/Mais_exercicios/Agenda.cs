// Parei no item 8
public class Agenda
{
	private Pessoa[] contato;
	private int qtd_amg;
	private int qtd_con;

	public Pessoa[] Contato
	{
		get { return contato; }
		set { contato = value; }
	}
	public int Qtd_amg
	{
		get { return qtd_amg; }
		set { qtd_amg = value; }
	}
	public int Qtd_con
	{
		get { return qtd_con; }
		set { qtd_con = value; }
	}

	public Agenda(int n_contatos)
	{
		contato = new Pessoa[n_contatos];
		for (int i = 0; i < n_contatos; i++)
		{
			Random rnd = new();
			int tipo = rnd.Next(1,2);

			if (tipo == 1)
				contato[i] = new Amigo();
			else
				contato[i] = new Conhecido();
		}
	}
}

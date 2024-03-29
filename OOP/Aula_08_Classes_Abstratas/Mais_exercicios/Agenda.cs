using System;

namespace Social
{
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
			Random rnd = new Random();
			for (int i = 0; i < n_contatos; i++)
			{
				int tipo = rnd.Next(1,3);
				if (tipo == 1)
				{
					contato[i] = new Amigo();
					qtd_amg ++;
				}
				else if (tipo == 2)
				{
					contato[i] = new Conhecido();
					qtd_con ++;
				}
			}
		}
		public void addInformacoes()
		{
			for (int i = 0; i < contato.Length; i++)
			{
			       contato[i].SetAll();	
			       Console.WriteLine();
			}
		}
		public void imprimeAniversarios()
		{
			for (int i = 0; i < contato.Length; i++)
			{
			       if (contato[i] is Amigo)
			       {
				       Amigo aux = (Amigo) contato[i];
				       Console.Write(aux.Nome + " - ");
				       Console.Write(aux.Niver.GetData() + "\n");
			       }
			}
		}
		public void imprimeEmails()
		{
			for (int i = 0; i < contato.Length; i++)
			{
			       if (contato[i] is Conhecido)
			       {
				       Conhecido aux = (Conhecido) contato[i];
				       Console.Write(aux.Nome + " - ");
				       Console.Write(aux.Email + "\n");
			       }
			}
		}
	}
}

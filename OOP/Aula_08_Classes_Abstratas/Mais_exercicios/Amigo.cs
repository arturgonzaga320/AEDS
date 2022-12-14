using System;
using Social;

namespace Social
{
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
			niver = new Data();
		}
		public override void SetAll()
		{
			int _dia,_mes,_ano;

			Console.Write("Nome: ");
			Nome = Console.ReadLine();

			Console.Write("Idade: ");
			Idade = int.Parse(Console.ReadLine());

			Console.Write("Data de nascimento: ");
			string[] _data_aux = Console.ReadLine().Split();

			_dia = int.Parse(_data_aux[0]);
			_mes = int.Parse(_data_aux[1]);
			_ano = int.Parse(_data_aux[2]);
			
			Data _data = new Data(_dia,_mes,_ano);
			Niver = _data;
		}
	}
}

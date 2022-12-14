using System;

namespace Social
{
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
		public override void SetAll()
		{
			Console.Write("Nome: ");
			Nome = Console.ReadLine();

			Console.Write("Idade: ");
			Idade = int.Parse(Console.ReadLine());

			Console.Write("Email: ");
			Email = Console.ReadLine();
		}
	}
}

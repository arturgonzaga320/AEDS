using System;
using Social;

public class TesteAgenda
{
	public static void Main(string[] args)
	{
		Console.Write("Quantidade de pessoas da agenda: ");
		int n_pessoas = int.Parse(Console.ReadLine());

		Agenda agen = new Agenda(n_pessoas);

		Console.WriteLine("\nAmigos: " + agen.Qtd_amg + "\nConhecidos: " + agen.Qtd_con + "\n");
		agen.addInformacoes();

		Console.WriteLine();
		agen.imprimeAniversarios();
		Console.WriteLine();
		agen.imprimeEmails();
		Console.WriteLine();
	}
}

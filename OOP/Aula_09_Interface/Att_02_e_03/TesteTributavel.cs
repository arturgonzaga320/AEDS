using System;
using Entities;
public class TesteTributavel
{
    public static void Main(string[] args)
	{
		ContaPoupanca c = new ContaPoupanca();
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();
		Banco Brasil = new Banco();
		AtualizadorDeContas fiscal = new AtualizadorDeContas(0.01);

		c.Depositar(1000);
		cc.Depositar(1000);
		cc.Depositar(0.20); // Pra deixar o numero inteiro
		cp.Depositar(1000);

		Brasil.AdicionarConta(c);
		Brasil.AdicionarConta(cc);
		Brasil.AdicionarConta(cp);

		SeguroDeVida seg_teste = new SeguroDeVida();
		Console.WriteLine("Tributo de CC: " + (cc.calculaTributos() + seg_teste.calculaTributos()) );
		Console.WriteLine();

		for (int x = 0; x < Brasil.TotalDeContas(); x++)
			fiscal.rodar(Brasil.PegarConta(x));

		Console.WriteLine("Saldo total: " + fiscal.SaldoTotal + "\n");
    }
}

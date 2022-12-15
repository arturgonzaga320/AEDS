using System;
using Entities;
public class TesteGerenciador
{
    public static void Main(string[] args)
	{
		string aux;
		Console.WriteLine();

		SeguroDeVida sv = new SeguroDeVida();
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();
		
		Banco Brasil = new Banco();
		AtualizadorDeContas fiscal = new AtualizadorDeContas(0.01);
		GerenciadorDeImpostoDeRenda geren_ir = new GerenciadorDeImpostoDeRenda();

		cc.Depositar(1000);
		cp.Depositar(1000);

		Tributavel[] n_tri = new Tributavel[2];
		n_tri[0] = cc;
		n_tri[1] = sv;
		geren_ir.Impostos = n_tri;

		Brasil.AdicionarConta(cc);
		Brasil.AdicionarConta(cp);

		for (int x = 0; x < Brasil.TotalDeContas(); x++)
			fiscal.rodar(Brasil.PegarConta(x));

		aux = string.Format("{0:0.00}", fiscal.SaldoTotal);
		Console.WriteLine("Saldo total: " + aux + "\n");

		fiscal.SaldoTotal -= geren_ir.totalTributado();
		aux = string.Format("{0:0.00}", fiscal.SaldoTotal);

		Console.WriteLine("Após pagamentos dos impostos..."); 
		Console.WriteLine("Saldo total: " + aux + "\n");
    }
}

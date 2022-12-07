using Entities;
public class Program
{
    public static void Main(String[] args)
	{
		ContaPoupanca c = new();
		ContaCorrente cc = new();
		ContaPoupanca cp = new();
		Banco Brasil = new();
		AtualizadorDeContas fiscal = new(0.01);

		c.Depositar(1000);
		cc.Depositar (1000);
		cp.Depositar (1000);

		Brasil.AdicionarConta(c);
		Brasil.AdicionarConta(cc);
		Brasil.AdicionarConta(cp);

		Console.WriteLine();

		for (int x = 0; x < Brasil.TotalDeContas(); x++)
			fiscal.rodar(Brasil.PegarConta(x));

		Console.WriteLine( "Saldo total: " + fiscal.SaldoTotal + "\n" );
    }
}

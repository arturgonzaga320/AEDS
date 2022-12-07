using Entities;
public class AtualizadorDeContas
{
	private double selic;
	private double saldoTotal;

	public double Selic
	{
		get { return selic; }
		set { selic = value; }
	}
	public double SaldoTotal
	{
		get { return saldoTotal; } 
		set { saldoTotal = value; }
	}

	// Constructors
	public AtualizadorDeContas (double _selic)
	{
		selic = _selic;
	}

	public void rodar(Conta _conta)
	{
		Console.WriteLine ("Saldo Anterior: " + _conta.Saldo);
		_conta.Atualizar(selic);

		Console.WriteLine ("Saldo Atualizado: " + _conta.Saldo + "\n");
		saldoTotal += _conta.Saldo;
	}
}

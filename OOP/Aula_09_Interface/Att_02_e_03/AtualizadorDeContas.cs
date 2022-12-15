using System;
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
		string aux = string.Format("{0:0.00}", _conta.Saldo);
		Console.WriteLine ("Saldo Anterior: " + aux);
		_conta.Atualizar(selic);

		aux = string.Format("{0:0.00}", _conta.Saldo);
		Console.WriteLine ("Saldo Atualizado: " + aux + "\n");
		saldoTotal += _conta.Saldo;
	}
}

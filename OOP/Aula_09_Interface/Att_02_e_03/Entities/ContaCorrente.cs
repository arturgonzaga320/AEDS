using System;
namespace Entities
{
	public class ContaCorrente:Conta,Tributavel
	{
		public override void Depositar(double deposito)
		{
			deposito -= 0.10;
			saldo += deposito;
		}
		public override void Atualizar(double taxa)
		{
			taxa *= 2;
			saldo += saldo * taxa;
		}
		public double calculaTributos()
		{
			return saldo * 0.01;
		}
	}
}

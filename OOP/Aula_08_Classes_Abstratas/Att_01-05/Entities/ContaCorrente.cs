namespace Entities
{
	public class ContaCorrente : Conta
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
	}
}

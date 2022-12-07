namespace Entities
{
	public abstract class Conta
	{
		protected double saldo;
		public double Saldo
		{
			get { return saldo; }
			set { saldo = value; }
		}

		public abstract void Depositar(double deposito);
		public abstract void Atualizar(double taxa);
		public double Sacar(double valor)
		{
			if (saldo - valor >= 0)
			{
				saldo -= valor;
				return valor;
			}
			Console.WriteLine("Saldo insuficiente para efetuar a operação");
			return 0;
		}
	}
}

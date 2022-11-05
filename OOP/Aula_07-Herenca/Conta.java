
public class Conta {

	protected double saldo;

	// Getters
	public double getSaldo()			{ return this.saldo; }

	// Setters
	public void setSaldo(double saldo_p)		{ this.saldo = saldo_p; }


	public void depositar (double deposito) {

		this.setSaldo ( this.getSaldo() + deposito );
	}

	public double sacar (double valor) {

		if (this.getSaldo() - valor >= 0) {

			this.setSaldo ( this.getSaldo() - valor );
			return valor;
		}
		else {

			System.out.println("Saldo insuficiente para efetuar a operacao");
			return 0;
		}

	}

	public void atualizar (double taxa) {

		this.setSaldo ( this.getSaldo() + (this.getSaldo() * taxa)  );
	}

}

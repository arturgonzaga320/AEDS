
public class AtualizadorDeContas {

	private double selic;
	private double saldoTotal = 0;

	// Getters
	public double getSelic()			{ return this.selic; }
	public double getSaldoTotal()			{ return this.saldoTotal; }

	// Setters
	public void setSelic(double selic_p)		{ this.selic = selic_p; }
	public void setSaldoTotal(double total_p)	{ this.saldoTotal = total_p; }

	// Constructors
	public AtualizadorDeContas (double selic) {
		this.setSelic (selic);
	}

	public void rodar(Conta c) {

		System.out.println("Saldo Anterior: " + c.getSaldo());

		c.atualizar(this.getSelic());

		System.out.println ("Saldo Atualizado: " + c.getSaldo() + "\n");

		this.setSaldoTotal (this.getSaldoTotal() + c.getSaldo());
	}
}

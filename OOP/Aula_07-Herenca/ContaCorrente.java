
public class ContaCorrente extends Conta {

	@Override
	public void depositar ( double deposito ) {

		deposito -= 0.10; // Taxa de deposito
		this.setSaldo (this.getSaldo() + deposito);
	}
	
	@Override
	public void atualizar ( double taxa ) {

		taxa *= 2;
		this.setSaldo( this.getSaldo() + (this.getSaldo() * taxa) );
	}

}

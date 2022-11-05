
public class ContaPoupanca extends Conta {

	@Override
	public void atualizar ( double taxa ) {

		taxa *= 3;
		this.setSaldo( this.getSaldo() + (this.getSaldo() * taxa) );
	}

}

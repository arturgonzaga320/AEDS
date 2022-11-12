public class Teste{

    public static void main(String args[]){

		Conta c = new Conta();
		ContaCorrente cc = new ContaCorrente();
		ContaPoupanca cp = new ContaPoupanca();
		Banco Brasil = new Banco();
		AtualizadorDeContas fiscal = new AtualizadorDeContas (0.01);

		c.depositar(1000);
		cc.depositar (1000);
		cp.depositar (1000);

		Brasil.adicionarConta(c);
		Brasil.adicionarConta(cc);
		Brasil.adicionarConta(cp);

		System.out.println();

		for (int x = 0; x < Brasil.totalDeContas(); x++) {
			fiscal.rodar(Brasil.pegarConta(x));
		}

		System.out.println( "Saldo total: " + fiscal.getSaldoTotal() + "\n" );

    }
}

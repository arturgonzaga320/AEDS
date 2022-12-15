using System;
namespace Entities
{ 
    public class ContaPoupanca : Conta
    {
        public override void Depositar(double deposito)
        {
            deposito -= 0.10;
            saldo += deposito;
        }
        public override void Atualizar(double taxa)
        {
            taxa *= 3;
            saldo += saldo * taxa;
        }
    }
}

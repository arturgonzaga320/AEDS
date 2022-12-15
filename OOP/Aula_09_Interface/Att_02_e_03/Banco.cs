using System;
using Entities;
public class Banco
{
    private Conta[] filiados = Array.Empty<Conta>(); 

    public void AdicionarConta (Conta nova)
    {
        Conta[] novos = new Conta[TotalDeContas() + 1];

        for (int i = 0; i < TotalDeContas(); i++)
            novos[i] = filiados[i];

        novos[TotalDeContas()] = nova;
        filiados = novos;
    }
    public Conta PegarConta (int x)
    {
        if (x < TotalDeContas())
            return filiados[x];

        return null;
    }
    public int TotalDeContas()
    {
        return filiados.Length;
    }
}

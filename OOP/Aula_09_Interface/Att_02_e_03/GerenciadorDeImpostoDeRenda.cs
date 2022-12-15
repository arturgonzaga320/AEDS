using System;
public class GerenciadorDeImpostoDeRenda
{
	private Tributavel[] impostos;

	public Tributavel[] Impostos
	{
		get { return impostos; }
		set { impostos = value; }
	}

	public double totalTributado()
	{
		double total = 0.0;
		for (int i = 0; i < impostos.Length; i++)
			total += impostos[i].calculaTributos();
		return total;
	}
}

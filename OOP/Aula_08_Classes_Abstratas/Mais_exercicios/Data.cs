public class Data
{
    private int dia;
    private int mes;
    private int ano;
    
    public string GetData()
    {
        string data_p = dia + "/" + mes + "/" + ano;
        return data_p;
    }
    public void SetData(int _dia, int _mes, int _ano)
    {
        dia = _dia;
        mes = _mes;
        ano = _ano;
        Validar_Data();
    }

    public Data()
    {
	    dia = 0;
	    mes = 0;
	    ano = 0;
    }
    public Data(int _dia, int _mes, int _ano)
    {
	    SetData(_dia, _mes, _ano);
    }

    public void Validar_Data()
    {
        if (dia > 28 && mes == 2)
        {
            mes += dia / 30;
            dia -= 28;

            Validar_Data();
        }
        
        if (dia > 30)
        {
            mes +=dia / 30;
            if (mes == 2) dia = dia % 28;
            else dia = dia % 30;

            Validar_Data();
        }

        if (mes > 12)
        {
            ano += mes / 12;
            mes %= 12;
            Validar_Data();
        }
    }
    public bool Comparar_Data (Data d2)
    {
        string v1 = GetData();
        string v2 = d2.GetData();
        return v1.Equals(v2);
    }    
}

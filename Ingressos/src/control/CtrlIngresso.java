package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.Ingresso;


//- Crianças: R$ 5.50
//- Estudantes: R$ 8.00
//- Idosos: R$ 6.00
public class CtrlIngresso 
{

	
	
	public Ingresso IngressoCalcula(String data,String tpIngresso, boolean feriado)
	{
		Ingresso ingresso = new Ingresso();
		double valorIngressoBruto;
		
		
		if(tpIngresso.equalsIgnoreCase("Estudantes"))
		{
			valorIngressoBruto=8.0;
			if(getDiaSemana(data)==3)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 50));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if( feriado || getDiaSemana(data)==0 || getDiaSemana(data)>4)
			{
				ingresso.setDesconto(0);
				ingresso.setValor(valorIngressoBruto);
			}
			else
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 35));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			
		}
		
		
		if(tpIngresso.equalsIgnoreCase("Idoso"))
		{
			valorIngressoBruto=6.0;
			if(getDiaSemana(data)==1)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 10));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==2)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 15));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==3)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 40));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==4)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 30));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(feriado || getDiaSemana(data)==0 || getDiaSemana(data)>5)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 5));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else
			{
				ingresso.setDesconto(0);
				ingresso.setValor(valorIngressoBruto);
			}
			
			
			
		}
		if(tpIngresso.equalsIgnoreCase("Criança")||tpIngresso.equalsIgnoreCase("Crianca"))
		{
			valorIngressoBruto=5.5;
			if(getDiaSemana(data)==1)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 10));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==2)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 15));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==3)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 30));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else if(getDiaSemana(data)==5)
			{
				ingresso.setDesconto(CalculaDesconto(valorIngressoBruto, 11));
				ingresso.setValor(CalculaValorIngresso(valorIngressoBruto, ingresso.getDesconto()));
			}
			else
			{
				ingresso.setDesconto(0);
				ingresso.setValor(valorIngressoBruto);
			}
		}
		
		return ingresso;
	}
	
	

	public int getDiaSemana(String data)
	{
		int diaDaSemana=-1;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = sdf.parse(data);
			diaDaSemana= date.getDay();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return diaDaSemana;
	}
	
	public double CalculaDesconto(double valorIngressoBruto,double porcetangem)
	{
		double desconto;
		desconto = (porcetangem*valorIngressoBruto)/100;
		return desconto;
	}
	
	public double CalculaValorIngresso(double valorIngressoBruto,double valorDesconto )
	{
		double total = valorIngressoBruto- valorDesconto;
		return total;
	}
	
	
}

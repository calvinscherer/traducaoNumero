package com.br.calvin.entity;

import java.io.Serializable;

public class Numero implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static String[] numeral = {"zero", "hum","dois","três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
	private static String[] decimal = {"dez", "onze","doze","treze","quatorze","quinze","dezesseis","dezessete","dezoito","dezenove"};
	private static String[] decimalCheio = {"vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"};
	private static String[] centena = {"cem","duzentos","trezentos","quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
	
	
	private String extenso;
	private Integer numero;
	
	public Numero(Integer numero) {
		super();
		this.numero = numero;
		traduzir();
	}
	public String getExtenso() {
		return extenso;
	}
	public void setExtenso(String extenso) {
		this.extenso = extenso;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	private void traduzir() {
		Integer numerico = numero;
		String traducao = "";
		boolean negativo = (numerico < 0);
		
		if(negativo) {
			numerico = numerico * -1;
			traducao += "menos ";
		}
		
		if(numerico>=1000 && numerico <=99999) {
			Integer numeroMilDivisao = numerico / 1000;
			Integer numMilResto = numerico % 1000;
			traducao += geraTraducaoTresDigitos(numeroMilDivisao);
			traducao += " mil";
			if(numMilResto > 0) {
				numerico = numMilResto;
				traducao += " e ";
			}
		}
		
		if(numerico < 1000) {
			traducao += geraTraducaoTresDigitos(numerico);
		}
				
		setExtenso(traducao);
	}
	
	private String geraTraducaoTresDigitos(Integer numero) {
		String traducao = "";
		
		if(numero>=100 && numero<1000) {
			Integer numeroDivisao = numero / 100;
			Integer numeroResto = numero % 100;
			traducao += centena[numeroDivisao-1];
			if(numeroResto > 0) {
				traducao += " e ";	
				numero = numeroResto;
			}	
		}
		if(numero>=10 && numero <20) {
			traducao += decimal[numero-10];
		}else {	
			if(numero>=20 && numero <100) {
				Integer numeroDivisao = numero / 10;
				Integer numeroResto = numero % 10;
				traducao += decimalCheio[numeroDivisao-2];
				if(numeroResto > 0) {
					traducao += " e ";
					numero = numeroResto;
				}
			}
		}
		if(numero < 10) {
			traducao += numeral[numero];
		}
		
		return traducao;
	}
	
	@Override
	public String toString() {
		return "Numero [extenso=" + extenso + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extenso == null) ? 0 : extenso.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		if (extenso == null) {
			if (other.extenso != null)
				return false;
		} else if (!extenso.equals(other.extenso))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
}

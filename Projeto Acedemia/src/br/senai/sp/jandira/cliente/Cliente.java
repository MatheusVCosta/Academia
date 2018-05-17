package br.senai.sp.jandira.cliente;

import javax.print.attribute.standard.RequestingUserName;

public class Cliente {
	private int id;
	private String nome;
	private String dtNasc;
	private String peso;
	private String altura;
	private String sexo;
	private String nvAtividade;
	private String mostrarImc;
	
	private double imc;
	private double tmb;
	private double fcm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNvAtividade() {
		return nvAtividade;
	}

	public void setNvAtividade(String nvAtividade) {
		this.nvAtividade = nvAtividade;
	}
	
	public double IMC(double peso, double altura){
		
		return imc = peso / (altura * altura);
	}

	public String MostrarImc() {
		if (imc <= 16.9) {
			return ("Muito abaixo do peso \nQueda de cabelo, infertilidade, ausência menstrual");
		} else if (imc <= 18.4) {
			return ("Abaixo do peso \nFadiga, stress, ansiedade");
		} else if (imc <= 24.9) {
			return ("Peso normal \nMenor risco de doenças cardíacas e vasculares");
		} else if (imc <= 29.9) {
			return ("Acima do peso \nFadiga, má circulação, varizes");
		} else if (imc <= 34.9) {
			return ("Obesidade Grau 1 \nDiabetes, angina, infarto, aterosclerose");
		} else if (imc <= 40) {
			return ("Obesidade Grau 2 \nApneia do sono, falta de ar");
		} else if (imc >= 40) {
			return ("Obesidade Grau 3 \nRefluxo, dificuldade para se mover, escaras, diabetes, \ninfarto e AVC");
		} else {
			return ("null");
		}
	}
	
	public double TMB(double peso, double altura, double idade) {
		
		if (sexo.equals("F")) {
			tmb = 665 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
		} else{
			tmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
		}
		if(nvAtividade.equals("Sedentário")){
			tmb = tmb * 1.20;
		}else if (nvAtividade.equals("Levemente Ativo")){
			tmb = tmb * 1.37;
		}else if(nvAtividade.equals("Moderadamente Ativo")){
			tmb = tmb * 1.55;
		}else if (nvAtividade.equals("Bastante Ativo")){
			tmb = tmb * 1.72;
		}else if(nvAtividade.equals("Muito Ativo")){
			tmb = tmb * 1.90;
		}
		 return tmb;
		
	}

	public double FMC(double idade, double peso) {
		peso = peso/100;
		if (sexo.equals("F")){
			fcm = ((210-(0.5*idade))- peso);
		}else{
			fcm = ((210-(0.5*idade))- peso) + 4;
		}
		return fcm;
	}
	
	

	
}

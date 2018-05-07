package br.senai.sp.jandira.cliente;

public class Cliente {
	private int id;
	private String nome;
	private String dtNasc;
	private int peso;
	private int altura;
	private String sexo;
	private String nvAtividade;

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

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
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


}

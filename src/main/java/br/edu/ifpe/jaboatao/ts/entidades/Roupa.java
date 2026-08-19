package br.edu.ifpe.jaboatao.ts.entidades;

public class Roupa {
	private String nome;
	private String tamanho;
	private Integer estoque;
	private Double valor; 
	
	public Roupa() {}
	
	public Roupa(String nome, String tamanho, Integer estoque, Double valor) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
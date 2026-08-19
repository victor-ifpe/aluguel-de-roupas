package br.edu.ifpe.jaboatao.ts.entidades;

import java.util.Date;
import java.util.List;

public class Locacao {

	private Cliente cliente;
	private List<Roupa> roupas;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valorLocacao;
	
	public Locacao() {}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValorLocacao() {
		return valorLocacao;
	}
	public void setValorLocacao(Double valor) {
		this.valorLocacao = valor;
	}
	public List<Roupa> getRoupas() {
		return roupas;
	}
	public void setRoupas(List<Roupa> roupas) {
		this.roupas = roupas;
	}
}
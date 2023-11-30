package br.com.model;

public class Plano {

	
	private int idPlano;
	private String tituloPlano;
	private float valorMensal;
	private float valorAnual;
	private String beneficios;
	
	
	public int getIdPlano() {
		return idPlano;
	}
	public void setIdPlano(int idPlano) {
		this.idPlano = idPlano;
	}
	public String getTituloPlano() {
		return tituloPlano;
	}
	public void setTituloPlano(String tituloPlano) {
		this.tituloPlano = tituloPlano;
	}
	public float getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(float valorMensal) {
		this.valorMensal = valorMensal;
	}
	public float getValorAnual() {
		return valorAnual;
	}
	public void setValorAnual(float valorAnual) {
		this.valorAnual = valorAnual;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	
}

package br.com.avaliacoes.states.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.avaliacoes.states.modelo.States;
import br.com.avaliacoes.states.repository.StatesRepository;

public class StatesForm {
	private String nome;
	private String regiao;
	private String capital;
	private Double area;
	private Integer populacao;
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getRegiao() {
		return regiao;
	}



	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}



	public String getCapital() {
		return capital;
	}



	public void setCapital(String capital) {
		this.capital = capital;
	}



	public Double getArea() {
		return area;
	}



	public void setArea(Double area) {
		this.area = area;
	}



	public Integer getPopulacao() {
		return populacao;
	}



	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}



	public States converter() {
		return new States(nome,regiao,populacao,capital,area) ;
	}



	public States atualizar(Long id, StatesRepository statesRepository) {
		States states = statesRepository.getOne(id);
		states.setNome(this.nome);
		states.setPopulacao(this.populacao);
		states.setCapital(this.capital);
		states.setArea(this.area);
		states.setRegiao(this.regiao);
		
		
		return states;
	}
	
	

}

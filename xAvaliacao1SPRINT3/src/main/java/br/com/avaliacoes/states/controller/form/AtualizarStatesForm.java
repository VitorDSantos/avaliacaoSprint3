package br.com.avaliacoes.states.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.avaliacoes.states.modelo.States;
import br.com.avaliacoes.states.repository.StatesRepository;

public class AtualizarStatesForm {
	@NotNull @NotEmpty 
	private String nome;
	@NotNull @NotEmpty 
	private String capital;
	@NotNull @NotEmpty 
	private @NotNull @NotEmpty Integer populacao;
	@NotNull @NotEmpty 
	private Double area;
	@NotNull @NotEmpty 
	private String regiao;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
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

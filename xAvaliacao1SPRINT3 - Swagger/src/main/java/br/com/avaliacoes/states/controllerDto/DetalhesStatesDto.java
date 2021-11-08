package br.com.avaliacoes.states.controllerDto;

import br.com.avaliacoes.states.modelo.States;

public class DetalhesStatesDto {
	private Long id;
	private String nome;
	private Integer populacao;
	private String regiao;
	private Double area;
	private String capital;
	
	public String getCapital() {
		return capital;
	}

	public Double getArea() {
		return area;
	}
	public String getRegiao() {
		return regiao;
	}

	public Integer getPopulacao() {
		return populacao;
	}

	public String getNome() {
		return nome;
	}
	public Long getId() {
		return id;
	}
	public DetalhesStatesDto(States states) {
		this.id = states.getId();
		this.nome = states.getNome();
		this.regiao = states.getRegiao();
		this.area = states.getArea();
		this.populacao = states.getPopulacao();
		this.capital = states.getCapital();
	}
}

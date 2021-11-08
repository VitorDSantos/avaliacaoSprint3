package br.com.avaliacoes.states.controllerDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.avaliacoes.states.controllerDto.StatesDto;
import br.com.avaliacoes.states.modelo.States;

public class StatesDto {
	private Long id;
	private String nome;
	private String regiao;
	private Integer populacao;
	private String capital;
	private Double area;

	
	public StatesDto(States states) {
		this.id = states.getId();
		this.nome = states.getNome();
		this.regiao = states.getRegiao();
		this.populacao = states.getPopulacao();
		this.capital = states.getCapital();
		this.area = states.getArea();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public Integer getPopulacao() {
		return populacao;
	}


	public String getCapital() {
		return capital;
	}


	public Double getArea() {
		return area;
	}

	
	public String getRegiao() {
		return regiao;
	}


	public static List<StatesDto> converter(List<States> state) {
		 
		return state.stream().map(StatesDto::new).collect(Collectors.toList());
	}
	
	public static Page<StatesDto> converterPage(Page<States> state) {
		 
		return state.map(StatesDto::new);
	}

}

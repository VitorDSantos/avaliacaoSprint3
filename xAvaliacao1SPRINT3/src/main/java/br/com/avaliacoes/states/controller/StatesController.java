package br.com.avaliacoes.states.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.avaliacoes.states.controller.form.StatesForm;
import br.com.avaliacoes.states.controllerDto.DetalhesStatesDto;
import br.com.avaliacoes.states.controllerDto.RegiaoDto;
import br.com.avaliacoes.states.controllerDto.StatesDto;
import br.com.avaliacoes.states.modelo.States;
import br.com.avaliacoes.states.repository.StatesRepository;
@RestController
@RequestMapping("/api")
public class StatesController {
	
	@Autowired
	private  StatesRepository statesRepository;

	@GetMapping("/states")
	public List<StatesDto> lista(String regiao){
		
		if(regiao == null) {
			List<States> states;
			
				states = statesRepository.findAll();
			
			return StatesDto.converter(states);
		}else {
			List<States> states = statesRepository.findByRegiao(regiao);
		
			return StatesDto.converter(states);
		}
	}
	
	@PostMapping("/states")
	public ResponseEntity<StatesDto> cadastrar(@RequestBody @Valid StatesForm form, UriComponentsBuilder uriBuilder) {
	
		States states = form.converter();
		statesRepository.save(states);
	
		URI uri = uriBuilder.path("states/{id}").buildAndExpand(states.getId()).toUri() ;
		
		return ResponseEntity.created(uri).body(new StatesDto(states));
	}
	
	@GetMapping("/states/{id}")
	@Transactional

	public ResponseEntity<DetalhesStatesDto> detalhar(@PathVariable Long id) {

		Optional<States> states = statesRepository.findById(id);
		if(states.isPresent()) {
		return  ResponseEntity.ok(new DetalhesStatesDto(states.get()));
		}else {
			return ResponseEntity.notFound().build();
			 }
	}
//************************************************/**********************************************

	@GetMapping("/states/populacao")
	@Cacheable(value = "lista" )

	public Page<StatesDto> lista(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "populacao",direction = Direction.ASC,page = 0, size = 10) Pageable paginacao ){

		if(nome == null) {		
			Page<States> states = statesRepository.findAll(paginacao);
			return StatesDto.converterPage(states);
		}else {
			Page<States> states = statesRepository.findByRegiao(nome,paginacao);
			return StatesDto.converterPage(states);
		}
	}
	
//************************************************/**********************************************

//************************************************/**********************************************

		@GetMapping("/states/area")
		@Cacheable(value = "lista" )

		public Page<StatesDto> listar(@RequestParam(required = false) String nome,
				@PageableDefault(sort = "area",direction = Direction.ASC,page = 0, size = 10) Pageable paginacao ){

			if(nome == null) {		
				Page<States> states = statesRepository.findAll(paginacao);
				return StatesDto.converterPage(states);
			}else {
				Page<States> states = statesRepository.findByRegiao(nome,paginacao);
				return StatesDto.converterPage(states);
			}
		}
		
//************************************************/**********************************************

//************************************************/**********************************************

			@GetMapping("/states/regiao")
			@Cacheable(value = "lista" )

			public Page<StatesDto> listaRegiao(@RequestParam(required = false) String nome,
					@PageableDefault(sort = "regiao",direction = Direction.ASC,page = 0, size = 10) Pageable paginacao ){

				if(nome == null) {		
					Page<States> states = statesRepository.findAll(paginacao);
					return StatesDto.converterPage(states);
				}else {
					Page<States> states = statesRepository.findByRegiao(nome,paginacao);
					return StatesDto.converterPage(states);
				}
			}
			
//************************************************/**********************************************

	@PutMapping("/states/{id}")
	@Transactional
	public ResponseEntity<StatesDto> atualizar(@PathVariable Long id,@RequestBody @Valid StatesForm form){
		Optional<States> opcional = statesRepository.findById(id);
		if(opcional.isPresent()) {
			States states = form.atualizar(id,statesRepository);
			return ResponseEntity.ok(new StatesDto(states));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/states/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<States> opcional = statesRepository.findById(id);
		if(opcional.isPresent()) {
			statesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
}
	}

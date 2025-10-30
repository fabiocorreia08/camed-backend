package br.com.camed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camed.dto.AplicacaoDTO;
import br.com.camed.service.AplicacaoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/aplicacoes")
public class AplicacaoController {
	
	@Autowired
	private AplicacaoService service;

	@GetMapping
    public List<AplicacaoDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public AplicacaoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public AplicacaoDTO salvar(@RequestBody AplicacaoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public AplicacaoDTO atualizar(@PathVariable Long id, @RequestBody AplicacaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }	

}

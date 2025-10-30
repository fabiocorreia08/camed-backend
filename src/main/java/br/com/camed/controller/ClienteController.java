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

import br.com.camed.dto.ClienteDTO;
import br.com.camed.service.ClienteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@GetMapping
    public List<ClienteDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ClienteDTO salvar(@RequestBody ClienteDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }	

}

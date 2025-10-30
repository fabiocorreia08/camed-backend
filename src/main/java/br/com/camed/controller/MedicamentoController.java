package br.com.camed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camed.dto.MedicamentoDTO;
import br.com.camed.service.MedicamentoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService service;

	@GetMapping
    public List<MedicamentoDTO> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public MedicamentoDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public MedicamentoDTO salvar(@RequestBody MedicamentoDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    public MedicamentoDTO atualizar(@PathVariable Long id, @RequestBody MedicamentoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
        	service.remover(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }	
   

}

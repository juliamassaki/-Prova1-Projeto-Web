package com.example.demo;

import com.example.demo.model.Atleta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atletas")
public class AtletaRestController {
    private final AtletaService atletaService;

    public AtletaRestController(AtletaService atletaService) {
        this.atletaService = atletaService;
    }

    @GetMapping("/buscar")
    public List<Atleta> buscar(@RequestParam String nome) {
        return atletaService.buscarPorNome(nome);
    }

    @GetMapping
    public List<Atleta> listar() {
        return atletaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atleta> buscar(@PathVariable Long id) {
        return atletaService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Atleta criarAtleta(@RequestBody Atleta atleta) {
        return atletaService.salvar(atleta);
    }

    @PostMapping("/lote")
    public List<Atleta> criarAtletas(@RequestBody List<Atleta> atletas) {
        return atletas.stream()
                .map(atletaService::salvar)
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return atletaService.remover(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}

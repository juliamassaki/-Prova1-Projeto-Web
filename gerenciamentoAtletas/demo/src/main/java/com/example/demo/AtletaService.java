package com.example.demo;

import com.example.demo.model.Atleta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaService {

    private final AtletaRepository atletaRepository;

    public AtletaService(AtletaRepository atletaRepository) {
        this.atletaRepository = atletaRepository;
    }

    public List<Atleta> listar() {
        return atletaRepository.findAll();
    }

    public Optional<Atleta> buscar(Long id) {
        return atletaRepository.findById(id);
    }

    public Atleta salvar(Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    public Atleta atualizar(Long id, Atleta atletaAtualizado) {
        return atletaRepository.findById(id).map(atleta -> {
            atleta.setNome(atletaAtualizado.getNome());
            atleta.setIdade(atletaAtualizado.getIdade());
            atleta.setEsporte(atletaAtualizado.getEsporte());
            atleta.setCategoria(atletaAtualizado.getCategoria());
            atleta.setProfissional(atletaAtualizado.isProfissional());
            atleta.setOlimpiadas(atletaAtualizado.isOlimpiadas());
            atleta.setTipoOlimpico(atletaAtualizado.getTipoOlimpico());
            return atletaRepository.save(atleta);
        }).orElseThrow(() -> new RuntimeException("Atleta não encontrado"));
    }

    public boolean remover(Long id) {
        return atletaRepository.findById(id).map(atleta -> {
            atletaRepository.delete(atleta);
            return true;
        }).orElse(false);
    }

    public List<Atleta> buscarPorNome(String nome) {
        return atletaRepository.findByNomeContainingIgnoreCase(nome);
    }
}
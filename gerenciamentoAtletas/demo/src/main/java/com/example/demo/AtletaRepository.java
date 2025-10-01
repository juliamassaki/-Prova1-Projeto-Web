package com.example.demo;

import com.example.demo.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    List<Atleta> findByNomeContainingIgnoreCase(String nome);
}

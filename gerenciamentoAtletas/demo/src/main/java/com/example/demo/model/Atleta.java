package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O nome deve conter apenas letras e espaços")
    private String nome;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 1, message = "A idade deve ser maior que zero")
    @Max(value = 100, message = "A idade deve ser menor que 100")
    private Integer idade;

    @NotBlank(message = "O esporte é obrigatório")
    private String esporte;

    @NotNull(message = "A categoria é obrigatória")
    @Enumerated(EnumType.STRING)
    private CategoryType categoria;


    private boolean profissional;
    private boolean olimpiadas;
    private String tipoOlimpico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public String getEsporte() { return esporte; }
    public void setEsporte(String esporte) { this.esporte = esporte; }

    public CategoryType getCategoria() { return categoria; }
    public void setCategoria(CategoryType categoria) { this.categoria = categoria; }

    public boolean isProfissional() { return profissional; }
    public void setProfissional(boolean profissional) { this.profissional = profissional; }

    public boolean isOlimpiadas() { return olimpiadas; }
    public void setOlimpiadas(boolean olimpiadas) { this.olimpiadas = olimpiadas; }

    public String getTipoOlimpico() { return tipoOlimpico; }
    public void setTipoOlimpico(String tipoOlimpico) { this.tipoOlimpico = tipoOlimpico; }

}

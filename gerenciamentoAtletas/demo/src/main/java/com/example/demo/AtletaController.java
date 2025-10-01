package com.example.demo;

import com.example.demo.model.Atleta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/atletas")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("atletas", atletaService.listar());
        return "lista";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nome, Model model) {
        model.addAttribute("atletas", atletaService.buscarPorNome(nome));
        model.addAttribute("nomeBuscado", nome);
        return "lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("atleta", new Atleta());
        return "form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute Atleta atleta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("atleta", atleta);
            return "form";
        }
        atletaService.salvar(atleta);
        model.addAttribute("mensagemSucesso", "Atleta cadastrado com sucesso!");
        return "redirect:/atletas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        Optional<Atleta> atleta = atletaService.buscar(id);
        if (atleta.isEmpty()) {
            model.addAttribute("mensagemErro", "Atleta não encontrado!");
            return "redirect:/atletas";
        }
        model.addAttribute("atleta", atleta.get());
        return "form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @Valid @ModelAttribute Atleta atleta, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        atletaService.atualizar(id, atleta);
        model.addAttribute("mensagemSucesso", "Atleta atualizado com sucesso!");
        return "redirect:/atletas";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id, Model model) {
        boolean removido = atletaService.remover(id);
        if (!removido) {
            model.addAttribute("mensagemErro", "Atleta não encontrado!");
        }
        return "redirect:/atletas";
    }
}

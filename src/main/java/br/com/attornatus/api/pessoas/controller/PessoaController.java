package br.com.attornatus.api.pessoas.controller;

import br.com.attornatus.api.pessoas.dto.pessoa.AtualizacaoPessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.PessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.RespostaPessoaDto;
import br.com.attornatus.api.pessoas.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid PessoaDto pessoaDto) {
        pessoaService.salvar(pessoaDto);
    }

    @GetMapping
    public List<RespostaPessoaDto> buscarTodas() {
        return pessoaService.buscarTodas();
    }

    @GetMapping("buscarPorId/{id}")
    public RespostaPessoaDto buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public List<RespostaPessoaDto> buscarPorNome(@PathVariable String nome) {
        return pessoaService.buscarPorNome(nome);
    }

    @PutMapping("/{id}")
    public void editar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPessoaDto pessoaDto) {
        pessoaService.editar(id, pessoaDto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
    }
}
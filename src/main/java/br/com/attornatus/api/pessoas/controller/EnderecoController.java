package br.com.attornatus.api.pessoas.controller;

import br.com.attornatus.api.pessoas.dto.endereco.AtualizacaoEnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.EnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.RespostaEnderecoDto;
import br.com.attornatus.api.pessoas.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pessoas/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{idPessoa}")
    public List<RespostaEnderecoDto> buscarEnderecoPorPessoa(@PathVariable Long idPessoa) {
        return enderecoService.buscarEnderecos(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public void cadastrarEndereco(@PathVariable Long idPessoa, @RequestBody @Valid EnderecoDto enderecoDto) {
        enderecoService.cadastrarEndereco(idPessoa, enderecoDto);
    }

    @PutMapping("/{idPessoa}")
    public void editarEndereco(@PathVariable Long idPessoa, @RequestBody @Valid AtualizacaoEnderecoDto enderecoDto) {
        enderecoService.editarEndereco(idPessoa, enderecoDto);
    }
}
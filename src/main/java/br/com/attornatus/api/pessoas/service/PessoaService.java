package br.com.attornatus.api.pessoas.service;

import br.com.attornatus.api.pessoas.dto.pessoa.AtualizacaoPessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.PessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.RespostaPessoaDto;

import java.util.List;

public interface PessoaService {

    void salvar(PessoaDto pessoaDto);

    void editar(Long id, AtualizacaoPessoaDto pessoaDto);

    RespostaPessoaDto buscarPorId(Long id);

    List<RespostaPessoaDto> buscarPorNome(String nome);

    List<RespostaPessoaDto> buscarTodas();

    void deletar(Long id);

}
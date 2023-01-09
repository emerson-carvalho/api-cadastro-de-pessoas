package br.com.attornatus.api.pessoas.service;

import br.com.attornatus.api.pessoas.dto.endereco.AtualizacaoEnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.EnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.RespostaEnderecoDto;

import java.util.List;

public interface EnderecoService {

    List<RespostaEnderecoDto> buscarEnderecos(Long idPessoa);

    void cadastrarEndereco(Long idPessoa, EnderecoDto enderecoDto);

    void editarEndereco(Long idPessoa, AtualizacaoEnderecoDto enderecoDto);

}

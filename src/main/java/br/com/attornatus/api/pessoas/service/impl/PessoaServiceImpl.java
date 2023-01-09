package br.com.attornatus.api.pessoas.service.impl;

import br.com.attornatus.api.pessoas.dto.pessoa.AtualizacaoPessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.PessoaDto;
import br.com.attornatus.api.pessoas.dto.pessoa.RespostaPessoaDto;
import br.com.attornatus.api.pessoas.model.Pessoa;
import br.com.attornatus.api.pessoas.repository.PessoaRepository;
import br.com.attornatus.api.pessoas.service.PessoaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public void salvar(PessoaDto pessoaDto) {
        Pessoa pessoa = modelMapper.map(pessoaDto, Pessoa.class);
        pessoa.getEnderecos().forEach(endereco -> {
                    enderecoService.preencherEnderecoPeloCep(endereco.getCep(), endereco);
                    endereco.setPessoa(pessoa);
                }
        );
        repository.save(pessoa);
    }

    @Override
    public void editar(Long id, AtualizacaoPessoaDto pessoaDto) {
            Pessoa pessoa = repository.getReferenceById(id);
            pessoa.editar(pessoaDto);
            repository.save(pessoa);

    }

    @Override
    public RespostaPessoaDto buscarPorId(Long id) {
        Pessoa pessoa = repository.getReferenceById(id);
        return modelMapper.map(pessoa, RespostaPessoaDto.class);
    }

    @Override
    public List<RespostaPessoaDto> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream().map(p -> modelMapper.map(p, RespostaPessoaDto.class))
                .toList();
    }

    @Override
    public List<RespostaPessoaDto> buscarTodas() {
        return repository.findAll()
                .stream().map(p -> modelMapper.map(p, RespostaPessoaDto.class))
                .toList();
    }

    @Override
    public void deletar(Long id) {
        Pessoa pessoa = repository.getReferenceById(id);
        repository.delete(pessoa);
    }

}
package br.com.attornatus.api.pessoas.service.impl;

import br.com.attornatus.api.pessoas.dto.endereco.AtualizacaoEnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.EnderecoDto;
import br.com.attornatus.api.pessoas.dto.endereco.RespostaEnderecoDto;
import br.com.attornatus.api.pessoas.model.Endereco;
import br.com.attornatus.api.pessoas.model.EnderecoPrincipal;
import br.com.attornatus.api.pessoas.model.Pessoa;
import br.com.attornatus.api.pessoas.repository.EnderecoRepository;
import br.com.attornatus.api.pessoas.repository.PessoaRepository;
import br.com.attornatus.api.pessoas.service.EnderecoService;
import br.com.attornatus.api.pessoas.service.ViaCepService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RespostaEnderecoDto> buscarEnderecos(Long idPessoa) {
        Pessoa pessoa = pessoaRepository.getReferenceById(idPessoa);
        return pessoa.getEnderecos()
                .stream().map(e -> modelMapper.map(e, RespostaEnderecoDto.class))
                .toList();
    }

    @Override
    public void cadastrarEndereco(Long idPessoa, EnderecoDto dto) {
        Pessoa pessoa = pessoaRepository.getReferenceById(idPessoa);
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        preencherEnderecoPeloCep(endereco.getCep(), endereco);
        if (!pessoa.existeEnderecoPrincipal() | dto.getEnderecoPrincipal().equals(EnderecoPrincipal.NAO)) {
            endereco.setPessoa(pessoa);
            enderecoRepository.save(endereco);
        } else {
            throw new IllegalArgumentException("Já existe endereço principal");
        }
    }

    @Override
    public void editarEndereco(Long idPessoa, AtualizacaoEnderecoDto dto) {
        Pessoa pessoa = pessoaRepository.getReferenceById(idPessoa);
        EnderecoPrincipal enderecoPrincipalDto = dto.getEnderecoPrincipal();
        Boolean encontrou = false;
        for (Endereco endereco: pessoa.getEnderecos()){
            if (endereco.getId().equals(dto.getId())) {
                encontrou = true;
                if (!pessoa.existeEnderecoPrincipal() | enderecoPrincipalDto == EnderecoPrincipal.NAO | enderecoPrincipalDto == null) {
                    endereco.atualizar(dto);
                    preencherEnderecoPeloCep(endereco.getCep(), endereco);
                    enderecoRepository.save(endereco);
                } else {
                    throw new IllegalArgumentException("Já existe endereço principal");
                }
           }
        }
        if(!encontrou){
            throw new NotFoundException("Endereço não encontrado");
        }
    }


    public void preencherEnderecoPeloCep(String cep, Endereco endereco) {
        RespostaEnderecoDto dto = viaCepService.consultarCep(cep);
        endereco.setLocalidade(dto.getLocalidade());
        endereco.setLogradouro(dto.getLogradouro());
    }
}
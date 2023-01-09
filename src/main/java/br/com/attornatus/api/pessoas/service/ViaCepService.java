package br.com.attornatus.api.pessoas.service;

import br.com.attornatus.api.pessoas.dto.endereco.RespostaEnderecoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping(value = "/{cep}/json/")
    RespostaEnderecoDto consultarCep(@PathVariable("cep") String cep);
}

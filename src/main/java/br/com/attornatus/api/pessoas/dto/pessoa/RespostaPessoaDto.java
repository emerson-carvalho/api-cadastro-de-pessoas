package br.com.attornatus.api.pessoas.dto.pessoa;

import br.com.attornatus.api.pessoas.dto.endereco.RespostaEnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaPessoaDto {

    private Long id;

    private String nome;

    private String dataNascimento;

    private List<RespostaEnderecoDto> enderecos;

}

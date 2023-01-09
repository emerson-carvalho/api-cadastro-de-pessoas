package br.com.attornatus.api.pessoas.dto.pessoa;

import br.com.attornatus.api.pessoas.dto.endereco.EnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String dataNascimento;

    @NotNull
    private List<EnderecoDto> enderecos = new ArrayList<>();

}

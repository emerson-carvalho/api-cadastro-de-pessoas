package br.com.attornatus.api.pessoas.dto.endereco;

import br.com.attornatus.api.pessoas.model.EnderecoPrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoEnderecoDto {

    @NotNull
    private Long id;

    private String cep;

    private Integer numero;

    private EnderecoPrincipal enderecoPrincipal;
}

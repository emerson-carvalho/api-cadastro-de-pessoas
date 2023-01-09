package br.com.attornatus.api.pessoas.dto.endereco;

import br.com.attornatus.api.pessoas.model.EnderecoPrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaEnderecoDto {
    private Long id;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String localidade;

    private EnderecoPrincipal enderecoPrincipal;
}

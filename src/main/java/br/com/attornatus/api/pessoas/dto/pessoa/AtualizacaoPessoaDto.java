package br.com.attornatus.api.pessoas.dto.pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoPessoaDto {

    private String nome;

    private String dataNascimento;
}

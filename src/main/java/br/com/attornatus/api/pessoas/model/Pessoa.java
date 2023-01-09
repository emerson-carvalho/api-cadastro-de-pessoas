package br.com.attornatus.api.pessoas.model;

import br.com.attornatus.api.pessoas.dto.pessoa.AtualizacaoPessoaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dataNascimento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
    private List<Endereco> enderecos = new ArrayList<>();

    public void editar(AtualizacaoPessoaDto dto) {
        if (dto.getNome() != null) {
            this.nome = dto.getNome();
        }
        if (dto.getDataNascimento() != null) {
            this.dataNascimento = dto.getDataNascimento();
        }    }

    public Boolean existeEnderecoPrincipal() {
        for (Endereco endereco : enderecos) {
            if (endereco.ePrincipal()) {
                return true;
            }
        }
        return false;
    }
}
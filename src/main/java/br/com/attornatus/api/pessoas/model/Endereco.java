package br.com.attornatus.api.pessoas.model;

import br.com.attornatus.api.pessoas.dto.endereco.AtualizacaoEnderecoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private String logradouro;

    private Integer numero;

    private String localidade;

    @Enumerated(EnumType.STRING)
    private EnderecoPrincipal enderecoPrincipal;

    @ManyToOne
    private Pessoa pessoa;

    public Boolean ePrincipal() {
        return enderecoPrincipal.equals(EnderecoPrincipal.SIM);
    }

    public void atualizar(AtualizacaoEnderecoDto dto) {
        if (dto.getEnderecoPrincipal() != null) {
            this.enderecoPrincipal = dto.getEnderecoPrincipal();
        }
        if (dto.getCep() != null) {
            this.cep = dto.getCep();
        }
        if (dto.getNumero() != null) {
            this.numero = dto.getNumero();
        }
    }
}
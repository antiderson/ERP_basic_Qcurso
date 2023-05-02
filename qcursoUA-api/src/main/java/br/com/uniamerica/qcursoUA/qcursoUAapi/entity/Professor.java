package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tb_professores", schema = "qcursoua")
@NoArgsConstructor
public class Professor extends AbstractEntity {

    public Professor(String nome, String endereco, String especialidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.especialidade = especialidade;
    }

    @Getter
    @Setter
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "O nome deve conter apenas letras")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Getter
    @Setter
    @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]+$", message = "A especialidade deve conter apenas letras")
    @Column(name = "especialidade", nullable = false)
    private String especialidade;

}
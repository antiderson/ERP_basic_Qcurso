package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_professores", schema = "qcursoua")
@NoArgsConstructor
public class Professor extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Getter @Setter
    @Column(name = "especialidade", nullable = false)
    private String especialidade;

}

package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "td_alunos", schema = "qcursoua")
@NoArgsConstructor
public class Aluno extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Getter @Setter
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "id_turmas", nullable = true)
    private List<Turma> turmas;


}

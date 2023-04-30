package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_turmas", schema = "qcursoua")
@NoArgsConstructor
public class Turma extends AbstractEntity {

    @Getter @Setter
    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Getter @Setter
    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Getter @Setter
    @OneToMany
    @JoinColumn(name = "id_professores", nullable = false)
    private List<Professor> professores;


}
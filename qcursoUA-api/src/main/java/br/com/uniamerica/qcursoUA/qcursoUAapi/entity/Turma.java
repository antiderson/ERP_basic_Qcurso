package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "td_turmas", schema = "qcursoua")
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
    @ManyToOne
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor professor;


}

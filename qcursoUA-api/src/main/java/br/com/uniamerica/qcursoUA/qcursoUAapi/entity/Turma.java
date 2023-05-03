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


    public Turma(Integer semestre, Integer ano, Curso curso, List<Professor> professores){
       this.semestre = semestre;
       this.ano = ano;
       this.curso = curso;
       this.professores = professores;
   }

    public void cadastro(Integer semestre, Integer ano, Curso curso, List<Professor> professores){

        if (semestre == null && ano != null){
            throw new RuntimeException("Preencha o campo de semestre por favor");
        }else{
            System.out.println("Dados corretos");
        }

        if (semestre != null && ano == null){
            throw new RuntimeException("Preencha o campo de ano por favor");
        }else{
            System.out.println("Dados corretos");
        }

        if (semestre == null && ano == null){
            throw new RuntimeException("Preencha os campos ano e semestre por favor");
        }else{
            System.out.println("Dados corretos");
        }

        if (semestre == 0 && ano != null){
            throw new RuntimeException("Preencha os campo semestre com um valor acima de zero por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (semestre == 0 && ano == null){
            throw new RuntimeException("Preencha os campo semestre com um valor acima de zero e preencha o campo ano por favor!");
        }else {
            System.out.println("Dados corretos");
        }

        if (semestre < 0 && ano != null){
            throw new RuntimeException("Preencha o campo semestre inteiro/acima de zero por favor!");
        }else {
            System.out.println("Dados corretos");
        }

        if (semestre < 0 && ano == null){
            throw new RuntimeException("Preencha o campo semestre inteiro/acima de zero e tambem preencha o campo ano por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano == 0 && semestre == 0){
            throw new RuntimeException("Preencha os campos ano e semetre com valores maiores que zero por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano == 0 && semestre < 0){
            throw new RuntimeException("Preencha o campo ano com valor maior que zero e o campo semestre com valor positivo/maior que zero por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano == 0 && semestre == null){
            throw new RuntimeException("Preencha o campo ano com valor acima de zero e o campo semestre deve ser preenchido por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano < 0 && semestre < 0){
            throw new RuntimeException("Preencha os campos ano e semestre com valores positivos/acima de zero por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano < 0 && semestre == null){
            throw new RuntimeException("Preencha o campo ano com valor positivo/acima de zero e o campo semestre deve ser preenchido por favor!");
        }else{
            System.out.println("Dados corretos");
        }

        if (ano < 0 && semestre == 0){
            throw new RuntimeException("Preencha o campo ano com valor positivo/acima de zero e o campo semestre com valor maior que zero por favor!");
        }else{
            System.out.println("Dados corretos");
        }


        if (ano != null && semestre != null && curso != null && professores != null){
         throw new RuntimeException("Preencha todos os campos por favor!");
        }else{
         System.out.println("Dados corretos");
        }
    }

}
package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_alunos", schema = "qcursoua")
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
    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = true)
    private Turma turma;

    public Aluno(String nome, Integer idade, String endereco, Turma turma){
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.turma = turma;
    }

    public void cadastrar(String nome, Integer idade, String endereco, Turma turma) {
        if (nome == null) {
            throw new RuntimeException("Nao e possivel realizar o cadastro sem um nome por favor preencha o campo");
        }
        if (idade == null) {
            throw new RuntimeException("Nao e possivel realizar o cadastro sem a idade do aluno");
        }
        if (endereco == null) {
            throw new RuntimeException("Nao e possivel realizar o cadastro sem o endereco");
        }
        if (nome != null && idade != null) {
            throw new RuntimeException("Preencha o campo de nome e idade, se nao sera possivel cadastrar");
        }
        if (endereco != null && turma != null) {
            throw new RuntimeException("Preencha o campo de endereco e o de turma, se nao sera possivel cadastrar");
        }
        if (nome == null && turma == null) {
            throw new RuntimeException("Preencha o campo de nome e o de turma, se nao sera possivel cadastrar");
        }
        if (idade == null && endereco == null) {
            throw new RuntimeException("Preencha o campo de idade e o de endereco, se nao sera possivel cadastrar");
        }
        if (nome != null && idade != null && endereco != null && turma != null) {
            throw new RuntimeException("Preencha todos os campos para realizar o cadastro");
        }
        if (!nome.matches("[a-zA-Z]+")) {
            throw new RuntimeException("O nome deve conter apenas letras.");
        }
        if (idade >= 17 && idade <= 100) {
            throw new RuntimeException("Cadastre uma idade entre 17 e 100");
        }
        if (idade <= 0) {
            throw new RuntimeException("Nao e possivel cadastrar numeros negativos");
        }
    }
}




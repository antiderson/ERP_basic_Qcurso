package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_professores", schema = "qcursoua")
@NoArgsConstructor
public class Professor extends AbstractEntity {

    @Getter
    @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter
    @Setter
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Getter
    @Setter
    @Column(name = "especialidade", nullable = false)
    private String especialidade;


     public Professor(String nome, String endereco, String especialidade){
        this.nome = nome;
        this.endereco = endereco;
        this.especialidade = especialidade;
    }


    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getEspecialidade(){
        return especialidade;
    }

}


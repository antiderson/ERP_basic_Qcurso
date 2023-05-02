package br.com.uniamerica.qcursoUA.qcursoUAapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cursos", schema = "qcursoua")
@NoArgsConstructor
public class Curso extends AbstractEntity{
    @Getter @Setter
    @Column(name = "nome", nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "sigla", nullable = false)
    private String sigla;

   public Curso(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }
    
    public String getNome() {//teste integracao
        return nome;
    }

    public String getSigla() {//teste integracao
        return sigla;
    }

}

package TurmaTest;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class TurmaTesteIntegracao {

    private Turma turma;
    private  Curso curso;
    private List<Professor> professores;

    @BeforeEach
    public void setUp(){
        turma = new Turma();
        curso = new Curso();
        professores = new ArrayList<>();
    }


    @Test
    @DisplayName("Deve adicionar cursos")
    public void testAdicionarCurso(){
        Curso curso01 = new Curso("Medicina", "Med");
        Assertions.assertEquals("Medicina", curso01.getNome());
    }

    @Test
    @DisplayName("Deve cadastrar professores")
    public void testeAdicionarProfessor(){
          Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
          Assertions.assertEquals("Angela", professor01.getNome());
    }

    @Test
    @DisplayName("Deve cadastrar uma lista de professores")
    public void testeAdicionarProfessorNaLista(){
        Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor01);
        Assertions.assertEquals(1, professores.size(), "Deve ter 1 professor a lista");
    }

    @Test
    @DisplayName("Deve retonar especialidade do professor")
    public void testeEncontrarEspecialidade(){
         Professor professor02 = new Professor("Celine", "Rua João Pessoa", "veterinaria");
         Assertions.assertEquals("veterinaria", professor02.getEspecialidade());
    }

    @Test
    @DisplayName("Deve vincular lista de professores a uma turma e verificar o tamanho do array de professores")
    public void testeVincularListaProfessoresATurma(){
        Turma turma01 = new Turma();
        Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor01);
        turma01.setProfessores(professores);
        Assertions.assertEquals(1, turma01.getProfessores().size());
    }

    @Test
    @DisplayName("Deve adicionar uma turma")
    public void testeAdicionarTurma(){
        Turma turma01 = new Turma();
        Curso curso01 = new Curso("Medicina", "Med");
        Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor01);
        turma01.setProfessores(professores);
        turma01.setAno(2023);
        turma01.setSemestre(4);
        turma01.setCurso(curso01);
        Assertions.assertEquals(2023, turma01.getAno());
    }


    @Test
    @DisplayName("Deve adicionar varios professores a uma turma")
    public void testeAdicionarVariosProfessoresTurma(){
        Turma turma01 = new Turma();
        Curso curso01 = new Curso("Medicina", "Med");
        Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
        Professor professor02 = new Professor("Celine", "Rua João Pessoa", "veterinaria");
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(professor01);
        professores.add(professor02);
        turma01.setProfessores(professores);
        turma01.setAno(2023);
        turma01.setSemestre(4);
        turma01.setCurso(curso01);
        Assertions.assertEquals(2, turma01.getProfessores().size());
    }

    @Test
    @DisplayName("Deve achar a sigla do curso")
    public void testeRetornarSiglaCurso(){
        Curso curso01 = new Curso("Medicina", "Med");
        Assertions.assertEquals("Med", curso01.getSigla());
    }

    @Test
    @DisplayName("Deve retonar o endereco do professor")
    public void testeRetornarEnderecoProfessor(){
        Professor professor01 = new Professor("Angela", "Rua Bela Vista", "medicina");
        Assertions.assertEquals("Rua Bela Vista", professor01.getEndereco());
    }
}
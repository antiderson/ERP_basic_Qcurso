package br.com.uniamerica.qcursoUA.qcursoUAapi.AlunoTest;

import br.com.uniamerica.qcursoUA.qcursoUAapi.QcursoUaApiApplication;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Aluno;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.AlunoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = QcursoUaApiApplication.class)
public class AlunoTestIntegracao {
    //Antes de rodar o teste configure o banco de dados
    private Aluno aluno;

    private Turma turma;

    @Autowired
    private AlunoService alunoService;

    @Test
    @DisplayName("deve adicionar alunos")
    public void deveAdicionarAlunos() {
        Aluno aluno1 = new Aluno("Giovana", 20, "ruaQ", turma);
        alunoService.save(aluno1);
        assertNotNull(aluno1.getId());

        Aluno aluno2 = new Aluno("Roberto", 21, "ruaW", turma);
        alunoService.save(aluno2);
        assertNotNull(aluno2.getId());

        Aluno aluno3 = new Aluno("Joao", 23, "ruaE", turma);
        alunoService.save(aluno3);
        assertNotNull(aluno3.getId());
    }
    @Test
    @DisplayName("deve atualizar cadastro de aluno")
    public void deveAtualizarCadastrDeAluno(){
        // Cria um aluno e salvá no banco de dados
        Aluno aluno = new Aluno("Albert", 24, "ruaEl", turma);
        alunoService.save(aluno);

        aluno.setNome("Joao E");
        aluno.setIdade(32);
        aluno.setEndereco("rua XY3");
        aluno.setTurma(turma);
        alunoService.atualizarGeral(aluno.getId(), aluno);

        // Verificar se o endereço do aluno foi atualizado corretamente
        Aluno alunoAtualizado = alunoService.findById(aluno.getId());
        assertEquals("Joao E", alunoAtualizado.getNome());
        assertEquals(32, alunoAtualizado.getIdade());
        assertEquals("rua XY3", alunoAtualizado.getEndereco());
        assertEquals(turma, alunoAtualizado.getTurma());
    }

    @Test
    @DisplayName("deve deletar cadastro de aluno")
    public void deveDeletarCadastroDeAluno(){
        Aluno aluno = new Aluno("Albert", 24, "ruaEl", turma);
        alunoService.save(aluno);

        alunoService.deletarGeral(aluno.getId());

        Assertions.assertThrows(RuntimeException.class, () -> alunoService.findById(aluno.getId()));
    }
}

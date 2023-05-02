package br.com.uniamerica.qcursoUA.qcursoUAapi;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import org.junit.jupiter.api.*;

import java.util.List;

public class TurmaTest {


    private Turma turma;
    private static Integer semestre;
    private static Integer ano;
    private static Curso curso;

    private static List<Professor> professores;

    //dados definodos para teste

    private static Integer semestreNullo;//teste01
    private static Integer semestreNaoNullo;
    private static Integer semestreZero;
    private static Integer semestreNegativo;

    private static Integer anoNãoNullo;//teste01
    private static Integer anoNullo;
    private static Integer anoZero;
    private static Integer anoNegativo;

    private static Curso cursoValido;
    private static Curso cursoNullo;
    private static List<Professor> professoresValidos;
    private static List<Professor> professoresNullos;


    //fim da definição


    @BeforeAll
    public static void definirValoresPadrao() {

        semestreNullo = null;
        semestreNegativo = -10;
        semestreNaoNullo = 4;
        semestreZero = 0;
        anoNãoNullo = 2023;
        anoNullo = null;
        anoZero = 0;
        anoNegativo = -20;
        cursoValido = curso;
        cursoNullo = null;
        professoresValidos = professores;
        professoresNullos = null;


    }

    @BeforeEach
    public void inicializarTurma() {
        turma = new Turma();
    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com campo de semestre faltando a ser preenchido")
    public void deveNegarCadastroTurmaComSemestreNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNullo, anoNãoNullo, cursoValido, professoresValidos));
    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com campo ano faltando a ser preenchido")
    public void deveNegarCadastroTurmaComAnoNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNaoNullo, anoNullo, cursoValido, professoresValidos));
    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com os campos ano e semestre falatando a ser preenchido")
    public void deveNegarCadastroTurmaComAnoESemestreNullos() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNullo, anoNullo, cursoValido, professoresValidos));
    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com o valor do campo semestre igual a zero")
    public void deveNegarCadastroSemestreZero() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreZero, anoNãoNullo, cursoValido, professoresValidos));
    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com o valor do campo semestre igual a zero e ano nullo")
    public void deveNegarCadastroSemestreZeroEAnoNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreZero, anoNullo, cursoValido, professoresValidos));

    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre negativo e ano não nullo")
    public void deveNegarCadastroSemestreNegativo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNegativo, anoNãoNullo, cursoValido, professoresValidos));

    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre negativo e ano nullo")
    public void deveNegarCadastroSemestreNegativoEAnoNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNegativo, anoNullo, cursoValido, professoresValidos));

    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre zero e ano zero")
    public void deveNegarCadastroAnoZeroESemestreZero() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreZero, anoZero, cursoValido, professoresValidos));

    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre negativo/abaixo de zero e ano zero")
    public void deveNegarCadastroAnoZeroESemestreNegativo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNegativo, anoZero, cursoValido, professoresValidos));

    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre nullo e ano zero")
    public void deveNegarCadastroTurmaComAnoZeroESemestreNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNullo, anoZero, cursoValido, professoresValidos));
    }


    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre negativo e ano negativo")
    public void deveNegarCadastroTurmaComAnoNegativoESemestreNegativo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNegativo, anoNegativo, cursoValido, professoresValidos));

    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre nullo e ano negativo")
    public void deveNegarCadastroTurmaComAnoNegativoESemestreNullo() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNullo, anoNegativo, cursoValido, professoresValidos));
    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com semestre zero e ano negativo")
    public void deveNegarCadastroTurmaComAnoNegativoESemestreZero() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreZero, anoNegativo, cursoValido, professoresValidos));
    }

    @Test
    @DisplayName("Não deve aceitar cadastro da turma com todos os campos nullos")
    public void deveNegarCadastroTurmaComTodosOsCamposNullos() {
        Assertions.assertThrows(RuntimeException.class, () -> turma.cadastro(semestreNullo, anoNullo, cursoNullo, professoresNullos));
    }
}
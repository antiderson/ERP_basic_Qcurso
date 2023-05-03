package AlunoTest;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Aluno;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import org.junit.jupiter.api.*;

public class AlunoTestUnidade {

    private Aluno aluno;

    private Aluno outroAluno;

    private Aluno aluno1;
    private Aluno aluno2;
    private Aluno aluno3;
    private Aluno aluno4;

    private static String nome;

    private static Integer idade;

    private static String endereco;

    private static Turma turma;
    private static Turma turmaValida;

    private static Turma turmaNullo;

    private static String nomeNullo;

    private static Integer idadeNullo;

    private static Integer idadeNunNegativo;

    private static String enderecoNullo;

    private static int testeIdNegativo;

    @BeforeAll
    public static void definicaodeValoresPadroes() {
        nome = "Joao";
        idade = 20;
        idadeNunNegativo = -2;
        endereco = "ruaA";
        turmaValida = turma;
        turmaNullo = null;
        nomeNullo = null;
        idadeNullo = null;
        enderecoNullo = null;
        testeIdNegativo = -1;

        System.out.println("-- BeforeAll -- ");
    }

    @BeforeEach
    public void inicializarAluno() {
        turma = new Turma();
        turma.setId(1L);

        aluno = new Aluno();
        aluno.setId(1L);
        aluno.setNome("Joao");
        aluno.setIdade(20);
        aluno.setEndereco("ruaA");

        aluno1 = new Aluno();
        aluno1.setId(-1L);
        aluno2 = new Aluno();
        aluno3 = new Aluno();
        aluno4 = new Aluno();

        outroAluno = new Aluno();
        outroAluno.setNome("Ana");
        outroAluno.setIdade(20);
        outroAluno.setEndereco("ruaS");



        System.out.println("-- BeforeEach -- ");
    }

    @Test
    @DisplayName("deve retornar o nome do aluno")
    public void deveRetornarONomeDoAluno() {
        Assertions.assertEquals(nome, aluno.getNome());
    }

    @Test
    @DisplayName("deve retorar a idade do aluno")
    public void deveRetornarAIdadeDoAluno() {

        Assertions.assertEquals(idade, aluno.getIdade());
    }

    @Test
    @DisplayName("deve retorar o endereco do aluno")
    public void deveRetornarOEnderecoDoAluno() {

        Assertions.assertEquals(endereco, aluno.getEndereco());
    }

    @Test
    @DisplayName("deve retorar o id do aluno")
    public void deveRetornarOIdDoAluno() {

        Assertions.assertEquals(1, aluno.getId());
    }

    @Test
    @DisplayName("nao deve retornar o id de aluno negativo")
    public void naoDeveRetornarOIdDeAlunoNegativo() {

        Assertions.assertEquals(testeIdNegativo, aluno1.getId());
    }

    @Test
    @DisplayName("deve retorar o id da turma do aluno")
    public void deveRetornarOIdDeTurmaDoAluno() {

        Assertions.assertEquals(1, turma.getId());
    }

    @Test
    @DisplayName("nao deve cadastrar aluno sem nome")
    public void naoDeveCadastrarAlunoSemNome() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nomeNullo, idade, endereco, turmaValida));
    }

    @Test
    @DisplayName("nao deve cadastrar o aluno sem a idade")
    public void naoDeveCadastrarOAlunoSemIdade() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nome, idadeNullo, endereco, turmaValida));
    }

    @Test
    @DisplayName("nao deve cadastrar o aluno sem endereco")
    public void naoDeveCadastrarOAlunoSemEndereco() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nome, idade, enderecoNullo, turmaValida));
    }

    @Test
    @DisplayName("deve cadastrar turma com aluno")
    public void deveCadastrarAlunoSemTurma() {
        Assertions.assertEquals(turmaValida, aluno.getTurma());
    }

    @Test
    @DisplayName("deve cadastrar aluno sem turma")
    public void deveTerTurmaComoNullo() {
        Assertions.assertEquals(turmaNullo, aluno.getTurma());
    }

    @Test
    @DisplayName("nao deve cadastrar o aluno sem o campo nome e sem o campo idade")
    public void naoDeveCadastrarOAlunoSemNomeEIdade() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nomeNullo, idadeNullo, endereco, turmaValida));
    }

    @Test
    @DisplayName("nao deve cadastrar o aluno sem o campo endereco e turma")
    public void naoDeveCadastrarOAlunoSemEnderecoETurma() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nome, idade, enderecoNullo, turmaNullo));
    }

    @Test
    @DisplayName("deve ter os campos de nome e turma preenchidos para cadastro")
    public void deveTerOsCamposDeNomeETurmaPreenhidos() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nomeNullo, idade, endereco, turmaNullo));
    }

    @Test
    @DisplayName("deve ter os campos de idade e endereco preenchidos para cadastro")
    public void deveTerOsCamposDeIdadeEEnderecoPreenhidos() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nome, idadeNullo, enderecoNullo, turma));
    }

    @Test
    @DisplayName("deve ter os campos preenchidos para cadastrar nao pode ser todos nullos")
    public void deveTerOsCamposPreenchidosParaCadastrar() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nomeNullo, idadeNullo, enderecoNullo, turmaNullo));
    }

    @Test
    @DisplayName("nao deve ter dados de alunos iguais")
    public void naoDeveTerDadosDeAlunosIguais() {

        Assertions.assertNotEquals(outroAluno, aluno);
    }

    @Test
    @DisplayName("Deve aceitar apenas letras no campo nome")
    public void deveAceitarApenasLetrasNoCampoNome() {
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar("Joao3w", idade, endereco, turma));
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar("Giovana da Siva", idade, endereco, turma));
    }

    @Test
    @DisplayName("deve ter a analise de valor limite")
    public void deveTerAAnaliseDeValorlimite() {

        //idade 16
        Assertions.assertThrows(RuntimeException.class, () -> aluno1.cadastrar("Giovana da Siva", 16, "ruaQ", turma));
        //idade 17
        Assertions.assertThrows(RuntimeException.class, () -> aluno2.cadastrar("Joao", 17, "ruaR", turma));

        //idade 101
        Assertions.assertThrows(RuntimeException.class, () -> aluno3.cadastrar("Ana", 101, "ruaQ", turma));
        //idade 100
        Assertions.assertThrows(RuntimeException.class, () -> aluno4.cadastrar("Carlos", 100, "ruaR", turma));
    }

    @Test
    @DisplayName("nao deve aceitar numero negativos na idade do aulo")
    public void naoDeveAceitarNumerosNegativosNaIdade(){
        Assertions.assertThrows(RuntimeException.class, () -> aluno.cadastrar(nome, idadeNunNegativo, endereco, turma));
    }
}

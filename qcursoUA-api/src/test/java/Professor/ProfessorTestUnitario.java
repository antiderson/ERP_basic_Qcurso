package Professor;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProfessorTestUnitario {

    private Professor professor;
    private static String nome;
    private static String endereco;
    private static String especialidade;

    @BeforeAll
    public static void definirValoresPadrao() {
        nome = "NOME";
        endereco = "ENDERECO";
        especialidade = "ESPECIALIDADE";
    }

    @BeforeEach
    public void inicializarProfessor() {
        professor = new Professor("Cleiton", "Rua2", "Fisica");
    }

    @Test
    @DisplayName("Deve retornar o endereço do professor")
    public void deveRetornarOEnderecoDoProfessor() {
        assertEquals("Rua2", professor.getEndereco());
    }

    @Test
    @DisplayName("Deve retornar o nome do professor")
    public void deveRetornarONomeDoProfessor() {
        assertEquals("Cleiton", professor.getNome());
    }

    @Test
    @DisplayName("Deve retornar a especialidade do professor")
    public void deveRetornarAEspecialidadeDoProfessor() {
        assertEquals("Fisica", professor.getEspecialidade());
    }

    @Test
    @DisplayName("Nome deve aceitar apenas letras")
    public void deveAceitarApenasLetrasNoNome(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Professor("123", "Rua2", "Fisica"),
                "O nome do professor deve conter apenas letras");
    }

    @Test
    @DisplayName("Especialidade deve aceitar apenas letras")
    public void deveAceitarApenasLetrasNaEspecialidade(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Professor("Cleiton", "Rua2", "Fisica123"),
                "A especialidade do professor deve conter apenas letras");
    }
}

package br.com.uniamerica.qcursoUA.qcursoUAapi.repository;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    @Query(value = "select * from qcursoua.td_alunos where id = :id", nativeQuery = true)
    public Optional<Aluno> findById(@Param("id") final Long id);

    @Query("SELECT aluno FROM Aluno aluno WHERE aluno.ativo = true")
    public List<Aluno> findByAlunosAtivos();




}

package br.com.uniamerica.qcursoUA.qcursoUAapi.repository;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {

    @Query("SELECT professor FROM Professor professor WHERE professor.ativo = true")
    public List<Professor> findByProfessoresAtivos();

    @Query(value = "select * from qcursoua.tb_professores where nome = :nome", nativeQuery = true)
    public List<Professor> findByProfessoresNomes(@Param("nome") final String nome);

}
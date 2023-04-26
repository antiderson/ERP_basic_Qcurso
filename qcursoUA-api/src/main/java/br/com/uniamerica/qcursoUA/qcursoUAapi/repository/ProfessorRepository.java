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

    @Query(value = "select * from qcursoua.td_professores where id = :id", nativeQuery = true)
    public Optional<Professor> findById(@Param("id") final Long id);

    @Query("SELECT professor FROM Professor professor WHERE professor.ativo = true")
    public List<Professor> findByProfessoresAtivos();






}

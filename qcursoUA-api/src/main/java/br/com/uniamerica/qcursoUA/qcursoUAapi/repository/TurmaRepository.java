package br.com.uniamerica.qcursoUA.qcursoUAapi.repository;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,Long> {
   
    @Query("SELECT turma FROM Turma turma WHERE turma.ativo = true")
    public List<Turma> findByTurmasAtivos();

    @Query(value = "select * from qcursoua.tb_turmas where semestre = :semestre", nativeQuery = true)
    public List<Turma> findByTurmaSemestre(@Param("semestre") final Integer semestre);

}
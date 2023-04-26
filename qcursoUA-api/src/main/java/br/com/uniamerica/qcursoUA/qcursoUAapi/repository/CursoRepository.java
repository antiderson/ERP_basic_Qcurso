package br.com.uniamerica.qcursoUA.qcursoUAapi.repository;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {

    @Query(value = "select * from qcursoua.td_cursos where id = :id", nativeQuery = true)
    public Optional<Curso> findById(@Param("id") final Long id);

    @Query("SELECT curso FROM Curso curso WHERE curso.ativo = true")
    public List<Curso> findByCursosAtivos();




}

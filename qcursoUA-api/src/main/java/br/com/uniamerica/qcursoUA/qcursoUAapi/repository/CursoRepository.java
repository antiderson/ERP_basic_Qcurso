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

    @Query("SELECT curso FROM Curso curso WHERE curso.ativo = true")
    public List<Curso> findByCursosAtivos();

    @Query(value = "select * from qcursoua.tb_cursos where sigla = :sigla", nativeQuery = true)
    public Optional<Curso> findBySigla(@Param("sigla") final String sigla);

    @Query(value = "select * from qcursoua.tb_cursos where nome = :nome", nativeQuery = true)
    public List<Curso> findByCursosNomes(@Param("nome") final String nome);
}
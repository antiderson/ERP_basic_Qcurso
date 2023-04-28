package br.com.uniamerica.qcursoUA.qcursoUAapi.service;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CursoService {



    @Autowired
    public CursoRepository cursoRepository;

     public List<Curso> findAll(){
        return this.cursoRepository.findByCursosAtivos();
    }


    @Transactional
    public Curso save(Curso curso){
        return this.cursoRepository.save(curso);
    }

    @Transactional
    public void atualizarGeral(final Long id,final Curso curso) {
        if (id.equals(curso.getId()) && !this.cursoRepository.findById(id).isEmpty()) {
            this.cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }


  


}

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

  


}

package br.com.uniamerica.qcursoUA.qcursoUAapi.service;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TurmaService {
    @Autowired
    public TurmaRepository turmaRepository;

   
    public List<Turma> findAll(){
        return this.turmaRepository.findByTurmasAtivos();
    }



    @Transactional
    public Turma save(Turma turma){
        return this.turmaRepository.save(turma);
    }

    

}
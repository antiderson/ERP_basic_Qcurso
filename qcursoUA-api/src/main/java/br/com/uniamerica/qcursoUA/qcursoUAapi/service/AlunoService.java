package br.com.uniamerica.qcursoUA.qcursoUAapi.service;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Aluno;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    public AlunoRepository alunoRepository;

    

    @Transactional
    public Aluno save(Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

   
    public List<Aluno> findAll(){
        return this.alunoRepository.findByAlunosAtivos();
    }

}

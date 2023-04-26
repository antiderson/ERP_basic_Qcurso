package br.com.uniamerica.qcursoUA.qcursoUAapi.service;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    public ProfessorRepository professorRepository;

    public Professor findById(Long id){
        return this.professorRepository.findById(id).orElse(new Professor());
    }

    public List<Professor> findAll(){
        return this.professorRepository.findByProfessoresAtivos();
    }

    @Transactional
    public Professor save(Professor professor){
        return this.professorRepository.save(professor);
    }

    @Transactional
    public void atualizarGeral(final Long id,final Professor professor) {
        if (id.equals(professor.getId()) && !this.professorRepository.findById(id).isEmpty()) {
            this.professorRepository.save(professor);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id){
        if (!this.professorRepository.findById(id).isEmpty()){
            this.professorRepository.deleteById(id);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }



}

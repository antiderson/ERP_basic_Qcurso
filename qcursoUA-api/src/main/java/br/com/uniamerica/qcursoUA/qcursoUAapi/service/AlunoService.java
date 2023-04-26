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

    public Aluno findById(Long id){
        return this.alunoRepository.findById(id).orElse(new Aluno());
    }

    public List<Aluno> findAll(){
        return this.alunoRepository.findByAlunosAtivos();
    }

    @Transactional
    public Aluno save(Aluno aluno){
        return this.alunoRepository.save(aluno);
    }

    @Transactional
    public void atualizarGeral(final Long id,final Aluno aluno) {
        if (id.equals(aluno.getId()) && !this.alunoRepository.findById(id).isEmpty()) {
            this.alunoRepository.save(aluno);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id){
        if (!this.alunoRepository.findById(id).isEmpty()){
            this.alunoRepository.deleteById(id);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }


}

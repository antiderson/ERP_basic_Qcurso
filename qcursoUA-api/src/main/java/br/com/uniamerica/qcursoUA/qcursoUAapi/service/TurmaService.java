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

    public Turma findById(Long id){
        return this.turmaRepository.findById(id).orElse(new Turma());
    }

    public List<Turma> findAll(){
        return this.turmaRepository.findByTurmasAtivos();
    }

    @Transactional
    public Turma save(Turma turma){
        return this.turmaRepository.save(turma);
    }

    @Transactional
    public void atualizarGeral(final Long id,final Turma turma) {
        if (id.equals(turma.getId()) && !this.turmaRepository.findById(id).isEmpty()) {
            this.turmaRepository.save(turma);
        } else {
            throw new RuntimeException("Id não encontrado");
        }
    }

    @Transactional
    public void deletarGeral(final Long id){
        if (!this.turmaRepository.findById(id).isEmpty()){
            this.turmaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Id não encontrado");
        }
    }


}

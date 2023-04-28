package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Aluno;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.AlunoRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/alunos")
public class AlunoController {




    @Autowired
    public AlunoRepository alunoRepository;

    @Autowired
    public AlunoService alunoService;

  

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Aluno aluno){
        this.alunoRepository.save(aluno);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }
   
}

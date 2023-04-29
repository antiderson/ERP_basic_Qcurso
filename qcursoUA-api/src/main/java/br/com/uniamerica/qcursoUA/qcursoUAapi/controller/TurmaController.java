package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.TurmaRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/turmas")
public class TurmaController {


    @Autowired
    public TurmaRepository turmaRepository;

    @Autowired
    public TurmaService turmaService;

    
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Turma turma){
        this.turmaRepository.save(turma);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

   



}
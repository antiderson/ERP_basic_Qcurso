package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.ProfessorRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/professores")
public class ProfessorController {


    @Autowired
    public ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService professorService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Professor professor){
        this.professorRepository.save(professor);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }




}
package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.CursoRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/api/cursos")
public class CursoController {


    @Autowired
    public CursoRepository cursoRepository;

    @Autowired
    public CursoService cursoService;
  
  
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Curso curso){
        this.cursoRepository.save(curso);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }




}
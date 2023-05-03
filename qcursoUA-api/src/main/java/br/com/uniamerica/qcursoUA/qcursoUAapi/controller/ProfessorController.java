package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Professor;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.ProfessorRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.ProfessorService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="Cadastra um professor novo")
    public ResponseEntity<?> cadastrar(@RequestBody final Professor professor){
        this.professorService.save(professor);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    @ApiOperation(value="Lista todos os professores")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.professorService.findAll());
    }

    @GetMapping("/buscarProfessorNome/{nome}")//buscar professor nome
    @ApiOperation(value="Lista todos os professores por nome")
    public ResponseEntity<List<Professor>> findByNome(
            @PathVariable final String nome
    ){
        return ResponseEntity.ok().body(this.professorRepository.findByProfessoresNomes(nome));
    }

    @PutMapping("/atualizarGeral/{id}")
    @ApiOperation(value="Atualiza os professores")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Professor professor
    ){
        try{
            this.professorService.atualizarGeral(id,professor);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta professor")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id
    ){
        try {
            this.professorService.deletarGeral(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }

}
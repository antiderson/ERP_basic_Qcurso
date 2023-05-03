package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;


import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Turma;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.TurmaRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.TurmaService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value="Cadastra uma turma")
    public ResponseEntity<?> cadastrar(@RequestBody final Turma turma){
        this.turmaRepository.save(turma);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

     @GetMapping
     @ApiOperation(value="Retorna uma lista com todas as turmas cadastradas")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.turmaRepository.findByTurmasAtivos());
    }

    @GetMapping("/buscarTurmaSemestre/{semestre}")//buscar turma semestre
    @ApiOperation(value="Retorna uma lista com todas as turmas por semestre")
    public ResponseEntity<List<Turma>> findBySemestre(
            @PathVariable final Integer semestre
    ){
        return ResponseEntity.ok().body(this.turmaRepository.findByTurmaSemestre(semestre));
    }

    @GetMapping("/buscarTurmaAno/{ano}")//buscar turma ano
    @ApiOperation(value="Retorna uma lista com todas as turmas por por ano")
    public ResponseEntity<List<Turma>> findByAno(
            @PathVariable final Integer ano
    ){
        return ResponseEntity.ok().body(this.turmaRepository.findByTurmaAno(ano));
    }

    @PutMapping("/atualizarGeral/{id}")
    @ApiOperation(value="Edita a turma")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Turma turma
    ){
        try{
            this.turmaService.atualizarGeral(id,turma);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta a turma")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id
    ){
        try {
            this.turmaService.deletarGeral(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}
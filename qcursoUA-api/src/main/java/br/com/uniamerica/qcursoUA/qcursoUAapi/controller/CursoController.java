package br.com.uniamerica.qcursoUA.qcursoUAapi.controller;

import br.com.uniamerica.qcursoUA.qcursoUAapi.entity.Curso;
import br.com.uniamerica.qcursoUA.qcursoUAapi.repository.CursoRepository;
import br.com.uniamerica.qcursoUA.qcursoUAapi.service.CursoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    public CursoRepository cursoRepository;

    @Autowired
    public CursoService cursoService;
  
    @PostMapping
    @ApiOperation(value="Cadastra um curso novo")
    public ResponseEntity<?> cadastrar(@RequestBody final Curso curso){
        this.cursoRepository.save(curso);
        return ResponseEntity.ok().body("Registro cadastrado com sucesso");
    }

    @GetMapping
    @ApiOperation(value="Retorna uma lista com todos os cursos cadastrados")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(this.cursoRepository.findByCursosAtivos());
    }

    @GetMapping("/buscarCursoSigla/{sigla}")//buscar curso sigla
    @ApiOperation(value="Retorna uma lista com todos os cursos por sigla ")
    public ResponseEntity<Optional<Curso>> findBySigla(
            @PathVariable final String sigla
    ){
        return ResponseEntity.ok().body(this.cursoRepository.findBySigla(sigla));
    }

    @GetMapping("/buscarCursoNome/{nome}")
    @ApiOperation(value="Retorna uma lista com todos os cursos por nome")
    public ResponseEntity<List<Curso>> findByCursoNome(@PathVariable("nome") String nome){
        return ResponseEntity.ok().body(this.cursoRepository.findByCursosNomes(nome));
    }

    @PutMapping("/atualizarGeral/{id}")
    @ApiOperation(value="Atualiza o curso")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long id,
            @RequestBody Curso curso
    ){
        try{
            this.cursoService.atualizarGeral(id,curso);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta o curso")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id
    ){
        try {
            this.cursoService.deletarGeral(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro deletado com sucesso");
    }
}
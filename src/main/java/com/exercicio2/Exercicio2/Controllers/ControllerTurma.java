package com.exercicio2.Exercicio2.Controllers;

import com.exercicio2.Exercicio2.Models.ModelAluno;
import com.exercicio2.Exercicio2.Models.ModelTurma;
import com.exercicio2.Exercicio2.Repository.RepositoryTurma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;

@RestController
@RequestMapping("/turma")
@Api(value = "Turma")
public class ControllerTurma {

    @Autowired
    private RepositoryTurma turmaRepository;

    @Autowired
    private RepositoryTurma alunoRepository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de Turmas")
    public List<ModelTurma> getAluno(){
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma turma pelo seu id")
    public Optional<ModelTurma> getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Adicionar uma Turma")
    public ModelTurma createTurma(@RequestBody ModelTurma alunoa) {
        return turmaRepository.save(alunoa);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma turma a partir do seu id")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma turma a partir do seu identificador")
    public ModelTurma updateTurma(@PathVariable("id") Long id, @RequestBody ModelTurma turma) {
       return turmaRepository.save(turma);    
    }

    @PutMapping("/{id}/matricularAluno{alunoid}")
    @ApiOperation(value = "Atualiza uma turma a partir do seu identificador")
    public Optional<ModelAluno> matricularAluno(@PathVariable("id") Long id, @PathVariable("alunoid") Long alunoid) {
        ModelAluno aluno =  alunoRepository.findById(alunoid);
        aluno.setIdTurma(id);
        return alunoRepository.save(aluno);  
    }
}
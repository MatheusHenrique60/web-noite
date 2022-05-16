package com.exercicio2.Exercicio2.Controllers;

import com.exercicio2.Exercicio2.Models.ModelProfessor;
import com.exercicio2.Exercicio2.Repository.RepositoryProfessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;

@RestController
@RequestMapping("/professor")
@Api(value = "Professor")
public class ControllerProfessor {

    @Autowired
    private RepositoryProfessor professorRepository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de Professores")
    public List<ModelProfessor> getProfessores(){
        return professorRepository.findAll();
    }

    @GetMapping("/{matricula}")
    @ApiOperation(value = "Busca um Professor pela sua matricula")
    public ModelProfessor getProfessorByMatricula (@PathVariable("matricula") Long matricula) {
        List<ModelProfessor> profs = professorRepository.findAll();
        ModelProfessor professor = new ModelProfessor();
        for(ModelProfessor prof : profs){
            if (prof.getMatricula() == matricula){
                professor = prof;
                return prof;
            }
        }
        return professor;
    }

    @PostMapping
    @ApiOperation(value = "Adicionar um Professor")
    public ModelProfessor createProfessor(@RequestBody ModelProfessor prof) {
        
        List<ModelProfessor> profs = professorRepository.findAll();
        boolean veri = true;
        for(ModelProfessor professor : profs){
            if (professor.getMatricula() == prof.getMatricula() || professor.getEmail() == prof.getEmail()){
                veri = false;
            }
        }
        if (veri){
            return professorRepository.save(prof);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um professor a partir do seu id")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.delete(professorRepository.findById(id).get());
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um Professor a partir do seu identificador")
    public ModelProfessor updateProfessor(@PathVariable("id") Long id, @RequestBody ModelProfessor prof) {
        List<ModelProfessor> profs = professorRepository.findAll();
        boolean veri = true;
        for(ModelProfessor professor : profs){
            if (professor.getMatricula() == prof.getMatricula() || professor.getEmail() == prof.getEmail() && professor.getId()!=prof.getId()){
                veri = false;
            }
        }
        if (veri){
            return professorRepository.save(prof);
        }
        else {
            return null;
        }
    }
}
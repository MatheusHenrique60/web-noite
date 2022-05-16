package com.exercicio2.Exercicio2.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "turma")
public class ModelTurma {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "disciplina")
    private String disciplina;

    @Column(name = "sala")
    private String sala;

    @Column(name = "matriculaProf")
    private Long matriculaProf;

    public ModelTurma(String disciplina, String sala, Long matriculaProf) {
        this.disciplina = disciplina;
        this.sala = sala;
        this.matriculaProf = matriculaProf;
    }
    
}

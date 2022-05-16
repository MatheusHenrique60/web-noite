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
@Table(name = "aluno")
public class ModelAluno {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "matricula")
    private Long matricula;

    @Column(name = "idTurma")
    private Long idTurma;

    public ModelAluno(String nome, String email,long matricula,long idTurma) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
        this.idTurma = idTurma;
    }
}

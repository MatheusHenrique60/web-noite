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
@Table(name = "professor")
public class ModelProfessor {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "formacao")
    private String formacao;

    @Column(name = "matricula")
    private Long matricula;

    public ModelProfessor(String nome, String email, String formacao, Long matricula) {
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
        this.matricula = matricula;
    }
}

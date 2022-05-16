package com.exercicio2.Exercicio2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exercicio2.Exercicio2.Models.ModelAluno;

@Repository
public interface RepositoryAluno extends JpaRepository<ModelAluno, Long> {}

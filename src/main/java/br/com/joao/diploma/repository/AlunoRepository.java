package br.com.joao.diploma.repository;

import br.com.joao.diploma.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

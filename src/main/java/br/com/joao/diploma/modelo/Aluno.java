package br.com.joao.diploma.modelo;

import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "aluno")
    private List<Disciplina> disciplinas;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aluno aluno = (Aluno) o;

        if (!Objects.equals(nome, aluno.nome)) return false;
        return Objects.equals(disciplinas, aluno.disciplinas);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (disciplinas != null ? disciplinas.hashCode() : 0);
        return result;
    }


}

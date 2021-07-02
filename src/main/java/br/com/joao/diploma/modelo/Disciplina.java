package br.com.joao.diploma.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Disciplina {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Aluno aluno;
    private String nome;
    private double nota;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disciplina that = (Disciplina) o;

        if (Double.compare(that.nota, nota) != 0) return false;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nome != null ? nome.hashCode() : 0;
        temp = Double.doubleToLongBits(nota);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

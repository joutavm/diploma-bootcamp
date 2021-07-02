package br.com.joao.diploma.controller.form;

import br.com.joao.diploma.modelo.Aluno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AlunoForm {

    @NotEmpty @NotNull
    private String nome;


    public Aluno convert() {
        return new Aluno(nome);
    }
}

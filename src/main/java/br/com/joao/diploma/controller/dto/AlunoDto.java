package br.com.joao.diploma.controller.dto;

import br.com.joao.diploma.modelo.Aluno;
import br.com.joao.diploma.modelo.Disciplina;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoDto {

    private final Long id;
    private final String nome;
    private final List<Disciplina> disciplinas;
    private final String diploma;
    private final double media;

    public AlunoDto(Aluno aluno){
        id = aluno.getId();
        nome = aluno.getNome();
        diploma = diploma();
        media = media();
        disciplinas = aluno.getDisciplinas();

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public String getDiploma() {
        return diploma;
    }

    public double getMedia() {
        return media;
    }

    private double media(){
        return disciplinas.stream().mapToDouble(Disciplina::getNota).average().orElse(0);
    }

    private String diploma(){
        double media = media();
        String mensagem = String.format("%s, sua média é %.2f", StringUtils.capitalize(nome), media);
        if (media() > 9) {
            return "Parabéns!!! " + mensagem;
        }
        return mensagem;
    }

    public static List<AlunoDto> converter(List<Aluno> alunos){
        return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
    }
}

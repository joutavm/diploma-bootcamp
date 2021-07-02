package br.com.joao.diploma.controller;

import br.com.joao.diploma.controller.dto.AlunoDto;
import br.com.joao.diploma.controller.form.AlunoForm;
import br.com.joao.diploma.modelo.Aluno;
import br.com.joao.diploma.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/aluno")
public class Controller {

    final
    AlunoRepository alunoRepository;

    public Controller(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<AlunoDto> listarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return AlunoDto.converter(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> obterAluno(@PathVariable Long id){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new AlunoDto(optionalAluno.get()));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder){
        Aluno aluno = form.convert();
        alunoRepository.save(aluno);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }


}

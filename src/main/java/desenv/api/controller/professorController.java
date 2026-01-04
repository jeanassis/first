package desenv.api.controller;

import desenv.api.professores.DadosCadastroDeProfessores;
import desenv.api.professores.professor;
import desenv.api.professores.professorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class professorController {

    @Autowired
    private professorRepository repository;

    @PostMapping
    public void cadastrarProfessores(@RequestBody DadosCadastroDeProfessores dados){
       repository.save(new professor(dados));
    }

}

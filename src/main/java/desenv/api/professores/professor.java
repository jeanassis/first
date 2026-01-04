package desenv.api.professores;

import jakarta.persistence.*;


@Entity(name= "Professor")
@Table(name = "professores")
public class professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String matricula;
    private  String nome;
    private  String email;
    private  String telefone;

    @Enumerated
    private Disciplina disciplina;

    public professor(DadosCadastroDeProfessores dados) {
        this.nome = dados.nome();
        this.matricula = dados.matricula();
        this.disciplina = dados.disciplina();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }
}

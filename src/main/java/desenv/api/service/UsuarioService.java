package desenv.api.service;

import desenv.api.entitys.Usuario;
import desenv.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    public void saveUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );
    }

    public void deletarUsuarioPorId(Integer id){
        repository.deleteById(id);
    }

    public void atualizarUsuarioPorId(Integer id,Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(()->
                new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .aluno(usuario.getAluno() != null ? usuario.getAluno() :
                        usuarioEntity.getAluno())
                .email(usuario.getEmail() != null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .curso(usuario.getCurso()!= null ? usuario.getCurso() :
                        usuarioEntity.getCurso())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}

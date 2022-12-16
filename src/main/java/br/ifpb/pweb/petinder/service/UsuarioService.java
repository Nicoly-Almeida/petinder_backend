package br.ifpb.pweb.petinder.service;

import br.ifpb.pweb.petinder.model.Usuario;
import br.ifpb.pweb.petinder.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuarios() {
       return this.usuarioRepository.findAll();
   }

   public Usuario getUsuarioPorId(Long idUsuario) {
       return this.usuarioRepository.findById(idUsuario).orElse(null);
   }

   @Transactional
   public Usuario inserirOuAtualizar(Usuario usuario) {
       Usuario usuarioInserido = this.usuarioRepository.save(usuario);
       return usuarioInserido;
   }

   public void deletar(Long id) {
       this.usuarioRepository.deleteById(id);
   }
}


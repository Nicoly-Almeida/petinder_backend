package br.ifpb.pweb.petinder.service;

import br.ifpb.pweb.petinder.model.Usuario2;
import br.ifpb.pweb.petinder.repositories.Usuario2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Usuario2Service {

   @Autowired
   private Usuario2Repository usuario2Repository;

    public Usuario2Service(Usuario2Repository usuario2Repository) {
        this.usuario2Repository = usuario2Repository;
    }

    public List<Usuario2> getUsuarios2() {
       return this.usuario2Repository.findAll();
   }

   public Usuario2 getUsuario2PorId(Long idUsuario2) {
       return this.usuario2Repository.findById(idUsuario2).orElse(null);
   }

   @Transactional
   public Usuario2 inserirOuAtualizar(Usuario2 usuario2) {
       Usuario2 usuarioInserido = this.usuario2Repository.save(usuario2);
       return usuarioInserido;
   }

   public void deletar(Long id) {
       this.usuario2Repository.deleteById(id);
   }
}


package br.ifpb.pweb.petinder.repositories;

import br.ifpb.pweb.petinder.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}

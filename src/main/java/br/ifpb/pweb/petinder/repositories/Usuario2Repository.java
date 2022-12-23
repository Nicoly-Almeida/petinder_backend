package br.ifpb.pweb.petinder.repositories;
import br.ifpb.pweb.petinder.model.Usuario2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario2Repository extends JpaRepository<Usuario2, Long> {


}

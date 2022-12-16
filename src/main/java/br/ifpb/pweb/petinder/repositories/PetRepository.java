package br.ifpb.pweb.petinder.repositories;

import br.ifpb.pweb.petinder.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}

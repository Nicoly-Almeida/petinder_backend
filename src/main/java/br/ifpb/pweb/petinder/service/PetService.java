package br.ifpb.pweb.petinder.service;

import br.ifpb.pweb.petinder.model.Pet;
import br.ifpb.pweb.petinder.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
	
	 @Autowired
	   private PetRepository petRepository;

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public List<Pet> getPets() {
	       return this.petRepository.findAll();
	   }

	   public Pet getPetPorId(Long idPet) {
	       return this.petRepository.findById(idPet).orElse(null);
	   }

	   @Transactional
	   public Pet inserirOuAtualizar(Pet pet) {
	       Pet petInserido = this.petRepository.save(pet);
	       return petInserido;
	   }

	   public void deletar(Long id) {
	       this.petRepository.deleteById(id);
	   }
}

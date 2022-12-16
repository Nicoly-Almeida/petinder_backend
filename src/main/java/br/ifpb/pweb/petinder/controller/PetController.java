package br.ifpb.pweb.petinder.controller;

import br.ifpb.pweb.petinder.model.Pet;
import br.ifpb.pweb.petinder.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PetController {

   @Autowired
   private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets")
   public List<Pet> getPets() {
       return this.petService.getPets();
   }

   @GetMapping("/pets/{id}")
   public Pet getPetPorId(@PathVariable("id") Long idPet) {
       return this.petService.getPetPorId(idPet);
   }

   @PostMapping("/pets")
   public Pet inserirPet(@RequestBody Pet pet){
       return this.petService.inserirOuAtualizar(pet);
   }

   @PutMapping("/pets/{id}")
   public Pet atualizarPet(@RequestBody Pet pet){
       return this.petService.inserirOuAtualizar(pet);
   }

   @DeleteMapping("/pets/{id}")
   public void apagarPet(@PathVariable("id") Long id) {
       this.petService.deletar(id);
   }
}

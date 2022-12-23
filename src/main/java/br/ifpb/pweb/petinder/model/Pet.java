package br.ifpb.pweb.petinder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pet")
public class Pet {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   private Integer idade;
   private String sexo;
   private String raca;
   

   public Long getId() {
       return id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getSexo() {
       return sexo;
   }

   public void setSexo(String sexo) {
       this.sexo = sexo;
   }

   public String getRaca() {
       return raca;
   }

   public void setRaca(String raca) {
       this.raca = raca;
   }
   
   public Integer getIdade() {
       return idade;
   }

   public void setIdade(Integer idade) {
       this.idade = idade;
   }
}

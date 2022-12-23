package br.ifpb.pweb.petinder.model;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_usuario")
public class Usuario2 {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   private String telefone;
   public Long getId() {
       return id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }
   
   public String getTelefone() {
       return telefone;
   }
}
package br.ifpb.pweb.petinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_usuario")
public class Usuario {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nome;
   private String email;
   private String senha;
   private String repetir_senha;

   public Long getId() {
       return id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   public String getSenha() {
       return senha;
   }

   public void setSenha(String senha) {
       this.senha = senha;
   }
   
   public String getRepetir_Senha() {
       return repetir_senha;
   }

   public void setRepetir_Senha(String repetir_senha) {
       this.repetir_senha = repetir_senha;
   }
}


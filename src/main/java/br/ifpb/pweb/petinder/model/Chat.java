package br.ifpb.pweb.petinder.model;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Usuario usuario;
    @ManyToOne()
    private Usuario2 usuario2;
    private LocalDateTime dateStamp;
    private String conteudoMensagem;
    @Enumerated(EnumType.STRING)
    private EnviadoPorEnum enviadoPor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference(value = "usuario-mensagem")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @JsonBackReference(value = "usuario2-mensagem")
    public Usuario2 getUsuario2() {
        return usuario2;
    }

    public void setUsuario2(Usuario2 usuario2) {
        this.usuario2 = usuario2;
    }

    public LocalDateTime getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(LocalDateTime dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getConteudoMensagem() {
        return conteudoMensagem;
    }

    public void setConteudoMensagem(String conteudoMensagem) {
        this.conteudoMensagem = conteudoMensagem;
    }

    public EnviadoPorEnum getEnviadoPor() {
        return enviadoPor;
    }

    public void setEnviadoPor(EnviadoPorEnum enviadoPor) {
        this.enviadoPor = enviadoPor;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", usuario2=" + usuario2 +
                ", dateStamp=" + dateStamp +
                ", conteudoMensagem='" + conteudoMensagem + '\'' +
                ", enviadoPor=" + enviadoPor +
                '}';
    }
	
	
}






    

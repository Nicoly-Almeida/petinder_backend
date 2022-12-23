package br.ifpb.pweb.petinder.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpb.pweb.petinder.model.EnviadoPorEnum;
import br.ifpb.pweb.petinder.model.Chat;
import br.ifpb.pweb.petinder.model.Usuario2;
import br.ifpb.pweb.petinder.model.Usuario;
import br.ifpb.pweb.petinder.repositories.ChatRepository;
import br.ifpb.pweb.petinder.service.Ususario2Service;
import br.ifpb.pweb.petinder.service.UsuarioService;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private Usuario2Service usuario2Service;

    public Mensagem criarMensagem(MensagemDTO mensagemDTO) {
        Usuario usuario = this.usuarioService.listarUsuario(mensagemDTO.getUsuario());
        Usuario2 usuario2 = this.usuario2Service.listarUsuario2(mensagemDTO.getUsuario2());
        Mensagem mensagem = new Mensagem();
        mensagem.setConteudoMensagem(mensagemDTO.getConteudoMensagem());
        mensagem.setEnviadoPor(EnviadoPorEnum.USUARIO);
        mensagem.setUsuario(usuario);
        mensagem.setUsuario2(usuario2);
        mensagem.setDateStamp(LocalDateTime.now());
        return this.mensagemRepository.save(mensagem);
//        System.out.println(mensagemDTO);
//        return new Mensagem();
    }

    public List<Mensagem> listarMensagens(Long usuarioId, Long usuario2Id){
        return this.chatRepository.listarMensagens(usuarioId, usuario2Id);
    }

    public Mensagem atualizarMensagem(Mensagem mensagem) {
        return this.chatRepository.save(mensagem);
    }

    public void deletarMensagem(Long id) {
        this.chatRepository.deleteById(id);
    }

    public Mensagem buscarMensagemPorId(Long id) {
        return this.chatRepository.findById(id).orElse(null);
    }
}

package br.ifpb.pweb.petinder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.ifpb.pweb.petinder.model.Usuario;
import br.ifpb.pweb.petinder.repositories.UsuarioRepository;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("UsuarioServiceTest")
public class UsuarioServiceTest {
	
	@MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;
    
    @Test
    public void deveCriarUsuario(){
        Usuario usuario = new Usuario();
        Mockito.when(usuarioRepository.save(ArgumentMatchers.eq(usuario))).thenReturn(usuario);
        usuarioService.inserirOuAtualizar(usuario);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(any(Usuario.class));
    }

    @Test
    public void naoDeveCriarUsuarioNulo(){
        Usuario usuario = null;
        Mockito.when(usuarioRepository.save(ArgumentMatchers.eq(usuario))).thenThrow(RuntimeException.class);
        Assertions.assertThrows(RuntimeException.class, () -> usuarioService.inserirOuAtualizar(usuario));
    }
    
    @Test
    public void deveBuscarPorId(){
        Optional<Usuario> usuario = Optional.of(new Usuario());
        Mockito.when(usuarioRepository.findById(1L)).thenReturn(usuario);
        usuarioService.getUsuarioPorId(1L);
        Mockito.verify(usuarioRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void naoDeveAcharPorIdInexistente(){
        Usuario usuario = null;
        Mockito.when(usuarioRepository.findById(ArgumentMatchers.eq(2L))).thenReturn(Optional.ofNullable(usuario));
        assertEquals(usuarioService.getUsuarioPorId(2L), null);
    }
    
    @Test
    public void deveRetornarListaDeUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuarios.add(usuario);
        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);
        usuarioService.getUsuarios();
        Mockito.verify(usuarioRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void deveDeletar(){
        usuarioService.deletar(2L);
        Mockito.verify(usuarioRepository, Mockito.times(1)).deleteById(2L);
    }
}

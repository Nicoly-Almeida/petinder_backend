package br.ifpb.pweb.petinder.repositories;

import br.ifpb.pweb.petinder.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query(value = "select c from Chat c where c.usuario2.id = :usuario2Id and c.usuario.id = :usuarioId order by c.dateStamp asc")
    List<Chat> listarMensagens(@Param("usuarioId")Long usuarioId, @Param("usuario2Id")Long usuario2Id);

}

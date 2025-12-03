package CRUD.interfaces;

import java.util.List;

public interface Listavel<T> {
    List<T> listarTodos();
    List<T> buscarPorNome(String termo); // opcional, se houver campo nome
}

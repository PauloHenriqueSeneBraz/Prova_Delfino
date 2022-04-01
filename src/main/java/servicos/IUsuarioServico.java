package servicos;

import entidades.Usuario;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface IUsuarioServico {
    @WebMethod
    void inserirUsuario(@WebParam(name = "usuario") Usuario usuario);

    @WebMethod
    List<Usuario> listarUsuario();

    @WebMethod
    void excluirUsuario(@WebParam(name = "usu_id") Integer id);

    @WebMethod
    void editarUsuario(@WebParam(name = "usuario") Usuario usuario);

    @WebMethod
    Usuario buscarUsuarioPorId(@WebParam(name = "usu_id") Integer id);
}

package servicos;

import entidades.Usuario;
import jakarta.jws.WebService;
import repositorios.UsuarioRepositorio;

import java.util.List;

@WebService(endpointInterface = "servicos.IUsuarioServico")
public class UsuarioServico implements IUsuarioServico {
    private UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();

    @Override
    public void inserirUsuario(Usuario usuario) {
        usuarioRepositorio.inserir(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepositorio.listar();
    }

    @Override
    public void excluirUsuario(Integer id) {
        usuarioRepositorio.excluir(id);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        usuarioRepositorio.editar(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioRepositorio.buscarPorId(id);
    }

}

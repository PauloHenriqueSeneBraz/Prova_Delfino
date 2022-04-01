package repositorios;

import entidades.Usuario;
import fabricas.FabricaDeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {

    public void inserir(Usuario usuario) {
        String sql = "INSERT usuario (usu_nome, usu_cpf, usu_email, usu_senha) VALUES (?,?,?,?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, usuario.getUsu_nome());
            comando.setString(2, usuario.getUsu_cpf());
            comando.setString(3, usuario.getUsu_email());
            comando.setString(4, usuario.getUsu_senha());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir um usuário", excecao);
        }
    }

    public List<Usuario> listar() {
        String sql = "SELECT usu_id, usu_nome, usu_cpf, usu_email, usu_senha FROM usuario ORDER BY usu_nome";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Usuario> usuarios = new ArrayList<>();

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsu_id(resultado.getInt("usu_id"));
                usuario.setUsu_nome(resultado.getString("usu_nome"));
                usuario.setUsu_cpf(resultado.getString("usu_cpf"));
                usuario.setUsu_email(resultado.getString("usu_email"));
                usuario.setUsu_senha(resultado.getString("usu_senha"));

                usuarios.add(usuario);
            }

            return usuarios;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar os usuários", excecao);
        }
    }

    public void excluir (Integer id) {
        String sql = "DELETE FROM usuario WHERE usu_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir um usuário", excecao);
        }
    }

    public void editar (Usuario usuario) {
        String sql = "UPDATE usuario SET usu_nome = ?, usu_cpf = ?, usu_email = ?, usu_senha = ? WHERE usu_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, usuario.getUsu_nome());
            comando.setString(2, usuario.getUsu_cpf());
            comando.setString(3, usuario.getUsu_email());
            comando.setString(4, usuario.getUsu_senha());
            comando.setInt(5, usuario.getUsu_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar um usuário", excecao);
        }
    }

    public Usuario buscarPorId(Integer id) {
        String sql = "SELECT usu_id, usu_nome, usu_cpf, usu_email, usu_senha FROM usuario WHERE usu_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Usuario usuario = null;

                if (resultado.next()) {
                    usuario = new Usuario();
                    usuario.setUsu_id(resultado.getInt("usu_id"));
                    usuario.setUsu_nome(resultado.getString("usu_nome"));
                    usuario.setUsu_cpf(resultado.getString("usu_cpf"));
                    usuario.setUsu_email(resultado.getString("usu_email"));
                    usuario.setUsu_senha(resultado.getString("usu_senha"));
                }

                return usuario;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar um usuário", excecao);
        }
    }
}

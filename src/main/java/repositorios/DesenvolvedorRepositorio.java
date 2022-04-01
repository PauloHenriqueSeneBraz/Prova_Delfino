package repositorios;

import entidades.Desenvolvedor;
import fabricas.FabricaDeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesenvolvedorRepositorio {
    public void inserir(Desenvolvedor desenvolvedor) {
        String sql = "INSERT desenvolvedor (dev_nome) VALUES (?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, desenvolvedor.getDev_nome());

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir um desenvolvedor", excecao);
        }
    }

    public List<Desenvolvedor> listar() {
        String sql = "SELECT dev_id, dev_nome FROM desenvolvedor ORDER BY dev_nome";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Desenvolvedor> desenvolvedores = new ArrayList<>();

            while (resultado.next()) {
                Desenvolvedor desenvolvedor = new Desenvolvedor();
                desenvolvedor.setDev_id(resultado.getInt("dev_id"));
                desenvolvedor.setDev_nome(resultado.getString("dev_nome"));

                desenvolvedores.add(desenvolvedor);
            }

            return desenvolvedores;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar os desenvolvedores", excecao);
        }
    }

    public void excluir (Integer id) {
        String sql = "DELETE FROM desenvolvedor WHERE dev_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir um desenvolvedor", excecao);
        }
    }

    public void editar (Desenvolvedor desenvolvedor) {
        String sql = "UPDATE desenvolvedor SET dev_nome = ? WHERE dev_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, desenvolvedor.getDev_nome());
            comando.setInt(2, desenvolvedor.getDev_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar um desenvolvedor", excecao);
        }
    }

    public Desenvolvedor buscarPorId(Integer id) {
        String sql = "SELECT dev_id, dev_nome FROM desenvolvedor WHERE dev_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Desenvolvedor desenvolvedor = null;

                if (resultado.next()) {
                    desenvolvedor = new Desenvolvedor();
                    desenvolvedor.setDev_id(resultado.getInt("dev_id"));
                    desenvolvedor.setDev_nome(resultado.getString("dev_nome"));

                }

                return desenvolvedor;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar um desenvolvedor", excecao);
        }
    }
}

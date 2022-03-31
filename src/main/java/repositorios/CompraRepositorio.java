package repositorios;

import entidades.Compra;
import fabricas.FabricaDeConexoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CompraRepositorio {

    public void inserir(Compra compra) {
        String sql = "INSERT compra (com_horario,com_preco_total) VALUES (?,?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setDate(1, (Date) compra.getCom_horario());
            comando.setDouble(2, compra.getCom_preco_total());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir uma compra", excecao);
        }
    }

    public List<Compra> listar() {
        String sql = "SELECT com_id, com_horario,com_preco_total FROM compra ORDER BY com_id";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Compra> compras = new ArrayList<>();

            while (resultado.next()) {
                Compra compra = new Compra();
                compra.setCom_id(resultado.getInt("com_id"));
                compra.setCom_horario(resultado.getDate("com_horario"));
                compra.setCom_preco_total(resultado.getDouble("com_preco_total"));

                compras.add(compra);
            }

            return compras;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar as compras", excecao);
        }
    }

    public void excluir(Integer id) {
        String sql = "DELETE FROM compra WHERE com_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir uma compra", excecao);
        }
    }

    public void editar(Compra compra) {
        String sql = "UPDATE compra SET com_horario,com_preco_total = ? WHERE com_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setDate(1, (Date) compra.getCom_horario());
            comando.setDouble(2, compra.getCom_preco_total());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar uma compra", excecao);
        }
    }

    public Compra buscarPorId(Integer id) {
        String sql = "SELECT com_id, com_horario,com_preco_total FROM compra WHERE com_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Compra compra = null;

                if (resultado.next()) {
                    compra = new Compra();
                    compra.setCom_id(resultado.getInt("com_id"));
                    compra.setCom_horario(resultado.getDate("com_horario"));
                    compra.setCom_preco_total(resultado.getDouble("com_preco_total"));
                }

                return compra;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar uma compra", excecao);
        }
    }

}


package repositorios;

import entidades.Compra;
import fabricas.FabricaDeConexoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CompraRepositorio {

    public void inserir(Compra compra) {
        String sql = "INSERT compra (com_horario, com_preco_total,com_usu_id, com_jog_id) VALUES (?,?,?,?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, compra.getCom_horario());
            comando.setDouble(2, compra.getCom_preco_total());
            comando.setInt(3, compra.getCom_usu_id().getUsu_id());
            comando.setInt(4, compra.getCom_jog_id().getJog_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir uma compra", excecao);
        }
    }

    public List<Compra> listar() {
        String sql = "SELECT com_id, com_horario,com_preco_total, com_usu_id, com_jog_id FROM compra ORDER BY com_id";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Compra> compras = new ArrayList<>();

            while (resultado.next()) {
                Compra compra = new Compra();
                compra.setCom_id(resultado.getInt("com_id"));
                compra.setCom_horario(resultado.getString("com_horario"));
                compra.setCom_preco_total(resultado.getDouble("com_preco_total"));
                compra.setCom_usu_id(compra.getCom_usu_id());
                compra.setCom_jog_id(compra.getCom_jog_id());

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
        String sql = "UPDATE compra SET com_horario = ?, com_preco_total = ? WHERE com_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, compra.getCom_horario());
            comando.setDouble(2, compra.getCom_preco_total());
            comando.setInt(3, compra.getCom_id());

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar uma compra", excecao);
        }
    }

    public Compra buscarPorId(Integer id) {
        String sql = "SELECT com_id, com_horario, com_preco_total, com_usu_id, com_jog_id FROM compra WHERE com_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Compra compra = null;

                if (resultado.next()) {
                    compra = new Compra();
                    compra.setCom_id(resultado.getInt("com_id"));
                    compra.setCom_horario(resultado.getString("com_horario"));
                    compra.setCom_preco_total(resultado.getDouble("com_preco_total"));
                    compra.setCom_usu_id(compra.getCom_usu_id());
                    compra.setCom_jog_id(compra.getCom_jog_id());
                }

                return compra;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar uma compra", excecao);
        }
    }

}


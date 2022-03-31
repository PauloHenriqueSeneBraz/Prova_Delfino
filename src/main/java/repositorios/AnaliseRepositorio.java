package repositorios;

import entidades.Analise;
import fabricas.FabricaDeConexoes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnaliseRepositorio {
    public void inserir(Analise analise) {
        String sql = "INSERT analise (ana_data,ana_titulo,ana_descricao,ana_situacao,ana_usu_id, ana_jog_id) VALUES (?,?,?,?,?,?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, analise.getAna_data());
            comando.setString(2, analise.getAna_titulo());
            comando.setString(3, analise.getAna_descricao());
            comando.setString(4, analise.getAna_situacao());
            comando.setInt(5, analise.getAna_usu_idFK().getUsu_id());
            comando.setInt(6, analise.getAna_jog_idFK().getJog_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir uma analise", excecao);
        }
    }

    public List<Analise> listar() {
        String sql = "SELECT ana_id, ana_data,ana_titulo,ana_descricao,ana_situacao FROM analise ORDER BY ana_titulo";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Analise> analises = new ArrayList<>();

            while (resultado.next()) {
                Analise analise = new Analise();
                analise.setAna_id(resultado.getInt("ana_id"));
                analise.setAna_data(resultado.getString("ana_data"));
                analise.setAna_titulo(resultado.getString("ana_titulo"));
                analise.setAna_descricao(resultado.getString("ana_descricao"));
                analise.setAna_situacao(resultado.getString("ana_situacao"));

                analises.add(analise);
            }

            return analises;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar as analises", excecao);
        }
    }

    public void excluir (Integer id) {
        String sql = "DELETE FROM analise WHERE ana_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir uma analise", excecao);
        }
    }

    public void editar (Analise analise) {
        String sql = "UPDATE analise SET ana_data = ?, ana_titulo = ?,ana_descricao = ?, ana_situacao = ? WHERE ana_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, analise.getAna_data());
            comando.setString(2, analise.getAna_titulo());
            comando.setString(3, analise.getAna_descricao());
            comando.setString(4, analise.getAna_descricao());
            comando.setInt(5, analise.getAna_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar uma analise", excecao);
        }
    }

    public Analise buscarPorId(Integer id) {
        String sql = "SELECT ana_id, ana_data, ana_titulo,ana_descricao,ana_situacao FROM analise WHERE ana_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Analise analise = null;

                if (resultado.next()) {
                    analise = new Analise();
                    analise.setAna_id(resultado.getInt("ana_id"));
                    analise.setAna_data(resultado.getString("ana_data"));
                    analise.setAna_titulo(resultado.getString("ana_titulo"));
                    analise.setAna_descricao(resultado.getString("ana_descricao"));
                    analise.setAna_situacao(resultado.getString("ana_situacao"));
                }

                return analise;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar uma analise", excecao);
        }
    }

}

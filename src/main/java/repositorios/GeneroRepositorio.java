package repositorios;

import entidades.Genero;
import fabricas.FabricaDeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroRepositorio {
    public void inserir(Genero genero) {
        String sql = "INSERT genero (gen_nome) VALUES (?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, genero.getGen_nome());

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir um genero", excecao);
        }
    }

    public List<Genero> listar() {
        String sql = "SELECT gen_id, gen_nome FROM genero ORDER BY gen_nome";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Genero> generos = new ArrayList<>();

            while (resultado.next()) {
                Genero genero = new Genero();
                genero.setGen_id(resultado.getInt("gen_id"));
                genero.setGen_nome(resultado.getString("gen_nome"));

                generos.add(genero);
            }

            return generos;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar os generos", excecao);
        }
    }

    public void excluir (Integer id) {
        String sql = "DELETE FROM genero WHERE gen_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir um genero", excecao);
        }
    }

    public void editar (Genero genero) {
        String sql = "UPDATE genero SET gen_nome = ? WHERE gen_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, genero.getGen_nome());
            comando.setInt(2, genero.getGen_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar um genero", excecao);
        }
    }

    public Genero buscarPorId(Integer id) {
        String sql = "SELECT gen_id, gen_nome FROM genero WHERE gen_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()) {
                Genero genero = null;

                if (resultado.next()) {
                    genero = new Genero();
                    genero.setGen_id(resultado.getInt("gen_id"));
                    genero.setGen_nome(resultado.getString("gen_nome"));

                }

                return genero;
            }
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar um genero", excecao);
        }
    }
}

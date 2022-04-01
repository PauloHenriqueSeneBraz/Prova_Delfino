package repositorios;

import entidades.Desenvolvedor;
import entidades.Genero;
import entidades.Jogo;
import fabricas.FabricaDeConexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoRepositorio {
    public void inserir(Jogo jogo) {
        String sql = "INSERT jogo (jog_titulo, jog_preco_unitario, jog_gen_id, jog_dev_id ) VALUES (?,?,?,?)";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, jogo.getJog_titulo());
            comando.setDouble(2, jogo.getJog_preco_unitario());
            comando.setInt(3, jogo.getJog_gen_idFK().getGen_id());
            comando.setInt(4, jogo.getJog_dev_idFK().getDev_id());


            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao tentar inserir um jogo", excecao);
        }
    }

    public List<Jogo> listar() {
        String sql = String.join(
                "\n",
                "SELECT jog_id, jog_titulo, jog_preco_unitario, gen_id, gen_nome, dev_id, dev_nome",
                "FROM jogo INNER JOIN genero ON jog_gen_id = gen_id",
                "FROM jogo INNER JOIN desenvolvedor ON jog_dev_id = dev_id  ",
                "ORDER BY jog_titulo"
        );

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            List<Jogo> jogos = new ArrayList<>();

            while (resultado.next()) {

                Genero genero = new Genero();
                genero.setGen_id(resultado.getInt("gen_id"));
                genero.setGen_nome(resultado.getString("gen_nome"));

                Desenvolvedor desenvolvedor = new Desenvolvedor();
                desenvolvedor.setDev_id(resultado.getInt("dev_id"));
                desenvolvedor.setDev_nome(resultado.getString("dev_nome"));

                Jogo jogo = new Jogo();

                jogo.setJog_id(resultado.getInt("jog_id"));
                jogo.setJog_titulo(resultado.getString("jog_titulo"));
                jogo.setJog_preco_unitario(resultado.getDouble("jog_preco_unitario"));
                jogo.setJog_gen_idFK(genero);
                jogo.setJog_dev_idFK(desenvolvedor);

                jogos.add(jogo);

            }

            return jogos;
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao listar os jogos", excecao);
        }
    }

    public void excluir (Integer id) {
        String sql = "DELETE FROM jogo WHERE jog_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao excluir um jogo", excecao);
        }
    }

    public void editar (Jogo jogo) {
        String sql = "UPDATE jogo SET jog_titulo = ?, jog_preco_unitario = ?,jog_gen_id = ?, jog_dev_id = ? WHERE jog_id = ?";

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, jogo.getJog_titulo());
            comando.setDouble(2, jogo.getJog_preco_unitario());
            comando.setInt(3, jogo.getJog_gen_idFK().getGen_id());
            comando.setInt(4, jogo.getJog_dev_idFK().getDev_id());
            comando.setInt(5, jogo.getJog_id());

            comando.execute();
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao editar um jogo", excecao);
        }
    }

    public Jogo buscarPorId(Integer id) {

        String sql = String.join(
                "\n",
                "SELECT jog_id, jog_titulo, jog_preco_unitario, gen_id, gen_nome, dev_id, dev_nome",
                "FROM jogo INNER JOIN genero ON jog_gen_id = gen_id",
                "FROM jogo INNER JOIN desenvolvedor ON jog_dev_id = dev_id  ",
                "WHERE jog_id"
        );

        try (Connection conexao = FabricaDeConexoes.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql))
        {

            comando.setInt(1, id);

            try (ResultSet resultado = comando.executeQuery()){

                Jogo jogo = null;

                while (resultado.next()) {

                    Genero genero = new Genero();
                    genero.setGen_id(resultado.getInt("gen_id"));
                    genero.setGen_nome(resultado.getString("gen_nome"));

                    Desenvolvedor desenvolvedor = new Desenvolvedor();
                    desenvolvedor.setDev_id(resultado.getInt("dev_id"));
                    desenvolvedor.setDev_nome(resultado.getString("dev_nome"));

                    jogo = new Jogo();

                    jogo.setJog_id(resultado.getInt("jog_id"));
                    jogo.setJog_titulo(resultado.getString("jog_titulo"));
                    jogo.setJog_preco_unitario(resultado.getDouble("jog_preco_unitario"));
                    jogo.setJog_gen_idFK(genero);
                    jogo.setJog_dev_idFK(desenvolvedor);

                }

                return jogo;
            }


        } catch (SQLException excecao) {
            throw new RuntimeException("Erro ao buscar os jogos", excecao);
        }

    }
}

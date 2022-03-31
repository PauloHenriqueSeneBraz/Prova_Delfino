package fabricas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
    public static Connection conectar() {
        String usuario = "root";
        String senha = "RandomBl0quia22092001";
        String url = "jdbc:mysql://localhost:3306/Prova_VendaJogosOnline";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (ClassNotFoundException excecao) {
            throw new RuntimeException("Erro ao tentar registrar o driver", excecao);
        } catch (SQLException excecao) {
            throw new RuntimeException("Erro de conexão", excecao);
        }
    }

}

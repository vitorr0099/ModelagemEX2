import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static Connection conexao;

    private ConexaoBD() {}

    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection("jdbc:url_do_banco_de_dados", "usuario", "senha");
        }
        return conexao;
    }
}

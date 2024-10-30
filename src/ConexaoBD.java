import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static Connection conexao;

    public static Connection getConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/sistema_gerenciamento";
            String usuario = "root";
            String senha = "senha";
            conexao = DriverManager.getConnection(url, usuario, senha);
        }
        return conexao;
    }
}

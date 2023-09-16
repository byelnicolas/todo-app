package mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

	public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=todo_app;encrypt=false";
	public static final String USER = "sa";
	public static final String PASS = "12345678";

	/**
	 * esse método devolve uma conexão static: diz que eu posso chamar esse método
	 * sem criar uma instancia dessa classe. nao é necessário criar um objeto da
	 * classe ConnectionFactory, para poder executa-lo. é como se fosse um método
	 * global, não é muito usual, vai depender de cada projeto.
	 *
	 * @return Conexão com o banco de dados.
	 */

	public static Connection getConnection() {
		// try catch é uma forma de pegar erros que podem acontecer e fazer um
		// tratamento. faz tratamento de esceçãp/erro.No try
		// codigo que é possivel de erro.
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new RuntimeException("erro na conexão com banco de dados", e);
		}
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement) {
		try {
			closeConnection(connection);
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}

	public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			closeConnection(connection, statement);
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			throw new RuntimeException("erro ao fechar a conexão com banco de dados.", e);
		}
	}
}

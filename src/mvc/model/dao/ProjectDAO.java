package mvc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Project;

public class ProjectDAO {

	public void save(Project project) {
		String sql = "INSERT INTO project (name, description, createdAt, updatedAt) VALUES (?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescripition());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdateAt().getTime()));

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao salvar o projeto",e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Project project) {
		String sql = "UPDATE project SET name = ?, description = ?, createdAt = ?, updatedAt = ? where id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);

			statement.setString(1, project.getName());
			statement.setString(2, project.getDescripition());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdateAt().getTime()));
			statement.setInt(5, project.getId());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao atualizar o projeto.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Project> getALL() {
		String sql = "SELECT * FROM project ";

		List<Project> projects = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;

		// classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			// enquanto existir dados no banco de dados
			while (resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescripition(resultSet.getString("description"));
				project.setCreatedAt(resultSet.getDate("createdAt"));
				project.setUpdateAt(resultSet.getDate("updatedAt"));

				// adiciono o contato recuperado, a lista de contatos
				projects.add(project);
			}
		} catch (SQLException e) {
			throw new RuntimeException("erro ao buscar os projestos.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return projects;
	}

	public void removeById(int idProject) {
		String sql = "DELETE FROM project WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProject);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("erro ao deletar o projeto.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}

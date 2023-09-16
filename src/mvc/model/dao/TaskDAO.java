package mvc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.model.Task;

public class TaskDAO {

	public void save(Task task) {
		String sql = "INSERT INTO task (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES (?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);

			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao salvar a tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public void update(Task task) {
		String sql = "UPDATE task SET idProject = ?, name ?, description = ?, completed = ?, notes = ?, deadline = ?, createdAt = ?, updatedAt = ? where id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);

			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());

			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("erro ao atualizar o projeto.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Task> getALL(int idProject) {
		String sql = "SELECT * FROM task WHERE idProject = ?";

		List<Task> tasks = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;

		// classe que vai recuperar os dados do banco de dados
		ResultSet resultSet = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProject);
			resultSet = statement.executeQuery();

			// enquanto existir dados no banco de dados
			while (resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setIdProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setCompleted(resultSet.getBoolean("completed"));
				task.setNotes(resultSet.getString("notes"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCreatedAt(resultSet.getDate("createdAt"));
				task.setUpdatedAt(resultSet.getDate("updatedAt"));

				// adiciono o contato recuperado, a lista de contatos
				tasks.add(task);
			}
		} catch (SQLException e) {
			throw new RuntimeException("erro ao buscar as tarefas.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		return tasks;
	}

	public void removeById(int idTask) {
		String sql = "DELETE FROM task WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idTask);
			statement.execute();
		} catch (Exception e) {
			throw new RuntimeException("erro ao deletar a tarefa.", e);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
}

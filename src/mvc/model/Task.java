package mvc.model;

import java.util.Date;

public class Task {
	// atributos
	private int id;
	private int idProject;
	private String name;
	private String description;
	private String notes;
	private boolean completed;
	private Date deadline;
	private Date createdAt;
	private Date updatedAt;

	// construtor
	// pode existir mais de um construtor, só deve se ter
	// o cuidado de colocar parametros diferentes

	public Task(int id, int idProject, String name, String description, String notes, boolean completed, Date deadline,
			Date createdAt, Date updateAt) {
		this.id = id;
		this.idProject = idProject;
		this.name = name;
		this.description = description;
		this.notes = notes;
		this.completed = completed;
		this.deadline = deadline;
		this.createdAt = createdAt;
		this.updatedAt = updateAt;
	}

	// construtor usado para inicializar a tarefa
	public Task() {
		this.completed = false;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	// métodos mágicos
	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	// Método publico que retorna uma string, a qual recebe o nome da classe
	// e ainda tem o nome do atributo e o valor que está armazenado no atributo
	@Override
	public String toString() {
		return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description
				+ ", notes=" + notes + ", isCompleted=" + completed + ", deadline=" + deadline + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + '}';
	}

}

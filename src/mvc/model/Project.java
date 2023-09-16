package mvc.model;

import java.util.Date;

public class Project {
	// Atributos

	private int id;
	private String name;
	private String descripition;
	private Date createdAt;
	private Date updateAt;

	// construtor com todos os atributos
	public Project(int id, String name, String descripition, Date createdAt, Date updateAt) {
		this.id = id;
		this.name = name;
		this.descripition = descripition;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	// construtor com datas
	public Project() {
		this.createdAt = new Date();
		this.updateAt = new Date();
	}

	// getters and setters
	// métodos de acesso
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	// método toString
	// retorna uma representação textual do objeto project
	@Override
	public String toString() {
		return this.name;
	}

}

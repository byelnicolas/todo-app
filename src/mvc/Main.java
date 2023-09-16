package mvc;

import mvc.model.Project;
import mvc.model.dao.ProjectDAO;
import mvc.model.dao.TaskDAO;

public class Main {
	public static void main(String[] args) {
		TaskDAO taskDAO = new TaskDAO();

		ProjectDAO projectDAO = new ProjectDAO();
		Project project = projectDAO.getALL().get(0);
				
		taskDAO.removeById(taskDAO.getALL(project.getId()).get(0).getId());
		projectDAO.removeById(project.getId());
	}

}

package Test;

import Controller.ProjectController;
import Model.Project;

import java.util.Date;
import java.util.List;

public class ProjectTest {

    public void testProjectSave() {
        ProjectController projectController = new ProjectController();
        Project project = new Project();

        project.setName("ProjetoTeste");
        project.setDescription("Modelo de projeto");
        project.setCreatedAt(new Date());
        project.setUpdatedAt(new Date());
        projectController.save(project);
        System.out.println("Project created ---------- Test OK!");
    }

    public void testProjectDelete(int id){
        ProjectController projectController = new ProjectController();
        projectController.removeById(id);
        System.out.println("Project deleted ---------- Test OK!");
    }

    public void testProjectUpdate(int id){
        ProjectController projectController = new ProjectController();
        Project project = new Project();

        project.setId(id);
        project.setName("ProjetoTeste");
        project.setDescription("Modelo de projeto modificado");
        project.setCreatedAt(new Date());
        project.setUpdatedAt(new Date());
        projectController.update(project);
        System.out.println("Project updated ---------- Test OK!");
    }

    public void testProjectGetAll (){
        ProjectController projectController = new ProjectController();
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos  = " + projects.size());
        System.out.println("List of projects ---------- Test OK!");
    }
}

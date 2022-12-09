package Test;

import Controller.ProjectController;
import Controller.TaskController;

import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException {

        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();
        ProjectTest projectTest = new ProjectTest();
        TaskTest taskTest = new TaskTest();

        //Teste para criar um projeto
        projectTest.testProjectSave();

        int testeCriadoProjeto = projectController.searchByName("ProjetoTeste");

        //Teste para modificar um projeto
        projectTest.testProjectUpdate(testeCriadoProjeto);

        //Teste para criar tarefas no no projeto
        taskTest.testTaskSave(testeCriadoProjeto);

        int testeCriadoTask = taskController.searchByName("TarefaTeste");

        //Teste para modificar uma tarefa
        taskTest.testTaskUpdate(testeCriadoTask);

        //Teste para verificar quantos tarefas tem no projeto
        taskTest.testTaskGetAll(testeCriadoProjeto);

        //Teste para deletar uma tarefa
        taskTest.testTaskDelete(testeCriadoTask);

        //Remove todas as tarefas criadas para teste, caso alguma tenha sido criada como teste e não removida
        taskController.removeByTest("TarefaTeste");

        //Teste para verificar quantos projetos tem no banco de dados
        projectTest.testProjectGetAll();

        //Teste para deletar um projeto
        projectTest.testProjectDelete(testeCriadoProjeto);

        //Remove todos os projetos criados para teste, caso algum tenha sido criado como teste e não removido
        projectController.removeByTest("ProjetoTeste");

    }
}

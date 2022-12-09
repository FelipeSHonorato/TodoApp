package Test;

import Controller.TaskController;
import Model.Task;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TaskTest {

    public void testTaskSave(int idProject) {
        TaskController taskController = new TaskController();
        Task task = new Task();

        task.setName("TarefaTeste");
        task.setDescription("Modelo de tarefa");
        task.setCompleted(false);
        task.setDeadline(new Date());
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        task.setIdProject(idProject);
        taskController.save(task);
        System.out.println("Task created ---------- Test OK!");
    }

    public void testTaskDelete(int id) throws SQLException {
        TaskController taskController = new TaskController();
        taskController.removeById(id);
        System.out.println("Task deleted ---------- Test OK!");
    }

    public void testTaskUpdate(int id) {
        TaskController taskController = new TaskController();
        Task task = new Task();

        task.setName("TarefaTeste");
        task.setDescription("Modelo de tarefa modificada");
        task.setCompleted(true);
        task.setDeadline(new Date());
        task.setCreatedAt(new Date());
        task.setUpdatedAt(new Date());
        task.setIdProject(id);
        taskController.update(task);
        System.out.println("Task updated ---------- Test OK!");
    }

    public void testTaskGetAll(int idProject) {
        TaskController taskController = new TaskController();
        List<Task> tasks = taskController.getAll(idProject);
        System.out.println("Total de tarefas  = " + tasks.size());
        System.out.println("List of tasks ---------- Test OK!");
    }
}

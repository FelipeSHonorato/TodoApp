package Controller;

import Model.Task;
import Util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (name,"
                + "description,"
                + "isCompleted,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt"
                + "idProject) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNotes());
            statement.setDate(5, new Date(task.getDeadline().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar tarefa" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET"
                + "name = ?, "
                + "description = ?, "
                + "isCompleted = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ?, "
                + "idProject = ?, "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNotes());
            statement.setDate(5, new Date(task.getDeadline().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar tarefa" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int taskId) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null; //Evita ataques de SQL Injection

        try {
            connection = ConnectionFactory.getConnection(); //Solicitou conexão
            statement = connection.prepareStatement(sql); //Preparou a conexão
            statement.setInt(1, taskId); //Ação de substituir o 1 parametro "?" de sql para o taskId
            statement.execute(); //Executando a ação no banco de dados
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover a tarefa");
        } finally {
            ConnectionFactory.closeConnection(connection, statement); //Fechando conexão e statement
        }
    }

    public List<Task> getAll(int idProject) {
        String sql = "SELECT * FROM tasks WHERE idProject = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null; //Guarda a resposta do banco de dados

        List<Task> tasks = new ArrayList<Task>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject); //Ação de substituir o 1 parametro "?" de sql para o idProject
            resultSet = statement.executeQuery(); //Guarda a execução e retorno da Query no resultSet

            while(resultSet.next()){

                Task task = new Task();
                task.setId(resultSet.getInt("id"));


            }


        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover a tarefa");
        } finally {
            ConnectionFactory.closeConnection(connection, statement); //Fechando conexão e statement
        }


        return null;
    }
}

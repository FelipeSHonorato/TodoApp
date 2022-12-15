package Controller;

import Model.Project;
import Model.Task;
import Util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task) {

        //Criando uma query para se comunicar com o banco de dados
        String sql = "INSERT INTO tasks (name,"
                + "description,"
                + "isCompleted,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt,"
                + "idProjects) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null; //Criando uma conexão com banco de dados
        PreparedStatement statement = null; //Criando o statement para enviar o query para o banco de dados

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNotes());
            statement.setDate(5, new Date(task.getDeadline().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Task task) {

        //Criando uma query para se comunicar com o banco de dados
        String sql = "UPDATE tasks SET "
                + "name = ?, "
                + "description = ?, "
                + "isCompleted = ?, "
                + "notes = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ?, "
                + "idProjects = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.isCompleted());
            statement.setString(4, task.getNotes());
            statement.setDate(5, new Date(task.getDeadline().getTime()));
            statement.setDate(6, new Date(task.getCreatedAt().getTime()));
            statement.setDate(7, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(8, task.getIdProject());
            statement.setInt(9, task.getId());

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar a tarefa" + e.getMessage(), e);
        } finally {

            //Fechando conexão e statement
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int taskId) {

        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null; //Evita ataques de SQL Injection

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setInt(1, taskId);

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover a tarefa", e);
        } finally {

            //Fechando conexão e statement
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeByTest(String name) throws SQLException {

        String sql = "DELETE FROM tasks WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null; //Evita ataques de SQL Injection

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setString(1, name);

            //Executando a query
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover as tarefas", e);
        } finally {

            //Fechando conexão e statement
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public int searchByName(String name) {
        String sql = "SELECT id FROM tasks WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            resultSet = statement.executeQuery();

            Task task = new Task();

            while (resultSet.next()) {
                task.setId(resultSet.getInt("id"));
            }

            return task.getId();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao procurar o id da tarefa", e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    }

    public List<Task> getAll(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProjects = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        //Criando um resultset onde será armazenado as infos retornadas do banco de dados
        ResultSet resultSet = null;

        //Criando uma lista de tasks
        List<Task> tasks = new ArrayList<Task>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setInt(1, idProject);

            //Executando a query e guardando o retorno do banco de dados na variável resultset
            resultSet = statement.executeQuery();

            //Percorrendo a variável resultset para popular a lista de task
            while (resultSet.next()) {

                //Criado um objeto task onde irá ser inserido os valores retornado para o resultSet
                Task task = new Task();

                //Setando os valores do resultset
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("isCompleted"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                task.setIdProject(resultSet.getInt("idProjects"));

                //Inserindo o objeto na lista de objetos de tarefas
                tasks.add(task);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao procurar a tarefa" + e.getMessage(), e);
        } finally {

            //Fechando conexão, statement e resultset
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        //Retornando os valores da lista de tasks
        return tasks;
    }
}

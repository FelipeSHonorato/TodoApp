package Controller;

import Model.Project;
import Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

    public void save(Project project) {
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Project project) {

        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao alterar o projeto" + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int projectId) {

        String sql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover o projeto", e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeByTest(String name) {

        String sql = "DELETE FROM projects WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover os projetos", e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public int searchByName(String name) {
        String sql = "SELECT id FROM projects WHERE name = ?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();

            statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            resultSet = statement.executeQuery();

            Project project = new Project();

            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
            }

            return project.getId();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao procurar o id do projeto", e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
    }

    public List<Project> getAll() {

        String sql = "SELECT * FROM projects";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                projects.add(project);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao procurar o projeto", e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }
}

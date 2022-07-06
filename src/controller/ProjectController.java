package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Project;
import model.Task;

public class ProjectController {

	public void save(Project project) {

		String sql = "INSERT INTO projects(id, name, description, createAt, updateAt) VALUES ( ?, ?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, project.getId());
			statement.setString(2, project.getName());
			statement.setString(3, project.getDescription());
			statement.setDate(4, new java.sql.Date(project.getCreateAt().getTime()));
			statement.setDate(5, new java.sql.Date(project.getUpdateAt().getTime()));

			statement.execute();
			
			JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso");

		}catch(Exception ex) {
			System.out.println(ex + " " );
			throw new RuntimeException("Erro ao salvar o projeto   " + ex.getMessage(), ex);
		}finally{
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				throw new RuntimeException("Erro ao fechar a conexão", ex);
			}

		}


	}

	public void update(Project project) {

		String sql = "UPDATE projects SET name = ?, description = ?, createAt = ?, updateAt = ? WHERE id = ?";

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();

			statement = connection.prepareStatement(sql);
			//Preparando a Query

			//setando os valores do statement
			statement.setInt(1, project.getId());
			statement.setString(2, project.getName());
			statement.setString(3, project.getDescription());
			statement.setDate(4, new Date(project.getCreateAt().getTime()));
			statement.setDate(5, new Date(project.getUpdateAt().getTime()));

			//executando a query
			statement.execute();


		}catch(Exception e) {
			throw new RuntimeException("Erro ao salvar o projeto" + e.getMessage(), e);
		}

	}

	public void removebyId(int idProject) throws SQLException {

		String sql = "DELETE FROM projects WHERE ID = ? "; 


		Connection connection = null;
		PreparedStatement statement = null;


		try {
			//criação da conexão
			connection = ConnectionFactory.getConnection();

			//preparando a query
			statement = connection.prepareStatement(sql);

			//setando os dados
			statement.setInt(1, idProject);

			//Executando a query
			statement.execute();

		}catch( Exception e) {
			throw new SQLException("Erro ao deletar o projeto");

		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}

	public List<Project> getAll(int idProject){


		String sql = "SELECT * FROM projects";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Project> projects = new ArrayList<Project>();

		try {
			//criação da conexão
			connection = ConnectionFactory.getConnection();

			//preparando a consulta
			statement = connection.prepareStatement(sql);

			//setando o dado pedido
			//statement.setInt(1, idProject);

			//passando dados da query para a variável do tipo ResultSet
			resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreateAt(resultSet.getDate("createAt"));
				project.setUpdateAt(resultSet.getDate("updateAt") );

				projects.add(project);


			}

		}catch(Exception e) {
			throw new RuntimeException("Erro ao buscar projetos" + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return projects;

	}
	
	public List<Project> getAll(){


		String sql = "SELECT * FROM projects";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Project> projects = new ArrayList<Project>();

		try {
			//criação da conexão
			connection = ConnectionFactory.getConnection();

			//preparando a consulta
			statement = connection.prepareStatement(sql);

			//setando o dado pedido
			//statement.setInt(1, idProject);

			//passando dados da query para a variável do tipo ResultSet
			resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Project project = new Project();
				project.setId(resultSet.getInt("id"));
				project.setName(resultSet.getString("name"));
				project.setDescription(resultSet.getString("description"));
				project.setCreateAt(resultSet.getDate("createAt"));
				project.setUpdateAt(resultSet.getDate("updateAt") );

				projects.add(project);


			}

		}catch(Exception e) {
			throw new RuntimeException("Erro ao buscar projetos" + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}

		return projects;

	}

}

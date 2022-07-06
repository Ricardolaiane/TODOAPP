package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskController {
	
	public void save(Task task) {
		
		
		String sql2 = "INSERT INTO tasks (idProject, name, description, completed, notes, deadline, createdAt, updatedAt) VALUES(?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(sql2);
			
			statement.setInt(1, task.getidProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.isCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.execute();
			
		}catch(Exception ex) {
			throw new RuntimeException("Erro ao salvar a tarefa    " + ex.getMessage(), ex);
		}finally{
			ConnectionFactory.closeConnection(connection, statement);
		}
		
		
		
		
	}
	
	public void update(Task task) {
		
		String sql = "UPDATE tasks SET idProject = ?, name=?, description=?, notes=?, completed=?, deadline=?, createdAt=?, updatedAt=? WHERE id=?" ;

		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Estabelecendo a conexão com o banco de dados
			connection = ConnectionFactory.getConnection();
			
			statement = connection.prepareStatement(sql);
			//Preparando a Query
			
			//setando os valores do statement
			statement.setInt(1, task.getidProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getNotes());
			statement.setBoolean(5, task.isCompleted());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());
			
			//executando a query
			statement.execute();
			System.out.println("Executou a query");
				
		}catch(Exception e) {
			throw new RuntimeException("Erro ao atualizar tarefa  " + e.getMessage(), e);
		}
		
	}

	public void removeById(int idTask) {
		
		String sql = "DELETE FROM TASKS WHERE ID = ? "; 
		
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try {
			//criação da conexão
			connection = ConnectionFactory.getConnection();
			
			//preparando a query
			statement = connection.prepareStatement(sql);
			
			//setando os dados
			statement.setInt(1, idTask);
			
			//Executando a query
			statement.execute();
			
		}catch( Exception e) {
			System.out.println("Erro ao deletar a tarefa");
			
		}finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
	}
	
	public List<Task> getAll(int idProject){
		
		
		String sql = "SELECT * FROM tasks WHERE idProject =  ?";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Task> tasks = new ArrayList<Task>();
		
		try {
			//criação da conexão
			connection = ConnectionFactory.getConnection();
			
			//preparando a consulta
			statement = connection.prepareStatement(sql);
			
			//setando o dado pedido
			statement.setInt(1, idProject);
			
			//passando dados da query para a variável do tipo ResultSet
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Task task = new Task();
				task.setId(resultSet.getInt("id"));
				task.setidProject(resultSet.getInt("idProject"));
				task.setName(resultSet.getString("name"));
				task.setDescription(resultSet.getString("description"));
				task.setNotes(resultSet.getString("notes"));
				task.setCompleted(resultSet.getBoolean("Completed"));
				task.setDeadline(resultSet.getDate("deadline"));
				task.setCreatedAt(resultSet.getDate("createdAt"));
				task.setUpdatedAt(resultSet.getDate("updatedAt"));
				
				tasks.add(task);
				
			}
		
		}catch(Exception e) {
			throw new RuntimeException("Erro ao buscar tarefas " + e.getMessage(), e);
		}finally {
			ConnectionFactory.closeConnection(connection, statement, resultSet);
		}
		
		return tasks;
		
	}

}

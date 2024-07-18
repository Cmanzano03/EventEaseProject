package Repositories;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import bean.User;

//Abstract class  which defines the basic structure of a repository

//Have to be defined as a singleton , not done yet 

public abstract class Repository {
	
	protected  final String filePath;
	protected  final ObjectMapper objectMapper;
	
	public Repository(String filePath) {
		this.filePath = filePath;
		this.objectMapper = new ObjectMapper();
	}
	
	public abstract List<User> readFile() throws IOException;
	public abstract  void writeFile(List<User> users) throws IOException;
	public abstract List<User> findAll() throws IOException;
	public abstract Optional<User> findById(String userId) throws IOException;
	public abstract void save(User user) throws IOException;
	public abstract void deleteById(String userId) throws IOException;
	
}

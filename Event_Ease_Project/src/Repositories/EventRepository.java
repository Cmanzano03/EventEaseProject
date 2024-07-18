package Repositories;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import bean.User;

public class EventRepository extends  Repository {

	public EventRepository(String filePath) {
		super(filePath);
		
	}

	@Override
	public List<User> readFile() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeFile(List<User> users) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(String userId) throws IOException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(User user) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(String userId) throws IOException {
		// TODO Auto-generated method stub
		
	}

	
}

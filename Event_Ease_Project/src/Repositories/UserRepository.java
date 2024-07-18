// repositories/UserRepository.java
package Repositories;

import com.fasterxml.jackson.core.type.TypeReference;

import bean.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

//Hacer como singleton 

public class UserRepository extends Repository<User>{
   private final static  String filePath  = "src/json/users.json";
	
    public UserRepository() {
    	super();
    }
    public  List<User> readFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return List.of();
        }
        return objectMapper.readValue(file, new TypeReference<List<User>>() {});
    }

    public void writeFile(List<User> users) throws IOException {
        objectMapper.writeValue(new File(filePath), users);		
    }

    public List<User> findAll() throws IOException {
        return readFile();
    }

    public Optional<User> findById(String userId) throws IOException {
        return readFile().stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst();
    }

    public void save(User user) throws IOException {
        List<User> users = readFile();
        users.add(user);
        writeFile(users);
    }

    public void deleteById(String id) throws IOException {
        List<User> users = readFile();
        users.removeIf(user -> user.getId().equals(id));
        writeFile(users);
    }
}

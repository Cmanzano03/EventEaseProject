package Repositories;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;

import bean.Event;

public class EventRepository extends  Repository<Event> {
	   private final static  String filePath  = "src/json/events.json";


	public EventRepository() {
		super();
	}

	@Override
	public List<Event> readFile() throws IOException {
		File file = new File(filePath);
        if (!file.exists()) {
            return List.of();
        }
        return objectMapper.readValue(file, new TypeReference<List<Event>>() {});	
		
	}

	@Override
	public void writeFile(List<Event> events) throws IOException {
		File file = new File(filePath);
		objectMapper.writeValue(file, events );
	}		
	

	@Override
	public List<Event> findAll() throws IOException {
		// TODO Auto-generated method stub
		return readFile();
	}

	@Override
	public Optional<Event> findById( String id) throws IOException {
		List<Event> events = readFile();
		return events.stream().filter(e -> e.getEventId().equals(id)).findFirst();
	}
	@Override
	public void save(Event event) throws IOException {
		List<Event> events = readFile();
		events.add(event);
		writeFile(events);
	}

	@Override
	public void deleteById(String id) throws IOException {
		List<Event> events = readFile();
		events.removeIf(e -> e.getEventId().equals(id));
		writeFile(events);
	}

	

	
}

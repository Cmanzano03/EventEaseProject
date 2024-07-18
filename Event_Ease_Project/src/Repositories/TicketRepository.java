package Repositories;

import bean.Ticket;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;


public class TicketRepository extends  Repository<Ticket> {
	   private final static  String filePath  = "src/json/tickets.json";

	
	public TicketRepository() {
		super();
		
	}

	@Override
	public List<Ticket> readFile() throws IOException {
		
		File file = new File(filePath);
        if (!file.exists()) {
            return List.of();
        }
        return objectMapper.readValue(file, new TypeReference<List<Ticket>>() {});	
		
	}

	@Override
	public void writeFile(List<Ticket> tickets) throws IOException {
		File file = new File(filePath);
		objectMapper.writeValue(file, tickets);
	}

	@Override
	public List<Ticket> findAll() throws IOException {
		return readFile();
	}

	@Override
	public Optional<Ticket> findById(String id) throws IOException {
		List<Ticket> tickets = readFile();
		return tickets.stream().filter(t -> t.getTicketId().equals(id)).findFirst();
	}


	@Override
	public void deleteById(String id) throws IOException {
		List<Ticket> tickets = readFile();
		tickets.removeIf(t -> t.getTicketId().equals(id));
		writeFile(tickets);
		
	}

	@Override
	public void save(Ticket ticket ) throws IOException {
        List<Ticket> tickets = readFile();
        tickets.add(ticket);
        writeFile(tickets);		
	}

	

}

package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Broker extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, String> adminCredentials;
    private Map<String, String> userCredentials;

    @Override
    public void init() throws ServletException {
        super.init();
        adminCredentials = new HashMap<>();
        userCredentials = new HashMap<>();
        loadCredentials();
    }

    private void loadCredentials() {
        loadAdminCredentials("admin.txt");
        loadUserCredentials("user.txt");
    }

    private void loadAdminCredentials(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getServletContext().getRealPath(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    adminCredentials.put(username, password);
                } else {
                    System.err.println("Invalid format in admin credentials file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUserCredentials(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(getServletContext().getRealPath(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    userCredentials.put(username, password);
                } else {
                    System.err.println("Invalid format in user credentials file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String action = request.getParameter("action");

        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (isAdmin(username, password)) {
                response.getWriter().println("Admin login successful");
                //////////////////////////////
                // Handle admin actions here//
                //////////////////////////////
                
            } else if (isUser(username, password)) {
                response.getWriter().println("User login successful");
                /////////////////////////////
                // Handle user actions here//
                /////////////////////////////
            } else {
                response.getWriter().println("Invalid credentials");
            }
        } else if ("createAccount".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("userType");

            if ("admin".equals(userType)) {
                createNewAccount(username, password, true);
            } else {
                createNewAccount(username, password, false);
            }
            response.getWriter().println("Account created successfully");
        }
    }

    private boolean isAdmin(String username, String password) {
        return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
    }

    private boolean isUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    private void createNewAccount(String username, String password, boolean isAdmin) {
        String credentialsFilePath = isAdmin ? "/path/to/admin.txt" : "/path/to/user.txt"; // Replace with your file paths
        try (FileWriter writer = new FileWriter(getServletContext().getRealPath(credentialsFilePath), true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.newLine();
            bufferedWriter.write(username + ":" + password);
            if (isAdmin) {
                adminCredentials.put(username, password);
            } else {
                userCredentials.put(username, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

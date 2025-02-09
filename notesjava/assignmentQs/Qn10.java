package assignmentQs;

class SharedResource {
    private boolean isProcessed = false;

    public synchronized void produce() {
        try {
            while (isProcessed) {
                wait(); // Wait until consumption is done
            }
            System.out.println(Thread.currentThread().getName() + " produced an item.");
            isProcessed = true;
            notifyAll(); // Notify all waiting threads
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    public synchronized void consume() {
        try {
            while (!isProcessed) {
                wait(); // Wait until production is done
            }
            System.out.println(Thread.currentThread().getName() + " consumed an item.");
            isProcessed = false;
            notifyAll(); // Notify all waiting threads
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

class Producer implements Runnable {
    private final SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.produce();
        }
    }
}

class Consumer implements Runnable {
    private final SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            resource.consume();
        }
    }
}

public class Qn10 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producerThread = new Thread(new Producer(resource), "Producer");
        Thread consumerThread = new Thread(new Consumer(resource), "Consumer");

        producerThread.start();
        consumerThread.start();

        // Ensure the main thread terminates last
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Main thread terminates last.");
    }
}



package jdbc;

import java.sql.*;

public class SimpleCRUD {

    Connection connection;

    SimpleCRUD() {
        connection = getConnection();
    }

    Connection getConnection() {
        if (connection != null) return connection;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbUrl = "jdbc:sqlserver://ANILTHPS;databaseName=student_db;integratedSecurity=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(dbUrl);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void readAllData() {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println("ID: " + result.getString("sid") +
                        ", Name: " + result.getString("name") +
                        ", Address: " + result.getString("address") +
                        ", Age: " + result.getString("age"));
            }
        } catch (SQLException e) {
            System.out.println("Read Exception: " + e);
        }
    }

    public void writeData(int id, String name, String address, int age) {
        try {
            String query = "INSERT INTO student (sid, name, address, age) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, address);
            statement.setInt(4, age);

            int result = statement.executeUpdate();
            System.out.println("Data successfully inserted.");
        } catch (SQLException e) {
            System.out.println("Write Exception: " + e);
        }
    }

    public void updateAge(int id, int age) {
        try {
            String query = "UPDATE student SET age = ? WHERE sid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, age);
            statement.setInt(2, id);
            statement.executeUpdate();
            System.out.println("Data successfully updated.");
        } catch (SQLException e) {
            System.out.println("Update Exception: " + e);
        }
    }

    public void deleteRecord(int id) {
        try {
            String query = "DELETE FROM student WHERE sid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Data successfully deleted.");
        } catch (SQLException e) {
            System.out.println("Delete Exception: " + e);
        }
    }

    // MAIN METHOD TO TEST CRUD OPERATIONS
    public static void main(String[] args) {
        SimpleCRUD crud = new SimpleCRUD();

        // INSERT Data
        crud.writeData(1, "John Doe", "New York", 22);

        // READ Data
        crud.readAllData();

        // UPDATE Data
        crud.updateAge(1, 23);

        // DELETE Data
        crud.deleteRecord(1);
    }
}


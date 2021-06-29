package MiniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientHandlerr extends Thread {
    public static Connection conn;
    private Socket socket;

    public ClientHandlerr(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            connectToDb();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            DataPackage dp;
            while ((dp = (DataPackage) inputStream.readObject()) != null) {
                if (dp.getOperationType().equals("add")) {
                    addStudents(dp.getStudent());
                } else if (dp.getOperationType().equals("list")) {
                    dp.setStudents(getAllStudents());

                    try {
                        outputStream.writeObject(dp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connectToDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlab_db?useUnicode=true=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents() {
        ArrayList<Students> students = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("select * from students");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                students.add(new Students(id, name, surname, age));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void addStudents(Students stu) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into students(name, surname, age) values(?, ?, ?)");
            st.setString(1, stu.getName());
            st.setString(2, stu.getSurname());
            st.setInt(3, stu.getAge());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

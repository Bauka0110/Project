package MiniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static MainFramee frame;
    public static ObjectOutputStream outputStream;
    public static Socket socket;
    public static ObjectInputStream inputStream;

    public static ArrayList<Students> students;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 9009);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new MainFramee();
        frame.setVisible(true);
    }

    public static void addStudent(Students students) {
        DataPackage dp = new DataPackage();
        dp.setOperationType("add");
        dp.setStudent(students);
        try {
            outputStream.writeObject(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getList() {
        DataPackage dp = new DataPackage();
        dp.setOperationType("list");
        try {
            outputStream.writeObject(dp);
            dp = (DataPackage) inputStream.readObject();
            students = dp.getStudents();
            System.out.println(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

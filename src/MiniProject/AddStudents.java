package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudents extends JPanel {
    private MainFramee parent;

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    private JButton add;
    private JButton back;

    public AddStudents(MainFramee parent) {
        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        label1 = new JLabel("NAME:");
        label1.setSize(100, 20);
        label1.setLocation(100, 150);
        add(label1);

        label2 = new JLabel("SURNAME:");
        label2.setSize(100, 20);
        label2.setLocation(100, 200);
        add(label2);

        label3 = new JLabel("AGE:");
        label3.setSize(100, 20);
        label3.setLocation(100, 250);
        add(label3);

        textField1 = new JTextField();
        textField1.setSize(200, 30);
        textField1.setLocation(200, 150);
        add(textField1);

        textField2 = new JTextField();
        textField2.setSize(200, 30);
        textField2.setLocation(200, 200);
        add(textField2);

        textField3 = new JTextField();
        textField3.setSize(200, 30);
        textField3.setLocation(200, 250);
        add(textField3);

        add = new JButton("ADD");
        add.setSize(130, 30);
        add.setLocation(100, 300);
        add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String surname = textField2.getText();
                String agee = textField3.getText();
                Integer age = Integer.parseInt(agee);

                Students students = new Students(name, surname, age);
                Client.addStudent(students);

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });

        back = new JButton("Back");
        back.setSize(130, 30);
        back.setLocation(270, 300);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFirstPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

    }
}

package MiniProject;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudentss extends JPanel {

    private MainFramee parent;

    private JTextArea area;
    private JButton back;

    public ListStudentss(MainFramee parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);

        back = new JButton("Back");
        back.setSize(300, 30);
        back.setLocation(100, 300);
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        area = new JTextArea();
        area.setSize(400, 200);
        area.setLocation(50, 50);
        area.setEditable(false);
        add(area);
    }

    public void updateList() {
        System.out.println(MiniProject.Client.students);
        area.setText("");
        for (Students student : MiniProject.Client.students) {
            area.append(student.toString() + "\n");
        }
        add(area);
    }
}

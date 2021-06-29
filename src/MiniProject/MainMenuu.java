package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuu extends JPanel {

    private MiniProject.MainFramee parent;

    private JButton firstPageButton;
    private JButton secondPageButton;
    private JButton exitButton;

    public MainMenuu(MiniProject.MainFramee parent) {

        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        firstPageButton = new JButton("ADD STUDENT");
        firstPageButton.setSize(300, 30);
        firstPageButton.setLocation(100, 100);
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getFirstPage().setVisible(true);
            }
        });
        add(firstPageButton);


        secondPageButton = new JButton("LIST STUDENTS");
        secondPageButton.setSize(300, 30);
        secondPageButton.setLocation(100, 150);
        secondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getSecondPage().setVisible(true);
                MiniProject.Client.getList();
                MiniProject.Client.frame.listStudents.updateList();
            }
        });
        add(secondPageButton);

        exitButton = new JButton("EXIT");
        exitButton.setSize(300, 30);
        exitButton.setLocation(100, 200);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}

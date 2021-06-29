package MiniProject;

import javax.swing.*;

public class MainFramee extends JFrame {
    public MainMenuu mainMenuPage;
    public MiniProject.AddStudents addStudent;
    public MiniProject.ListStudentss listStudents;

    public MainFramee() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BITLAB Application");
        setSize(500, 500);
        setLayout(null);


        mainMenuPage = new MainMenuu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudent = new MiniProject.AddStudents(this);
        addStudent.setVisible(false);
        add(addStudent);

        listStudents = new MiniProject.ListStudentss(this);
        listStudents.setLocation(0, 0);
        listStudents.setVisible(false);
        add(listStudents);

    }

    public MainMenuu getMainMenuPage() {
        return mainMenuPage;
    }

    public MiniProject.AddStudents getFirstPage() {
        return addStudent;
    }

    public void setMainMenuPage(MainMenuu mainMenuPage) {
        this.mainMenuPage = mainMenuPage;
    }

    public MiniProject.AddStudents getAddStudents() {
        return addStudent;
    }

    public void setAddStudents(MiniProject.AddStudents addStudent) {
        this.addStudent = addStudent;
    }

    public MiniProject.ListStudentss getListStudents() {
        return listStudents;
    }

    public void setListStudentss(MiniProject.ListStudentss listStudents) {
        this.listStudents = listStudents;
    }

    public MiniProject.ListStudentss getSecondPage() {
        return listStudents;
    }

}

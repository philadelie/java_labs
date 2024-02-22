package ntudp.psj.lab4.model;

import java.util.ArrayList;

public class Group {
    String name;
    Human head;
    private ArrayList<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students.addAll(students);
    }
}

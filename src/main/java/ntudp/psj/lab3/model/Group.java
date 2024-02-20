package ntudp.psj.lab3.model;

import java.util.ArrayList;

public class Group {
    String name;
    Human head;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void setStudents(ArrayList<Student> students) {
        this.students.addAll(students);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    public Human getHead() {
        return head;
    }

    public String getName() {
        return name;
    }
}

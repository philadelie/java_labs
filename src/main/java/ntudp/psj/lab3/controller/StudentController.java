package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Sex;
import ntudp.psj.lab3.model.Student;

import java.util.*;

public class StudentController {
    private ArrayList<Student> newStudents = new ArrayList<>();
    private Map<String, ArrayList<Student>> groupedStudents = new HashMap<>();

    public StudentController() {
        createBasicStudentsCollection();
    }

    private void createBasicStudentsCollection() {
        Student studentSE1_1 = new Student("Alina", "Namestnykova", "Andriivna", Sex.female);
        Student studentSE1_2 = new Student("Oleksandra", "Atamanchuk", "Anatoliivna", Sex.female);
        Student studentSE2_1 = new Student("Hleb", "Bekish", "Evgeniyovych", Sex.male);
        Student studentSE2_2 = new Student("Oleksandr", "Burlaka", "Sergiyovych", Sex.male);
        Student studentSA1_1 = new Student("Vladlena", "Vatamanyuk", "Volodymyrivna", Sex.female);
        Student studentSA1_2 = new Student("Sofia", "Heyko", "Kostiantynivna", Sex.female);
        Student studentSA2_1 = new Student("Maksym", "Honcharov", "Sergiyovych", Sex.male);
        Student studentSA2_2 = new Student("Stanislav", "Diduh", "Kostiantynovych", Sex.male);
        Student studentFL1_1 = new Student("Denys", "Polishuk", "Dmytrovych", Sex.male);
        Student studentFL1_2 = new Student("Viacheslav", "Kasterov", "Oleksandrovych", Sex.male);
        Student studentFL2_1 = new Student("Anna", "Kondrat", "Dmytrivna", Sex.female);
        Student studentFL2_2 = new Student("Dmytro", "Kusnetsov", "Kostiantynovych", Sex.male);
        Student studentAE1_1 = new Student("Mykyta", "Mishenko", "Sergiyovych", Sex.male);
        Student studentAE1_2 = new Student("Viktoria", "Mudruk", "Dmytrivna", Sex.female);
        Student studentAE2_1 = new Student("Ivan", "Piven", "Sergiyovych", Sex.male);
        Student studentAE2_2 = new Student("Yehor", "Potebenko", "Dmytrovych", Sex.male);

        Collections.addAll(newStudents, studentSE1_1, studentSE1_2, studentSE2_1, studentSE2_2,
                studentSA1_1, studentSA1_2, studentSA2_1, studentSA2_2,
                studentFL1_1, studentFL1_2, studentFL2_1, studentFL2_2,
                studentAE1_1, studentAE1_2, studentAE2_1, studentAE2_2);
    }

    public void createStudentGroup(String group, int studentsAmount) {
        groupedStudents.put(group, new ArrayList<>());
        for (int i = 0; i < studentsAmount; i++) {
            assignStudentToGroup(group);
        }
    }

    public void assignStudentToGroup(String group) {
        newStudents.getFirst().setGroup(group);
        groupedStudents.get(group).add(newStudents.getFirst());
        newStudents.removeFirst();
    }

    public void chooseGroupHead(String group) {
        Random rand = new Random();
        ArrayList<Student> theGroup = groupedStudents.get(group);
        Student choosenStudent = theGroup.get(rand.nextInt(theGroup.size()));
        choosenStudent.setHead(true);
    }

    public Student getGroupHead(String group) {
        ArrayList<Student> theGroup = groupedStudents.get(group);
        for (Student student : theGroup) {
            if (student.isHead()) {
                return student;
            }
        }
        return null;
    }

    public void printStudentsInfo(String group) {
        ArrayList<Student> theGroup = groupedStudents.get(group);
        System.out.print("Students: ");
        for (Student student : theGroup) {
            System.out.printf(student.getFullName());
            if (theGroup.indexOf(student) != theGroup.size() - 1)  System.out.print(", ");
            else System.out.println(".");
        }
    }

    public Student getNewStudent() {
        return newStudents.getFirst();
    }

    public ArrayList<Student> getSomeGroup(String group) {
        return groupedStudents.get(group);
    }
}

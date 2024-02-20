package ntudp.psj.lab3;

import ntudp.psj.lab3.controller.*;
import ntudp.psj.lab3.model.*;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    private static UniversityController uniController;
    private static FacultyController facultyController;
    private static DepartmentController departmentController;
    private static GroupController groupController;
    private static ProfessorController professorController;
    private static StudentController studentController;

    public static void main(String[] args) {
        createTypicalUniversity();
        //System.out.println(uni);
    }

    private static void createTypicalUniversity() {
        professorController = new ProfessorController();
        //studentController = new StudentController();
        uniController = new UniversityController(professorController);

/*        Faculty facultyIT = new Faculty("Faculty of Computer Science", professors.get("deanIT"));
        Faculty facultyM = new Faculty("Faculty of Management", professors.get("deanM"));

        Department departmentSE = new Department("Department of Software Engineering", professors.get("headSE"));
        Department departmentSA = new Department("Department of System Analysis", professors.get("headSA"));
        Department departmentFL = new Department("Department of Foreign Languages", professors.get("headFL"));
        Department departmentAE = new Department("Department of Applied Economics", professors.get("headAE"));

        Group groupSE1 = new Group("SE-1", students.get("studentSE1"));
        Group groupSE2 = new Group("SE-2", students.get("studentSE2"));
        Group groupSA1 = new Group("SA-1", students.get("studentSA1"));
        Group groupSA2 = new Group("SA-2", students.get("studentSA2"));
        Group groupFL1 = new Group("FL-1", students.get("studentFL1"));
        Group groupFL2 = new Group("FL-2", students.get("studentFL2"));
        Group groupAE1 = new Group("AE-1", students.get("studentAE1"));
        Group groupAE2 = new Group("AE-2", students.get("studentAE2"));
    }*/

    }
}

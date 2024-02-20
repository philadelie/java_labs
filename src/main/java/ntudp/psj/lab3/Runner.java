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
        createTypicalUniversity(2,4, 2);
    }

    private static void createTypicalUniversity(int facultiesNumber, int departmetsNumber, int studentsInGroup) {
        professorController = new ProfessorController();
        studentController = new StudentController();

        uniController = new UniversityController(professorController);
        facultyController = new FacultyController(professorController, facultiesNumber);
        departmentController = new DepartmentController(professorController, departmetsNumber);
        groupController = new GroupController(studentController, departmentController.getDepartmentsAbbreviation(), studentsInGroup);
    }
}

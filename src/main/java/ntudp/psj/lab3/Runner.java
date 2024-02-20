package ntudp.psj.lab3;

import ntudp.psj.lab3.controller.*;

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

    private static void createTypicalUniversity(int facultiesNumber, int departmentsNumber, int studentsInGroup) {
        professorController = new ProfessorController();
        studentController = new StudentController();

        uniController = new UniversityController(professorController);
        facultyController = new FacultyController(professorController, facultiesNumber);
        departmentController = new DepartmentController(professorController, departmentsNumber);
        groupController = new GroupController(studentController, departmentController.getDepartmentsAbbreviation(), studentsInGroup);
    }
}

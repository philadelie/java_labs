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
        createTypicalUniversity();
    }

    private static void createTypicalUniversity() {
        createPeople();
        createUniStructures(2, 2, 2);
        linkUniTogether();
    }

    private static void createPeople() {
        professorController = new ProfessorController();
        studentController = new StudentController();
    }

    private static void createUniStructures(int facultiesNumber, int departmentsInFaculty, int studentsInGroup) {
        uniController = new UniversityController(professorController);
        facultyController = new FacultyController(professorController, facultiesNumber);
        departmentController = new DepartmentController(professorController, facultiesNumber * departmentsInFaculty);
        groupController = new GroupController(studentController, departmentController.getAbbreviations(), studentsInGroup);
    }

    private static void linkUniTogether() {
        uniController.setFaculties(facultyController.getFaculties());
        facultyController.setDepartments(departmentController.getDepartments());
        departmentController.setGroups(groupController.getGroups());
    }
}

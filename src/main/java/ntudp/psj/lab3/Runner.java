package ntudp.psj.lab3;

import ntudp.psj.lab3.controller.*;
import ntudp.psj.lab3.model.University;

public class Runner {
    private static UniversityController uniController;
    private static FacultyController facultyController;
    private static DepartmentController departmentController;
    private static GroupController groupController;
    private static ProfessorController professorController;
    private static StudentController studentController;

    public static void main(String[] args) {
        University uni = createTypicalUniversity();
    }

    private static University createTypicalUniversity() {
        createPeople();
        createUniStructures(2, 2, 2, 2);
        linkUniTogether();
        return uniController.getUniversity();
    }

    private static void createPeople() {
        professorController = new ProfessorController();
        studentController = new StudentController();
    }

    private static void createUniStructures(
            int facultiesNumber,
            int departmentsInFaculty,
            int groupsInDepartment,
            int studentsInGroup) {
        uniController = new UniversityController(professorController);
        facultyController = new FacultyController(professorController, facultiesNumber);
        departmentController = new DepartmentController(professorController, departmentsInFaculty);
        groupController = new GroupController(studentController, departmentController.getAbbreviations(), groupsInDepartment, studentsInGroup);
    }

    private static void linkUniTogether() {
        uniController.linkFaculties(facultyController);
        facultyController.linkDepartments(departmentController);
        departmentController.linkGroups(groupController);
    }
}

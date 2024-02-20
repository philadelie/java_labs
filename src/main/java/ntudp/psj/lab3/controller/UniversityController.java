package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.University;

public class UniversityController {
    private University uni;
    private ProfessorController professorController;
    private FacultyController facultyController;

    public UniversityController(ProfessorController professorController) {
        this.professorController = professorController;
        createUniversity("NTU DP");
        this.facultyController = new FacultyController(professorController, 2);
    }

    private void createUniversity(String name) {
        this.uni = new University(name, professorController.getProfessor(0));
        professorController.assignPositionToProfessor(0, "rector");
        System.out.println("University \"" + uni.getName() + "\" is created. " +
                "Rector: " + uni.getHead().getFullName() + ".");
    }
}

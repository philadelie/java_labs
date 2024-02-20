package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.Printer;
import ntudp.psj.lab3.model.University;

public class UniversityController implements Printer<University> {
    private University uni;
    private ProfessorController professorController;

    public UniversityController(ProfessorController professorController) {
        this.professorController = professorController;
        createUniversity("NTU DP");
    }

    private void createUniversity(String name) {
        this.uni = new University(name, professorController.getVacantProfessor());
        professorController.assignPositionToProfessor("rector");
        printCreationText(uni);
    }

    @Override
    public void printCreationText(University uni) {
        System.out.printf("University \"" + uni.getName() + "\" is created. ");
        printHeadInfo(uni);
    }
    @Override
    public void printHeadInfo(University uni) {
        System.out.println("Rector: " + uni.getHead().getFullName() + ".");
    }

    public void linkFaculties(FacultyController facultyController) {
        uni.setFaculties(facultyController.getFaculties());
    }
}

package ntudp.psj.lab4.controller;

import ntudp.psj.lab4.model.University;

import java.util.Map;

public class UniversityController implements Printer<University> {
    private University uni;
    private final ProfessorController profController;
    private final FacultyController facultyController;

    public UniversityController(Map<String, Integer> uniUnitsAmount) {
        profController = new ProfessorController();
        createUniversity("NTU DP");
        facultyController = new FacultyController(profController, uniUnitsAmount);
        linkFaculties();
    }

    private void createUniversity(String name) {
        uni = new University(name, profController.getVacantProfessor());
        profController.assignPositionToProfessor("rector");
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

    public void linkFaculties() { uni.setFaculties(facultyController.getFaculties()); }

    public University getUniversity() { return uni; }
}

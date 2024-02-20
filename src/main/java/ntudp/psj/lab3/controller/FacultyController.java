package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FacultyController {
    private ArrayList<Faculty> faculties = new ArrayList<Faculty>();
    private ProfessorController professorController;
    private final String[] FACULTY_NAMES = new String[]{"Information Technology", "Management"};

    public FacultyController(ProfessorController professorController, int facultiesNumber) {
        this.professorController = professorController;
        createFaculties(facultiesNumber);
    }

    private void createFaculties(int n) {
        for (int i = 0; i < n && i < FACULTY_NAMES.length; i++) {
            Faculty faculty = new Faculty(FACULTY_NAMES[i], professorController.getProfessor(i + 1));
            faculties.add(faculty);
            professorController.assignPositionToProfessor(i + 1, "dean" + getFacultyAbbreviation(i));
            System.out.println("Faculty of " + faculties.get(i).getName() + " is created. " +
                    "Dean: " + faculties.get(i).getHead().getFullName() + ".");
        }
    }

    private String getFacultyAbbreviation(int idx) {
        String abb = "";
        String[] words = FACULTY_NAMES[idx].split(" ");
        for (String word : words) abb += word.charAt(0);
        return abb;
    }
}

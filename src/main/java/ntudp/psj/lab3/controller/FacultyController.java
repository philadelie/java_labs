package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Faculty;

import java.util.ArrayList;
import java.util.Map;

public class FacultyController implements Printer<Faculty>, AbbreviationsMaker {
    private final String[] FACULTY_NAMES = new String[]{"Information Technology", "Management"};
    private final ArrayList<Faculty> faculties = new ArrayList<>();
    private final ProfessorController profController;
    private final DepartmentController departmentController;

    public FacultyController(ProfessorController pC, Map<String, Integer> uniUnitsAmount) {
        profController = pC;
        int facultiesMax = Math.min(uniUnitsAmount.get("faculties"), FACULTY_NAMES.length);
        createFaculties(facultiesMax);
        departmentController = new DepartmentController(profController, uniUnitsAmount, getAbbreviations());
        linkDepartments();
    }

    private void createFaculties(int n) {
        for (int i = 0; i < n; i++) {
            Faculty faculty = new Faculty(FACULTY_NAMES[i], profController.getVacantProfessor());
            faculties.add(faculty);
            profController.assignPositionToProfessor("dean" + makeAbbreviation(faculty.getName()));
            printCreationText(faculty);
        }
    }

    @Override
    public void printCreationText(Faculty faculty) {
        System.out.printf("Faculty of " + faculty.getName() + " is created. ");
        printHeadInfo(faculty);
    }

    @Override
    public void printHeadInfo(Faculty faculty) {
        System.out.println("Dean: " + faculty.getHead().getFullName() + ".");
    }

    public String[] getAbbreviations() {
        String[] abbs = new String[faculties.size()];
        for (int i = 0; i < faculties.size(); i++) {
            abbs[i] = makeAbbreviation(faculties.get(i).getName());
        }
        return abbs;
    }

    public void linkDepartments() {
        for (Faculty faculty : faculties) {
            String facultyAbbreviation = makeAbbreviation(faculty.getName());
            faculty.setDepartments(departmentController.getDepartmentsOfFaculty(facultyAbbreviation));
        }
    }

    public Faculty[] getFaculties() {
        return faculties.toArray(Faculty[]::new);
    }
}

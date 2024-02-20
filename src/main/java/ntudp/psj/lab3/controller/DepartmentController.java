package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.AbbreviationsMaker;
import ntudp.psj.lab3.Printer;
import ntudp.psj.lab3.model.Department;

import java.util.ArrayList;

public class DepartmentController implements
        Printer<Department>,
        AbbreviationsMaker {
    private ProfessorController professorController;
    private ArrayList<Department> departments = new ArrayList<>();
    private final String[] DEPARTMENT_NAMES = new String[]{
            "Software Engineering", "System Analysis",
            "Foreign Languages", "Applied Economics"};

    public DepartmentController(ProfessorController professorController, int departmentsAmount) {
        this.professorController = professorController;
        int departmentsMax = Math.min(departmentsAmount, DEPARTMENT_NAMES.length);
        createDepartments(departmentsMax);
    }

    private void createDepartments(int n) {
        for (int i = 0; i < n; i++) {
            Department department = new Department(DEPARTMENT_NAMES[i], professorController.getVacantProfessor());
            departments.add(department);
            professorController.assignPositionToProfessor("head" + makeAbbreviation(department.getName()));
            printCreationText(department);
        }
    }

    public String[] getAbbreviations() {
        String[] abbs = new String[departments.size()];
        for (int i = 0; i < departments.size(); i++) {
            abbs[i] = makeAbbreviation(departments.get(i).getName());
        }
        return abbs;
    }

    @Override
    public void printCreationText(Department department) {
        System.out.printf("Department of " + department.getName() + " is created. ");
        printHeadInfo(department);
    }

    @Override
    public void printHeadInfo(Department department) {
        System.out.println("Head: " + department.getHead().getFullName() + ".");
    }
}

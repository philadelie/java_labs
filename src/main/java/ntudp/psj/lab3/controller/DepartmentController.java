package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.Printable;
import ntudp.psj.lab3.model.Department;

import java.util.ArrayList;

public class DepartmentController implements Printable<Department> {
    private ProfessorController professorController;
    private ArrayList<Department> departments = new ArrayList<Department>();
    private final String[] DEPARTMENT_NAMES = new String[]{"Software Engineering", "System Analysis",
            "Foreign Languages", "Applied Economics"};

    public DepartmentController(ProfessorController professorController, int departmentsNumber) {
        this.professorController = professorController;
        createDepartments(departmentsNumber);
    }

    private void createDepartments(int n) {
        for (int i = 0; i < n && i < DEPARTMENT_NAMES.length; i++) {
            Department department = new Department(DEPARTMENT_NAMES[i], professorController.getVacantProfessor());
            departments.add(department);
            professorController.assignPositionToProfessor("head" + getDepartmentAbbreviation(i));
            printCreationText(department);
        }
    }

    public String[] getDepartmentsAbbreviation() {
        String[] tmp = new String[departments.size()];
        for (int i = 0; i < departments.size(); i++) {
            tmp[i] = getDepartmentAbbreviation(i);
        }
        return tmp;
    }

    private String getDepartmentAbbreviation(int idx) {
        String abb = "";
        String[] words = DEPARTMENT_NAMES[idx].split(" ");
        for (String word : words) abb += word.charAt(0);
        return abb;
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

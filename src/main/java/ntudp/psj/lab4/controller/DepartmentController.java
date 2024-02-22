package ntudp.psj.lab4.controller;

import ntudp.psj.lab4.model.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepartmentController implements Printer<Department>, AbbreviationsMaker {
    private final String[] DEPARTMENT_NAMES = new String[]{
            "Software Engineering", "System Analysis",
            "Foreign Languages", "Applied Economics"};
    private final Map<String, ArrayList<Department>> departments = new HashMap<>();
    private final ProfessorController profController;
    private final GroupController groupController;

    public DepartmentController(ProfessorController pC, Map<String, Integer> uniUnitsAmount, String[] faculties) {
        this.profController = pC;
        createDepartments(faculties, uniUnitsAmount.get("departments"));
        this.groupController = new GroupController(uniUnitsAmount, getAbbreviations());
        linkGroups();
    }

    private void createDepartments(String[] faculties, int n) {
        int j = 0;
        for (String faculty : faculties) {
            departments.put(faculty, new ArrayList<>());
            for (int i = 0; i < n; i++) {
                Department department = new Department(DEPARTMENT_NAMES[j++], profController.getVacantProfessor());
                departments.get(faculty).add(department);
                profController.assignPositionToProfessor("head" + makeAbbreviation(department.getName()));
                printCreationText(department);
            }
        }
    }

    public String[] getAbbreviations() {
        ArrayList<String> abbs = new ArrayList<>();
        for (String faculty : departments.keySet()) {
            ArrayList<Department> deps = departments.get(faculty);
            for (Department dep : deps) {
                String abb = makeAbbreviation(dep.getName());
                abbs.add(abb);
            }
        }
        return abbs.toArray(String[]::new);
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

    public void linkGroups() {
        for (String faculty : departments.keySet()) {
            for (Department department : departments.get(faculty)) {
                String departmentAbbreviation = makeAbbreviation(department.getName());
                department.setGroups(groupController.getGroupsOfDepartment(departmentAbbreviation));
            }
        }
    }

    public Department[] getDepartmentsOfFaculty(String faculty) {
        return departments.get(faculty).toArray(Department[]::new);
    }
}

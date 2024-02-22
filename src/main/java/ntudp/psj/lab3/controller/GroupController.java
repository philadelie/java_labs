package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupController implements Printer<Group> {
    private final Map<String, ArrayList<Group>> groups = new HashMap<>();
    private final StudentController studentController;

    public GroupController(Map<String, Integer> uniUnitsAmount, String[] departments) {
        studentController = new StudentController();
        createGroups(departments, uniUnitsAmount.get("groups"), uniUnitsAmount.get("students"));
    }

    private void createGroups(String[] departments, int groupsInADepartment, int studentsInAGroup) {
        for (String department : departments) {
            groups.put(department, new ArrayList<>());
            for (int i = 0; i < groupsInADepartment; i++) {
                Group group = new Group(department + "-" + (i + 1));
                groups.get(department).add(group);
                populateGroup(group, studentsInAGroup);
                assignGroupHead(group);
                printCreationText(group);
            }
        }
    }

    private void populateGroup(Group group, int studentsAmount) {
        studentController.createStudentGroup(group.getName(), studentsAmount);
        group.setStudents(studentController.getSomeGroup(group.getName()));
    }

    public void assignGroupHead(Group group) {
        studentController.chooseGroupHead(group.getName());
        group.setHead(studentController.getGroupHead(group.getName()));
    }

    @Override
    public void printCreationText(Group group) {
        System.out.println("- - - - -");
        System.out.println("Group \"" + group.getName() + "\" is created.");
        studentController.printStudentsInfo(group.getName());
        printHeadInfo(group);
    }

    @Override
    public void printHeadInfo(Group group) {
        System.out.println("Head: " + group.getHead().getFullName() + ".");
    }

    public Group[] getGroupsOfDepartment(String department) {
        return groups.get(department).toArray(Group[]::new);
    }
}

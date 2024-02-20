package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.Printable;
import ntudp.psj.lab3.model.Group;

import java.util.ArrayList;

public class GroupController implements Printable<Group> {
    private StudentController studentController;
    private ArrayList<Group> groups = new ArrayList<Group>();

    public GroupController(StudentController studentController, String[] departmentsAbbreviations, int studentsAmountInGroup) {
        this.studentController = studentController;
        createGroups(departmentsAbbreviations, studentsAmountInGroup);
    }

    private void createGroups(String[] departments, int studentsAmount) {
        for (String department : departments) {
            for (int i = 0; i < studentsAmount; i++) {
                String groupName = department + "-" + (i + 1);
                Group group = new Group(groupName);
                groups.add(group);
                populateGroup(group, studentsAmount);
                printCreationText(group);
            }
        }
    }

    private void populateGroup(Group group, int studentsAmount) {
        String groupName = group.getName();
        studentController.createStudentGroup(groupName, studentsAmount);
        group.setStudents(studentController.getTheGroupOfStudents(groupName));
        studentController.chooseGroupHead(groupName);
        group.setHead(studentController.getGroupHead(groupName));
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
}

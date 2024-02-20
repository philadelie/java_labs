package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.Printer;
import ntudp.psj.lab3.model.Faculty;
import ntudp.psj.lab3.model.Group;

import java.util.ArrayList;

public class GroupController implements Printer<Group> {
    private StudentController studentController;
    private ArrayList<Group> groups = new ArrayList<>();

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
                assignGroupHead(group);
                printCreationText(group);
            }
        }
    }

    private void populateGroup(Group group, int studentsAmount) {
        studentController.createStudentGroup(group.getName(), studentsAmount);
        group.setStudents(studentController.getTheGroupOfStudents(group.getName()));
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

    public Group[] getGroups() {
        return groups.toArray(Group[]::new);
    }
}

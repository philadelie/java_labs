package ntudp.psj.lab4.model;

public class Student extends Human {
    private boolean head;
    private String group;

    public Student(String firstName, String lastName, String patronymic, Sex sex) {
        super(firstName, lastName, patronymic, sex);
        this.head = false;
    }

    public boolean isHead() {
        return head;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}

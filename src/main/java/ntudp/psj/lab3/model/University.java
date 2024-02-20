package ntudp.psj.lab3.model;

public class University {
    String name;
    Human head;
    Faculty[] faculties;

    public University(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }
}

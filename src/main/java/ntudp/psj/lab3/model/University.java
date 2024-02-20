package ntudp.psj.lab3.model;

public class University {
    String name;
    Human head;

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
}

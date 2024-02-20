package ntudp.psj.lab3.model;

public class Faculty {
    String name;
    Human head;

    public Faculty(String name, Human head) {
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

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

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }
}

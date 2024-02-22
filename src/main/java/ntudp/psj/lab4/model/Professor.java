package ntudp.psj.lab4.model;

public class Professor extends Human {
    String position;

    public Professor(String firstName, String lastName, String patronymic, Sex sex){
        super(firstName, lastName, patronymic, sex);
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

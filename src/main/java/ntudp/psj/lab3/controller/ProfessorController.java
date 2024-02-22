package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Sex;
import ntudp.psj.lab3.model.Professor;

import java.util.*;

public class ProfessorController {
    private ArrayList<Professor> vacantProfessors = new ArrayList<>();
    private Map<String, Professor> assignedProfessors = new HashMap<>();

    public ProfessorController( ) {
        createBasicProfessorsCollection();
    }

    private void createBasicProfessorsCollection() {
        Professor rector = new Professor("Oleksandr", "Azyukovsky", "Oleksandrovych", Sex.male);
        Professor deanIT = new Professor("Iryna", "Udovik", "Myhailivna", Sex.female);
        Professor deanM = new Professor("Olena", "Tryfonova", "Vasylivna", Sex.female);
        Professor headSE = new Professor("Myhailo", "Aleksieiev", "Oleksandrovych", Sex.male);
        Professor headSA = new Professor("Timur", "Zheldak", "Anatoliyovych", Sex.male);
        Professor headFL = new Professor("Svitlana", "Kostrytska", "Ivanivha", Sex.female);
        Professor headAE = new Professor("Oleksandra", "Vagonova", "Grygoriyvna", Sex.female);

        Collections.addAll(vacantProfessors,rector, deanIT, deanM, headSE, headSA, headFL, headAE);
    }

    public void assignPositionToProfessor(String position) {
        vacantProfessors.getFirst().setPosition(position);
        assignedProfessors.put(position, vacantProfessors.getFirst());
        vacantProfessors.removeFirst();
    }

    public Professor getVacantProfessor() {
        return vacantProfessors.getFirst();
    }
}

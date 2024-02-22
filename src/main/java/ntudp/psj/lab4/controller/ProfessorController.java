package ntudp.psj.lab4.controller;

import ntudp.psj.lab4.model.Professor;
import ntudp.psj.lab4.model.Sex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

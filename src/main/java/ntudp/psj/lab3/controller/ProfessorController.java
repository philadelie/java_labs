package ntudp.psj.lab3.controller;

import ntudp.psj.lab3.model.Sex;
import ntudp.psj.lab3.model.Professor;

import java.util.ArrayList;
import java.util.Collections;

public class ProfessorController {
    private ArrayList<Professor> professors = new ArrayList<Professor>();

    public ProfessorController( ) {
        Professor rector = new Professor("Oleksandr", "Azyukovsky", "Oleksandrovych", Sex.male);
        Professor deanIT = new Professor("Iryna", "Udovik", "Myhailivna", Sex.female);
        Professor deanM = new Professor("Olena", "Tryfonova", "Vasylivna", Sex.female);
        Professor headSE = new Professor("Myhailo", "Aleksieiev", "Oleksandrovych", Sex.male);
        Professor headSA = new Professor("Timur", "Zheldak", "Anatoliyovych", Sex.male);
        Professor headFL = new Professor("Svitlana", "Kostrytska", "Ivanivha", Sex.female);
        Professor headAE = new Professor("Oleksandra", "Vagonova", "Grygoriyvna", Sex.female);

        Collections.addAll(professors,rector, deanIT, deanM, headSE, headSA, headFL, headAE);
    }

    public void assignPositionToProfessor(int idx, String position) {
        professors.get(idx).setPosition(position);
    }

    public Professor getProfessor(int idx) {
        return professors.get(idx);
    }
}

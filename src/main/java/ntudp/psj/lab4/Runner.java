package ntudp.psj.lab4;

import ntudp.psj.lab4.controller.UniversityController;

import java.util.Map;

public class Runner {
    private static UniversityController uniController;
    private static final Map<String, Integer> UNI_UNITS_AMOUNT = Map.of(
        "faculties", 2,
        "departments", 2,
        "groups", 2,
        "students", 2);

    public static void main(String[] args) {
        createTypicalUniversity();
    }

    private static void createTypicalUniversity() {
        uniController = new UniversityController(UNI_UNITS_AMOUNT);
    }
}

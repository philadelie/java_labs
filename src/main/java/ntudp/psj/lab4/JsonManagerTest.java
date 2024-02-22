package ntudp.psj.lab4;

import ntudp.psj.lab4.controller.UniversityController;
import ntudp.psj.lab4.model.University;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonManagerTest {
    private final Map<String, Integer> UNI_UNITS_AMOUNT = Map.of(
            "faculties", 2,
            "departments", 2,
            "groups", 2,
            "students", 2);

    @Test
    void compareActualWithRestored() {
        // creating some object - university
        UniversityController uniController = new UniversityController(UNI_UNITS_AMOUNT);
        University oldUniversity = uniController.getUniversity();

        // writing object to json file and reading it back
        JsonManager jm = new JsonManager();
        jm.storeObjInJsonFile(oldUniversity);
        University newUniversity = jm.restoreObjFromJsonFile();

        // comparing created and restored objects
        newUniversity.equals(oldUniversity);
    }
}

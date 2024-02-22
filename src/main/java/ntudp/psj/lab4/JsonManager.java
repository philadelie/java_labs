package ntudp.psj.lab4;

import com.google.gson.Gson;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class JsonManager {
    private static Gson gson;

    public JsonManager() {
        gson = new Gson();
    }

    public void writeToJson(Object obj) {
        Logger logger = Logger.getLogger("ntudp.psj.lab4.JsonManager");
        logger.info(gson.toJson(obj));
    }

    public void recordIntoFile() {

    }

    public void readJsonFromFile() {

    }

    public void restoreFromJson() {

    }

    @Test
    @Disabled("Not implemented yet")
    void compareActualWithRestored() {
        //Assertions.assertEquals(oldUniversity, newUniversity);
        //oldUniversity.equals(newUniversity);
    }
}

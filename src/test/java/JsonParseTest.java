import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParseTest {
    private ClassLoader cl = JsonParseTest.class.getClassLoader();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonParsing() throws IOException {
        try (InputStream inputStream = cl.getResourceAsStream("project.json")) {
            EventModel modelEvent = objectMapper.readValue(inputStream, EventModel.class);

            assertEquals("Новый проект", modelEvent.getNameProject());
            assertEquals(232323, modelEvent.getCodeProject());
            assertEquals(1, modelEvent.getIdProject());
            assertEquals("RU", modelEvent.getLanguage());


            Map<String, Object> creator = modelEvent.getCreator();
            assertEquals(1, creator.size());
            List<String> testCreator = Arrays.asList("Алексей", "Алексеев");
            assertEquals(testCreator, creator.get("name"));


            Map<String, Object> administrator = modelEvent.getAdministrator();
            assertEquals(1, administrator.size());
            List<String> testAdministrator = Arrays.asList("Иван", "Иванов");
            assertEquals(testAdministrator, administrator.get("name"));
        }
    }
}

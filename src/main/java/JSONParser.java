import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONParser implements ResourceParser {

    private ObjectMapper mapper = new ObjectMapper();
    private String file = "item.json"; //default file
    Item item;

    /** LoadSJONMap just calls the jackson method which loads & maps the data */
    private void loadJSONMAP(String file) {
        try {
            item = mapper.readValue(new File(PATH + file),
                    Item.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     The loading procedures - Load data then Process it for cleaning (remove nulls & lowercase)
     Load(File) = main loading procedure
     Load() = if default file is used (calls load(file) internally)

     @param file - file to write to
     */
    @Override
    public List load(String file) {
        loadJSONMAP(file);
        try {
            return Arrays.asList(
                    mapper.convertValue(
                            mapper.readTree(String.valueOf(item)).get("values"),
                            String[].class
                    ));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    @Override
    public List load() throws FileNotFoundException { return null; }
    @Override
    public void clean() { }
    @Override
    public List selectAllEntries() { return null; }
    @Override
    public List selectSpecificEntry(String searchCriteria) { return null; }
    @Override
    public void insertNewEntries(String file) { }
    @Override
    public void insertNewEntries() throws IOException { }
    @Override
    public void updateEntries(String file) { }
    @Override
    public void updateEntries() throws IOException { }
}
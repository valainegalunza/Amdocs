package com.valainegalunza.amdocs.data;

import com.valainegalunza.amdocs.entities.Amdocs;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author valainegalunza
 */
@Repository
public class AmdocsRepository implements AmdocsDao {

    private List<Amdocs> amdocsList = new ArrayList<>();
    public String ITEM_FILE = "";
    public static final String DELIMITER = "|";

    @Override
    public void addAmdocs(Amdocs amdocs) throws AmdocsPersistenceException {
        amdocsList.add(amdocs);
        ITEM_FILE = createFile(amdocs);
        saveItems(amdocs);
    }

    @Override
    public void saveItems(Amdocs currentInfo) {
        try {
            writeItem(currentInfo);
        } catch (AmdocsPersistenceException ex) {
            Logger.getLogger(AmdocsPersistenceException.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //marshallAmdocs
    private String marshallAmdocs(Amdocs aInfo) {

        //Id
        String amdocsAsText = aInfo.getId() + DELIMITER;

        // Number
        amdocsAsText += aInfo.getNumber() + DELIMITER;

        // Comment
        amdocsAsText += aInfo.getComment() + DELIMITER;

        // StartDate
        amdocsAsText += aInfo.getStartDate().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + DELIMITER;

        // EndDate
        amdocsAsText += aInfo.getEndDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        return amdocsAsText;
    }

    //writeItems
    private void writeItem(Amdocs current) throws AmdocsPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ITEM_FILE));
        } catch (IOException e) {
            throw new AmdocsPersistenceException(
                    "Could not save amdocs data.", e);
        }

        String amdocsAsText;
        // turn a Amdocs into a String
        amdocsAsText = marshallAmdocs(current);
        // write the Amdocs object to the file
        out.println(amdocsAsText);
        // force PrintWriter to write line to the file
        out.flush();
        // Clean up
        out.close();
    }

    public String createFile(Amdocs amdoc) {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));

        String result = String.format("new_file_%d_%d_%s.txt", amdoc.getId(), amdoc.getNumber(), timestamp);

        return result;

    }

}

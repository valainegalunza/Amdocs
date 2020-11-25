package com.valainegalunza.amdocs.service;

import com.valainegalunza.amdocs.data.AmdocsPersistenceException;
import com.valainegalunza.amdocs.data.AmdocsRepository;
import com.valainegalunza.amdocs.entities.Amdocs;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 *
 * @author valainegalunza
 */
@Service
public class LookupService {

    private final AmdocsRepository amdocsRepo;

    public LookupService(AmdocsRepository amdocsRepo) {
        this.amdocsRepo = amdocsRepo;
    }

    //Add Method
    public void saveAmdocs(Amdocs amdocs) throws AmdocsPersistenceException{
         amdocsRepo.addAmdocs(amdocs);
    }
    
    
    //Validation
    public BindingResult validateAmdocs(Amdocs amdocs, BindingResult result, HttpServletRequest request) {

        if (amdocs.getId() == null) {
            FieldError error = new FieldError("amdocs", "id", "ID is required.");
            result.addError(error);
        } else {
            int id = amdocs.getId();
            amdocs.setId(id);
        }

        if (amdocs.getNumber() == null) {
            FieldError error = new FieldError("amdocs", "number", "Number is required.");
            result.addError(error);
        } else {
            int number = amdocs.getNumber();
            amdocs.setNumber(number);
        }

        if (amdocs.getComment().equals("")) {
            FieldError error = new FieldError("amdocs", "comment", "Comment is required.");
            result.addError(error);
        } else {
            String comments = amdocs.getComment();
            amdocs.setComment(comments);
        }

        if (amdocs.getStartDate() == null) {
            FieldError error = new FieldError("amdocs", "startDate", "Start Date is required.");
            result.addError(error);
        } else {
            LocalDate startDate = amdocs.getStartDate();
            amdocs.setStartDate(startDate);
        }

        if (amdocs.getEndDate() == null) {
            FieldError error = new FieldError("amdocs", "endDate", "End Date is required.");
            result.addError(error);
        } else {
            LocalDate endDate = amdocs.getEndDate();
            amdocs.setEndDate(endDate);
        }

        return result;
    }
}

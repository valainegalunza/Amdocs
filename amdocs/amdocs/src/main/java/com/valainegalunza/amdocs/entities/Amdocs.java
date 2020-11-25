package com.valainegalunza.amdocs.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author valainegalunza
 */

@Entity
@Data
public class Amdocs {

    @NotBlank(message = "Identifier is Required.")
    @Size(max = 7, message = "Limit to 7 characters.")
    @Id
    private Integer id;

    @NotBlank(message = "Number is Required.")
    @Size(max = 10, message = "Limit to 10 characters.")
    private Integer number;

    @NotBlank(message = "Comment is Required.")
    @Size(max = 42, message = "Limit to 42 characters.")
    private String comment;

    @NotBlank(message = "Start Date is Required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank(message = "End Date is Required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    
}

package com.valainegalunza.amdocs.controller;

import com.valainegalunza.amdocs.data.AmdocsPersistenceException;
import com.valainegalunza.amdocs.entities.Amdocs;
import com.valainegalunza.amdocs.service.LookupService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author valainegalunza
 */
@Controller
public class MainController {

    @Autowired
    LookupService service;

    @GetMapping("/home")
    public String addInfo(Amdocs amdocs) {

        return "home";

    }

    @PostMapping("/home")
    public String addAmdocsInfo(@Valid Amdocs amdocs, BindingResult result, HttpServletRequest request) throws AmdocsPersistenceException {

        result = service.validateAmdocs(amdocs, result, request);

        if (result.hasErrors()) {
            return "home";
        } else {
            service.saveAmdocs(amdocs);   
        }
        return "redirect:/home";

    }

}

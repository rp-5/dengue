package com.datamart.dengueservice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datamart.entity.Humano;
import com.datamart.service.HumanoService;

@Controller
public class HumanoController {
    
    @Autowired
    private HumanoService humanoService;

    @GetMapping("/form/registro-humano")
    public ModelAndView getList(){
        ModelAndView mv = new ModelAndView("registroHumano");
        return mv;
    }

    @PostMapping("/form/save")
    public String saveForm(@Valid Humano humano, BindingResult result, RedirectAttributes redirect){
        this.humanoService.save(humano);
        return "redirect:/index";
    }

}

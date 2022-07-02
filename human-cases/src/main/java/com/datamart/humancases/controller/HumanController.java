package com.datamart.humancases.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datamart.humancases.entity.Human;
import com.datamart.humancases.service.HumanService;

@Controller
public class HumanController {
    @Autowired
    private HumanService humanService;

    @GetMapping("/form/human-register")
    public ModelAndView getList() {
        ModelAndView mv = new ModelAndView("humanRegister");
        return mv;
    }

    @PostMapping("/form/save")
    public String saveForm(@Valid Human human, BindingResult result, RedirectAttributes redirect) {
        this.humanService.save(human);
        return "redirect:/registered";
    }
}
package com.datamart.humancases.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.datamart.humancases.entity.Gravity;
import com.datamart.humancases.entity.Human;
import com.datamart.humancases.entity.Status;
import com.datamart.humancases.entity.Symptom;
import com.datamart.humancases.service.GravityService;
import com.datamart.humancases.service.HumanService;
import com.datamart.humancases.service.StatusService;
import com.datamart.humancases.service.SymptomService;

@Controller
public class HumanController {
    @Autowired
    private HumanService humanService;

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private GravityService gravityService;

    @GetMapping("/form/human-register")
    public ModelAndView getRegister() {
        ModelAndView mv = new ModelAndView("humanRegister");
        List<Symptom> symptomList = this.symptomService.getSymptomList();
        mv.addObject("symptomList", symptomList);

        List<Status> statusList = this.statusService.getStatusList();
        mv.addObject("statusList", statusList);

        List<Gravity> gravityList = this.gravityService.getGravityList();
        mv.addObject("gravityList", gravityList);
        return mv;
    }

    @PostMapping("/form/save")
    public String saveForm(@Valid Human human, BindingResult result, RedirectAttributes redirect) {
        this.humanService.save(human);
        return "redirect:/registered";
    }

    @GetMapping("/list/human")
    public ModelAndView getList(){
        List<Human> humanList = this.humanService.findAll();
        ModelAndView mv = new ModelAndView("humanList");
        mv.addObject("humanList", humanList);
        return mv;
    }

    @GetMapping("/edit/human/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("humanEdit");
        List<Human> humanList = this.humanService.findAll();
        mv.addObject("humanList", humanList);

        Human human = this.humanService.findById(id);
        mv.addObject("human", human);

        List<Symptom> symptomList = this.symptomService.getSymptomList();
        mv.addObject("symptomList", symptomList);

        List<Status> statusList = this.statusService.getStatusList();
        mv.addObject("statusList", statusList);

        List<Gravity> gravityList = this.gravityService.getGravityList();
        mv.addObject("gravityList", gravityList);
        return mv;
    }

    @GetMapping("/delete/human/{id}")
    public String delete(@PathVariable("id")Long id){
        this.humanService.delete(id);
        return "redirect:/list/human";
    }
}
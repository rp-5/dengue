package com.datamart.regioncases.controller;

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

import com.datamart.regioncases.entity.Region;
import com.datamart.regioncases.service.RegionService;

@Controller
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("/form/region-register")
    public ModelAndView getRegister() {
        ModelAndView mv = new ModelAndView("regionRegister");
        return mv;
    }

    @PostMapping("/form/save")
    public String saveForm(@Valid Region region, BindingResult result, RedirectAttributes redirect) {

        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
            return "redirect:/form/region-register";
        }

        this.regionService.save(region);
        return "redirect:/list/region";
    }

    @PostMapping("/edit/save")
    public String saveEdit(@Valid Region region, BindingResult result, RedirectAttributes redirect){

        this.regionService.save(region);
        return "redirect:/list/region";
    }

    @GetMapping("/list/region")
    public ModelAndView getList(){
        List<Region> regionList = this.regionService.findAll();
        ModelAndView mv = new ModelAndView("regionList");
        mv.addObject("regionList", regionList);
        return mv;
    }

    @PostMapping("/edit/region/{id}")
    public ModelAndView getEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("regionEdit");
        List<Region> regionList = this.regionService.findAll();
        mv.addObject("regionList", regionList);

        Region region = this.regionService.findById(id);
        mv.addObject("region", region);

        return mv;
    }

    @PostMapping("/delete/region/{id}")
    public String delete(@PathVariable("id")Long id){
        this.regionService.delete(id);
        return "redirect:/list/region";
    }
}
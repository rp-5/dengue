package com.datamart.humancases.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    // @PostMapping("/form/save")
    // public String saveForm(@Valid Human human, BindingResult result, RedirectAttributes redirect) {

    //     if(result.hasErrors()){
    //         redirect.addFlashAttribute("mensagem", "Verifique os campos obrigatórios");
    //         return "redirect:/form/human-register";
    //     }

    //     this.humanService.save(human);
    //     return "redirect:/list/human";
    // }

    @RequestMapping(value = "/form/save", method =  RequestMethod.POST)
    public ResponseEntity<String> Post(@Valid @RequestBody Human human)
    {
        try{
        this.humanService.save(human);
        return new ResponseEntity<String>("Cadastrado com sucesso", HttpStatus.OK);
        }catch(Error e){
        return new ResponseEntity<String>("Erro ao salvar", HttpStatus.BAD_REQUEST);
        }
        
    }

    @PostMapping("/edit/save")
    public String saveEdit(@Valid Human human, BindingResult result, RedirectAttributes redirect){

        this.humanService.save(human);
        return "redirect:/list/human";
    }

    // @GetMapping("/list/human")
    // public ModelAndView getList(){
    //     List<Human> humanList = this.humanService.findAll();
    //     ModelAndView mv = new ModelAndView("humanList");
    //     mv.addObject("humanList", humanList);
    //     return mv;
    // }

    @RequestMapping(value = "/list/human", method = RequestMethod.GET)
    public ResponseEntity<List<Human>> Get() {
        return new ResponseEntity<List<Human>>(humanService.findAll(), HttpStatus.OK);
    }

    // @PostMapping("/edit/human/{id}")
    // public ModelAndView getEdit(@PathVariable("id") Long id){
    //     ModelAndView mv = new ModelAndView("humanEdit");
    //     return mv;
    // }

    @PutMapping(value = "/edit/human/{id}")
    public ResponseEntity<String> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Human oldHuman)
    {
        try{
        humanService.save(oldHuman);
        return new ResponseEntity<String>("Editado com sucesso", HttpStatus.OK);
        }catch(Error e){
        return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.BAD_REQUEST); 
        }
        // try{
        // this.humanService.edit(id, oldHuman);
        // return new ResponseEntity<String>("Editado com sucesso", HttpStatus.OK);
        // }catch(Error e){
        // return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.BAD_REQUEST);
        // }
    }

    // @PostMapping("/delete/human/{id}")
    // public String delete(@PathVariable("id")Long id){
    //     this.humanService.delete(id);
    //     return "redirect:/list/human";
    // }

    @DeleteMapping(value = "/delete/human/{id}")
    public ResponseEntity<Object> Delete(@PathVariable("id")Long id)
    {
        try{
        this.humanService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
        }catch(Error e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
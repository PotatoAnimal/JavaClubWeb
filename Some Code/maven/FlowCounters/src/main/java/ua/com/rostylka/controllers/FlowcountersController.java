package ua.com.rostylka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.rostylka.dao.FlowCounterDao;
import ua.com.rostylka.models.Condition;
import ua.com.rostylka.models.FlowCounter;
import ua.com.rostylka.models.NatGasCharacter;
import ua.com.rostylka.utilities.ConditionCalculator;

@Controller
@RequestMapping("/flowcounters")
public class FlowcountersController {
    @Autowired
    FlowCounterDao flowCounterDao;
    @Autowired
    Condition condition;
    @Autowired
    NatGasCharacter natGasCharacter;

    
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("flowcounters", flowCounterDao.readAll());
        return "flowcounters/list";
    }
    
    @GetMapping("/{id}")
    public String calc(@PathVariable("id") int id, Model model) {
        model.addAttribute("flowcounter", flowCounterDao.readByID(id));
        return "flowcounters/calc";
    }

    @GetMapping("/new")
    public String newFlowCounter(@ModelAttribute("flowcounter") FlowCounter flowcounter){
        return "flowcounters/new";
    }

    @PostMapping("/{id}/calc")
    public String calculate(@PathVariable("id") int id, @ModelAttribute("flowcounter") FlowCounter flowcounter,
                            @ModelAttribute("condition") Condition condition,
                            @ModelAttribute("ngchar") NatGasCharacter natGasCharacter, Model model){
        model.addAttribute("zmin", ConditionCalculator.gerg91Mod(condition.getpMax(), condition.gettMin(), natGasCharacter));
        model.addAttribute("zmax", ConditionCalculator.gerg91Mod(condition.getpMin(), condition.gettMax(), natGasCharacter));
        model.addAttribute("qminst", ConditionCalculator.qMinCount(flowcounter, condition, natGasCharacter));
        model.addAttribute("qmaxst", ConditionCalculator.qMaxCount(flowcounter, condition, natGasCharacter));
        return "redirect: flowcounters/calcresult";
    }


}
;
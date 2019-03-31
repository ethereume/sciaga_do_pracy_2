package com.clockworkjava.kursspring.controllers;
import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.services.KnightService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/knight/v1")
public class KnightController {


    private KnightService service;
    private PlayerInformation information;

    public KnightController(KnightService service, PlayerInformation information) {
        this.service = service;
        this.information = information;
    }

    @GetMapping("/knights")
    public String getKnights(Model model) {
        return getStringForDuplicated(model);
    }

    @PostMapping("/knights")
    public String addKnight(Knight knight) {
        System.out.println(knight);
        System.out.println(service.getAllKnights());
        this.service.addKnight(knight);
        return "redirect:knights";
    }
    @GetMapping("/knights/details/{name}")
    public String showDetaild(@PathVariable String name,Model model) {
        List<Knight> allKnights = service.getAllKnights();
        Knight k = service.getKnightByName(name);
        model.addAttribute("knight",k);
        model.addAttribute("knights", allKnights);
        return "knights";
    }
    @GetMapping("/knights/remove/{name}")
    public String remove(@PathVariable String name,Model model) {
        service.removeKight(name);
        return getStringForDuplicated(model);
    }

    private String getStringForDuplicated(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        Knight k = service.getKnightByName("Lancelot");
        model.addAttribute("knight",k);
        model.addAttribute("knights", allKnights);
        model.addAttribute("gold",information.getGoldAmount());
        return "knights";
    }
}

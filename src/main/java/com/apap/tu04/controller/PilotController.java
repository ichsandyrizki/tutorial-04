package com.apap.tu04.controller;

import com.apap.tu04.model.FlightModel;
import com.apap.tu04.model.PilotModel;
import com.apap.tu04.service.FlightService;
import com.apap.tu04.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @Autowired
    private FlightService flightService;

    @RequestMapping("/")
    private String home(Model model){
        List<PilotModel> pilotList = pilotService.findAllPilot();
        model.addAttribute("pilotList", pilotList);

        List<FlightModel> flightList = flightService.flightList();
        model.addAttribute("flightList", flightList);
        return "home";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model){
        model.addAttribute("pilot", new PilotModel());
        return "addPilot";
    }
    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model){
        pilotService.addPilot(pilot);
        model.addAttribute("message", "Pilot Berhasil Ditambahkan!");
        return "successPage";
    }
    @RequestMapping("/pilot/view")
    private String view(@RequestParam(value = "licenseNumber") String licenseNumber, Model model){
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);

        if(pilot != null){
            List<FlightModel> flightList = flightService.findAllFlightByPilotLicenseNumber(licenseNumber);
            model.addAttribute("flightList", flightList);
            model.addAttribute("pilot", pilot);
            return "viewPilot";
        }else{
            model.addAttribute("message", "License number tidak ditemukan");
            return "errorPage";
        }
    }
    @RequestMapping(value = "/pilot/delete/{id}", method= RequestMethod.GET)
    private String delete(@PathVariable(value = "id") Long id, Model model){
        pilotService.removePilot(id);
        model.addAttribute("message", "Pilot berhasil Dihapus!");
        return "successPage";
    }
    @RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
    private String update(@PathVariable(value = "licenseNumber") String licenseNumber, Model model){
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        model.addAttribute("pilot",pilot);
        return "updatePilot";
    }
    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private String updateSubmit(@ModelAttribute PilotModel pilotModel, Model model){
        pilotService.updatePilot(pilotModel);
        return "redirect:/pilot/view?licenseNumber="+pilotModel.getLicenseNumber();
    }

}

package com.crud.test.crud.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.test.crud.course.models.AdminAdd;
import com.crud.test.crud.course.models.AdminAddDesserts;
import com.crud.test.crud.course.models.AdminAddDinner;
import com.crud.test.crud.course.models.AdminAddDrink;
import com.crud.test.crud.course.models.AdminAddGallery;
import com.crud.test.crud.course.models.AdminAddLunch;
import com.crud.test.crud.course.services.AdminsAddDessertsRepository;
import com.crud.test.crud.course.services.AdminsAddDinnerRepository;
import com.crud.test.crud.course.services.AdminsAddDrinkRepository;
import com.crud.test.crud.course.services.AdminsAddGalleryRepository;
import com.crud.test.crud.course.services.AdminsAddLunchRepository;
import com.crud.test.crud.course.services.AdminsAddRepository;


@Controller
@RequestMapping("/customerviewmenu")
public class CustomerViewMenu {

    @Autowired
    private AdminsAddDinnerRepository repoDinner;

    @Autowired
    private AdminsAddRepository repoBreakfast;

    @Autowired
    private AdminsAddDessertsRepository repoDesserts;

    @Autowired
    private AdminsAddDrinkRepository repoDrink;

    @Autowired
    private AdminsAddGalleryRepository repoGallery;

    @Autowired
    private AdminsAddLunchRepository repoLunch;





    @GetMapping({"customerviewdinnermenu"})
    public String customerViewDinner(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDinner> adminadddinner = repoDinner.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddinner", adminadddinner);
        return "customerviewmenu/customerviewdinnermenu";
    }


    @GetMapping({"/customerviewbreakfastmenu"})
    public String customerViewBF(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAdd> adminadd = repoBreakfast.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadd", adminadd);
        return "customerviewmenu/customerviewbreakfastmenu";
    }


    @GetMapping({"customerviewdessertsmenu"})
    public String customerViewDesserts(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDesserts> adminadddesserts = repoDesserts.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddesserts", adminadddesserts);
        return "customerviewmenu/customerviewdessertsmenu";
    }


    @GetMapping({"customerviewdrinkmenu"})
    public String customerViewDrink(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDrink> adminadddrink = repoDrink.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddrink", adminadddrink);
        return "customerviewmenu/customerviewdrinkmenu";
    }


    @GetMapping({"customerviewgallery"})
    public String customerViewGallery(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddGallery> adminaddgallery = repoGallery.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminaddgallery", adminaddgallery);
        return "customerviewmenu/customerviewgallery";
    }


    @GetMapping({"customerviewlunchmenu"})
    public String customerViewLunch(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddLunch> adminaddlunch = repoLunch.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminaddlunch", adminaddlunch);
        return "customerviewmenu/customerviewlunchmenu";
    }
    
}

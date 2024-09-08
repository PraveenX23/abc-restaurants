package com.crud.test.crud.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.test.crud.course.models.AdminAdd;
import com.crud.test.crud.course.models.AdminAddDesserts;
import com.crud.test.crud.course.models.AdminAddDinner;
import com.crud.test.crud.course.models.AdminAddDrink;
import com.crud.test.crud.course.models.AdminAddLunch;
import com.crud.test.crud.course.models.CustomerOrderFood;
import com.crud.test.crud.course.models.CustomerOrderFoodDto;
import com.crud.test.crud.course.models.CustomerTableReservation;
import com.crud.test.crud.course.models.CustomerTableReservationDto;
import com.crud.test.crud.course.services.AdminsAddDessertsRepository;
import com.crud.test.crud.course.services.AdminsAddDinnerRepository;
import com.crud.test.crud.course.services.AdminsAddDrinkRepository;
import com.crud.test.crud.course.services.AdminsAddLunchRepository;
import com.crud.test.crud.course.services.AdminsAddRepository;
import com.crud.test.crud.course.services.CustomersOrderFoodRepository;
import com.crud.test.crud.course.services.CustomersTableReservationRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/staffdashboard")
public class StaffsDashboardController {

    @GetMapping("/staff")
    public String adminAddPage(){
        return "staffdashboard/staff";
    }

    @GetMapping("/googlemaps")
    public String adminGoogleMap(){
        return "staffdashboard/googlemaps";
    }




    @Autowired
    private AdminsAddRepository repoBreakfast;

    @Autowired
    private AdminsAddLunchRepository repoLunch;

    @Autowired
    private AdminsAddDessertsRepository repoDesserts;

    @Autowired
    private AdminsAddDinnerRepository repoDinner;

    @Autowired
    private AdminsAddDrinkRepository repoDrink;

    @Autowired
    private CustomersOrderFoodRepository repoViewOrder;

        @Autowired
    private CustomersTableReservationRepository repoStaffViewReservation;




    @GetMapping({"viewaddbreakfastmenu"})
    public String showAdminAddList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAdd> adminadd = repoBreakfast.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadd", adminadd);
        return "staffdashboard/viewaddbreakfastmenu";
    }

    
    @GetMapping({"viewaddfoodmenulunch"})
    public String showAdminAddLunchList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddLunch> adminaddlunch = repoLunch.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminaddlunch", adminaddlunch);
        return "staffdashboard/viewaddfoodmenulunch";
    }

     @GetMapping({"viewaddfoodmenudesserts"})
    public String showAdminAddDessertsList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDesserts> adminadddesserts = repoDesserts.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddesserts", adminadddesserts);
        return "staffdashboard/viewaddfoodmenudesserts";
    }

        @GetMapping({"viewaddfoodmenudinner"})
    public String showAdminAddDinnerList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDinner> adminadddinner = repoDinner.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddinner", adminadddinner);
        return "staffdashboard/viewaddfoodmenudinner";
    }

        @GetMapping({"viewaddfoodmenudrink"})
    public String showAdminAddDrinkList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<AdminAddDrink> adminadddrink = repoDrink.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("adminadddrink", adminadddrink);
        return "staffdashboard/viewaddfoodmenudrink";
    }
    

    @GetMapping({"staffvieworderfood"})
    public String showCustomersOrderFoodRepositoryList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<CustomerOrderFood> customerorderfood = repoViewOrder.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("customerorderfood", customerorderfood);
        return "staffdashboard/staffvieworderfood";
        
    }

    @GetMapping({"staffviewtablereservations"})
    public String showCustomersTableReservationRepositoryList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<CustomerTableReservation> customertablereservation = repoStaffViewReservation.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("customertablereservation", customertablereservation);
        return "staffdashboard/staffviewtablereservations";
    }


        // Staff update the order stauts
        @GetMapping("/staffeditorderfood")
        public String showEditPageAdmin(
            Model model,
            @RequestParam int id
        ) {
    
            try {
    
                CustomerOrderFood customerOrderFood = repoViewOrder.findById(id).get();
                model.addAttribute("customerOrderFood", customerOrderFood);
    
                CustomerOrderFoodDto customerOrderFoodDto = new CustomerOrderFoodDto();
                customerOrderFoodDto.setName(customerOrderFood.getName());
                customerOrderFoodDto.setType(customerOrderFood.getType());
                customerOrderFoodDto.setPlace(customerOrderFood.getPlace());
                customerOrderFoodDto.setPhone(customerOrderFood.getPhone());
                customerOrderFoodDto.setDescription(customerOrderFood.getDescription());
                customerOrderFoodDto.setTime(customerOrderFood.getTime());
                customerOrderFoodDto.setStatus(customerOrderFood.getStatus());
    
                model.addAttribute("customerOrderFoodDto", customerOrderFoodDto);
    
    
            } catch(Exception ex) {
                System.out.println("Exception : " + ex.getMessage());
                return "redirect:/staffdashboard";
            }
    
            return "staffdashboard/staffeditorderfood";
    
        }

    // Post request for update the product staff 
    @PostMapping("/staffeditorderfood")
    public String updateProductAdmin(
        Model model,
        @RequestParam int id,
        @Valid @ModelAttribute CustomerOrderFoodDto customerOrderFoodDto,
        BindingResult result
    ) {

        CustomerOrderFood customerOrderFood = repoViewOrder.findById(id).get();
        model.addAttribute("customerOrderFood", customerOrderFood);
        // Check do we have any errors or not
        if(result.hasErrors()) {
            return "staffdashboard/staffeditorderfood";
        }
        // Update the other details
        customerOrderFood.setName(customerOrderFoodDto.getName());
        customerOrderFood.setType(customerOrderFoodDto.getType());
        customerOrderFood.setPlace(customerOrderFoodDto.getPlace());
        customerOrderFood.setPhone(customerOrderFoodDto.getPhone());
        customerOrderFood.setDescription(customerOrderFoodDto.getDescription());
        customerOrderFood.setTime(customerOrderFoodDto.getTime());
        customerOrderFood.setStatus(customerOrderFoodDto.getStatus());
        repoViewOrder.save(customerOrderFood);


        return "redirect:/staffdashboard/staffvieworderfood";
    }

    @GetMapping("/staffDelete")
    public String adminDeleteProduct(@RequestParam int id) {

        try {
            CustomerOrderFood customerorderfood = repoViewOrder.findById(id).get();

            //Delete the product
            repoViewOrder.delete(customerorderfood);
            
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        return "redirect:/staffdashboard/staffvieworderfood";
    }




    // staff update the reservation stauts
        @GetMapping("/staffedittablereservations")
        public String showResEditPageStaff(
            Model model,
            @RequestParam int id
        ) {
    
            try {
    
                CustomerTableReservation customerTableReservation = repoStaffViewReservation.findById(id).get();
                model.addAttribute("customerTableReservation", customerTableReservation);
    
                CustomerTableReservationDto customerTableReservationDto = new CustomerTableReservationDto();
                customerTableReservationDto.setName(customerTableReservation.getName());
                customerTableReservationDto.setEmail(customerTableReservation.getEmail());
                customerTableReservationDto.setPhone(customerTableReservation.getPhone());
                customerTableReservationDto.setDate(customerTableReservation.getDate());
                customerTableReservationDto.setTime(customerTableReservation.getTime());
                customerTableReservation.setStatus(customerTableReservationDto.getStatus());
                customerTableReservationDto.setPerson(customerTableReservation.getPerson());
    
                model.addAttribute("customerTableReservationDto", customerTableReservationDto);
    
    
            } catch(Exception ex) {
                System.out.println("Exception : " + ex.getMessage());
                return "redirect:/staffdashboard";
            }
    
            return "staffdashboard/staffedittablereservations";
    
        }

    // Post request for update the product admin 
    @PostMapping("/staffedittablereservations")
    public String updateProductAdmin(
        Model model,
        @RequestParam int id,
        @Valid @ModelAttribute CustomerTableReservationDto customerTableReservationDto,
        BindingResult result
    ) {

        CustomerTableReservation customerTableReservation = repoStaffViewReservation.findById(id).get();
        model.addAttribute("customerTableReservation", customerTableReservation);
        // Check do we have any errors or not
        if(result.hasErrors()) {
            return "staffdashboard/staffedittablereservations";
        }
        // Update the other details
        customerTableReservation.setName(customerTableReservationDto.getName());
        customerTableReservation.setEmail(customerTableReservationDto.getEmail());
        customerTableReservation.setPhone(customerTableReservationDto.getPhone());
        customerTableReservation.setDate(customerTableReservationDto.getDate());
        customerTableReservation.setTime(customerTableReservationDto.getTime());
        customerTableReservation.setStatus(customerTableReservationDto.getStatus());
        customerTableReservation.setPerson(customerTableReservationDto.getPerson());
        repoStaffViewReservation.save(customerTableReservation);


        return "redirect:/staffdashboard/staffviewtablereservations";
    }


}

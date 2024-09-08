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

import com.crud.test.crud.course.models.CustomerMakePayment;
import com.crud.test.crud.course.models.CustomerMakePaymentDto;
import com.crud.test.crud.course.services.CustomersMakePaymentRepository;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/customerpayment")
public class CustomerMakePaymentController {

    @GetMapping("/viewcustomermakepayment")
    public String adminViewAddFoodMenuLunch(){
        return "customerpayment/viewcustomermakepayment";
    }

    @Autowired
    private CustomersMakePaymentRepository repo;

    @GetMapping({"", "/"})
    public String showaymentAddList(Model model){
                                               // This parameter makes desending order of adminadd 
        List<CustomerMakePayment> customerpayment = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("customerpayment", customerpayment);
        return "customerpayment/viewcustomermakepayment";
    }


    // Create new product
    @GetMapping("/customermakepayment")
    public String showMakePaymentPage(Model model){
        CustomerMakePaymentDto customerMakePaymentDto = new CustomerMakePaymentDto();
        model.addAttribute("customerMakePaymentDto", customerMakePaymentDto);
        // In the customerpayment folder there is a customerpayment called customermakepayment
        return "customerpayment/customermakepayment";
    }

@PostMapping("/customermakepayment")
public String customermakepayment(
    @Valid @ModelAttribute CustomerMakePaymentDto customerMakePaymentDto,
    BindingResult result) {


        CustomerMakePayment customerMakePayment = new CustomerMakePayment();
        customerMakePayment.setName(customerMakePaymentDto.getName());  // Fixing a typo here
        customerMakePayment.setCardnumber(customerMakePaymentDto.getCardnumber());
        customerMakePayment.setExpdate(customerMakePaymentDto.getExpdate());
        customerMakePayment.setCvc(customerMakePaymentDto.getCvc());

        // Save this data on the database
        repo.save(customerMakePayment);

    return "redirect:/customerpayment";
}
}
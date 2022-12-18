package Musteri.Sap.Controller;

import Musteri.Sap.exception.CustomerNotFoundException;
import Musteri.Sap.Model.Customer;
import Musteri.Sap.Model.User;
import Musteri.Sap.service.CustomerService;
import Musteri.Sap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService CustomerService;

    @Autowired
    private UserService userService;

    // Customer ları listeliyorum .
    @GetMapping("/Customers")
    public String showCustomerList(Model model){

        return "index";
    }

    // User ları listeye atıp yeni Customer formunda gösteriyorum .
    @GetMapping("/Customers/new")
    public String showCustomerNewForm(Model model){
        List<User> listUsers = userService.listAll();
        if (listUsers.isEmpty()){
            model.addAttribute("user",new User());
            model.addAttribute("pageTitle","There is no User so :You have to Add New User");
            return "user_form";
        }
        model.addAttribute("pageTitle","Create Customer");

        model.addAttribute("listUsers",listUsers);
        model.addAttribute("Customer",new Customer());
        return "Customer_form";
    }

    // Post metodu ile Customerı kayıt ediyorum. POST kullanma sebebim url de verilerin görünmemesi için
    @PostMapping("/Customers/save")
    public String saveCustomer(Customer Customer, RedirectAttributes ra){
        CustomerService.save(Customer);
        ra.addFlashAttribute("message","The Customer has been saved succesfuly");
        return "redirect:/ ";
    }

    // Customer Id si ile forma kayıtlı bilgileri gösteriyorum .
    @GetMapping("/Customers/edit/{id}")
    public String showEditFormCustomer(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Customer Customer = CustomerService.get(id);
            model.addAttribute("Customer",Customer);
            model.addAttribute("pageTitle","Edit Customer");
            List<User> listUsers = userService.listAll();
            model.addAttribute("listUsers",listUsers);

            return "Customer_form";
        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/ ";
        }
    }

    //     Customer Id si ile silme işlmei yapıyorum
    @GetMapping("/Customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id,RedirectAttributes ra) throws CustomerNotFoundException {
        try {
            CustomerService.delete(id);
            ra.addFlashAttribute("message","The Customer ID "+id+" has been deleted.");

        } catch (CustomerNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "index";
    }


}

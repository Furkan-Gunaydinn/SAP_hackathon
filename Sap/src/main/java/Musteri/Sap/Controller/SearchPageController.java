package Musteri.Sap.Controller;

import Musteri.Sap.Model.Customer;
import Musteri.Sap.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchPageController {

    @Autowired
    private CustomerService CustomerService;

    // Arama kelimesini alıyorum ve kontrol yapıyorum . Boş ise bütün Customer ları getiriyorum .Dolu ise alaklı verileri .
    @RequestMapping(path = {"/","/search"})
    public String search(Customer Customer, Model model, String keyword) {
        if(keyword!=null) {
            List<Customer> list = CustomerService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Customer> list = CustomerService.getAllCustomers();
            model.addAttribute("list", list);}
        return "index";
    }

}

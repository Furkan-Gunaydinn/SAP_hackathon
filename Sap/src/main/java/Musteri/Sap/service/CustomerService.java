package Musteri.Sap.service;


import Musteri.Sap.exception.CustomerNotFoundException;
import Musteri.Sap.Model.Customer;
import Musteri.Sap.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> listAll(){
        return (List<Customer>) repo.findAll();
    }

    public void save(Customer Customer) {
        repo.save(Customer);
        return ;
    }

    public Customer get(Integer id) throws CustomerNotFoundException {
        Optional<Customer> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new CustomerNotFoundException("Couldn find any Customer with ID "+ id);
    }

    public void delete(Integer id) throws CustomerNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count==0){
            throw new CustomerNotFoundException("Couldn find any Customer with ID "+ id);
        }
        repo.deleteById(id);
    }

    //    search
    public List<Customer> getAllCustomers(){
        List<Customer> list =  (List<Customer>)repo.findAll();
        return list;
    }

    public List<Customer> getByKeyword(String keyword){
        return repo.findByKeyword(keyword);
    }



}

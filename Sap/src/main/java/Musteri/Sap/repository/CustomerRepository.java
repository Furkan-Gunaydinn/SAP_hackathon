package Musteri.Sap.repository;



import Musteri.Sap.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer > {
    public Long countById(Integer id);

    // Sahibinin ismi ile de kayıtları bulmak için bu sql sorgusunu kullandım .
    @Query(value = "select a.* from Customers a inner join users u on u.id=a.user_id where a.name like %:keyword% or u.first_name like %:keyword%", nativeQuery = true)
    List<Customer> findByKeyword(@Param("keyword") String keyword);
}


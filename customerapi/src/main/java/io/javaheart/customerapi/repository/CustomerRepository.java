package io.javaheart.customerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaheart.customerapi.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}

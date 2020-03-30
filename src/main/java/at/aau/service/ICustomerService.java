package at.aau.service;

import at.aau.entity.Customer;
import at.aau.exceptions.MissingElementException;
import at.aau.exceptions.OverflowException;

import java.util.List;

public interface ICustomerService {

    public List<Customer> findAllCustomers();
    public Customer insertCustomer(String name) throws OverflowException;
    public void removeCustomer(long id) throws MissingElementException;

}

package at.aau.service;

import at.aau.dao.ICustomerDao;
import at.aau.entity.Customer;
import at.aau.exceptions.MissingElementException;
import at.aau.exceptions.OverflowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao<Customer> custDao;

    public CustomerServiceImpl() {

    }

    public List<Customer> findAllCustomers() {
        return custDao.findAll();
    }


    public Customer insertCustomer(String name) throws OverflowException {

        Customer c = new Customer();
        c.setName(name);
        return custDao.insert(c);
    }

    public void removeCustomer(long id) throws MissingElementException {
        custDao.delete(id);
    }
}

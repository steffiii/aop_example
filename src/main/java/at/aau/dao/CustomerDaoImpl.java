package at.aau.dao;


import at.aau.entity.Customer;
import at.aau.exceptions.MissingElementException;
import at.aau.exceptions.OverflowException;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDaoImpl implements
        ICustomerDao<Customer> {

    private List<Customer> list=new ArrayList<Customer>();
    private Long currentId;
    private int capacity = 3;
    private int counter = 0;

	public CustomerDaoImpl() {
		this.currentId = 1L;
	}

	public List<Customer> findAll() {
		return this.list;
	}

	public Customer findOne(Long id) {
		for (Customer c : this.list) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}



    public Customer insert(Customer element) throws OverflowException {
        if(counter< capacity){
            element.setId(currentId++);
            this.list.add(element);
            counter++;
            return element;
        }else{
            throw  new OverflowException("too many customers.");
        }

	}

	public void delete(Long id) throws MissingElementException {
		Customer cust = null;
		for (Customer c : this.list) {
			if (c.getId() == id) {
				cust = c;
				break;
			}
		}
		if (cust != null) {
			this.list.remove(cust);
			counter--;
		}else{
		    throw new MissingElementException("there is no customer with the id "+id);
        }
	}

	public Customer update(Customer element) {
		Customer cust = null;
		for (Customer c : this.list) {
			if (c.getId() == element.getId()) {
				cust = c;
				break;
			}
		}
		if (cust != null) {
			this.list.remove(cust);
		}
		this.list.add(element);
		return cust;
	}

}

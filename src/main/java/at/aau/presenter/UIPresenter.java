package at.aau.presenter;

import at.aau.exceptions.MissingElementException;
import at.aau.exceptions.OverflowException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import at.aau.service.CustomerServiceImpl;

@Service
public class UIPresenter {

    @Autowired
    private CustomerServiceImpl psi;

    public String handleInput(String input) {
        try {
            if (input.startsWith("list")) {
                return psi.findAllCustomers().toString();
            } else if (input.startsWith("insert")) {
                String name = input.split(" ")[1];
                psi.insertCustomer(name);
                return "SUCCESSFULLY added Customer " + name + ".";
            } else if (input.startsWith("remove")) {
                long id = new Long(input.split(" ")[1]);
                psi.removeCustomer(id);
                return "SUCCESS: removed customer with the id " + id;
            } else {
                return "ERROR: invalid input";
            }
        } catch (OverflowException e) {
            return "ERROR: " + e.getMessage();
        } catch (MissingElementException e) {
            return "ERROR: " + e.getMessage();
        } catch (NumberFormatException nfe) {
            return "ERROR: please enter a valid ID";
        }

    }
}

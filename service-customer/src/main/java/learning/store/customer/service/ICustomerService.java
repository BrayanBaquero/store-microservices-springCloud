package learning.store.customer.service;

import learning.store.customer.entity.Customer;
import learning.store.customer.entity.Region;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByRegion(Region region);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer (Customer customer);
    public Customer deleteCustomer (Customer customer);
    public Customer getCustomer(Long id);

}

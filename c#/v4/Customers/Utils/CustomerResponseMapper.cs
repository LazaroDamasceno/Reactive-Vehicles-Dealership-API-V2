using v4.Customers.Domain;
using v4.Customers.DTOs;
using v4.People.Utils;

namespace v4.Customers.Utils;

public class CustomerResponseMapper
{
    
    public static CustomerResponseDto Map(Customer customer)
    {
        return new CustomerResponseDto(PersonResponseMapper.Map(customer.Person));
    }
    
}
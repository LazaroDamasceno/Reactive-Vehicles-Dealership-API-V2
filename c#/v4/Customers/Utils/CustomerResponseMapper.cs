using v4.Customers.Domain;
using v4.Customers.DTOs;
using v4.People.Domain;
using v4.People.Utils;

namespace v4.Customers.Utils;

public class CustomerResponseMapper
{
    
    private readonly PersonRepository _repository;

    public CustomerResponseMapper(PersonRepository repository)
    {
        _repository = repository;
    }

    public async Task<CustomerResponseDto> Map(Customer customer)
    {
        var person = await _repository.GetByIdAsync(customer.PersonId);
        return new CustomerResponseDto(PersonResponseMapper.Map(person));
    }
}
using System.ComponentModel.DataAnnotations;
using v4.Customers.Domain;
using v4.Customers.DTOs;
using v4.Customers.Utils;
using v4.People.Domain;
using v4.People.DTOs;
using v4.People.Services;

namespace v4.Customers.Services;

internal class CustomerRegistrationService: ICustomerRegistrationService
{
    
    private readonly CustomerRepository _customerRepository;
    private readonly IPersonRegistrationService _personRegistrationService;
    private readonly CustomerResponseMapper _responseMapper;

    public CustomerRegistrationService(
        CustomerRepository customerRepository, 
        IPersonRegistrationService personRegistrationService, 
        CustomerResponseMapper responseMapper)
    {
        _customerRepository = customerRepository;
        _personRegistrationService = personRegistrationService;
        _responseMapper = responseMapper;
    }

    public async Task<CustomerResponseDto> RegisterAsync([Required] PersonRegistrationRequestDto requestDto)
    {
        var registeredPerson = await RegisterPersonAsync(requestDto);
        var registeredCustomer = await RegisterCustomerAsync(registeredPerson.Id);
        return await _responseMapper.Map(registeredCustomer);
    }

    private async Task<Person> RegisterPersonAsync(PersonRegistrationRequestDto requestDto)
    {
        var person = Person.Create(requestDto);
        await _personRegistrationService.RegisterAsync(person);
        return person;
    }

    private async Task<Customer> RegisterCustomerAsync(Guid personId)
    {
        var customer = Customer.Create(personId);
        await _customerRepository.SaveAsync(customer);
        return customer;
    }
    
}
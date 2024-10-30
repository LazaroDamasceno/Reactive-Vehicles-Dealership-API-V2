using v4.Customers.DTOs;
using v4.People.DTOs;

namespace v4.Customers.Services;

public interface ICustomerRegistrationService
{
    Task<CustomerResponseDto> RegisterAsync(PersonRegistrationRequestDto requestDto);
}
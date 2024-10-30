using System.ComponentModel.DataAnnotations;
using Microsoft.AspNetCore.Mvc;
using v4.Customers.DTOs;
using v4.Customers.Services;
using v4.People.DTOs;

namespace v4.Customers.Controllers;

[Route("api/v4/customers")]
public class CustomerController: ControllerBase
{

    private readonly ICustomerRegistrationService _registrationService;

    public CustomerController(ICustomerRegistrationService registrationService)
    {
        _registrationService = registrationService;
    }

    [HttpPost]
    public async Task<CustomerResponseDto> RegisterAsync([Required] PersonRegistrationRequestDto requestDto)
    {
        return await _registrationService.RegisterAsync(requestDto);
    }
    
}
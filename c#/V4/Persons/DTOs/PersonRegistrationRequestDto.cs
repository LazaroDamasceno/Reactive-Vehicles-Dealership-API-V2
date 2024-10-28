using System.ComponentModel.DataAnnotations;

namespace V4.Persons.DTOs;

public record PersonRegistrationRequestDto(
    [Required] string FirstName,
    string? MiddleName,
    [Required] string LastName,
    [Required] DateTime DateOfBirth,
    [Required, StringLength(9)] string Ssn,
    [Required, EmailAddress] string Email,
    [Required, StringLength(10)] string PhoneNumber,
    [Required] string Address
);
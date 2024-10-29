using System.ComponentModel.DataAnnotations;

namespace v4.People.DTOs;

public record PersonRegistrationRequestDto(
    [Required] string FirstName,
    string? MiddleName,
    [Required] string LastName,
    [Required, StringLength(9)] string Ssn,
    [Required] DateOnly BirthDate,
    [Required] string Email,
    [Required, StringLength(10)] string PhoneNumber,
    [Required] string Address
);
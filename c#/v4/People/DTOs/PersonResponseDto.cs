using System.ComponentModel.DataAnnotations;

namespace v4.People.DTOs;

public record PersonResponseDto(
    [Required] string FullName,
    [Required, StringLength(9)] string Ssn,
    [Required] DateOnly BirthDate,
    [Required] string Email,
    [Required, StringLength(10)] string PhoneNumber,
    [Required] string Address
);
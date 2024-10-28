namespace V4.Persons.DTOs;

public record PersonResponseDto(
    string FullName,
    DateTime DateOfBirth,
    string Ssn,
    string Email,
    string PhoneNumber,
    string Address
);
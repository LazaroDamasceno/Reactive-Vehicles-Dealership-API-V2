namespace V4.Persons;

public record PersonRegistrationRequestDto(
    string FirstName,
    string? MiddleName,
    string LastName,
    DateTime DateOfBirth,
    string Ssn,
    string Email,
    string PhoneNumber,
    string Address
);
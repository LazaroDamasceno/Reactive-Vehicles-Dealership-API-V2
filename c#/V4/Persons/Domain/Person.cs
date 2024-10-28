using V4.Persons.DTOs;

namespace V4.Persons.Domain;

public class Person
{
    
    public Guid Id { get; } = Guid.NewGuid();
    public string FirstName { get; set; }
    public string? MiddleName { get; set; }
    public string LastName { get; set; }
    public DateTime DateOfBirth { get; set; }
    public string Ssn { get; }
    public string Email { get; set; }
    public string PhoneNumber { get; set; }
    public string Address { get; set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreatedAtZone { get; } = TimeZoneInfo.Local;

    public string FullName()
    {
        return string.IsNullOrEmpty(MiddleName) ? 
            $"{FirstName} {LastName}" : 
            $"{FirstName} {MiddleName} {LastName}";
    }

    private Person(PersonRegistrationRequestDto requestDto)
    {
        FirstName = requestDto.FirstName;
        MiddleName = requestDto.MiddleName;
        LastName = requestDto.LastName;
        DateOfBirth = requestDto.DateOfBirth;
        Ssn = requestDto.Ssn;
        Email = requestDto.Email;
        PhoneNumber = requestDto.PhoneNumber;
        Address = requestDto.Address;
    }

    public static Person Of(PersonRegistrationRequestDto requestDto)
    {
        return new Person(requestDto);
    }
    
}
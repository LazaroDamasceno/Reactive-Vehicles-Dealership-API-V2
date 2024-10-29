using V4.Persons.DTOs;

namespace V4.Persons.Domain;

public class Person
{
    
    public Guid Id { get; } = Guid.NewGuid();
    public string FirstName { get; }
    public string? MiddleName { get; }
    public string LastName { get; }
    public DateTime DateOfBirth { get; }
    public string Ssn { get; }
    public string Email { get; }
    public string PhoneNumber { get; }
    public string Address { get;  }
    public string Gender { get; }
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
        Gender = requestDto.Gender;
    }

    public static Person Of(PersonRegistrationRequestDto requestDto)
    {
        return new Person(requestDto);
    }
    
}
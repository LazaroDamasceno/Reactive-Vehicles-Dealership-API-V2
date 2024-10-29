using System.ComponentModel.DataAnnotations;
using v4.People.DTOs;

namespace v4.People.Domain;

public class Person
{
    
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public string FirstName { get; }
    public string? MiddleName { get; }
    public string LastName { get; }
    public string Ssn { get; }
    public DateOnly BirthDate { get; } 
    public string Email { get; }
    public string PhoneNumber { get; }
    public string Address { get; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreationTimeZone { get; } = TimeZoneInfo.Local;

    private Person(PersonRegistrationRequestDto requestDto)
    {
        FirstName = requestDto.FirstName;
        MiddleName = requestDto.MiddleName;
        LastName = requestDto.LastName;
        Ssn = requestDto.Ssn;
        BirthDate = requestDto.BirthDate;
        Email = requestDto.Email;
        PhoneNumber = requestDto.PhoneNumber;
        Address = requestDto.Address;
    }

    public static Person Create(PersonRegistrationRequestDto requestDto)
    {
        return new Person(requestDto);
    }

    public string FullName()
    {
        return string.IsNullOrEmpty(MiddleName) ?
            $"{FirstName} {LastName}" :
            $"{FirstName} {MiddleName} {LastName}";
    }
    
}
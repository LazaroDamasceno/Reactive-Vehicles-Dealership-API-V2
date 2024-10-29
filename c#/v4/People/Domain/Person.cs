using System.ComponentModel.DataAnnotations;
using v4.People.DTOs;

namespace v4.People.Domain;

public class Person
{
    
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public string FirstName { get; private set; }
    public string? MiddleName { get; private set; }
    public string LastName { get; private set; }
    public string Ssn { get; private set; }
    public DateOnly BirthDate { get; private set; }
    public string Email { get; private set; }
    public string PhoneNumber { get; private set; }
    public string Address { get; private set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreationTimeZone { get; } = TimeZoneInfo.Local;
    public DateTime? ModifiedAt { get; private set; }
    public TimeZoneInfo? ModificationTimeZone { get; private set; }

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

    public void Modify(PersonModificationRequestDto requestDto)
    {
        FirstName = requestDto.FirstName;
        MiddleName = requestDto.MiddleName;
        LastName = requestDto.LastName;
        BirthDate = requestDto.BirthDate;
        Email = requestDto.Email;
        PhoneNumber = requestDto.PhoneNumber;
        Address = requestDto.Address;
        ModifiedAt = DateTime.Now;
        ModificationTimeZone = TimeZoneInfo.Local;
    }
    
}
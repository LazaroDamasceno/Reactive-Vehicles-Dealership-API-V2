using System.ComponentModel.DataAnnotations;
using v4.People.DTOs;

namespace v4.People.Domain;

public class Person
{
    
    [Key]
    public Guid Id { get; set; } = Guid.NewGuid();
    public string FirstName { get; set; }
    public string? MiddleName { get; set; }
    public string LastName { get; set; }
    public string Ssn { get; set; }
    public DateOnly BirthDate { get; set; }
    public string Email { get; set; }
    public string PhoneNumber { get; set; }
    public string Address { get; set; }
    public DateTime CreatedAt { get; set; } = DateTime.Now;
    public DateTime? ModifiedAt { get; set; }

    public static Person Create(PersonRegistrationRequestDto requestDto)
    {
        return new Person
        {
            FirstName = requestDto.FirstName,
            MiddleName = requestDto.MiddleName,
            LastName = requestDto.LastName,
            Ssn = requestDto.Ssn,
            BirthDate = requestDto.BirthDate,
            Email = requestDto.Email,
            PhoneNumber = requestDto.PhoneNumber,
            Address = requestDto.Address
        };
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
    }
    
}
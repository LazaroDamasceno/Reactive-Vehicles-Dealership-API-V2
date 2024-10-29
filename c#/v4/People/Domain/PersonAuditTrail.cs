using System.ComponentModel.DataAnnotations;

namespace v4.People.Domain;

public class PersonAuditTrail
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
    
    private PersonAuditTrail(Person person)
    {
        FirstName = person.FirstName;
        MiddleName = person.MiddleName;
        LastName = person.LastName;
        Ssn = person.Ssn;
        BirthDate = person.BirthDate;
        Email = person.Email;
        PhoneNumber = person.PhoneNumber;
        Address = person.Address;
    }

    public static PersonAuditTrail Create(Person person)
    {
        return new PersonAuditTrail(person);
    }
    
}
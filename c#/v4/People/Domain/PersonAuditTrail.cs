using System.ComponentModel.DataAnnotations;

namespace v4.People.Domain;

public class PersonAuditTrail
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
    
    public static PersonAuditTrail Create(Person person)
    {
        return new PersonAuditTrail
        {
            FirstName = person.FirstName,
            MiddleName = person.MiddleName,
            LastName = person.LastName,
            Ssn = person.Ssn,
            BirthDate = person.BirthDate,
            Email = person.Email,
            PhoneNumber = person.PhoneNumber,
            Address = person.Address
        };
    }
    
}
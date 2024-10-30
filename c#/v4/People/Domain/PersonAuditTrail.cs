using System.ComponentModel.DataAnnotations;

namespace v4.People.Domain;

public class PersonAuditTrail
{
    
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public Person Person { get; set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    
    public static PersonAuditTrail Create(Person person)
    {
        return new PersonAuditTrail
        {
            Person = person
        };
    }
    
}
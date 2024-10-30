using System.ComponentModel.DataAnnotations;
using v4.People.Domain;

namespace v4.Customers;

public class Customer
{
 
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public Guid PersonId { get; private set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreatedAtZone { get; } = TimeZoneInfo.Local;

    public static Customer Of(Person person)
    {
        return new Customer()
        {
            PersonId = person.Id,
        };
    }
    
}
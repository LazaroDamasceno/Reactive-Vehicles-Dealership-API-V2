using System.ComponentModel.DataAnnotations;
using v4.People.Domain;

namespace v4.Customers.Domain;

[Serializable]
public class Customer
{
 
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public Guid PersonId { get; private set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreatedAtZone { get; } = TimeZoneInfo.Local;

    public static Customer Create(Guid personId)
    {
        return new Customer()
        {
            PersonId = personId
        };
    }
    
}
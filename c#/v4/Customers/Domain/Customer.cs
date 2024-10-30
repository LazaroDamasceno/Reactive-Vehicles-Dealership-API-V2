using System.ComponentModel.DataAnnotations;
using v4.People.Domain;

namespace v4.Customers.Domain;

public class Customer
{
 
    [Key]
    public Guid Id { get; } = Guid.NewGuid();
    public Guid PersonFk { get; private set; }
    public Person Person { get; private set; }
    public DateTime CreatedAt { get; } = DateTime.Now;

    public static Customer Create(Person person)
    {
        return new Customer()
        {
            PersonFk = person.Id,
            Person = person
        };
    }
    
}
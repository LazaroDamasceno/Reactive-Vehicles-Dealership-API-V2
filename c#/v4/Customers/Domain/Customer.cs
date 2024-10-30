using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;
using v4.People.Domain;

namespace v4.Customers.Domain;

public class Customer
{
 
    [Key]
    public Guid Id { get; set; } = Guid.NewGuid();
    public Person Person { get; set; }
    public DateTime CreatedAt{ get; set; } = DateTime.Now;

    public static Customer Create(Person person)
    {
        return new Customer()
        {
            Person = person
        };
    }
    
}
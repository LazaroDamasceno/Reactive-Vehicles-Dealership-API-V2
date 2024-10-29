using v4.People.Domain;

namespace v4.People.Services;

public interface IPersonRegistration
{
    Task RegisterAsync(Person person);
}
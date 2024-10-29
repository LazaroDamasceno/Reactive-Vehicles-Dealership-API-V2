using v4.People.Domain;

namespace v4.People.Services;

public interface IPersonRegistrationService
{
    Task RegisterAsync(Person person);
}
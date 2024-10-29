using System.ComponentModel.DataAnnotations;
using v4.People.Domain;
using v4.People.Exceptions;

namespace v4.People.Services;

internal class PersonRegistrationService: IPersonRegistrationService
{
    
    private readonly PersonRepository _personRepository;

    public PersonRegistrationService(PersonRepository personRepository)
    {
        _personRepository = personRepository;
    }

    public async Task RegisterAsync([Required] Person person)
    {
        HandleDuplicatedSsn(person.Ssn);
        HandleDuplicatedEmail(person.Email);
        await _personRepository.SaveAsync(person);
    }

    private void HandleDuplicatedSsn(string ssn)
    {
        if (_personRepository.GetAllAsync().Result.Any(p => p.Ssn == ssn))
        {
            throw new DuplicatedSsnException();
        }
    }

    private void HandleDuplicatedEmail(string email)
    {
        if (_personRepository.GetAllAsync().Result.Any(p => p.Email == email))
        {
            throw new DuplicatedEmailException();
        }
    }

}
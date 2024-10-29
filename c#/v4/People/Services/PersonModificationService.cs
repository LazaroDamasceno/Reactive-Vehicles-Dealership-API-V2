using System.ComponentModel.DataAnnotations;
using v4.People.Domain;
using v4.People.DTOs;

namespace v4.People.Services;

internal class PersonModificationService: IPersonModificationService
{

    private readonly PersonRepository _personRepository;

    public PersonModificationService(PersonRepository personRepository)
    {
        _personRepository = personRepository;
    }

    public async Task Modify([Required] Person person, [Required] PersonModificationRequestDto requestDto)
    {
        person.Modify(requestDto);
        await _personRepository.SaveAsync(person);
    }
    
}
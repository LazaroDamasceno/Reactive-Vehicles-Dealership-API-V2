using v4.People.Domain;
using v4.People.DTOs;

namespace v4.People.Services;

public interface IPersonModificationService
{
    Task Modify(Person person, PersonModificationRequestDto requestDto);
}
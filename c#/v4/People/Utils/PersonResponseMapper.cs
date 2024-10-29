using v4.People.Domain;
using v4.People.DTOs;

namespace v4.People.Utils;

public class PersonResponseMapper
{
    public static PersonResponseDto Map(Person person)
    {
        return new PersonResponseDto(
            person.FullName(),
            person.Ssn,
            person.BirthDate,
            person.Email,
            person.PhoneNumber,
            person.Address
        );
    }
}
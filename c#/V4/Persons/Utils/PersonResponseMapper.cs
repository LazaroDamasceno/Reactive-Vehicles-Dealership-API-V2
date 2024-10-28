using V4.Persons.Domain;
using V4.Persons.DTOs;

namespace V4.Persons.Utils;

public class PersonResponseMapper
{

    public static PersonResponseDto Map(Person person)
    {
        return new PersonResponseDto(
            person.FullName(),
            person.DateOfBirth,
            person.Ssn,
            person.Email,
            person.PhoneNumber,
            person.Address,
            person.Gender
        );
    }

}
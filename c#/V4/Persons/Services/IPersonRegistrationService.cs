using System.ComponentModel.DataAnnotations;
using V4.Persons.Domain;
using V4.Persons.DTOs;

namespace V4.Persons.Services;

public interface IPersonRegistrationService
{
    Task<Person> Register(PersonRegistrationRequestDto requestDto);
}
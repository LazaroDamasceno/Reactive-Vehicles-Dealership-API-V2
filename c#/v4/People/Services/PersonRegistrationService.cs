using System.ComponentModel.DataAnnotations;
using Microsoft.EntityFrameworkCore;
using v4.Data;
using v4.People.Domain;
using v4.People.Exceptions;

namespace v4.People.Services;

internal class PersonRegistrationService: IPersonRegistrationService
{
    
    private readonly AppDbContext _context;

    public PersonRegistrationService(AppDbContext context)
    {
        _context = context;
    }

    public async Task RegisterAsync([Required] Person person)
    {
        HandleDuplicatedSsn(person.Ssn);
        HandleDuplicatedEmail(person.Email);
        await _context.People.AddAsync(person);
        await _context.SaveChangesAsync();
    }

    private void HandleDuplicatedSsn(string ssn)
    {
        if (_context.People.ToArrayAsync().Result.Any(p => p.Ssn == ssn))
        {
            throw new DuplicatedSsnException();
        }
    }

    private void HandleDuplicatedEmail(string email)
    {
        if (_context.People.ToArrayAsync().Result.Any(p => p.Email == email))
        {
            throw new DuplicatedEmailException();
        }
    }

}
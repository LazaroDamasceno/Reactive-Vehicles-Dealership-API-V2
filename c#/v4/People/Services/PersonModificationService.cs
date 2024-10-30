using System.ComponentModel.DataAnnotations;
using v4.People.Domain;
using v4.People.DTOs;
using v4.Data;

namespace v4.People.Services;

internal class PersonModificationService: IPersonModificationService
{

    private readonly AppDbContext _context;

    public PersonModificationService(AppDbContext context)
    {
        _context = context;
    }

    public async Task Modify([Required] Person person, [Required] PersonModificationRequestDto requestDto)
    {
        person.Modify(requestDto);
        _context.People.Update(person);
        await _context.SaveChangesAsync();
    }
    
}
using Microsoft.EntityFrameworkCore;
using v4.Data;

namespace v4.People.Domain;

public class PersonRepository
{
    
    private readonly AppDbContext _context;

    public PersonRepository(AppDbContext context) => _context = context;

    public async Task SaveAsync(Person person)
    {
        await SaveIfNotExists(person);
        await UpdateIfExists(person);
        await _context.SaveChangesAsync();
    }

    private async Task SaveIfNotExists(Person person)
    {
        if (!await _context.People.AnyAsync(p => p.Id == person.Id))
        {
            await _context.People.AddAsync(person);
        }
    }
    
    private async Task UpdateIfExists(Person person)
    {
        if (await _context.People.AnyAsync(p => p.Id == person.Id))
        {
            _context.People.Update(person);
        }
    }

    public async Task<Person?> GetByIdAsync(Guid id)
    {
        return await _context.People.FindAsync(id);
    }
    
    public async Task<Person?> GetBySsnAsync(string ssn)
    {
        return await _context.People.SingleOrDefaultAsync(p => p.Ssn == ssn);
    }
    
    public async Task<List<Person>> GetAllAsync()
    {
        return await _context.People.ToListAsync();
    }
    
}
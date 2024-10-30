using Microsoft.EntityFrameworkCore;
using v4.Customers.Exceptions;
using v4.Data;

namespace v4.Customers.Domain;

public class CustomerRepository
{
    
    private readonly AppDbContext _context;

    public CustomerRepository(AppDbContext context)
    {
        _context = context;
    }

    public async Task SaveAsync(Customer customer)
    {
        await _context.Customers.AddAsync(customer);
        await _context.SaveChangesAsync();
    }

    public async Task<Customer> GetByIdAsync(Guid id)
    {
        var existingCustomer = await _context.Customers.FindAsync(id);
        if (existingCustomer is null) throw new CustomerNotFoundException();
        return existingCustomer;
    }

    public async Task<Customer> GetBySsnAsync(string ssn)
    {
        var existingPerson = await _context
            .People
            .SingleOrDefaultAsync(p => p.Ssn == ssn);
        if (existingPerson is null) throw new CustomerNotFoundException();
        return await _context
            .Customers
            .SingleAsync(e => e.PersonId == existingPerson.Id);
    }

    public async Task<List<Customer>> GetAllAsync()
    {
        return await _context.Customers.ToListAsync();
    }
    
}
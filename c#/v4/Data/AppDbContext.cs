using Microsoft.EntityFrameworkCore;
using v4.Customers.Domain;
using v4.People.Domain;

namespace v4.Data;

public class AppDbContext: DbContext
{
    
    public DbSet<Person> People { get; init; }
    public DbSet<PersonAuditTrail> PersonAuditTrails { get; init; }
    public DbSet<Customer> Customers { get; init; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        const string connectionString = "Host=localhost;Port=5432;Database=postgres;Username=postgres;Password=postgres";
        optionsBuilder.UseNpgsql(connectionString);
    }
    
}
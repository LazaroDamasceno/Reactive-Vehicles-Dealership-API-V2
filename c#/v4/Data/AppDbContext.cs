using Microsoft.EntityFrameworkCore;
using v4.People.Domain;

namespace v4.Data;

public class AppDbContext: DbContext
{
    
    public DbSet<Person> People { get; set; }
    public DbSet<PersonAuditTrail> PersonAuditTrails { get; set; }
    
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        const string connectionString = "Host=localhost;Port=5432;Database=v4;Username=postgres;Password=postgres;";
        optionsBuilder.UseNpgsql(connectionString);
    }
    
}
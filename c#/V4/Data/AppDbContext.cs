using Microsoft.EntityFrameworkCore;
using V4.Persons.Domain;

namespace V4.Data;

public class AppDbContext: DbContext
{
    
    public DbSet<Person> People { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        const string connectionString = "Server=127.0.0.1;Port=5432;Database=v4;UserId=postgres;Password=postgres;";
        optionsBuilder.UseNpgsql(connectionString);
    }
}
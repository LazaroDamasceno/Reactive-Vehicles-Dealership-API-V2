using Microsoft.EntityFrameworkCore;

namespace v4.Data;

public class AppDbContext: DbContext
{
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        const string connectionString = "Host=localhost;Port=5432;Database=v4;Username=postgres;Password=postgres;";
        optionsBuilder.UseNpgsql(connectionString);
    }
}
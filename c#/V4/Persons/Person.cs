namespace V4.Persons;

public class Person
{
    
    public Guid Id { get; } = Guid.NewGuid();
    public string FirstName { get; set; }
    public string? MiddleName { get; set; }
    public string LastName { get; set; }
    public DateTime DateOfBirth { get; set; }
    public string Ssn { get; set; }
    public string Email { get; set; }
    public string PhoneNumber { get; set; }
    public string Address { get; set; }
    public DateTime CreatedAt { get; } = DateTime.Now;
    public TimeZoneInfo CreatedAtZone { get; } = TimeZoneInfo.Local;

    public string FullName()
    {
        return string.IsNullOrEmpty(MiddleName) ? 
            $"{FirstName} {LastName}" : 
            $"{FirstName} {MiddleName} {LastName}";
    }
    
}
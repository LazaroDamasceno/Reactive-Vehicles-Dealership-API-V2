using v4.Customers.Services;
using v4.Data;
using v4.People.Domain;
using v4.People.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddDbContext<AppDbContext>();
builder.Services.AddScoped<PersonRepository>();
builder.Services.AddScoped<IPersonRegistrationService, PersonRegistrationService>();
builder.Services.AddScoped<IPersonModificationService, PersonModificationService>();
builder.Services.AddScoped<ICustomerRegistrationService, CustomerRegistrationService>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

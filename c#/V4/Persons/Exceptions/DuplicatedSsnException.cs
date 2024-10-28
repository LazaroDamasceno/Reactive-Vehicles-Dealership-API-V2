namespace V4.Persons.Exceptions;

public class DuplicatedSsnException(): Exception("The given SSN is already in use");
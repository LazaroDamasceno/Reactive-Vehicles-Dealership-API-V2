namespace v4.People.Exceptions;

public class DuplicatedSsnException(): Exception("The given SSN is already in use");
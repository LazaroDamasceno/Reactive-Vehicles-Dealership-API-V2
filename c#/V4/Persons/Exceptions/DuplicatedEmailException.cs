namespace V4.Persons.Exceptions;

public class DuplicatedEmailException(): Exception("The given email is already in use");
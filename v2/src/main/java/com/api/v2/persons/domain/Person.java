package com.api.v2.persons.domain;

import com.api.v2.persons.dtos.PersonModificationRequestDto;
import com.api.v2.persons.dtos.PersonRegistrationRequestDto;
import com.api.v2.persons.utils.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Document
@Getter
@NoArgsConstructor
public class Person {

    @Id
    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private LocalDate birthDate;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private LocalDateTime createdAt;
    private ZoneId createdAtZone;
    private LocalDateTime modifiedAt;
    private ZoneId modifiedAtZone;
    private LocalDateTime bookedDeletionDate;

    private Person(PersonRegistrationRequestDto requestDto) {
        this.id = UUID.randomUUID();
        this.firstName = requestDto.firstName();
        this.middleName = requestDto.middleName();
        this.lastName = requestDto.lastName();
        this.ssn = requestDto.ssn();
        this.birthDate = requestDto.birthDate();
        this.email = requestDto.email();
        this.address = requestDto.address();
        this.phoneNumber = requestDto.phoneNumber();
        this.gender = requestDto.gender();
        this.createdAt = LocalDateTime.now();
        this.createdAtZone = ZoneId.systemDefault();
    }

    public static Person of(PersonRegistrationRequestDto requestDto) {
        return new Person(requestDto);
    }

    public void modify(PersonModificationRequestDto requestDto) {
        this.firstName = requestDto.firstName();
        this.middleName = requestDto.middleName();
        this.lastName = requestDto.lastName();
        this.birthDate = requestDto.birthDate();
        this.email = requestDto.email();
        this.address = requestDto.address();
        this.phoneNumber = requestDto.phoneNumber();
        this.gender = requestDto.gender();
        this.modifiedAt = LocalDateTime.now();
        this.modifiedAtZone = ZoneId.systemDefault();
    }

    public void bookDeletion() {
        this.bookedDeletionDate = LocalDateTime.now().plusYears(Constants.LEGAL_DELETION_DEADLINE);
    }

}

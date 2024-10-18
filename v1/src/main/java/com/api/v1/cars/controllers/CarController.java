package com.api.v1.cars.controllers;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.cars.services.CarRetrievalService;
import com.api.v1.cars.services.crossovers.CrossoverRegistrationServiceImpl;
import com.api.v1.cars.services.elecrics.ElectricRegistrationServiceImpl;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CrossoverRegistrationServiceImpl crossoverRegistrationService;
    private final CarRetrievalService carRetrievalService;
    private final ElectricRegistrationServiceImpl electricRegistrationServiceImpl;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<CarResponseDto> findAll() {
        return carRetrievalService.findAll();
    }

    @PostMapping("crossover")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> registerCrossover(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return crossoverRegistrationService.register(requestDto);
    }

    @PostMapping("electric")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> register(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return electricRegistrationServiceImpl.register(requestDto);
    }

}

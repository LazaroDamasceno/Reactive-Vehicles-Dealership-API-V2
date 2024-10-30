package com.api.v2.cars.controllers;

import com.api.v2.cars.dtos.CarResponseDto;
import com.api.v2.cars.services.CarRetrievalService;
import com.api.v2.cars.services.crossovers.CrossoverRegistrationServiceImpl;
import com.api.v2.cars.services.elecrics.ElectricRegistrationServiceImpl;
import com.api.v2.cars.services.hatchback.HatchbackRegistrationServiceImpl;
import com.api.v2.cars.services.pickup.PickupRegistrationServiceImpl;
import com.api.v2.cars.services.sedan.SedanRegistrationServiceImpl;
import com.api.v2.cars.services.suv.SuvRegistrationServiceImpl;
import com.api.v2.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v2/cars")
@RequiredArgsConstructor
public class CarController {

    private final CrossoverRegistrationServiceImpl crossoverRegistrationService;
    private final CarRetrievalService carRetrievalService;
    private final ElectricRegistrationServiceImpl electricRegistrationServiceImpl;
    private final HatchbackRegistrationServiceImpl hatchbackRegistrationService;
    private final PickupRegistrationServiceImpl pickupRegistrationService;
    private final SedanRegistrationServiceImpl sedanRegistrationService;
    private final SuvRegistrationServiceImpl suvRegistrationServiceImpl;

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
    public Mono<CarResponseDto> registerElectric(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return electricRegistrationServiceImpl.register(requestDto);
    }

    @PostMapping("hatchback")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> registerHatchback(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return hatchbackRegistrationService.register(requestDto);
    }

    @PostMapping("pickup")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> registerPickup(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return pickupRegistrationService.register(requestDto);
    }

    @PostMapping("sedan")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> registerSedan(@Valid  @RequestBody VehicleRegistrationRequestDto requestDto) {
        return sedanRegistrationService.register(requestDto);
    }

    @PostMapping("suv")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> registerSUV(@Valid @RequestBody VehicleRegistrationRequestDto requestDto) {
        return suvRegistrationServiceImpl.register(requestDto);
    }

}

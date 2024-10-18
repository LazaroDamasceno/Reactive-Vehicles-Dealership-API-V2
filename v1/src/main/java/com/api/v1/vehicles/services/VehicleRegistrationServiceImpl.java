package com.api.v1.vehicles.services;

import com.api.v1.vehicles.domain.Vehicle;
import com.api.v1.vehicles.domain.VehicleRepository;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class VehicleRegistrationServiceImpl implements VehicleRegistrationService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Mono<Vehicle> register(@Valid VehicleRegistrationRequestDto requestDto) {
        Mono<Vehicle> vehicleFound = vehicleRepository
                .findByModelAndMakeAndYear(
                        requestDto.model(),
                        requestDto.make(),
                        requestDto.manufacturingYear()
                );
        return vehicleFound
                .hasElement()
                .flatMap(exists -> {
                   if (exists) return vehicleFound;
                   return vehicleRepository.save(Vehicle.of(requestDto));
                });
    }

}

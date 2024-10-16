package com.api.v1.vehicle.services;

import com.api.v1.vehicle.domain.vehicle.Vehicle;
import com.api.v1.vehicle.domain.vehicle.VehicleRepository;
import com.api.v1.vehicle.dtos.VehicleRegistrationRequestDto;
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
        return vehicleRepository.save(Vehicle.of(requestDto));
    }

}

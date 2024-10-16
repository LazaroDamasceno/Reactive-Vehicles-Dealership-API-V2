package com.api.v1.vehicles.services;

import com.api.v1.vehicles.domain.vehicle.Vehicle;
import com.api.v1.vehicles.domain.vehicle.VehicleAuditTrail;
import com.api.v1.vehicles.domain.vehicle.VehicleAuditTrailRepository;
import com.api.v1.vehicles.domain.vehicle.VehicleRepository;
import com.api.v1.vehicles.dtos.VehicleModificationRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class VehicleModificationServiceImpl implements VehicleModificationService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleAuditTrailRepository auditTrailRepository;

    @Override
    public Mono<Vehicle> modify(@NotNull Vehicle vehicle, @Valid VehicleModificationRequestDto requestDto) {
        return auditTrailRepository
                .save(VehicleAuditTrail.of(vehicle))
                .then(Mono.defer(() -> {
                    vehicle.modify(requestDto);
                    return vehicleRepository.save(vehicle);
                }));
    }

}

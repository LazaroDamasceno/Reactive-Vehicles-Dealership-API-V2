package com.api.v1.cars.types.minivan;

import com.api.v1.cars.dtos.CarResponseDto;
import com.api.v1.vehicles.dtos.VehicleRegistrationRequestDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/minivan")
public class MinivanController {

    @Autowired
    private MinivanRegistrationServiceImpl registrationService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<CarResponseDto> register(@Valid VehicleRegistrationRequestDto requestDto) {
        return registrationService.register(requestDto);
    }


}

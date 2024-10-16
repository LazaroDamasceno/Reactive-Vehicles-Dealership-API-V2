package com.api.v1.cars.generics;

import com.api.v1.cars.dtos.CarResponseDto;

public interface CarResponseMapper<T> {

    CarResponseDto map(T vehicle);

}

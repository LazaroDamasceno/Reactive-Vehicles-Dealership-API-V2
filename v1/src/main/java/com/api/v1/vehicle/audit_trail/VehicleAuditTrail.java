package com.api.v1.vehicle.audit_trail;

import com.api.v1.vehicle.vehicle.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Document(collection = "vehicle_audit_trail")
public class VehicleAuditTrail {

    @Id
    private UUID id;
    private Vehicle vehicle;
    private Instant createdAt;
    private ZoneId createdAtZone;

}

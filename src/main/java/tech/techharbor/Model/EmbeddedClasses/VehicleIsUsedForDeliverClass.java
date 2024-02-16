package tech.techharbor.Model.EmbeddedClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class VehicleIsUsedForDeliverClass implements Serializable {
    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;

    @Column(name = "delivery_id", nullable = false)
    private Integer deliveryId;

    public VehicleIsUsedForDeliverClass() {
    }
}


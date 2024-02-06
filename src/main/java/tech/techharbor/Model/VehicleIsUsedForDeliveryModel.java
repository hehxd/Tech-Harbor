package tech.techharbor.Model;

import jakarta.persistence.*;
import lombok.Data;
import tech.techharbor.Model.EmbeddedClasses.VehicleIsUsedForDeliverClass;
import java.util.Objects;

@Entity
@Data
@Table(name = "vehicle_is_used_for_delivery", schema = "project", catalog = "db_202324z_va_prj_techharbor")
public class VehicleIsUsedForDeliveryModel {

    @EmbeddedId
    private VehicleIsUsedForDeliverClass vehicleIsUsedForDeliverClass;

    @Override
    public int hashCode() {
        return Objects.hash(vehicleIsUsedForDeliverClass);
    }
}

package tech.techharbor.Web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.techharbor.Model.UserTableModel;
import tech.techharbor.Service.DeliveryService;
import tech.techharbor.Service.OrderTableService;


@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final OrderTableService orderTableService;

    public DeliveryController(DeliveryService deliveryService, OrderTableService orderTableService) {
        this.deliveryService = deliveryService;
        this.orderTableService = orderTableService;
    }

    @GetMapping("/myDeliveries/{id}")
    public String getDeliveryPage(@PathVariable Integer id, Model model, HttpSession session) {
        Object deliveryManObject = session.getAttribute("deliveryMan");
        model.addAttribute("deliveryMan", deliveryManObject);
        UserTableModel deliveryMan = (UserTableModel) deliveryManObject;
        model.addAttribute("deliveries", deliveryService.findByDeliveryManId(deliveryMan.getUserId()));

        return "myDeliveries";
    }

    @PostMapping("/update-delivery-status")
    public String updateDeliveryStatus(@RequestParam("deliveryId") Integer deliveryId,
                                       @RequestParam("orderId") Integer orderId,
                                       @RequestParam("newStatus") String newStatus,
                                       HttpSession session) {

        Object deliveryManObject = session.getAttribute("deliveryMan");
        UserTableModel deliveryMan = (UserTableModel) deliveryManObject;
        deliveryService.updateDeliveryStatus(deliveryId, newStatus);
        orderTableService.updateOrderStatus(orderId, newStatus);
        return "redirect:/myDeliveries/" + deliveryMan.getUserId();
    }

}

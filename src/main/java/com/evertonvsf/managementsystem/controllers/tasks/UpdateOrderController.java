package com.evertonvsf.managementsystem.controllers.tasks;

import com.evertonvsf.managementsystem.controllers.utils.MainController;
import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.task.Service;
import com.evertonvsf.managementsystem.models.task.ServiceCategory;
import com.evertonvsf.managementsystem.models.task.ServiceOrder;
import com.evertonvsf.managementsystem.models.task.Status;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UpdateOrderController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    @FXML
    private ChoiceBox<Status> statusChoices;

    @FXML
    private void initialize(){
        this.statusChoices.getItems().addAll(Status.values());
        this.statusChoices.setValue(ServiceOrdersController.selectedOrder.getStatus());
    }
    @FXML
    void cancel() throws IOException {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        MainController.changePanel(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/views/serviceOrders.fxml"))));
        stage.close();
    }

    @FXML
    void save(ActionEvent event) throws IOException {
        ServiceOrder serviceOrder = DAO.fromServiceOrder().findById(ServiceOrdersController.selectedOrder.getId());
        serviceOrder.setStatus(this.statusChoices.getValue());
        List<Service> services = new ArrayList<>();
        for (Integer serviceId : serviceOrder.getServicesIds()){
            services.add(DAO.fromService().findById(serviceId));
        }

        for (Service service : services){
            if (service.getStatus() != Status.FINISHED && service.getStatus() != Status.CANCELED){
                service.setStatus(this.statusChoices.getValue());
                DAO.fromService().update(service);
            }
        }

        DAO.fromServiceOrder().update(serviceOrder);
        cancel();
    }

}

package com.evertonvsf.managementsystem.controllers.utils;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public abstract class MainController {
    public static Stage STAGE;
    public static Technician loggedTechnician;
    public static void saveInfo() {
        DAO.fromClient().writePersistence();
        DAO.fromTechnician().writePersistence();

        DAO.fromService().writePersistence();
        DAO.fromServiceOrder().writePersistence();

        DAO.fromBuyOrder().writePersistence();
        DAO.fromComponent().writePersistence();

        DAO.fromInvoice().writePersistence();
        DAO.fromPayment().writePersistence();
    }

    public static void loadInfo() {
        DAO.fromClient().loadPersistence();
        DAO.fromTechnician().loadPersistence();

        DAO.fromService().loadPersistence();
        DAO.fromServiceOrder().loadPersistence();

        DAO.fromBuyOrder().loadPersistence();
        DAO.fromComponent().loadPersistence();

        DAO.fromInvoice().loadPersistence();
        DAO.fromPayment().loadPersistence();
    }

    public static void popUp(Parent root){
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(MainController.STAGE);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }

    public static void closePopUp(Stage stage, String parentPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(MainController.class.getResource(parentPath)));
        MainController.STAGE.setScene(new Scene(root));
        MainController.STAGE.show();
        stage.close();
    }
}
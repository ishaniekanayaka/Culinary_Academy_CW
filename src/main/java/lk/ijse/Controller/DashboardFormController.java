package lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private AnchorPane mainroot;

    @FXML
    private AnchorPane root;

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPaymentOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/Payment_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnProgrammeOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/Programme_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/student_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/user_form.fxml"));
            loadWindow(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadWindow(AnchorPane anchorPane) {
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

}

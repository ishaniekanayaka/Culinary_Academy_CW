package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DTO.StudentDTO;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.entity.User;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private DatePicker cmbDob;

    @FXML
    private ComboBox<User> cmb_Codinator_ID;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colCoordinatorId;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private AnchorPane rootStudent;

    @FXML
    private TableView<?> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setStudentID();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       getAll();
        setCellValueFactory();
        setComboUser();
    }

    private void setCellValueFactory() {
    }

    private void getAll() {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    private void setComboUser() {
        List<User> users = studentBO.getUserIds(); // Adjust this method to return List<User>
        cmb_Codinator_ID.getItems().addAll(users);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws IOException {
        User selectedCoordinator = (User) this.cmb_Codinator_ID.getSelectionModel().getSelectedItem();

        boolean isSaved = studentBO.addStudent(new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(), txtContact.getText(), selectedCoordinator, cmbDob.getValue()));
        if(isSaved){
            setComboUser();
            new Alert(Alert.AlertType.CONFIRMATION,"Student save successfully....!!! :)").show();
            AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/Register_form.fxml"));
            Scene scene = new Scene(rootNode);
            Stage stage =(Stage) this.rootStudent.getScene().getWindow();
            stage.setScene(scene);

            stage.setTitle("dashboard Form");
            stage.centerOnScreen();
        }else {
            new Alert(Alert.AlertType.ERROR,"Student save unsuccessfully....!!! :(").show();
        }

    }

    private void setStudentID() throws IOException {
        String studentID = studentBO.generateNewStudentID();

        if (studentID == null) {
            txtId.setText("ST000001");
        } else {
            String[] split = studentID.split("[S][T]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newID = String.format("ST%06d", lastDigits);
            txtId.setText(newID);
        }
    }

    private void clearAll() {
        txtContact.clear();
        txtAddress.clear();
        txtContact.clear();
        txtName.clear();
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmb_Codinator_OnAction(ActionEvent event) {
        cmb_Codinator_ID.getValue();
        cmb_Codinator_ID.requestFocus();
    }

    @FXML
    void tblStudentOnMouseClicked(MouseEvent event) {

    }


}

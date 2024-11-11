package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DTO.StudentDTO;
import lk.ijse.DTO.tm.StudentTM;
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
    private TableView<StudentTM> tblStudents;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    StudentBO studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);
    ObservableList<StudentTM> obList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setStudentID();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            getAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setCellValueFactory();
        setComboUser();
    }

    private void setCellValueFactory() {
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCoordinatorId.setCellValueFactory(new PropertyValueFactory<>("useId"));

    }

    private void getAll() throws IOException {
       /* try {
           // ObservableList<StudentTm> studentTms = FXCollections.observableArrayList();
            List<StudentDTO> allStudents = studentBO.getAllStudents();

            for (StudentDTO studentDto : allStudents) {
                StudentTM studentTm = new StudentTM(
                        studentDto.getStudent_id(),
                        studentDto.getName(),
                        studentDto.getAddress(),
                        studentDto.getContact(),
                        studentDto.getUserId(),
                        studentDto.getDate()
                        // Ensure this matches the expected field
                );
                obList.add(studentTm);
            }

            tblStudents.setItems(obList);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading student data.").show();
            e.printStackTrace();
        }*/
        List<StudentDTO> allStudents = studentBO.getAllStudents();

        if (!(allStudents.isEmpty())) {

            for (StudentDTO studentDTO : allStudents) {

                obList.add(new StudentTM(studentDTO.getStudent_id(),
                        studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContact(),
                        studentDTO.getUserId(), studentDTO.getDate()));

                tblStudents.setItems(obList);
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Empty Students :( !!!").show();
        }
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
            getAll();
            clearAll();
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

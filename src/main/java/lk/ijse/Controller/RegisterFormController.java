package lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class RegisterFormController {

    @FXML
    private Text Amountduetxt;

    @FXML
    private Text CourseDuration;

    @FXML
    private TextField Paymenttxt;

    @FXML
    private Text RegistationNumbertxt;

    @FXML
    private ComboBox<?> StudentIDComboBox;

    @FXML
    private ComboBox<?> StudentIDComboCourseComboBox;

    @FXML
    private TableView<?> StudentTable;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colProgram;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> coldueAmonut;

    @FXML
    private TableColumn<?, ?> colduration;

    @FXML
    private TableColumn<?, ?> colsid;

    @FXML
    private TableColumn<?, ?> colsname;

    @FXML
    private Text courseName;

    @FXML
    private Text courseid;

    @FXML
    private DatePicker datecombo;

    @FXML
    private Text fee;

    @FXML
    private Text payment;

    @FXML
    private Text payment1;

    @FXML
    private AnchorPane rootStudent;

    @FXML
    private Text studentMobile;

    @FXML
    private Text studentName;

    @FXML
    private Text studentid;

    @FXML
    private Text text11;

    @FXML
    void RegisterComfirmOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnActionRegistaion(ActionEvent event) {

    }

    @FXML
    void comboCourseList(ActionEvent event) {

    }

    @FXML
    void comboStudetList(ActionEvent event) {

    }

}

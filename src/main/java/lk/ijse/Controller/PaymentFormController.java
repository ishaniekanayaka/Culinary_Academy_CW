package lk.ijse.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PaymentFormController {

    @FXML
    private Text RegistationNumbertxt;

    @FXML
    private ComboBox<?> cmb_Registr_ID;

    @FXML
    private TableColumn<?, ?> col_Amount;

    @FXML
    private TableColumn<?, ?> col_FullCourse_fee;

    @FXML
    private TableColumn<?, ?> col_balance;

    @FXML
    private TableColumn<?, ?> col_paid_Amount;

    @FXML
    private TableColumn<?, ?> col_pay;

    @FXML
    private TableColumn<?, ?> col_payment_ID;

    @FXML
    private TableColumn<?, ?> col_registr_ID;

    @FXML
    private AnchorPane rootStudent;

    @FXML
    private Text studentid;

    @FXML
    private Text studentid1;

    @FXML
    private Text studentid11;

    @FXML
    private Text studentid111;

    @FXML
    private Text studentid12;

    @FXML
    private Text studentid2;

    @FXML
    private TableView<?> tbl_registr;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtCash;

    @FXML
    private TextField txtPaidAmount;

    @FXML
    private TextField txt_Full_Course_Fee;

    @FXML
    private TextField txt_payment_ID;

}

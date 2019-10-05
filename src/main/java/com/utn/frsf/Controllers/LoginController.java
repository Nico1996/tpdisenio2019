package com.utn.frsf.Controllers;

import com.utn.frsf.DTO.UserDTO;
import com.utn.frsf.Gestores.GestorUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginAP;

    @FXML
    private Label errorLabel;
    @FXML
    private TextField userTextfield;
    @FXML
    private PasswordField userPwField;

    private MainController mainController;

    private UserDTO userDTO;

    @Autowired
    GestorUser gestorUser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void ingresarPressed(){
        String username = userTextfield.getText();
        String password = userTextfield.getText();
        Boolean rta = gestorUser.existsUserByUsernameAndPassword(username,password);
        if(rta){
            this.loginAP.setVisible(false);
            this.mainController.verdb();
        }
        else this.errorLabel.setVisible(true);
    }

    public void injectMainController(MainController m){
        this.mainController=m;
    }

    public void ver(){
        this.loginAP.setVisible(true);
    }





}

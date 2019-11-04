package com.utn.frsf.Controllers;

import com.utn.frsf.DTO.UserDTO;
import com.utn.frsf.Gestores.GestorUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.GraphicDecoration;
import org.controlsfx.control.decoration.StyleClassDecoration;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.font.Decoration;

import javax.management.Notification;
import java.awt.event.ActionEvent;
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
        else {
            this.errorLabel.setVisible(true);
            notificarErrorLogin();
            };
        }


    public void injectMainController(MainController m){
        this.mainController=m;
    }

    public void ver(){
        this.loginAP.setVisible(true);
    }

    private void notificarErrorLogin() {
        Notifications notificationBuilder= Notifications.create()
                .title("Error")
                .text("Error al ingresar usuario y/o contraseña")
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.showError();
    }




}

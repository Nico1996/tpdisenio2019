package com.utn.frsf.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

    @Autowired
    private DashboardGerenteController dbGerenteController;
    @Autowired
    private LoginController loginController;

    @FXML private AnchorPane dbGerenteAP;
    @FXML private AnchorPane loginAP;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //Asigna el main controller a los Controller de los otros FXML
        dbGerenteController.injectMainController(this);
        loginController.injectMainController(this);
    }

    //Muestra el Dashboard de X
    public void verdb(){
        this.dbGerenteController.ver();
    }

    public void verlogin(){
        this.loginController.ver();
    }


}

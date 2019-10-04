package com.utn.frsf.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class LoginController implements Initializable {
    @FXML
    private AnchorPane loginAP;

    private MainController mainController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("-----------"+this.toString()+"--------");
    }

    @FXML
    public void ingresarPressed(){
        this.loginAP.setVisible(false);
        this.mainController.verdb();
    }

    public void injectMainController(MainController m){
        this.mainController=m;
    }

    public void ver(){
        this.loginAP.setVisible(true);
    }





}

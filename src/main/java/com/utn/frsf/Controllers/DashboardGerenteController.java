package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class DashboardGerenteController implements Initializable {

    @FXML
    private AnchorPane dashboardAP;

    @FXML
    private JFXButton x;

    @FXML
    public void buttonPressed(){
        this.dashboardAP.setVisible(false);
    }

    private MainController mainController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.dashboardAP.setVisible(false);
        System.out.println("-----------"+this.toString()+"--------");
    }

    public void injectMainController(MainController m){
        this.mainController=m;
    }

    public void ver(){
        this.dashboardAP.setVisible(true);
    }

    @FXML
    public void salirButtonPressed(){
        this.dashboardAP.setVisible(false);
        this.mainController.verlogin();
    }


}

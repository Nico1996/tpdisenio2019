package com.utn.frsf.Controllers;


import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class DashboardProdSegurosController implements Initializable {

    @FXML
    private JFXButton altaPolizaButton;

    @FXML

    private VBox panelDashboardProdSeguro;


    @FXML
    private HBox dashboardProdSegurosHBOX;

    @Autowired
    AltaPolizaController altaPolizaController;

    private MainController mainController;

    public void injectMainController(MainController m){
        this.mainController=m;
    }



    @FXML
    public void altaPolizaButtonPressed(){
        this.altaPolizaController.verFormulario();
    }

    public void verDashBoard(){
        this.dashboardProdSegurosHBOX.setVisible(true);
    }

    public void disableDashboard(){
        this.dashboardProdSegurosHBOX.setDisable(true);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

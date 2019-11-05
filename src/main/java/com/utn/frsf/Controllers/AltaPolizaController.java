package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.utn.frsf.TPDisenio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin.javascript.navig.Anchor;

import java.io.IOException;

@Component
public class AltaPolizaController {

    @FXML
    private AnchorPane altaPolizaAnchorPane;

    @FXML
    private JFXButton confirmarAltaPolizaButton;

    @FXML
    private JFXButton buscarClienteButton;

    @FXML
    private JFXButton administrarHijosButton;

    @FXML
    private AnchorPane buscarClienteAnchorPane;

    @FXML
    private AnchorPane administrarHijosAnchorPane;




    @Autowired
    private DashboardProdSegurosController dashboardProdSegurosController;

    @FXML
    public void confirmarAltaPolizaButtonPressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(TPDisenio.class.getResource("/confrimacionPolizaPopout.fxml"));
        Scene scene = new Scene (loader.load());
        Stage popoutStage = new Stage();
        dashboardProdSegurosController.disableDashboard();
        popoutStage.initStyle(StageStyle.UNDECORATED);
        popoutStage.setAlwaysOnTop(true);
        popoutStage.setScene(scene);
        popoutStage.show();
        }

    public void verFormulario(){
        this.altaPolizaAnchorPane.setVisible(true);
    }


    @FXML
    public void buscarClienteButtonPressed(){
        if(buscarClienteAnchorPane.isVisible())
              buscarClienteAnchorPane.setVisible(false);
        else //if(!administrarHijosAnchorPane.isVisible())
                    buscarClienteAnchorPane.setVisible(true);
    }

    @FXML
    public void administrarHijosButtonPressed(){

        if(administrarHijosAnchorPane.isVisible())
            administrarHijosAnchorPane.setVisible(false);
        else administrarHijosAnchorPane.setVisible(true);
    }
}

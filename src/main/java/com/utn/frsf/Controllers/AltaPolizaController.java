package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Gestores.GestorLocalidad;
import com.utn.frsf.Gestores.GestorPoliza;
import com.utn.frsf.Model.*;
import com.utn.frsf.TPDisenio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class AltaPolizaController implements Initializable {

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

    @FXML
    private JFXComboBox<Provincia> provinciaComboBox;

    @FXML JFXComboBox<Localidad> localidadComboBox;

    @FXML
    JFXComboBox<TipoDocumento> dniComboBox;

    @FXML
    JFXComboBox<TipoCobertura> tipoCoberturaComboBox;

    @FXML
    JFXComboBox<Marca> marcaComboBox;

    @FXML
    JFXComboBox<Modelo> modeloComboBox;




    @Autowired
    private DashboardProdSegurosController dashboardProdSegurosController;

    @Autowired
    private GestorLocalidad gestorLocalidad;

    @Autowired
    private GestorPoliza gestorPoliza;

    @FXML
    public void confirmarAltaPolizaButtonPressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(TPDisenio.class.getResource("/fxmls/ConfrimacionPolizaPopout.fxml"));
        Scene scene = new Scene (loader.load());
        Stage popoutStage = new Stage();
        dashboardProdSegurosController.disableDashboard();
        popoutStage.initStyle(StageStyle.UNDECORATED);
        popoutStage.setAlwaysOnTop(true);
        popoutStage.setScene(scene);
        popoutStage.show();
        }

    public void verFormulario(){
        if(!this.altaPolizaAnchorPane.isVisible()) {
            this.altaPolizaAnchorPane.setVisible(true);
        }

    }


    @FXML
    public void buscarClienteButtonPressed(){
        if(buscarClienteAnchorPane.isVisible())
              buscarClienteAnchorPane.setVisible(false);
        else buscarClienteAnchorPane.setVisible(true);
    }

    @FXML
    public void administrarHijosButtonPressed(){

        if(administrarHijosAnchorPane.isVisible())
            administrarHijosAnchorPane.setVisible(false);
        else administrarHijosAnchorPane.setVisible(true);
    }

    @FXML
    public void marcaComboPressed(){
        Marca marca = this.marcaComboBox.getSelectionModel().getSelectedItem();
        if(marca!=null){
            this.modeloComboBox.getItems().clear();
            this.modeloComboBox.getItems().addAll(gestorPoliza.findAllModelosByIdMarca(marca.getId_marca()));

        }
    }

    @FXML
    public void provinciaComboPressed(){
        Provincia provincia = this.provinciaComboBox.getSelectionModel().getSelectedItem();
        if(provincia!=null){
            this.localidadComboBox.getItems().clear();
            this.localidadComboBox.getItems().addAll(gestorLocalidad.getLocalidadesById_Provincia(provincia.getId_provincia()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(provinciaComboBox.getItems().isEmpty()) {
            this.provinciaComboBox.getItems().addAll(gestorLocalidad.getProvincias());
            this.dniComboBox.getItems().addAll(TipoDocumento.values());
            this.marcaComboBox.getItems().addAll(gestorPoliza.findAllMarcasVehiculo());
          //  this.modeloComboBox.getItems().addAll(gestorPoliza.findAllModelosVehiculo());

        }
    }
}

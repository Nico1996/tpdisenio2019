package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.utn.frsf.DTO.ClienteDTO;
import com.utn.frsf.DTO.CuotaDTO;
import com.utn.frsf.DTO.PolizaDTO;
import com.utn.frsf.DTO.VehiculoDTO;
import com.utn.frsf.Gestores.GestorPoliza;
import com.utn.frsf.TPDisenio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ConfirmacionPolizaController implements Initializable {

    @FXML
    private JFXTextField marcaResumenTextField;

    @FXML
    private JFXTextField montoResumenTextField;

    @FXML
    private JFXTextField nombreResumenTextField;

    @FXML
    private JFXTextField patenteResumenTextField;

    @FXML
    private JFXTextField apellidoResumenTextField;

    @FXML
    private JFXTextField modeloResumenTextField;

    @FXML
    private JFXTextField fechainicioResumenTextField;

    @FXML
    private JFXTextField chasisResumenTextField;

    @FXML
    private JFXTextField ultimodiaResumenTextField;

    @FXML
    private JFXTextField premioResumenTextField;

    @FXML
    private JFXTextField motorResumenTextField;

    @FXML
    private JFXTextField fechafinResumenTextField;

    @FXML
    private JFXTextField sumaResumenTextField;

    @FXML
    private JFXTextField descuentosResumenTextField;

    @FXML
    private JFXTextArea textAreaConfirmacion;

    @FXML
    private JFXButton cancelarAltaPolizaButton;

    @Autowired
    AltaPolizaController altaPolizaController;

    public void setDatos(PolizaDTO polizaDTO, VehiculoDTO vehiculoDTO, ClienteDTO clienteDTO){
        this.apellidoResumenTextField.setText(clienteDTO.getApellido());
        this.nombreResumenTextField.setText(clienteDTO.getNombre());

        this.marcaResumenTextField.setText(vehiculoDTO.getMarca());
        this.modeloResumenTextField.setText(vehiculoDTO.getModelo());
        this.motorResumenTextField.setText(vehiculoDTO.getMotor().toString());
        this.chasisResumenTextField.setText(vehiculoDTO.getChasis().toString());
        this.patenteResumenTextField.setText(vehiculoDTO.getPatente());

        this.fechainicioResumenTextField.setText(polizaDTO.getFecha_inicio().toString());
        this.fechafinResumenTextField.setText(polizaDTO.getFecha_fin().toString());

        this.ultimodiaResumenTextField.setText(polizaDTO.getUltimo_dia_pago().toString());
        this.sumaResumenTextField.setText("150000");
        this.premioResumenTextField.setText(polizaDTO.getPremio().toString());
        this.descuentosResumenTextField.setText(polizaDTO.getPremio().toString());
        this.montoResumenTextField.setText(polizaDTO.getMonto_total().toString());

        this.textAreaConfirmacion.setText(polizaDTO.getCuotaDTOList().toString());

        StringBuilder fieldContent = new StringBuilder("");
        for (CuotaDTO c : polizaDTO.getCuotaDTOList())
        {
            Integer numeroCuota = polizaDTO.getCuotaDTOList().indexOf(c)+1;
            fieldContent.append("Cuota Nº"+numeroCuota.toString()+": "+c.toString()+"\n");
        }
        textAreaConfirmacion.setText(fieldContent.toString());
        textAreaConfirmacion.requestFocus();
        this.polizaDTO = polizaDTO;

    }
    private PolizaDTO polizaDTO;

    @Autowired
    GestorPoliza gestorPoliza;

    @FXML
    private JFXButton confirmarAltaPolizaButton;

    @FXML
    private void confirmarAltaPolizaButtonPressed(){
        gestorPoliza.altaPoliza(this.polizaDTO);
    }

    @FXML
    private void cancelarAltaPolizaButtonPressed(){
        this.altaPolizaController.volverDeConfirmacion();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.polizaDTO = new PolizaDTO();
    }
}

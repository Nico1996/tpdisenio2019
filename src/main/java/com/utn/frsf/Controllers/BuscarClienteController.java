package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.utn.frsf.Enums.TipoDocumento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class BuscarClienteController implements Initializable {

    @FXML
    private AnchorPane buscarClienteAnchorPane;

    @FXML
    private JFXButton buscarCliente_buscarButton;

    @FXML
    private JFXTextField buscarNroClienteTextfield;

    @FXML
    private JFXTextField buscarApellidoTextfield;

    @FXML
    private JFXTextField buscarNombreTextfield;

    @FXML
    private JFXTextField buscarNroDocumentoTextfield;

    @FXML
    private JFXButton seleccionarClienteButton;

    @FXML
    private JFXComboBox<TipoDocumento> buscarTipoDniComboBox;

    public void setVisible(boolean value){
        this.buscarClienteAnchorPane.setVisible(value);
    }

    public boolean isVisible(){
        return this.buscarClienteAnchorPane.isVisible();
    }

    @FXML
    public void buscarCliente_buscarButtonPressed(){

    }

    @FXML
    public void seleccionarButtonPressed(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buscarTipoDniComboBox.getItems().addAll(TipoDocumento.values());
    }
}

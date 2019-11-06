package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.utn.frsf.Enums.EstadoCivil;
import com.utn.frsf.Enums.Sexo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class AbmHijosController implements Initializable {

    @FXML
    private AnchorPane administrarHijosAnchorPane;
    @FXML
    private DatePicker fechaNacimientoHijoDatePicker;

    @FXML
    private JFXComboBox<Sexo> sexoHijoComboBox;

    @FXML
    private JFXComboBox<EstadoCivil> estadoCivilHijoComboBox;

    @FXML
    private JFXButton agregarHijoButton;

    @FXML
    public void agregarHijoButtonPressed(){

    }

    public void setVisible(boolean value){
        this.administrarHijosAnchorPane.setVisible(value);
    }

    public boolean isVisible(){
        return this.administrarHijosAnchorPane.isVisible();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.estadoCivilHijoComboBox.getItems().addAll(EstadoCivil.values());
        this.sexoHijoComboBox.getItems().addAll(Sexo.values());
    }
}

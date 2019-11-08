package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.utn.frsf.DTO.HijoDTO;
import com.utn.frsf.Enums.EstadoCivil;
import com.utn.frsf.Enums.Sexo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class AbmHijosController implements Initializable {

    @Autowired
    AltaPolizaController altaPolizaController;

    @FXML
    private TableColumn<HijoDTO,Sexo> sexoColumn;

    @FXML
    private TableColumn<HijoDTO,Date> fechaNacimientoColumn;

    @FXML
    private TableColumn<HijoDTO, EstadoCivil> estadoCivilColumn;

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
    private TableView<HijoDTO> hijosTableView;

    @FXML
    public void agregarHijoButtonPressed(){

        if(sexoHijoComboBox.getValue()!=null && estadoCivilHijoComboBox.getValue()!=null && fechaNacimientoHijoDatePicker.getValue()!= null)
        {
            Date fecha = java.sql.Date.valueOf(fechaNacimientoHijoDatePicker.getValue());
            HijoDTO hijoDTO = new HijoDTO(sexoHijoComboBox.getValue(), fecha, estadoCivilHijoComboBox.getValue());
            hijosTableView.getItems().add(hijoDTO);
            altaPolizaController.addHijoDTO(hijoDTO);
            this.sexoHijoComboBox.setValue(null);
            this.estadoCivilHijoComboBox.setValue(null);
            this.fechaNacimientoHijoDatePicker.setValue(null);
            hijosTableView.refresh();
        }
        else{
            altaPolizaController.showError("Completar los campos faltantes del hijo.");
        }

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
        fechaNacimientoColumn.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
        sexoColumn.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        estadoCivilColumn.setCellValueFactory((new PropertyValueFactory<>("estado_civil")));
    }

    public List<HijoDTO> getHijos(){
        return this.hijosTableView.getItems();
    }


}

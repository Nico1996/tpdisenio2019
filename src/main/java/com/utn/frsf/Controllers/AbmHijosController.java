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
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

@Controller
public class AbmHijosController implements Initializable {

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
        Date asd = java.sql.Date.valueOf(fechaNacimientoHijoDatePicker.getValue());
        if(sexoHijoComboBox.getValue()!=null && estadoCivilHijoComboBox.getValue()!=null && fechaNacimientoHijoDatePicker.getValue()!= null)
        {
            HijoDTO hijoDTO = new HijoDTO(sexoHijoComboBox.getValue(), asd, estadoCivilHijoComboBox.getValue());
            hijosTableView.getItems().add(hijoDTO);
            System.out.println(hijosTableView.getItems());
            hijosTableView.refresh();
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

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }
}

package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.utn.frsf.DTO.*;
import com.utn.frsf.Enums.FormaPago;
import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Gestores.GestorLocalidad;
import com.utn.frsf.Gestores.GestorPoliza;
import com.utn.frsf.Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class AltaPolizaController implements Initializable {

    private List<HijoDTO> hijosDTO;

    private ClienteDTO clienteDTO;

    public void addHijoDTO(HijoDTO hijoDTO){
        this.hijosDTO.add(hijoDTO);
    }

    public void setClienteDTO(ClienteDTO c){
        this.clienteDTO=c;
        this.numeroClienteTextfield.setText(c.getNroCliente().toString());
        this.dniComboBox.setValue(c.getTipoDocumento());
        this.nroDocumentoTextfield.setText(c.getNumeroDocumento().toString());
        this.nombreTextfield.setText(c.getNombre());
        this.apellidoTextfield.setText(c.getApellido());
        this.domicilioTextfield.setText(c.getCalle() + " " + c.getNumero());
    }

    private VehiculoDTO vehiculoDTO;

    private PolizaDTO polizaDTO;

    @FXML
    private AnchorPane altaPolizaAnchorPane;

    @FXML
    private JFXButton confirmarAltaPolizaButton;

    @FXML
    private JFXButton buscarClienteButton;

    @FXML
    private JFXButton administrarHijosButton;

    @FXML
    private JFXComboBox<ProvinciaDTO> provinciaComboBox;

    @FXML JFXComboBox<LocalidadDTO> localidadComboBox;

    @FXML
    private JFXComboBox<TipoDocumento> dniComboBox;

    @FXML
    private JFXComboBox<TipoCoberturaDTO> tipoCoberturaComboBox;

    @FXML
    private JFXComboBox<MarcaDTO> marcaComboBox;

    @FXML
    private JFXComboBox<ModeloDTO> modeloComboBox;

    @FXML
    private JFXComboBox<FormaPago> formaDePagoComboBox;

    @FXML
    private JFXTextField añoVehiculoTextfield;

    @FXML
    private JFXTextField motorVehiculoTextfield;

    @FXML
    private JFXTextField chasisVehiculoTextfield;

    @FXML
    private JFXTextField patenteVehiculoTextfield;

    @FXML
    private JFXTextField kmsPorAñoTextField;

    @FXML
    private JFXTextField siniestrosTextField;

    @FXML
    private JFXTextField sumaAseguradaTextField;

    @FXML
    private JFXCheckBox alarmaCheckBox;

    @FXML
    private JFXCheckBox garageCheckBox;

    @FXML
    private JFXCheckBox rastreoCheckBox;

    @FXML
    private JFXCheckBox tuercasCheckBox;

    @FXML
    private AnchorPane formularioAnchorPane;

    @FXML
    private AnchorPane confirmacionAnchorPane;

    @FXML
    private DatePicker fechaInicioDatePicker;

    @FXML
    private JFXTextField numeroClienteTextfield;

    @FXML
    private JFXTextField apellidoTextfield;

    @FXML JFXTextField nombreTextfield;

    @FXML private JFXTextField nroDocumentoTextfield;

    @FXML private JFXTextField domicilioTextfield;


    @Autowired
    private BuscarClienteController buscarClienteController;

    @Autowired
    private AbmHijosController abmHijosController;


    @Autowired
    private DashboardProdSegurosController dashboardProdSegurosController;

    @Autowired
    private GestorLocalidad gestorLocalidad;

    @Autowired
    private GestorPoliza gestorPoliza;

    @Autowired
    private ConfirmacionPolizaController confirmacionPolizaController;

    @FXML
    public void confirmarAltaPolizaButtonPressed(){

        this.crearVehiculoDTO();
        this.crearPolizaDTO();

        System.out.println(polizaDTO);
        System.out.println(vehiculoDTO);

        this.confirmacionPolizaController.setDatos(this.polizaDTO,this.vehiculoDTO,this.clienteDTO);
        this.confirmacionAnchorPane.setVisible(true);

        this.formularioAnchorPane.setVisible(false);

        }
    private void crearPolizaDTO(){

        polizaDTO.setLocalidad(this.localidadComboBox.getValue().getId_localidad());
        polizaDTO.setId_tipoCoberturaDTO(this.tipoCoberturaComboBox.getValue().getId_cobertura());

        Date inicio = java.sql.Date.valueOf(fechaInicioDatePicker.getValue());
        polizaDTO.setFecha_inicio(inicio);

        Date fin = java.sql.Date.valueOf(fechaInicioDatePicker.getValue().plusMonths(6));
        polizaDTO.setFecha_fin(fin);

        polizaDTO.setUltimo_dia_pago(java.sql.Date.valueOf(fechaInicioDatePicker.getValue().plusDays(-1)));
        polizaDTO.setUltimo_dia_pago(java.sql.Date.valueOf(fechaInicioDatePicker.getValue().plusDays(-1)));

        polizaDTO.setFormaPago(this.formaDePagoComboBox.getValue());
        polizaDTO.setPremio(Float.valueOf(0));
        polizaDTO.setImporte_x_descuento(Float.valueOf(0));
        polizaDTO.setMonto_total(Float.valueOf(10000));
        polizaDTO.setId_clienteDTO(clienteDTO.getId_cliente());
        polizaDTO.setHijoDTOList(hijosDTO);
        polizaDTO.setVehiculoDTO(vehiculoDTO);
    }

    public void verFormulario(){
        if(!this.altaPolizaAnchorPane.isVisible()) {
            this.altaPolizaAnchorPane.setVisible(true);
        }

    }


    @FXML
    public void buscarClienteButtonPressed(){
        if(this.buscarClienteController.isVisible()){
            this.buscarClienteController.setVisible(false);
            System.out.println(vehiculoDTO);
            System.out.println(clienteDTO);
        }
        else  this.buscarClienteController.setVisible(true);
    }

    @FXML
    public void administrarHijosButtonPressed(){
        if(this.abmHijosController.isVisible()){
            this.abmHijosController.setVisible(false);
        }
        else
            this.abmHijosController.setVisible(true);
    }

    @FXML
    public void marcaComboPressed(){
        MarcaDTO marca = this.marcaComboBox.getSelectionModel().getSelectedItem();
        if(marca!=null){
            this.modeloComboBox.getItems().clear();
            this.modeloComboBox.getItems().addAll(gestorPoliza.findAllModelosByIdMarca(marca.getId_marca()));
            this.sumaAseguradaTextField.setText("150000");

        }
    }

    @FXML
    public void provinciaComboPressed(){
        ProvinciaDTO provincia = this.provinciaComboBox.getSelectionModel().getSelectedItem();
        if(provincia!=null){
            this.localidadComboBox.getItems().clear();
            this.localidadComboBox.getItems().addAll(gestorLocalidad.getLocalidadesById_Provincia(provincia.getId_provincia()));
        }
    }

    private VehiculoDTO crearVehiculoDTO(){

        vehiculoDTO.setId_modelo(this.modeloComboBox.getValue().getId_modelo());
        vehiculoDTO.setId_vehiculo(this.marcaComboBox.getValue().getId_marca());
        vehiculoDTO.setChasis(Integer.valueOf(this.chasisVehiculoTextfield.getText()));
        vehiculoDTO.setPatente(this.patenteVehiculoTextfield.getText());
        vehiculoDTO.setMotor(Integer.valueOf(this.motorVehiculoTextfield.getText()));

        vehiculoDTO.setMarca(this.marcaComboBox.getValue().getMarca());
        vehiculoDTO.setModelo(this.modeloComboBox.getValue().getModelo());

        List<MedidaDeSeguridadDTO> lista = new ArrayList<>();

        if(this.alarmaCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Alarma"));
        }
        if(this.garageCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Garage"));
        }
        if(this.rastreoCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Rastreo"));
        }
        if(this.tuercasCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Tuercas"));
        }

        vehiculoDTO.setMedidaDeSeguridadDTOList(lista);
    return vehiculoDTO;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
            this.provinciaComboBox.getItems().addAll(gestorLocalidad.getProvincias());
            this.dniComboBox.getItems().addAll(TipoDocumento.values());
            this.marcaComboBox.getItems().addAll(gestorPoliza.findAllMarcasVehiculo());
            this.tipoCoberturaComboBox.getItems().addAll(gestorPoliza.findAllTiposDeCobertura());
            this.formaDePagoComboBox.getItems().addAll(FormaPago.values());

            hijosDTO = new ArrayList<>();
            polizaDTO = new PolizaDTO();
            vehiculoDTO = new VehiculoDTO();
            clienteDTO = new ClienteDTO();

    }
}

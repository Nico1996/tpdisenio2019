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
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
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

        if(this.verificarCamposCompletos()){
            System.out.println(nombreTextfield.getText());
            this.crearVehiculoDTO();
            this.crearPolizaDTO();
            this.confirmacionPolizaController.setDatos(this.polizaDTO,this.vehiculoDTO,this.clienteDTO);
            this.confirmacionAnchorPane.setVisible(true);
            this.formularioAnchorPane.setVisible(false);
        }

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
        polizaDTO.setKm_año(Float.valueOf(this.kmsPorAñoTextField.getText()));
        polizaDTO.setVehiculoDTO(vehiculoDTO);
        List<CuotaDTO> cuotaDTOList = this.crearCuotasDTO(polizaDTO.getMonto_total(),polizaDTO.getFormaPago());
        this.polizaDTO.setCuotaDTOList(cuotaDTOList);
    }

    public boolean verificarCamposCompletos(){
        System.out.println(clienteDTO);
        if (tipoCoberturaComboBox.getValue() == null || fechaInicioDatePicker.getValue() == null || formaDePagoComboBox.getValue() == null || provinciaComboBox.getValue() == null || localidadComboBox.getValue() == null
            || marcaComboBox.getValue() == null || modeloComboBox.getValue()==null || añoVehiculoTextfield.getText() == null || motorVehiculoTextfield.getText() == null || chasisVehiculoTextfield.getText() == null ||
                patenteVehiculoTextfield.getText() == null || kmsPorAñoTextField.getText() == null || siniestrosTextField.getText() == null || clienteDTO.getApellido() == null) {

            this.showError("Completar los campos faltantes de la poliza.");
            return false;
        }
        else return true;

    }

    public void verFormulario(){
        if(!this.altaPolizaAnchorPane.isVisible()) {
            this.altaPolizaAnchorPane.setVisible(true);
        }
    }

    public void volverDeConfirmacion(){
        this.confirmacionAnchorPane.setVisible(false);
        this.formularioAnchorPane.setVisible(true);
        this.altaPolizaAnchorPane.setVisible(false);
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
        vehiculoDTO.setAño(Integer.valueOf(this.añoVehiculoTextfield.getText()));

        vehiculoDTO.setMarca(this.marcaComboBox.getValue().getMarca());
        vehiculoDTO.setModelo(this.modeloComboBox.getValue().getModelo());

        List<MedidaDeSeguridadDTO> lista = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        if(this.alarmaCheckBox.isSelected()){
            integerList.add(1);
        }
        if(this.garageCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Garage"));
            integerList.add(2);
        }
        if(this.rastreoCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Rastreo"));
            integerList.add(3);
        }
        if(this.tuercasCheckBox.isSelected()){
            lista.add(new MedidaDeSeguridadDTO("Tuercas"));
            integerList.add(4);
        }

        vehiculoDTO.setMedidaDeSeguridadDTOList(lista);
        vehiculoDTO.setMedidas_id(integerList);
    return vehiculoDTO;
    }

        public List<CuotaDTO> crearCuotasDTO(Float monto, FormaPago formaPago){
        LocalDate fecha_vencimiento = this.fechaInicioDatePicker.getValue().plusDays(-1);
        List<CuotaDTO> list = new ArrayList<>();
                if(formaPago.equals(FormaPago.SEMESTRAL)){
                    CuotaDTO cuotaDTO = new CuotaDTO();
                    cuotaDTO.setFecha_vencimiento(java.sql.Date.valueOf(fecha_vencimiento));;
                    cuotaDTO.setMonto(monto);
                    list.add(cuotaDTO);
                }
                else{
                    Float precio_x_cuota = monto/6;
                    for(int i = 0 ; i<6 ; i++){
                        CuotaDTO cuotaDTO = new CuotaDTO();
                        cuotaDTO.setFecha_vencimiento(java.sql.Date.valueOf(fecha_vencimiento.plusMonths(i)));
                        cuotaDTO.setMonto(precio_x_cuota);
                        list.add(cuotaDTO);
                    }

                }
            return list;
        }

        public void showError(String s){
            Notifications notificationBuilder= Notifications.create()
                    .title("Error")
                    .text(s)
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            notificationBuilder.showError();
        }

    public void notificarExito(String s){
        Notifications notificationBuilder= Notifications.create()
                .title("Notificacion")
                .text(s)
                .graphic(null)
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.showConfirm();
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

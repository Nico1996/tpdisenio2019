package com.utn.frsf.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.utn.frsf.DTO.ClienteDTO;
import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Gestores.GestorCliente;
import com.utn.frsf.Model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class BuscarClienteController implements Initializable {

    @Autowired
    private GestorCliente gestorCliente;

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

    @FXML
    private TableColumn<ClienteDTO, Integer> numClienteColumn;
    @FXML
    private TableColumn<ClienteDTO, String> apellidoColumn;
    @FXML
    private TableColumn<ClienteDTO, String> nombreColumn;
    @FXML
    private TableColumn<ClienteDTO, TipoDocumento> tipoDocColumn;
    @FXML
    private TableColumn<ClienteDTO, Long> numDocColumn;

    @FXML
    private TableView<ClienteDTO> tablaClientes;

    public void setVisible(boolean value){
        this.buscarClienteAnchorPane.setVisible(value);
    }

    public boolean isVisible(){
        return this.buscarClienteAnchorPane.isVisible();
    }

    @FXML
    public void buscarCliente_buscarButtonPressed(){


        Long nro_cliente = Long.valueOf(this.buscarNroClienteTextfield.getText());
        Long nro_documento= Long.valueOf(this.buscarNroDocumentoTextfield.getText());
        String apellido = this.buscarApellidoTextfield.getText();
        String nombre = this.buscarNombreTextfield.getText();
        TipoDocumento tipoDocumento = this.buscarTipoDniComboBox.getValue();

        Cliente cliente = new Cliente();
        List<Cliente> listaClientes = this.gestorCliente.findAllClientes(nro_cliente,nro_documento,apellido,nombre,tipoDocumento);
        cliente = listaClientes.get(0);

        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCuil_cuit(),cliente.getApellido(),cliente.getNombre(),cliente.getTipoDocumento(),cliente.getId_cliente());
        this.tablaClientes.getItems().add(clienteDTO);
        this.tablaClientes.refresh();

    }

    @FXML
    public void seleccionarButtonPressed(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buscarTipoDniComboBox.getItems().addAll(TipoDocumento.values());
        this.apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        this.nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.tipoDocColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDocumento"));
        this.numDocColumn.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        this.numClienteColumn.setCellValueFactory(new PropertyValueFactory<>("nroCliente"));
    }
}

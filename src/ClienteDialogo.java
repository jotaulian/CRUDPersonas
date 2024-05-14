import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ClienteDialogo extends JFrame{
    private JButton btnAgregarCliente;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JList listadoClientes;
    private DefaultListModel<String> listaElementos;
    private JPanel contenedor;
    private JButton btnEliminar;
    private JButton btnGuardarCambios;

    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;

    public ClienteDialogo() {
        listaElementos = new DefaultListModel<>();
        listadoClientes.setModel(listaElementos);
        clientes = new ArrayList<>();

        btnAgregarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                crearCliente(true);
            }
        });

        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                eliminarClienteSeleccionado();
            }
        });

        listadoClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pintarClienteSeleccionado();
            }
        });

        btnGuardarCambios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                crearCliente(false);
            }
        });
    }

    private void pintarClienteSeleccionado() {
        clienteSeleccionado =clientes.get(listadoClientes.getSelectedIndex());
        txtNombre.setText(clienteSeleccionado.getNombre());
        txtApellido.setText(clienteSeleccionado.getApellido());
        txtEmail.setText(clienteSeleccionado.getEmail());
        txtDireccion.setText(clienteSeleccionado.getDireccion());
        txtTelefono.setText(clienteSeleccionado.getTelefono());
    }

    private void eliminarClienteSeleccionado() {
        clientes.remove(listadoClientes.getSelectedIndex());
        renderizarListaClientes();
    }

    private void crearCliente(Boolean esNuevo) {
        Cliente cliente;
        if(esNuevo){
            cliente = new Cliente();
        }else{
            cliente = clienteSeleccionado;
        }
        cliente.setNombre(txtNombre.getText());
        cliente.setApellido(txtApellido.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setTelefono(txtTelefono.getText());

        if(esNuevo){
            clientes.add(cliente);
            limpiarTxts();
        }
        renderizarListaClientes();
    }


    private void limpiarTxts() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    private void renderizarListaClientes() {
        listaElementos.clear();

        for(Cliente cliente : clientes){
            listaElementos.addElement(cliente.getNombreCompleto());
        }
    }

    public JButton getBtnGuardar() {
        return btnAgregarCliente;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JList getListadoClientes() {
        return listadoClientes;
    }

    public JPanel getContenedor() {
        return contenedor;
    }
}

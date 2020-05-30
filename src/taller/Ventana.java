/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SISTEMAS
 */
public class Ventana extends JFrame{
    
    JLabel lblCedula, lblNombres, lblApellidos,lblDireccion, lblTelefono, lblCargo, lblSueldo;
    JTextField txtCedula, txtNombres, txtApellidos, txtDireccion, txtTelefono, txtCargo, txtSueldo;
    
    JTabbedPane miTabbed;
    DefaultTableModel table;
    JTable ta;
    JScrollPane scroll;    
    JButton btnGuardar;
        
    public Ventana()
    {
        setTitle("Taller 2");
        setSize(700,250);
        setLocation(100,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        InicializarComponentes();      
        btnGuardar.addActionListener(new ManejadordeBoton());
    }

    private void InicializarComponentes() {
                
        Object[][] datos = new Object[][]{};
        String[] cabecera = {"Cedula","Nombres","Apellidos","Direccion","Telefono","Cargo","Sueldo Basico"};
        table = new DefaultTableModel(datos,cabecera); //ModeloTabla        
        
        miTabbed = new JTabbedPane();                 
        JPanel panelLabel = new JPanel();
        JPanel panelText = new JPanel();
        JPanel panelButton = new JPanel();        
        JPanel panelBase = new JPanel();
        
        //Labels
        panelLabel.setLayout(new GridLayout(7,1));
        panelLabel.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));
        panelLabel.add(lblCedula = new JLabel("Cedula"));
        panelLabel.add(lblNombres = new JLabel("Nombres"));
        panelLabel.add(lblApellidos = new JLabel("Apellidos"));
        panelLabel.add(lblDireccion = new JLabel("Direccion"));
        panelLabel.add(lblTelefono = new JLabel("Telefono"));
        panelLabel.add(lblCargo = new JLabel("Cargo"));
        panelLabel.add(lblSueldo = new JLabel("Sueldo Basico"));
        
        //Campos de Texto
        panelText.setLayout(new GridLayout(7,1));
        panelText.setBorder(BorderFactory.createEmptyBorder(10,0,0,10));
        panelText.add(txtCedula = new JTextField());
        panelText.add(txtNombres = new JTextField());
        panelText.add(txtApellidos = new JTextField());
        panelText.add(txtDireccion = new JTextField());
        panelText.add(txtTelefono = new JTextField());
        panelText.add(txtCargo = new JTextField());
        panelText.add(txtSueldo = new JTextField());        
        
        //Botón
        panelButton.setLayout(new FlowLayout());        
        panelButton.add(btnGuardar = new JButton("Guardar"));
        
                                
        //Se agregan los paneles al panel Base
        panelBase.setLayout(new BorderLayout(8,0));
        panelBase.add(panelLabel,BorderLayout.WEST);
        panelBase.add(panelText,BorderLayout.CENTER);
        panelBase.add(panelButton,BorderLayout.SOUTH);
                       
        //Se agregan los paneles a la pestaña correspondiente.
        miTabbed.add("Registro de Empleados", panelBase);        
        
        ta = new JTable(table);
        scroll = new JScrollPane(ta);
        miTabbed.add("Reporte",scroll);
        add(miTabbed);
    } 
    
    class ManejadordeBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {            
            
            if(validaciones()){
                Object[] nuevaFila = {txtCedula.getText(),txtNombres.getText(),txtApellidos.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCargo.getText(), txtSueldo.getText()};
                table.addRow(nuevaFila);

                //Se limpian los campos
                txtCedula.setText("");
                txtNombres.setText("");
                txtApellidos.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtCargo.setText("");
                txtSueldo.setText("");
                txtCedula.requestFocus();
            }                        
        }        

        //Metodo que realiza las validaciones de los campos de textos
        private boolean validaciones() {
            boolean isValid = false;
            
            if(txtCedula.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar una cedula.","Advertencia",JOptionPane.WARNING_MESSAGE);                
                txtCedula.requestFocus();
                return isValid;
            }
            
            if(txtNombres.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un Nombre.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtNombres.requestFocus();
                return isValid;
            }
            
            if(txtApellidos.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar los Apellidos.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtApellidos.requestFocus();
                return isValid;
            }
            
            if(txtDireccion.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar una Dirección.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtDireccion.requestFocus();
                return isValid;
            }
            
            if(txtTelefono.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un Telefono.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtTelefono.requestFocus();
                return isValid;
            }
            
            if(txtCargo.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un Cargo.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtCargo.requestFocus();
                return isValid;
            }
            
            if(txtSueldo.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Debe ingresar un Sueldo.","Advertencia",JOptionPane.WARNING_MESSAGE);
                txtSueldo.requestFocus();
                return isValid;
            }
            
            isValid = true;            
            return isValid;       
        }
    }    
}

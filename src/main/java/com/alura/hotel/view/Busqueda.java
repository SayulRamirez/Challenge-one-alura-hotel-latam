package com.alura.hotel.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.hotel.controller.HuespedController;
import com.alura.hotel.controller.ReservacionController;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	
	private List<Integer> ids;
	private int idHuesped;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(321, 62, 290, 42);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0 && column != 3 && column != 5;
			}
		};
		tbReservas.setModel(modelo);
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		modelo.addColumn("Número de huesped");
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
		scroll_table.setVisible(true);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		};
		tbHuespedes.setModel(modeloHuesped);
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String parametro = txtBuscar.getText();
				
				if(!isInt(parametro) && !parametro.isBlank()) {
						
					limpiar();
					
					cargarHuespedes(parametro);
					cargarReservas(ids);
				} 

				if(isInt(parametro)) {
					
					limpiar();
					
					cargarReserva(parametro);
					cargarHuesped(idHuesped);
				}
				
			}
		});
		
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		btnEditar.addMouseListener(new MouseAdapter() {
			//K
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = panel.getSelectedIndex();
		        String title = panel.getTitleAt(index);

		        if (title.equals("Reservas")) {
		        	
		        	modificarReservas();
		        	limpiar();
		        } 
		        
		        if (title.equals("Huéspedes")) {
		            modificarHuespedes();
		            limpiar();
		        }
			}
		});
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		btnEliminar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int index = panel.getSelectedIndex();
				String title = panel.getTitleAt(index);

				if (title.equals("Reservas")) {

					eliminarReserva();
					limpiar();
				}

				if (title.equals("Huéspedes")) {
					modificarHuesped();
					limpiar();

				}
			}
		});
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
	    
	    public boolean isInt(String s) {
	    	
	    	try {
	    		int n = Integer.parseInt(s);
	    		return true;
	    	} catch (Exception e) {
	    		return false;
	    	}
	    }
	    
	    public void limpiar() {
	    	modelo.getDataVector().clear();
	    	modeloHuesped.getDataVector().clear();
	    }
	    
		private void cargarReserva(String parametro) {
			int parametro2 = Integer.parseInt(parametro);
			
			ReservacionController reservaC = new ReservacionController();
			
			var reserva = reservaC.cargarDatos(parametro2);
			
			idHuesped = reserva.getidHuesped();
			
			modelo.addRow(new Object[] {
							reserva.getId(),
							reserva.getFechaIngreso(),
							reserva.getFechaEgreso(),
							reserva.getCosto(),
							reserva.getFormaPago(),
							reserva.getidHuesped()
			});
		}
		
		private void cargarHuesped(int idHuesped) {
			
			HuespedController huespedC = new HuespedController();
			
			var huesped = huespedC.cargarDatos(idHuesped);
			
			modeloHuesped.addRow(new Object[] {
									huesped.getId(),
									huesped.getNombre(),
									huesped.getApellido(),
									huesped.getNacimiento(),
									huesped.getNacion(),
									huesped.getTel()
					});
			
		}
		
		private void cargarReservas(List<Integer> ids) {
			
			ReservacionController reservaC = new ReservacionController();
			
			
			var listaReservas = reservaC.cargarDatos(ids);
			
			listaReservas.forEach(reserva -> modelo.addRow(
					
					new Object[] {
							reserva.getId(),
							reserva.getFechaIngreso(),
							reserva.getFechaEgreso(),
							reserva.getCosto(),
							reserva.getFormaPago(),
							reserva.getidHuesped()
					}));
		}

		private void cargarHuespedes(String parametro) {
			
			HuespedController huespedC = new HuespedController();
			ids = new ArrayList<>();
			var listaHuesped = huespedC.cargarDatos(parametro);
			
			listaHuesped.forEach(huesped -> ids.add(huesped.getId()));
			
			listaHuesped.forEach(huesped -> modeloHuesped.addRow(
					
					new Object[] {
							huesped.getId(),
							huesped.getNombre(),
							huesped.getApellido(),
							huesped.getNacimiento(),
							huesped.getNacion(),
							huesped.getTel()
					}));
		}
		
		private boolean tieneFilaElegida(JTable table) {
	        return table.getSelectedRowCount() == 0 || table.getSelectedColumnCount() == 0;
	    }
		
		private void modificarHuespedes() {
			
			HuespedController huespedC = new HuespedController();
			
	        if (tieneFilaElegida(tbHuespedes)) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }

	        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer idHuesped = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
	                    String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
	                    String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
	                    String nacimiento = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3);
	                    String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
						String telefono = modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString();
						
						System.out.println(nacimiento);
						
						Huesped huesped = new Huesped(idHuesped, nombre, apellido, nacimiento, nacionalidad, telefono);

	                    int modificacion;
	                    modificacion = huespedC.modificar(huesped);
	                    
	                    JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
	                    
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	    }
		
		private void modificarReservas() {
			
			ReservacionController rc = new ReservacionController();
			
			if (tieneFilaElegida(tbReservas)) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }

	        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer idReserva = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                    String fechaIngreso = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 1);
	                    String fechaEgreso = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
	                    String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
	                    String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
	                    
	                    Reservacion reservacion = new Reservacion(idReserva, fechaIngreso, fechaEgreso, valor, formaPago);
	                    
	                    int modificacion;
	                    modificacion = rc.modificar(reservacion);
	                    
	                    JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
	                    
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
			
		}
		
		private void eliminarReserva() {
			
			ReservacionController rc = new ReservacionController();
			
			if (tieneFilaElegida(tbReservas)) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }
			
			Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
					.ifPresentOrElse(fila -> {
						
						Integer idReserva = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
						
						int modificacion;
						modificacion = rc.eliminar(idReserva);
						
						JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
						
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
			
		}
		
		private void modificarHuesped() {
			HuespedController hC = new HuespedController();
			
			if (tieneFilaElegida(tbHuespedes)) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }
			
			Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
					.ifPresentOrElse(fila -> {
						
						Integer idHuespedEliminar = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
						
						int modificacion;
						modificacion = hC.eliminar(idHuespedEliminar);
						
						JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
						
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
		
		}
}


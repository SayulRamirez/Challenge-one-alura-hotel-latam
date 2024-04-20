package com.alura.hotel.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.alura.hotel.controller.BusquedaController;
import com.alura.hotel.controller.HuespedController;
import com.alura.hotel.controller.ReservacionController;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Reservacion;
import com.alura.hotel.validaciones.VBusqueda;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Optional;
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
	private int xMouse, yMouse;

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
				MenuUser usuario = new MenuUser();
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
				MenuUser usuario = new MenuUser();
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

				VBusqueda.isVacio(parametro);

				if(isInt(parametro)){
					limpiar();
					cargarDatosPorReserva(parametro);
				}

				limpiar();
				cargarDatosPorHuesped(parametro);
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
					eliminarHuesped();
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

	/**
	 * Valida que el {@link String} ingresado san números.
	 * @param s {@link String} para validar.
	 * @return true si son solo números y false si no lo son
	 */
	public boolean isInt(String s) {
		try {
			int n = Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Limpia las casillas de las tablas.
	 */
	public void limpiar() {
		modelo.getDataVector().clear();
		modeloHuesped.getDataVector().clear();
	}

	/**
	 * Carga los datos buscados por el id de la reserva.
	 * @param numero int id de la reservación.
	 */
	private void cargarDatosPorReserva(String numero) {
		int numeroReserva = Integer.parseInt(numero);
			
		BusquedaController busqueda = new BusquedaController();
			
		var datos = busqueda.cargarDatosPorNumero(numeroReserva);

		Reservacion reserva = (Reservacion) datos.get(0);
		Huesped huesped = (Huesped) datos.get(1);

		if (reserva == null) {
			JOptionPane.showMessageDialog(null, "No se encontro reservacion");
			throw new RuntimeException();
		}

		modelo.addRow(new Object[] {
				reserva.getId(),
				reserva.getFechaIngreso(),
				reserva.getFechaEgreso(),
				reserva.getCosto(),
				reserva.getFormaPago(),
				reserva.getidHuesped()
		});

		if(huesped == null) {
			JOptionPane.showMessageDialog(null, "No se encontro huesped asociado a la reservación");
			throw new RuntimeException();
		}

		modeloHuesped.addRow(new Object[] {
				huesped.getId(),
				huesped.getNombre(),
				huesped.getApellido(),
				huesped.getNacimiento(),
				huesped.getNacion(),
				huesped.getTel()
		});
	}

	/**
	 * Carga los datos buscados por el apellido del huesped.
	 * @param apellido {@link String}
	 */
	private void cargarDatosPorHuesped(String apellido) {
			
		BusquedaController busqueda = new BusquedaController();

		//EL METODO DEVUELDE UNA LA LISTA DE HUESPEDES Y RESERVAS ASOCIADOS AL APELLIDO Y NÚMERO DE HUESPED
		var datos = busqueda.cargarDatosPorApellido(apellido);

		//DESEMPAQUETAMOS LA LISTA.
		List<Huesped> listaHuesped = (List<Huesped>) datos.get(0);
		List<Reservacion> listaReservas = (List<Reservacion>) datos.get(1);

		if(listaHuesped == null) {
			JOptionPane.showMessageDialog(null, "No se encontaron huespedes con ese apellido");
			throw new RuntimeException();
		}

		//CON LOS LOOPING AGREGAMOS LA INFORMACIÓN A LA TABLA PARA VISUALIZARLA.
		//HUESPEDES.
		listaHuesped.forEach(huesped -> modeloHuesped.addRow(
					
				new Object[] {
						huesped.getId(),
						huesped.getNombre(),
						huesped.getApellido(),
						huesped.getNacimiento(),
						huesped.getNacion(),
						huesped.getTel()
				}));

		if(listaReservas == null) {
			JOptionPane.showMessageDialog(null, "No se encontraron reservaciones asociadas a ese apellido");
			throw  new RuntimeException();
		}

		//RESERVACIÓNES
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

	/**
	 * Modifica los datos del huesped.
	 */
	private void modificarHuespedes() {
			
		HuespedController huespedC = new HuespedController();

		VBusqueda.tieneFilaElegida(tbHuespedes);

		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Huesped huesped = new Huesped(
							Integer.parseInt((modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString())),
							(String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1),
							(String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2),
							(String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3),
							(String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4),
							modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());

					int modificacion = huespedC.modificar(huesped);

					JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	/**
	 * Modifica los datos de la reservación.
	 */
	private void modificarReservas() {
			
		ReservacionController rc = new ReservacionController();

		VBusqueda.tieneFilaElegida(tbReservas);

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Reservacion reservacion = new Reservacion(
							Integer.parseInt(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString()),
							(String) modelo.getValueAt(tbReservas.getSelectedRow(), 1),
							(String) modelo.getValueAt(tbReservas.getSelectedRow(), 2),
							(String) modelo.getValueAt(tbReservas.getSelectedRow(), 3),
							(String) modelo.getValueAt(tbReservas.getSelectedRow(), 3));

					int modificacion = rc.modificar(reservacion);
	                    
					JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	/**
	 * Elimina la reservación.
	 */
	private void eliminarReserva() {
			
		ReservacionController rc = new ReservacionController();

		VBusqueda.tieneFilaElegida(tbReservas);

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
						
					int idReserva = Integer.parseInt(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
						
					int modificacion = rc.eliminar(idReserva);
						
					JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
	}

	/**
	 * Elimina el huesped.
	 */
	private void eliminarHuesped() {
		HuespedController hC = new HuespedController();

		VBusqueda.tieneFilaElegida(tbHuespedes);

		Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
						
					int idHuespedEliminar = Integer.parseInt(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
						
					int modificacion = hC.eliminar(idHuespedEliminar);
						
					JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
	}
}


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
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Panel;
import com.alura.hotel.utils.Separator;
import com.alura.hotel.validaciones.VBusqueda;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import static javax.swing.BorderFactory.*;

public class Busqueda extends JFrame {

	private final JTextField txtSearch;
	private final JTable tbGuests;
	private final JTable tbReservations;
	private final DefaultTableModel modelReservations;
	private final DefaultTableModel modelGuests;
	private int xMouse, yMouse;

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		setLocationRelativeTo(null);
		setUndecorated(true);
        setResizable(false);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		txtSearch = new JTextField();
		txtSearch.setBounds(536, 127, 193, 31);
		txtSearch.setBorder(createEmptyBorder());
		txtSearch.setColumns(10);
		contentPane.add(txtSearch);

		JLabel lblTitle = new JLabel("SISTEMA DE BÚSQUEDA");
		lblTitle.setBounds(321, 62, 290, 42);
		lblTitle.setForeground(new Color(12, 138, 199));
		lblTitle.setFont(new Font("Roboto Black", Font.BOLD, 24));
		contentPane.add(lblTitle);
		
		JTabbedPane tabulator = new JTabbedPane(JTabbedPane.TOP);
		tabulator.setBackground(new Color(12, 138, 199));
		tabulator.setFont(new Font("Roboto", Font.PLAIN, 16));
		tabulator.setBounds(20, 169, 865, 328);
		contentPane.add(tabulator);
		
		tbReservations = new JTable();
		tbReservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservations.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelReservations = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0 && column != 3 && column != 5;
			}
		};
		tbReservations.setModel(modelReservations);
		modelReservations.addColumn("Numero de Reserva");
		modelReservations.addColumn("Fecha Check In");
		modelReservations.addColumn("Fecha Check Out");
		modelReservations.addColumn("Valor");
		modelReservations.addColumn("Forma de Pago");
		modelReservations.addColumn("Número de huesped");
		JScrollPane scrollReservations = new JScrollPane(tbReservations);
		tabulator.addTab("Reservas", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/reservado.png"))), scrollReservations, null);
		scrollReservations.setVisible(true);
		
		tbGuests = new JTable();
		tbGuests.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbGuests.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelGuests = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		};
		tbGuests.setModel(modelGuests);
		modelGuests.addColumn("Número de Huesped");
		modelGuests.addColumn("Nombre");
		modelGuests.addColumn("Apellido");
		modelGuests.addColumn("Fecha de Nacimiento");
		modelGuests.addColumn("Nacionalidad");
		modelGuests.addColumn("Telefono");
		JScrollPane scrollGuests = new JScrollPane(tbGuests);
		tabulator.addTab("Huéspedes", new ImageIcon(Objects.requireNonNull(Busqueda.class.getResource("/imagenes/pessoas.png"))), scrollGuests, null);
		scrollGuests.setVisible(true);
		
		contentPane.add(Label.addLogo(56, 51, 104, 107));
		
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
		
		JPanel btnBack = new JPanel();

        JLabel lblBack = new JLabel("<");
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Roboto", Font.PLAIN, 23));
        lblBack.setBounds(0, 0, 53, 36);
        btnBack.add(lblBack);

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUser usuario = new MenuUser();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(12, 138, 199));
				lblBack.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnBack.setBackground(Color.white);
			     lblBack.setForeground(Color.black);
			}
		});
		btnBack.setLayout(null);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(0, 0, 53, 36);
		header.add(btnBack);

		JPanel btnExit = new JPanel();
        btnExit.setBounds(857, 0, 53, 36);
        btnExit.setLayout(null);
        btnExit.setBackground(Color.WHITE);

        JLabel labelExit = Label.addLabelExit(53, 36);
        btnExit.add(labelExit);
        header.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUser usuario = new MenuUser();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
				 btnExit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});

		contentPane.add(Separator.addSeparator(539, 159, 193, 2));

		JPanel btnSearch = Panel.addPanel("BUSCAR", 748, 125, 122, 35);
		contentPane.add(btnSearch);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String parametro = txtSearch.getText();

				VBusqueda.isVacio(parametro);

				if(isInt(parametro)){
					limpiar();
					cargarDatosPorReserva(parametro);
				}
				limpiar();

				cargarDatosPorHuesped(parametro);
			}
		});

		JPanel btnEdit = Panel.addPanel("EDITAR", 635, 508, 122, 35);
		contentPane.add(btnEdit);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tabulator.getSelectedIndex();
		        String title = tabulator.getTitleAt(index);

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

		JPanel btnDelete = Panel.addPanel("ELIMINAR", 767, 508, 122, 35);
		contentPane.add(btnDelete);
		btnDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tabulator.getSelectedIndex();
				String title = tabulator.getTitleAt(index);

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
	}

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
		modelReservations.getDataVector().clear();
		modelGuests.getDataVector().clear();
	}

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

		modelReservations.addRow(new Object[] {
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

		modelGuests.addRow(new Object[] {
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
		listaHuesped.forEach(huesped -> modelGuests.addRow(
					
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
		listaReservas.forEach(reserva -> modelReservations.addRow(

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

		VBusqueda.tieneFilaElegida(tbGuests);

		Optional.ofNullable(modelGuests.getValueAt(tbGuests.getSelectedRow(), tbGuests.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Huesped huesped = new Huesped(
							Integer.parseInt((modelGuests.getValueAt(tbGuests.getSelectedRow(), 0).toString())),
							(String) modelGuests.getValueAt(tbGuests.getSelectedRow(), 1),
							(String) modelGuests.getValueAt(tbGuests.getSelectedRow(), 2),
							(String) modelGuests.getValueAt(tbGuests.getSelectedRow(), 3),
							(String) modelGuests.getValueAt(tbGuests.getSelectedRow(), 4),
							modelGuests.getValueAt(tbGuests.getSelectedRow(), 5).toString());

					int modificacion = huespedC.modificar(huesped);

					JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	/**
	 * Modifica los datos de la reservación.
	 */
	private void modificarReservas() {
			
		ReservacionController rc = new ReservacionController();

		VBusqueda.tieneFilaElegida(tbReservations);

		Optional.ofNullable(modelReservations.getValueAt(tbReservations.getSelectedRow(), tbReservations.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Reservacion reservacion = new Reservacion(
							Integer.parseInt(modelReservations.getValueAt(tbReservations.getSelectedRow(), 0).toString()),
							(String) modelReservations.getValueAt(tbReservations.getSelectedRow(), 1),
							(String) modelReservations.getValueAt(tbReservations.getSelectedRow(), 2),
							(String) modelReservations.getValueAt(tbReservations.getSelectedRow(), 3),
							(String) modelReservations.getValueAt(tbReservations.getSelectedRow(), 3));

					int modificacion = rc.modificar(reservacion);
	                    
					JOptionPane.showMessageDialog(this, modificacion + "Item modificado con exito!");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	/**
	 * Elimina la reservación.
	 */
	private void eliminarReserva() {
			
		ReservacionController rc = new ReservacionController();

		VBusqueda.tieneFilaElegida(tbReservations);

		Optional.ofNullable(modelReservations.getValueAt(tbReservations.getSelectedRow(), tbReservations.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
						
					int idReserva = Integer.parseInt(modelReservations.getValueAt(tbReservations.getSelectedRow(), 0).toString());
						
					int modificacion = rc.eliminar(idReserva);
						
					JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
	}

	/**
	 * Elimina el huesped.
	 */
	private void eliminarHuesped() {
		HuespedController hC = new HuespedController();

		VBusqueda.tieneFilaElegida(tbGuests);

		Optional.ofNullable(modelGuests.getValueAt(tbGuests.getSelectedRow(), tbGuests.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
						
					int idHuespedEliminar = Integer.parseInt(modelGuests.getValueAt(tbGuests.getSelectedRow(), 0).toString());
						
					int modificacion = hC.eliminar(idHuespedEliminar);
						
					JOptionPane.showMessageDialog(this, modificacion + " item a sido eliminado");
					}, () -> JOptionPane.showMessageDialog(this, "Por favor elije un item"));
	}
}


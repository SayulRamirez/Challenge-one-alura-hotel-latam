package com.alura.hotel.view;

import com.alura.hotel.utils.Load;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class MenuUser extends JFrame {

	private int xMouse, yMouse;

	public MenuUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUser.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

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
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(50, 58, 150, 150);
		Load.image(lblLogo, "/imagenes/aH-150px.png");
		panelMenu.add(lblLogo);

		JPanel btnRegisterReservation = new JPanel();
		btnRegisterReservation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegisterReservation.setBackground(new Color(118, 187, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegisterReservation.setBackground(new Color(12, 138, 199));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				RegisterGuest registro = new RegisterGuest();
				registro.setVisible(true);
				dispose();
			}
		});
		btnRegisterReservation.setBounds(0, 255, 257, 56);
		btnRegisterReservation.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegisterReservation);
		btnRegisterReservation.setLayout(null);
		
		JLabel lblRegister = new JLabel("Registro de reservas");
		Load.image(lblRegister, "/imagenes/reservado.png");
		lblRegister.setForeground(SystemColor.text);
		lblRegister.setBounds(25, 11, 205, 34);
		lblRegister.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegisterReservation.add(lblRegister);
		
		JPanel btnSearch = new JPanel();
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setBackground(new Color(118, 187, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setBackground(new Color(12, 138, 199));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnSearch.setBounds(0, 312, 257, 56);
		btnSearch.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnSearch);
		btnSearch.setLayout(null);
		
		JLabel lblSearch = new JLabel("Búsqueda");
		Load.image(lblSearch, "/imagenes/pessoas.png");
		lblSearch.setBounds(27, 11, 200, 34);
		lblSearch.setHorizontalAlignment(SwingConstants.LEFT);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnSearch.add(lblSearch);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		
		JPanel panelBack = new JPanel();
		panelBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBack.setBounds(182, 517, 45, 40);
		panelMenu.add(panelBack);
		
		JLabel lblBack = new JLabel();
		Load.image(lblBack, "/imagenes/cerrar-sesion 32-px.png");
		panelBack.add(lblBack);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		
		JPanel btnExit = new JPanel();
		btnExit.setLayout(null);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(891, 0, 53, 36);
		header.add(btnExit);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		btnExit.add(lblExit);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));

		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				lblExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.white);
				lblExit.setForeground(Color.black);
			}
		});
		
	    JPanel panelHeadboard = new JPanel();
	    panelHeadboard.setBackground(new Color(118, 187, 223));
	    panelHeadboard.setBounds(256, 84, 688, 121);
	    contentPane.add(panelHeadboard);
	    panelHeadboard.setLayout(null);
	    
	    JLabel lblTitle = new JLabel("Sistema de reservas Hotel Alura");
	    lblTitle.setBounds(180, 11, 356, 42);
	    lblTitle.setForeground(Color.WHITE);
	    lblTitle.setFont(new Font("Roboto", Font.PLAIN, 24));
	    panelHeadboard.add(lblTitle);

	    JLabel lblDate = new JLabel();
	    lblDate.setBounds(35, 64, 294, 36);
	    lblDate.setForeground(Color.WHITE);
	    lblDate.setFont(new Font("Roboto", Font.PLAIN, 33));

	    Date fechaActual = new Date(); //fecha y hora actual
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
	    lblDate.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha
	    panelHeadboard.add(lblDate);

	    JLabel lblWelcome = new JLabel("Bienvenido");
	    lblWelcome.setFont(new Font("Roboto", Font.BOLD, 24));
	    lblWelcome.setBounds(302, 234, 147, 46);
	    contentPane.add(lblWelcome);
	    
	    String description = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil <br> el flujo de reservas y de huespédes del hotel   </body></html>";
	    JLabel lblDescription = new JLabel(description);
	    lblDescription.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescription.setBounds(312, 291, 598, 66);
	    contentPane.add(lblDescription);
	    
	    String descriptionTwo = "<html><body> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas específicas como lo son:</body></html>";
	    JLabel lblDescriptionTwo = new JLabel(descriptionTwo);
	    lblDescriptionTwo.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescriptionTwo.setBounds(311, 345, 569, 88);
	    contentPane.add(lblDescriptionTwo);
	    
	    contentPane.add(addLabel("- Registro de Reservas y Huéspedes", 312, 444, 295, 27));
	    
	    contentPane.add(addLabel("- Edición de Reservas y Huéspedes existentes", 312, 482, 355, 27));
	    
	    contentPane.add(addLabel("- Eliminar todo tipo de registros", 312, 520, 295, 27));
	}

	private JLabel addLabel(String content, int x, int y, int widht, int height) {
		JLabel label = new JLabel(content);
		label.setFont(new Font("Roboto", Font.PLAIN, 17));
		label.setBounds(x, y, widht, height);
		return label;
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
}

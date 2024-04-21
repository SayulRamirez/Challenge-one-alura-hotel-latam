package com.alura.hotel.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;

import com.alura.hotel.controller.HuespedController;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Load;
import com.alura.hotel.utils.Separator;
import com.alura.hotel.validaciones.VRegistroHueUser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class RegisterGuest extends JFrame {

	private final JTextField txtName;
	private final JTextField txtLastname;
	private final JTextField txtTelefono;
	private final JComboBox<String> comboNationality;
	private int xMouse, yMouse;

	public RegisterGuest() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterGuest.class.getResource("/imagenes/lOGO-50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnBack = new JPanel();

		JLabel labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setForeground(Color.WHITE);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnBack.add(labelAtras);
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUser menuUser = new MenuUser();
				menuUser.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnBack.setBackground(new Color(12, 138, 199));
			     labelAtras.setForeground(Color.white);
			}
		});
		btnBack.setLayout(null);
		btnBack.setBackground(new Color(12, 138, 199));
		btnBack.setBounds(0, 0, 53, 36);
		header.add(btnBack);
		
		txtName = loadTextField(560, 135, 285, 33);
		contentPane.add(txtName);
		
		txtLastname = loadTextField(560, 204, 285, 33);
		contentPane.add(txtLastname);
		
		JDateChooser txtBirth = new JDateChooser();
		txtBirth.setBounds(560, 278, 285, 36);
		Load.image(txtBirth, "/imagenes/icon-reservas.png");
		txtBirth.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtBirth.setDateFormatString("yyyy-MM-dd");
		contentPane.add(txtBirth);
		
		comboNationality = new JComboBox<>();
		comboNationality.setBounds(560, 350, 289, 36);
		comboNationality.setBackground(SystemColor.text);
		comboNationality.setFont(new Font("Roboto", Font.PLAIN, 16));
		Load.countries(comboNationality);
		contentPane.add(comboNationality);
		
		contentPane.add(addLabel("NOMBRE", 562, 119, 253, 14));
		
		contentPane.add(addLabel("APELLIDO", 560, 189, 255, 14));
		
		contentPane.add(addLabel("FECHA DE NACIMIENTO", 560, 256, 255, 14));
		
		contentPane.add(addLabel("NACIONALIDAD", 560, 326, 255, 14));
		
		contentPane.add(addLabel("TELÉFONO", 562, 406, 253, 14));
		
		txtTelefono = loadTextField(560 ,424, 285, 33);
		contentPane.add(txtTelefono);
		
		JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
		lblTitulo.setBounds(591, 55, 244, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
		contentPane.add(lblTitulo);

		contentPane.add(Separator.addSeparator(560, 170, 289, 2)); //NAME

		contentPane.add(Separator.addSeparator(560, 240, 289, 2)); //LASTNAME

		contentPane.add(Separator.addSeparator(560, 314, 289, 2)); //BIRHTDATE

		contentPane.add(Separator.addSeparator(560, 386, 289, 2)); //NATIONALITY

		contentPane.add(Separator.addSeparator(560, 457, 289, 2)); //PHONE

		JPanel btnNext = new JPanel();
		btnNext.setBounds(723, 560, 122, 35);
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

				String nombre = txtName.getText();
				String apellido = txtLastname.getText();
				String nacimiento = formato.format(txtBirth.getDate());
				String tel = txtTelefono.getText();

				VRegistroHueUser.validarCampos(nombre, apellido, nacimiento, tel);

				VRegistroHueUser.isMayorDeEdad(nacimiento);

				VRegistroHueUser.esNumero(tel);

				Huesped huesped = new Huesped(nombre,
						apellido,
						nacimiento,
						comboNationality.getSelectedItem().toString(),
						tel,
						Login.usuario.getId()
				);
					
				HuespedController huespedController = new HuespedController();
				int idHuesped = huespedController.registrarHuesped(huesped);

				RegisterReservation reservas = new RegisterReservation(idHuesped);
				reservas.setVisible(true);
				dispose();
			}
		});
		btnNext.setLayout(null);
		btnNext.setBackground(new Color(12, 138, 199));
		btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNext);

		JLabel lblNext = new JLabel("SIGUIENTE");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setForeground(Color.WHITE);
		lblNext.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNext.setBounds(0, 0, 122, 35);
		btnNext.add(lblNext);
		
		JPanel panelBanner = new JPanel();
		panelBanner.setBounds(0, 0, 489, 634);
		panelBanner.setBackground(new Color(12, 138, 199));
		panelBanner.setLayout(null);
		contentPane.add(panelBanner);

		JLabel backgroundImage = new JLabel();
		backgroundImage.setBounds(0, 121, 479, 502);
		Load.image(backgroundImage, "/imagenes/registro.png");
		panelBanner.add(backgroundImage);

		panelBanner.add(Label.addLogo(194, 39, 104, 107));

		JPanel btnExit = new JPanel();
		btnExit.setBounds(857, 0, 53, 36);
		btnExit.setLayout(null);
		btnExit.setBackground(Color.white);

		JLabel labelExit = Label.addLabelExit(53, 36);
		btnExit.add(labelExit);

		header.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu principal = new MainMenu();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnExit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
	}
	
	private JTextField loadTextField(int x, int y, int width, int height) {
		JTextField field = new JTextField();
		field.setFont(new Font("Roboto", Font.PLAIN, 16));
		field.setBounds(x, y, width, height);
		field.setBackground(Color.WHITE);
		field.setColumns(10);
		field.setBorder(BorderFactory.createEmptyBorder());
		
		return field;
	}

	private JLabel addLabel(String content, int x, int y, int width, int height) {
		JLabel label = new JLabel(content);
		label.setBounds(x, y, width, height);
		label.setForeground(SystemColor.textInactiveText);
		label.setFont(new Font("Roboto Black", Font.PLAIN, 18));
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
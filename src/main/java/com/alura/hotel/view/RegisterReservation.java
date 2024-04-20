
package com.alura.hotel.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import com.alura.hotel.controller.ReservacionController;
import com.alura.hotel.modelo.Reservacion;
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Load;
import com.alura.hotel.utils.Separator;
import com.alura.hotel.validaciones.VFechaReservacion;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.math.BigDecimal;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ReservasView extends JFrame {
	private final JTextField txtAmount;
	private final JDateChooser chooserCheckIn;
	private final JDateChooser chooserCheckOut;
	private final JComboBox<String> comboPaymentMethod;
	private int xMouse, yMouse;

	public ReservasView(int idHuesped) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel basePanel = new JPanel();
		basePanel.setBorder(null);
		basePanel.setBackground(Color.WHITE);
		basePanel.setBounds(0, 0, 910, 560);
		basePanel.setLayout(null);
		setContentPane(basePanel);

		basePanel.add(Separator.addSeparator(68, 195, 289, 2)); //CHECK IN

		basePanel.add(Separator.addSeparator(68, 453, 289, 2)); //CHECK OUT

		basePanel.add(Separator.addSeparator(68, 281, 289, 2)); //PAYMENT

		basePanel.add(Separator.addSeparator(68, 362, 289, 2)); //VALUE
		
		basePanel.add(Label.addLabel("SISTEMA DE RESERVAS",95, 60, 245, 42));

		basePanel.add(Label.addLabel("FECHA DE CHECK IN", 68, 136, 200, 16));

		basePanel.add(Label.addLabel("FECHA DE CHECK OUT", 68, 221, 217, 16));

		basePanel.add(Label.addLabel("FORMA DE PAGO", 68, 382, 187, 24));

		basePanel.add(Label.addLabel("VALOR DE LA RESERVA", 72, 303, 217, 16));

		JPanel panelBanner = new JPanel();
		panelBanner.setBounds(428, 0, 482, 560);
		panelBanner.setBackground(new Color(12, 138, 199));
		panelBanner.setLayout(null);
		basePanel.add(panelBanner);

		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(197, 68, 104, 107);
		Load.image(lblLogo, "/imagenes/Ha-100px.png");
		panelBanner.add(lblLogo);

		JLabel backgroundImage = new JLabel();
		backgroundImage.setBounds(0, 140, 500, 409);
		Load.image(backgroundImage, "/imagenes/reservas-img-3.png");
		panelBanner.add(backgroundImage);
												
		JPanel btnExit = new JPanel();

		JLabel labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));

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
				 btnExit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setBounds(429, 0, 53, 36);
		panelBanner.add(btnExit);
		
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
		header.setBackground(Color.WHITE);
		basePanel.add(header);
		
		JPanel btnBack = new JPanel();

		JLabel lblBack = new JLabel("<");
		lblBack.setBounds(0, 0, 53, 36);
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setFont(new Font("Roboto", Font.PLAIN, 23));
		btnBack.add(lblBack);

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RegisterGuest registerGuest = new RegisterGuest();
				registerGuest.setVisible(true);
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

		JLabel lblReserve = new JLabel("RESERVAR");
		lblReserve.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserve.setForeground(Color.WHITE);
		lblReserve.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblReserve.setBounds(0, 0, 122, 35);

		txtAmount = new JTextField();
		txtAmount.setBackground(SystemColor.text);
		txtAmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmount.setForeground(Color.BLACK);
		txtAmount.setBounds(78, 328, 43, 33);
		txtAmount.setEditable(false);
		txtAmount.setFont(new Font("Roboto Black", Font.BOLD, 17));
		txtAmount.setBorder(BorderFactory.createEmptyBorder());
		txtAmount.setColumns(10);
		basePanel.add(txtAmount);
		
		chooserCheckIn = addDateChooser(161);
		basePanel.add(chooserCheckIn);

		chooserCheckOut =  addDateChooser(246);
		basePanel.add(chooserCheckOut);
		chooserCheckOut.addPropertyChangeListener(evt -> {

            if (chooserCheckIn.getDate() != null && chooserCheckOut.getDate() != null) {
				Date startDate = chooserCheckIn.getDate();
				Date lastDate = chooserCheckOut.getDate();

				if(startDate.before(lastDate)) {
					BigDecimal valorFinal = calculateAmount(startDate, lastDate);
					txtAmount.setText(valorFinal.toString());
					return;
				}

				txtAmount.setText("");
			}
        });

		comboPaymentMethod = new JComboBox<>();
		comboPaymentMethod.setBounds(68, 417, 289, 38);
		comboPaymentMethod.setBackground(SystemColor.text);
		comboPaymentMethod.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		comboPaymentMethod.setFont(new Font("Roboto", Font.PLAIN, 16));
		comboPaymentMethod.setModel(new DefaultComboBoxModel<>(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		basePanel.add(comboPaymentMethod);

		JPanel btnFinish = new JPanel();

		JLabel lblFinish = new JLabel("SIGUIENTE");
		lblFinish.setBounds(0, 0, 122, 35);
		lblFinish.setForeground(new Color(250, 250, 250));
		lblFinish.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinish.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnFinish.add(lblFinish);

		btnFinish.setBounds(238, 493, 122, 35);
		btnFinish.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

				String fFechaEntrada = formato.format(chooserCheckIn.getDate());
				String fFechaSalida = formato.format(chooserCheckOut.getDate());

				VFechaReservacion.isNull(fFechaEntrada, fFechaSalida);

				VFechaReservacion.validarFechas(fFechaEntrada, fFechaSalida);

				Reservacion reservacion = new Reservacion(
						fFechaEntrada,
						fFechaSalida,
						txtAmount.getText(),
						comboPaymentMethod.getSelectedItem().toString(),
						idHuesped);

				ReservacionController reservaController = new ReservacionController();

				int idReservacion = reservaController.registrarReservacion(reservacion);

				Exito exito = new Exito(idReservacion);
				exito.setVisible(true);
				dispose();
			}
		});
		btnFinish.setLayout(null);
		btnFinish.setBackground(SystemColor.textHighlight);
		btnFinish.setCursor(new Cursor(Cursor.HAND_CURSOR));
		basePanel.add(btnFinish);
	}

	private JDateChooser addDateChooser(int positionY) {
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(SystemColor.textHighlight);
		dateChooser.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		dateChooser.setBounds(68, positionY, 289, 35);
		dateChooser.getCalendarButton().setBounds(267, 1, 21, 31);
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBorder(new LineBorder(SystemColor.window));
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setFont(new Font("Roboto", Font.PLAIN, 18));

		Load.image(dateChooser, "/imagenes/icon-reservas.png");

		return dateChooser;
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

	private BigDecimal calculateAmount(Date startDate, Date lastDate) {
		long result = lastDate.getTime() - startDate.getTime();
		TimeUnit time = TimeUnit.DAYS;

		long duration = time.convert(result, TimeUnit.MILLISECONDS);

		double valor = 300;
		return new BigDecimal (duration * valor);
	}
}
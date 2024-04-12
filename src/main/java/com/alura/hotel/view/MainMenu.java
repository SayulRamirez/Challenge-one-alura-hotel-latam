package com.alura.hotel.view;

import com.alura.hotel.utils.Load;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class MainMenu extends JFrame {

	private final JLabel lblClose;
	private int xMouse, yMouse;

	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 910, 537);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		Panel panelBottom = new Panel();
		panelBottom.setBackground(SystemColor.window);
		panelBottom.setBounds(0, 0, 910, 537);
		contentPane.add(panelBottom);
		panelBottom.setLayout(null);
		
		JLabel backgroundImage = new JLabel();
		backgroundImage.setBounds(-50, 0, 732, 501);
		Load.image(backgroundImage, "/imagenes/menu-img.png");
		panelBottom.add(backgroundImage);
		
		JLabel logo = new JLabel();
		logo.setBounds(722, 80, 150, 156);
		Load.image(logo, "/imagenes/aH-150px.png");
		panelBottom.add(logo);
		
		JPanel panelFoot = new JPanel();
		panelFoot.setBounds(0, 500, 910, 37);
		panelFoot.setBackground(new Color(12, 138, 199));
		panelBottom.add(panelFoot);
		panelFoot.setLayout(null);
		
		JLabel lblCopyright = new JLabel("Desarrollado por Saúl Ramírez © 2023");
		lblCopyright.setBounds(315, 11, 284, 19);
		lblCopyright.setForeground(new Color(240, 248, 255));
		lblCopyright.setFont(new Font("Roboto", Font.PLAIN, 16));
		panelFoot.add(lblCopyright);
		
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
		panelBottom.add(header);

		JPanel btnClose = createButtonExit();
		header.add(btnClose);
		
		lblClose = new JLabel("X");
		lblClose.setBounds(0, 0, 53, 36);
		btnClose.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnLogin = new JPanel();
		btnLogin.setBounds(754, 300, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		panelBottom.add(btnLogin);
		
		JLabel lblLoginImage = new JLabel();
		lblLoginImage.setBounds(0, 0, 80, 70);
		btnLogin.add(lblLoginImage);
		lblLoginImage.setHorizontalAlignment(SwingConstants.CENTER);
		Load.image(lblLoginImage, "/imagenes/login.png");

		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setBounds(754, 265, 83, 24);
		lblTitle.setBackground(SystemColor.window);
		panelBottom.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		
		JPanel btnExit = new JPanel();
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.setBounds(836, 444, 55, 50);
		panelBottom.add(btnExit);
		btnExit.setLayout(null);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
		});
		
		JLabel lblExit = new JLabel();
		lblExit.setBounds(5, 5, 45, 40);
		Load.image(lblExit, "/imagenes/cerrar-sesion 32-px.png");
		btnExit.add(lblExit);
	}

	private JPanel createButtonExit() {
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(Color.red);
				lblClose.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 panel.setBackground(Color.white);
			     lblClose.setForeground(Color.black);
			}
		});
		panel.setLayout(null);
		panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel.setBackground(Color.WHITE);
		panel.setBounds(857, 0, 53, 36);
		return panel;
	}

	private void headerMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
	}
    
    private void exit() {
		int option = JOptionPane.showConfirmDialog(this, "¿Realmente deseas salir de la aplicación?", "Salir", JOptionPane.YES_NO_OPTION);
		
		if(option == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
    }
}
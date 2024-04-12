package com.alura.hotel.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.alura.hotel.controller.UserController;
import com.alura.hotel.modelo.Usuario;
import com.alura.hotel.utils.Load;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class Login extends JFrame {

	private final JTextField txtUsuario;

	private final JPasswordField txtPassword;

	int xMouse, yMouse;

	public static Usuario usuario;

	
	public Login() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		setLocationRelativeTo(null);

		JPanel panelBottom = new JPanel();
		panelBottom.setBounds(0, 0, 788, 527);
		panelBottom.setBackground(Color.WHITE);
		setContentPane(panelBottom);
		panelBottom.setLayout(null);
		
		JPanel panelImage = new JPanel();
		panelImage.setBackground(new Color(12, 138, 199));
		panelImage.setBounds(484, 0, 304, 527);
		panelBottom.add(panelImage);
		panelImage.setLayout(null);
		
		JLabel lblHotel = new JLabel();
		lblHotel.setBounds(0, 0, 304, 538);
		panelImage.add(lblHotel);
		Load.image(lblHotel, "/imagenes/img-hotel-login-.png");

		JLabel lblQuestion = new JLabel("¿AUN NO TE HAZ REGISTRADO?");
		lblQuestion.setForeground(SystemColor.controlLtHighlight);
		lblQuestion.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblQuestion.setBounds(25, 50, 280, 26);
		panelImage.add(lblQuestion);

		JPanel panelRegister = new JPanel();
		panelRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelRegister.setBackground(new Color(0, 156, 223));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panelRegister.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				registerUser();
			}
		});
		panelRegister.setBackground(SystemColor.textHighlight);
		panelRegister.setBounds(50, 90, 200, 44);
		panelImage.add(panelRegister);
		panelRegister.setLayout(null);
		panelRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel lblRegister = new JLabel("NUEVO USUARIO");
		lblRegister.setBounds(0, 0, 200, 44);
		panelRegister.add(lblRegister);
		lblRegister.setForeground(SystemColor.controlLtHighlight);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setFont(new Font("Roboto", Font.PLAIN, 18));

		JLabel labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		labelExit.setForeground(SystemColor.text);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel btnClose = new JPanel();
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClose.setBounds(251, 0, 53, 36);
		panelImage.add(btnClose);
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnClose.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnClose.setBackground(new Color(12, 138, 199));
		btnClose.setLayout(null);
		btnClose.add(labelExit);

		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
					 txtUsuario.setText("");
					 txtUsuario.setForeground(Color.black);
			        }
			        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			        	txtPassword.setText("********");
			        	txtPassword.setForeground(Color.gray);
			        }
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBorder(BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		panelBottom.add(txtUsuario);
		txtUsuario.setColumns(10);

		addSeparator(panelBottom, 45, 292);

		JLabel lblTitle = new JLabel("INICIAR SESIÓN");
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		lblTitle.setBounds(65, 149, 202, 26);
		panelBottom.add(lblTitle);

		addSeparator(panelBottom, 65, 393);

		txtPassword = new JPasswordField();
		txtPassword.setText("********");
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPassword.getPassword()).equals("********")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
		        }

		        if (txtUsuario.getText().isEmpty()) {
		        	txtUsuario.setText("Ingrese su nombre de usuario");
		        	txtUsuario.setForeground(Color.gray);
		        }
			}
		});
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPassword.setBorder(BorderFactory.createEmptyBorder());
		txtPassword.setBounds(65, 353, 324, 32);
		panelBottom.add(txtPassword);
		
		JLabel lblUser = new JLabel("USUARIO");
		lblUser.setForeground(SystemColor.textInactiveText);
		lblUser.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblUser.setBounds(65, 219, 107, 26);
		panelBottom.add(lblUser);
		
		JLabel lblPassword = new JLabel("CONTRASEÑA");
		lblPassword.setForeground(SystemColor.textInactiveText);
		lblPassword.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblPassword.setBounds(65, 316, 140, 26);
		panelBottom.add(lblPassword);
		
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				login();
			}
		});
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		panelBottom.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JLabel lblEnter = new JLabel("ENTRAR");
		lblEnter.setBounds(0, 0, 122, 44);
		btnLogin.add(lblEnter);
		lblEnter.setForeground(SystemColor.controlLtHighlight);
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel lblLogo = new JLabel();
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Load.image(lblLogo, "/imagenes/lOGO-50PX.png");
		lblLogo.setBounds(65, 65, 48, 59);
		panelBottom.add(lblLogo);
		
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 784, 36);
		panelBottom.add(header);
		header.setLayout(null);
		
		JPanel btnReturnMain = new JPanel();
		btnReturnMain.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReturnMain.setBounds(370, 431, 48, 44);
		panelBottom.add(btnReturnMain);
		btnReturnMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblReturn = new JLabel();
		Load.image(lblReturn, "/imagenes/cerrar-sesion 32-px.png");
		btnReturnMain.add(lblReturn);
	}

	private void addSeparator(JPanel panel, int x, int y) {
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(x, y, 324, 2);
		panel.add(separator);
	}

	private void registerUser() {
		RegisterUser register = new RegisterUser();
		register.setVisible(true);
		dispose();
	}

	/**
	 * Entra al menu principal autenticando al usuario.
	 */
	private void login() {
	        
	        usuario = new Usuario(txtUsuario.getText(), new String (txtPassword.getPassword()));
	        
	        UserController userController = new UserController();
	        
	        if(userController.autenticar(usuario)){

	            MenuUsuario menu = new MenuUsuario();
	            menu.setVisible(true);
	            dispose();	 
	            
	        }else {
	            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
			}
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


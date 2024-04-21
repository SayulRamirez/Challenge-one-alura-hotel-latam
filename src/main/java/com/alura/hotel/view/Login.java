package com.alura.hotel.view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.alura.hotel.controller.UserController;
import com.alura.hotel.modelo.Usuario;
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Load;
import com.alura.hotel.utils.Panel;
import com.alura.hotel.utils.Separator;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;

public class Login extends JFrame {

	private final JTextField txtUser;

	private final JPasswordField txtPassword;

	private int xMouse, yMouse;

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
		panelBottom.setLayout(null);
		setContentPane(panelBottom);

		JPanel panelImage = new JPanel();
		panelImage.setBackground(new Color(12, 138, 199));
		panelImage.setBounds(484, 0, 304, 527);
		panelImage.setLayout(null);
		panelBottom.add(panelImage);

		JLabel lblHotel = new JLabel();
		lblHotel.setBounds(0, 0, 304, 538);
		Load.image(lblHotel, "/imagenes/img-hotel-login-.png");
		panelImage.add(lblHotel);

		JLabel lblQuestion = new JLabel("¿AUN NO TE HAZ REGISTRADO?");
		lblQuestion.setForeground(SystemColor.controlLtHighlight);
		lblQuestion.setFont(new Font("Roboto Black", Font.PLAIN, 17));
		lblQuestion.setBounds(25, 50, 280, 26);
		panelImage.add(lblQuestion);

		JPanel panelRegister = Panel.addPanel("NUEVO USUARIO", 50, 90, 200, 44);
		panelImage.add(panelRegister);
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


		JPanel btnClose = new JPanel();
		btnClose.setLayout(null);
		btnClose.setBackground(new Color(12, 138, 199));
		btnClose.setBounds(251, 0, 53, 36);
		btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));

		JLabel labelExit = Label.addLabelExit(53, 36);
		btnClose.add(labelExit);
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

		txtUser = new JTextField();
		txtUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
					 txtUser.setText("");
					 txtUser.setForeground(Color.black);
			        }
			        if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			        	txtPassword.setText("********");
			        	txtPassword.setForeground(Color.gray);
			        }
			}
		});
		txtUser.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUser.setText("Ingrese su nombre de usuario");
		txtUser.setBorder(BorderFactory.createEmptyBorder());
		txtUser.setForeground(SystemColor.activeCaptionBorder);
		txtUser.setBounds(65, 256, 324, 32);
		panelBottom.add(txtUser);
		txtUser.setColumns(10);

		panelBottom.add(Separator.addSeparator(65, 292, 324, 2)); // USER

		JLabel lblTitle = new JLabel("INICIAR SESIÓN");
		lblTitle.setBounds(65, 149, 202, 26);
		lblTitle.setForeground(SystemColor.textHighlight);
		lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		panelBottom.add(lblTitle);

		panelBottom.add(Separator.addSeparator(65, 393, 324, 2)); // PASSWORD

		txtPassword = new JPasswordField();
		txtPassword.setText("********");
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (String.valueOf(txtPassword.getPassword()).equals("********")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
		        }

		        if (txtUser.getText().isEmpty()) {
		        	txtUser.setText("Ingrese su nombre de usuario");
		        	txtUser.setForeground(Color.gray);
		        }
			}
		});
		txtPassword.setForeground(SystemColor.activeCaptionBorder);
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtPassword.setBorder(BorderFactory.createEmptyBorder());
		txtPassword.setBounds(65, 353, 324, 32);
		panelBottom.add(txtPassword);
		
		JLabel lblUser = Label.addLabel("USUARIO", 65, 219, 107, 26);
		panelBottom.add(lblUser);
		
		JLabel lblPassword = Label.addLabel("CONTRASEÑA",65, 316, 140, 26);
		panelBottom.add(lblPassword);
		
		JPanel btnLogin = Panel.addPanel("ENTRAR", 65, 431, 122, 44);
		panelBottom.add(btnLogin);
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
		header.setLayout(null);
		panelBottom.add(header);

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

	private void registerUser() {
		UserInformationForm register = new UserInformationForm();
		register.setVisible(true);
		dispose();
	}

	private void login() {
	        
	        usuario = new Usuario(txtUser.getText(), new String (txtPassword.getPassword()));
	        
	        UserController userController = new UserController();
	        
	        if(userController.autenticar(usuario)){

	            MenuUser menu = new MenuUser();
	            menu.setVisible(true);
	            dispose();	 
	            
	        }else {
	            JOptionPane.showMessageDialog(this, "Usuario o Contraseña no válidos");
			}
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
}


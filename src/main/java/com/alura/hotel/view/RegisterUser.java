package com.alura.hotel.view;

import com.alura.hotel.controller.NewUsuarioController;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Usuario;
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Load;
import com.alura.hotel.utils.Panel;
import com.alura.hotel.utils.Separator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterUser extends JFrame{

    private final JTextField txtUser;
    private final JPasswordField txtPassword;
    private int xMouse, yMouse;
    private final JLabel labelExit;

    public RegisterUser(Huesped huesped) {
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 484, 527);
        setLocationRelativeTo(null);

        JPanel panelBottom = new JPanel();
        panelBottom.setBounds(0, 0, 484, 527);
        panelBottom.setBackground(Color.WHITE);
        setContentPane(panelBottom);
        panelBottom.setLayout(null);

        JPanel btnExit = new JPanel();

        labelExit = Label.addLabelExit(53, 36);
        btnExit.add(labelExit);

        btnExit.setBackground(new Color(240, 240, 240));
        btnExit.setLayout(null);
        btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExit.setBounds(431, 0, 53, 36);
        panelBottom.add(btnExit);
        btnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnExit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnExit.setBackground(new Color(240, 240, 240));
                labelExit.setForeground(Color.black);
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

        panelBottom.add(Separator.addSeparator(65, 292, 324, 2)); //User

        JLabel labelTitulo = new JLabel("CREAR USUARIO");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        labelTitulo.setBounds(65, 149, 222, 26);
        panelBottom.add(labelTitulo);

        panelBottom.add(Separator.addSeparator(65, 393, 324, 2)); //Password

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

        panelBottom.add(Label.addLabel("USUARIO", 65, 219, 107, 26));

        panelBottom.add(Label.addLabel("CONTRASEÑA", 65, 316, 140, 26));

        JPanel btnRegisterUser = Panel.addPanel("CREAR",65, 431, 122, 44);
        panelBottom.add(btnRegisterUser);
        btnRegisterUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnRegisterUser.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRegisterUser.setBackground(SystemColor.textHighlight);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crearUsuario(huesped);
            }
        });

        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setBounds(65, 65, 48, 59);
        Load.image(lblLogo, "/imagenes/lOGO-50PX.png");
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

        JPanel btnCancelRegister = Panel.addPanel("CANCELAR", 297, 431, 122, 44);
        panelBottom.add(btnCancelRegister);
        btnCancelRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCancelRegister.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCancelRegister.setBackground(SystemColor.textHighlight);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                UserInformationForm registroUsuario = new UserInformationForm();
                registroUsuario.setVisible(true);
                dispose();
            }
        });
    }

    /**
     * Crea un nuevo usuario.
     */
    private void crearUsuario(Huesped huesped) {

        Usuario user = new Usuario(txtUser.getText(), new String (txtPassword.getPassword()));

        NewUsuarioController nUsuarioC = new NewUsuarioController();

        nUsuarioC.createNewUser(user, huesped);

        JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
        Login login = new Login();
        login.setVisible(true);
        dispose();
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

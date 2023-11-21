package com.alura.hotel.view;

import com.alura.hotel.controller.NewUsuarioController;
import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.modelo.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CrearUsuario extends JFrame{
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private int xMouse, yMouse;
    private JLabel labelExit;
    private Huesped dataNewHuesped;
    private Usuario usuarioNew;

    /**
     * Create the frame.
     */

    public CrearUsuario(Huesped dataNewHuesped) {
        this.dataNewHuesped = dataNewHuesped;
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 484, 527);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 484, 527);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel btnexit = new JPanel();
        btnexit.setBounds(431, 0, 53, 36);
        panel.add(btnexit);
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnexit.setBackground(Color.red);
                labelExit.setForeground(Color.white);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnexit.setBackground(new Color(240, 240, 240));
                labelExit.setForeground(Color.black);
            }
        });
        btnexit.setBackground(new Color(240, 240, 240));
        btnexit.setLayout(null);
        btnexit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelExit = new JLabel("X");
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);
        labelExit.setForeground(SystemColor.black);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);

        txtUsuario = new JTextField();
        txtUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (txtUsuario.getText().equals("Ingrese su nombre de usuario")) {
                    txtUsuario.setText("");
                    txtUsuario.setForeground(Color.black);
                }
                if (String.valueOf(txtContrasena.getPassword()).isEmpty()) {
                    txtContrasena.setText("********");
                    txtContrasena.setForeground(Color.gray);
                }
            }
        });
        txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtUsuario.setText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtUsuario.setForeground(SystemColor.activeCaptionBorder);
        txtUsuario.setBounds(65, 256, 324, 32);
        panel.add(txtUsuario);
        txtUsuario.setColumns(10);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 120, 215));
        separator.setBounds(65, 292, 324, 2);
        panel.add(separator);

        JLabel labelTitulo = new JLabel("CREAR USUARIO");
        labelTitulo.setForeground(SystemColor.textHighlight);
        labelTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
        labelTitulo.setBounds(65, 149, 222, 26);
        panel.add(labelTitulo);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(SystemColor.textHighlight);
        separator_1.setBounds(65, 393, 324, 2);
        panel.add(separator_1);

        txtContrasena = new JPasswordField();
        txtContrasena.setText("********");
        txtContrasena.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (String.valueOf(txtContrasena.getPassword()).equals("********")) {
                    txtContrasena.setText("");
                    txtContrasena.setForeground(Color.black);
                }
                if (txtUsuario.getText().isEmpty()) {
                    txtUsuario.setText("Ingrese su nombre de usuario");
                    txtUsuario.setForeground(Color.gray);
                }
            }
        });
        txtContrasena.setForeground(SystemColor.activeCaptionBorder);
        txtContrasena.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtContrasena.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtContrasena.setBounds(65, 353, 324, 32);
        panel.add(txtContrasena);

        JLabel LabelUsuario = new JLabel("USUARIO");
        LabelUsuario.setForeground(SystemColor.textInactiveText);
        LabelUsuario.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        LabelUsuario.setBounds(65, 219, 107, 26);
        panel.add(LabelUsuario);

        JLabel lblContrasea = new JLabel("CONTRASEÑA");
        lblContrasea.setForeground(SystemColor.textInactiveText);
        lblContrasea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
        lblContrasea.setBounds(65, 316, 140, 26);
        panel.add(lblContrasea);

        JPanel btnCrearUsuario = new JPanel();
        btnCrearUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCrearUsuario.setBackground(new Color(0, 156, 223));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnCrearUsuario.setBackground(SystemColor.textHighlight);
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                crearUsuario();
            }
        });
        btnCrearUsuario.setBackground(SystemColor.textHighlight);
        btnCrearUsuario.setBounds(65, 431, 122, 44);
        panel.add(btnCrearUsuario);
        btnCrearUsuario.setLayout(null);
        btnCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel lblNewLabel = new JLabel("CREAR");
        lblNewLabel.setBounds(0, 0, 122, 44);
        btnCrearUsuario.add(lblNewLabel);
        lblNewLabel.setForeground(SystemColor.controlLtHighlight);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/lOGO-50PX.png")));
        lblNewLabel_1.setBounds(65, 65, 48, 59);
        panel.add(lblNewLabel_1);

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
        panel.add(header);
        header.setLayout(null);

        JPanel panelMenuRegistro = new JPanel();
        panel.add(panelMenuRegistro);
        panelMenuRegistro.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                MenuRegistroNuevoUsuario registroUsuario = new MenuRegistroNuevoUsuario();
                registroUsuario.setVisible(true);
                dispose();
            }
        });
        panelMenuRegistro.setBackground(SystemColor.textHighlight);
        panelMenuRegistro.setBounds(297, 431, 122, 44);
        panel.add(panelMenuRegistro);
        panelMenuRegistro.setLayout(null);
        panelMenuRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel lblRegreso = new JLabel("CANCELAR");
        lblRegreso.setBounds(0, 0, 122, 44);
        lblRegreso.setForeground(SystemColor.controlLtHighlight);
        lblRegreso.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegreso.setFont(new Font("Roboto", Font.PLAIN, 18));
        panelMenuRegistro.add(lblRegreso);
    }

    private void crearUsuario() {

        usuarioNew = new Usuario(txtUsuario.getText(),
                                 new String (txtContrasena.getPassword()));

        NewUsuarioController nUsuarioC = new NewUsuarioController();

        nUsuarioC.createNewUser(usuarioNew, dataNewHuesped);

        JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);

    }
}

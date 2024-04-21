package com.alura.hotel.view;

import com.alura.hotel.modelo.Huesped;
import com.alura.hotel.utils.Label;
import com.alura.hotel.utils.Load;
import com.alura.hotel.utils.Panel;
import com.alura.hotel.utils.Separator;
import com.alura.hotel.validaciones.VRegistroHueUser;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;

public class UserInformationForm extends JFrame{

    private final JTextField txtName;
    private final JTextField txtLastname;
    private final JTextField txtPhone;
    private final JDateChooser chooserDate;
    private final JComboBox<String> comboCountries;
    private int xMouse, yMouse;

    public UserInformationForm() {

        setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterGuest.class.getResource("/imagenes/lOGO-50PX.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.text);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);

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

        JLabel lblBack = addLabelBack();

        JPanel btnBack = new JPanel();
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnBack.setBackground(Color.white);
                lblBack.setForeground(Color.black);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnBack.setBackground(new Color(12, 138, 199));
                lblBack.setForeground(Color.white);
            }
        });
        btnBack.setLayout(null);
        btnBack.setBackground(new Color(12, 138, 199));
        btnBack.setBounds(0, 0, 53, 36);
        btnBack.add(lblBack);
        header.add(btnBack);

        txtName = addTextField(135);
        contentPane.add(txtName);

        txtLastname = addTextField(204);
        contentPane.add(txtLastname);

        chooserDate = new JDateChooser();
        chooserDate.setBounds(560, 298, 285, 36);
        Load.image(chooserDate, "/imagenes/icon-reservas.png");
        chooserDate.getCalendarButton().setBackground(SystemColor.textHighlight);
        chooserDate.setDateFormatString("yyyy-MM-dd");
        contentPane.add(chooserDate);

        comboCountries = new JComboBox<>();
        comboCountries.setBounds(560, 385, 289, 36);
        comboCountries.setBackground(SystemColor.text);
        comboCountries.setFont(new Font("Roboto", Font.PLAIN, 16));
        Load.countries(comboCountries);
        contentPane.add(comboCountries);

        contentPane.add(Label.addLabel("NOMBRE", 560, 114, 255, 20));

        contentPane.add(Label.addLabel("APELLIDO", 560, 184, 255, 20));

        contentPane.add(Label.addLabel("FECHA DE NACIMIENTO", 560, 266, 255, 20));

        contentPane.add(Label.addLabel("NACIONALIDAD", 560, 356, 255, 20));

        contentPane.add(Label.addLabel("TELÉFONO", 560, 441, 255, 20));

        txtPhone = addTextField(459);
        contentPane.add(txtPhone);

        JLabel lblTitle = new JLabel("REGISTRO USUARIO");
        lblTitle.setBounds(606, 55, 234, 42);
        lblTitle.setForeground(new Color(12, 138, 199));
        lblTitle.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitle);

        contentPane.add(Separator.addSeparator(560, 170, 289, 2)); //NAME

        contentPane.add(Separator.addSeparator(560, 240, 289, 2)); //Lastname

        contentPane.add(Separator.addSeparator(560, 334, 289, 2)); //Birthdate

        contentPane.add(Separator.addSeparator(560, 421, 289, 2)); //Nationality

        contentPane.add(Separator.addSeparator(560, 492, 289, 2)); //Phone

        JPanel btnNext = Panel.addPanel("SIGUIENTE", 723, 560, 122, 35);
        contentPane.add(btnNext);
        btnNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                String name = txtName.getText();
                String lastname = txtLastname.getText();
                String birthdate = format.format(chooserDate.getDate());
                String nation = (String) comboCountries.getSelectedItem();
                String phone = txtPhone.getText();

                VRegistroHueUser.validarCampos(name, lastname, birthdate, phone);

                VRegistroHueUser.isMayorDeEdad(birthdate);

                VRegistroHueUser.esNumero(phone);

                Huesped registerClient = new Huesped(name, lastname, birthdate, nation, phone);

                RegisterUser createUser = new RegisterUser(registerClient);
                createUser.setVisible(true);
                dispose();
            }
        });

        JPanel panelBanner = new JPanel();
        panelBanner.setBounds(0, 0, 489, 634);
        panelBanner.setBackground(new Color(12, 138, 199));
        contentPane.add(panelBanner);
        panelBanner.setLayout(null);

        JLabel lblBackgroundImage = new JLabel();
        lblBackgroundImage.setBounds(0, 121, 479, 502);
        panelBanner.add(lblBackgroundImage);
        Load.image(lblBackgroundImage, "/imagenes/registro.png");

        JLabel logo = new JLabel();
        logo.setBounds(194, 39, 104, 107);
        Load.image(logo, "/imagenes/Ha-100px.png");
        panelBanner.add(logo);
    }

    private JLabel addLabelBack() {
        JLabel label = new JLabel("<");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Roboto", Font.PLAIN, 23));
        label.setBounds(0, 0, 53, 36);

        return label;
    }

    private JTextField addTextField(int positionY) {
        JTextField field = new JTextField();
        field.setFont(new Font("Roboto", Font.PLAIN, 16));
        field.setBounds(560, positionY, 285, 33);
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createEmptyBorder());

        return field;
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

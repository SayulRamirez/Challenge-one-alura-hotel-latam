package com.alura.hotel.view;

import com.alura.hotel.utils.Label;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Success extends JDialog {

	public Success(int id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Success.class.getResource("/imagenes/aH-40px.png")));
		setBounds(100, 100, 394, 226);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		contentPanel.add(Label.addLogo(25, 26, 100, 100));

		contentPanel.add(addLabel("Datos guardados  ", 26, 22));
		
		contentPanel.add(addLabel("satisfactoriamente,", 51, 22));
		
		contentPanel.add(addLabel("número de reserva:", 76, 22));
		
		contentPanel.add(addLabel(Integer.toString(id), 101, 42));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		okButton.addActionListener(e -> {
            MenuUser usuario = new MenuUser();
            usuario.setVisible(true);
            dispose();
        });

		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	}

	private JLabel addLabel(String content, int y, int height) {
		JLabel label = new JLabel(content);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(152, y, 199, height);
		label.setForeground(new Color(12, 138, 199));
		label.setFont(new Font("Arial", Font.BOLD, 18));

		return label;
	}
}

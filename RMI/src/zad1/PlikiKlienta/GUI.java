package zad1.PlikiKlienta;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import javafx.scene.control.RadioButton;
import zad1.PlikiKlienta.Kontroler.ServiceLis;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class GUI {
	private String rad;
	private JFrame frmTelefonyTpoAutors;
	private JTextField imieWstaw;

	public JTextField getImieWstaw() {
		return imieWstaw;
	}

	public JTextField getTelefonWstaw() {
		return telefonWstaw;
	}

	private JTextField telefonWstaw;
	private JLabel labelWynik;
	private JButton btnWykonaj;
	private JRadioButton znajdzNumerR;
	private JRadioButton rdbtnZmieNrTelefonu;
	private JRadioButton radioDodaj;
	private ButtonGroup grupRadio;
	private JButton btnKoniec;

	public GUI() {
		initialize();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmTelefonyTpoAutors.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frmTelefonyTpoAutors = new JFrame();
		frmTelefonyTpoAutors.getContentPane().setFont(new Font("Verdana", Font.ITALIC, 14));
		frmTelefonyTpoAutors.getContentPane().setMinimumSize(new Dimension(20, 5));
		frmTelefonyTpoAutors.setTitle("TelefonyRMI TPO5 autor Sławomir Kobyliński");
		frmTelefonyTpoAutors.setBounds(100, 100, 550, 300);
		frmTelefonyTpoAutors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("Imie"), lblNewLabel_1 = new JLabel("NrTelefonu");
		imieWstaw = new JTextField();
		imieWstaw.setColumns(10);
		telefonWstaw = new JTextField();
		telefonWstaw.setColumns(10);
		radioDodaj = new JRadioButton("Dodaj nowy rekord");
		radioDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rad = arg0.getActionCommand();
			}
		});
		rdbtnZmieNrTelefonu = new JRadioButton("Zmień nr telefonu");
		rdbtnZmieNrTelefonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rad = arg0.getActionCommand();
			}
		});
		znajdzNumerR = new JRadioButton("Znajdz nr telefonu");
		znajdzNumerR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				rad = arg0.getActionCommand();
			}
		});
		btnWykonaj = new JButton("Wykonaj");
		grupRadio = new ButtonGroup();
		grupRadio.add(radioDodaj);
		radioDodaj.setSelected(true);
		rad = "Dodaj nowy rekord";
		grupRadio.add(rdbtnZmieNrTelefonu);
		grupRadio.add(znajdzNumerR);
		zaleznoscGrupRadio();
		labelWynik = new JLabel("");
		btnKoniec = new JButton("Zakończ");
		GroupLayout groupLayout = new GroupLayout(frmTelefonyTpoAutors.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addGap(7).addComponent(imieWstaw))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnWykonaj)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnKoniec))
										.addComponent(telefonWstaw, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
										.addComponent(labelWynik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))))
				.addGap(15).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnZmieNrTelefonu).addComponent(radioDodaj).addComponent(znajdzNumerR))
				.addContainerGap(58, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
								.addComponent(imieWstaw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(radioDodaj))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblNewLabel_1)
												.addComponent(telefonWstaw, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout
										.createSequentialGroup().addGap(3).addComponent(rdbtnZmieNrTelefonu)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(znajdzNumerR)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnWykonaj)
								.addComponent(btnKoniec))
						.addGap(27).addComponent(labelWynik).addContainerGap(108, Short.MAX_VALUE)));
		frmTelefonyTpoAutors.getContentPane().setLayout(groupLayout);
		this.btnKoniec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public void setImie(String s) {
		this.imieWstaw.setText(s);
	}

	public void setTelefon(String s) {
		this.telefonWstaw.setText(s);
	}

	private void zaleznoscGrupRadio() {
		if (!znajdzNumerR.isSelected())
			telefonWstaw.setEditable(true);
		else
			this.telefonWstaw.setEditable(false);
		frmTelefonyTpoAutors.repaint();
	}

	public String getImie() {
		return imieWstaw.getText();
	}

	public String getNr() {
		return this.telefonWstaw.getText();
	}

	public String getRadio() {
		return rad;
	}

	public void setOdpowiedz(String odp) {
		this.labelWynik.setText(odp);
	}

	public void inputData(ServiceLis serviceListener) {

		this.btnWykonaj.addActionListener(serviceListener);	
		frmTelefonyTpoAutors.repaint();

	}

}

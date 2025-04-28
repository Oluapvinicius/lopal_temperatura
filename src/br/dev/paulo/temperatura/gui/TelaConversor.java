package br.dev.paulo.temperatura.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.paulo.temperatura.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	private Font labels = new Font("arial", Font.PLAIN, 20);

	public void criarTelaConversor() {

		JFrame tela = new JFrame();

		// tamanho da tela
		tela.setSize(600, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Conversor");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

		// JLabel e o JTextField para o celsius
		labelCelsius = new JLabel();
		labelCelsius.setFont(labels);
		labelCelsius.setText("Digite o valor em celsius para converter");
		labelCelsius.setBounds(75, 30, 450, 50);

		textCelsius = new JTextField();
		textCelsius.setFont(labels);
		textCelsius.setBounds(75, 80, 450, 50);
		textCelsius.setHorizontalAlignment(JTextField.CENTER);

		// JButton para o Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setBounds(75, 140, 180, 30);
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setFont(labels);

		// JButton para o Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setBounds(305, 140, 180, 30);
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setFont(labels);

		// JLabel para o Resultado
		labelResultado = new JLabel();
		labelResultado.setText(null);
		labelResultado.setBounds(180, 200, 250, 30);
		labelResultado.setFont(labels);

		// JLabel para a mensagem de Erro
		labelMensagemErro = new JLabel();
		labelMensagemErro.setText(null);
		labelMensagemErro.setBounds(75, 260, 450, 30);
		labelMensagemErro.setFont(labels);

		tela.getContentPane().add(labelCelsius);
		tela.getContentPane().add(textCelsius);
		tela.getContentPane().add(buttonKelvin);
		tela.getContentPane().add(buttonFahreinheit);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(labelMensagemErro);

		// Listener ao botão calcular
		buttonKelvin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Temperatura temperatura = new Temperatura();

				try {
					double celsius = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(celsius);
					double kelvin = temperatura.converterParaKelvin();
					labelResultado.setText(kelvin + " Kelvin");

				} catch (Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("valor invalido! Digite Somente numeros.");
				}

			}
		});

		buttonFahreinheit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Temperatura temperatura = new Temperatura();

				try {
					double celsius = Double.parseDouble(textCelsius.getText());
					temperatura.setCelsius(celsius);
					double fahreinheit = temperatura.converterParaFahrenheit();
					labelResultado.setText(fahreinheit + " Fahreinheit");

				} catch (Exception erro) {
					labelResultado.setText("");
					labelMensagemErro.setText("valor invalido! Digite Somente numeros.");
				}

			}
		});

		tela.setVisible(true);

	}

}

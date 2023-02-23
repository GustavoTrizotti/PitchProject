package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Musica;
import dao.MusicaDAO;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class RelatorioMusicas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaiorDNome;
	private JTextField textFieldMaiorD;
	private JTextField textFieldMenorDNome;
	private JTextField textFieldMenorD;
	
	private int btnLocate;
	private JLabel lblNewLabel;
	private JTextField textFieldRecenteNome;
	private JTextField textFieldRecente;
	private JLabel lblMaisAntiga;
	private JTextField textFieldAntigaNome;
	private JTextField textFieldAntiga;
	private JLabel lblQuantidadeDeMsicas;
	private JTextField textFieldQtdCadastradas;
	private JTextField textFieldQtdGravadas;
	private JLabel lblQuantidadeDeMsicas_2;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioMusicas frame = new RelatorioMusicas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RelatorioMusicas() {
		Color colorBG = new Color(32, 22, 57);
		
		setTitle("Relat\u00F3rio ");
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(colorBG);
		panel.setBounds(0, 0, 404, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaior = new JLabel("Maior dura\u00E7\u00E3o:");
		labelMaior.setFont(new Font("Poppins", Font.PLAIN, 12));
		labelMaior.setForeground(Color.WHITE);
		labelMaior.setBounds(10, 63, 90, 14);
		panel.add(labelMaior);
		
		JLabel labelMenor = new JLabel("Menor dura\u00E7\u00E3o:");
		labelMenor.setFont(new Font("Poppins", Font.PLAIN, 12));
		labelMenor.setForeground(Color.WHITE);
		labelMenor.setBounds(10, 91, 100, 14);
		panel.add(labelMenor);
		
		textFieldMaiorDNome = new JTextField();
		textFieldMaiorDNome.setBackground(colorBG);
		textFieldMaiorDNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMaiorDNome.setForeground(Color.WHITE);
		textFieldMaiorDNome.setEditable(false);
		textFieldMaiorDNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaiorDNome.setBounds(110, 60, 204, 20);
		panel.add(textFieldMaiorDNome);
		textFieldMaiorDNome.setColumns(10);
		
		textFieldMaiorD = new JTextField();
		textFieldMaiorD.setBackground(colorBG);
		textFieldMaiorD.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMaiorD.setForeground(Color.WHITE);
		textFieldMaiorD.setEditable(false);
		textFieldMaiorD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaiorD.setColumns(10);
		textFieldMaiorD.setBounds(324, 60, 70, 20);
		panel.add(textFieldMaiorD);
		
		textFieldMenorDNome = new JTextField();
		textFieldMenorDNome.setBackground(colorBG);
		textFieldMenorDNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMenorDNome.setForeground(Color.WHITE);
		textFieldMenorDNome.setEditable(false);
		textFieldMenorDNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMenorDNome.setColumns(10);
		textFieldMenorDNome.setBounds(120, 88, 194, 20);
		panel.add(textFieldMenorDNome);
		
		textFieldMenorD = new JTextField();
		textFieldMenorD.setBackground(colorBG);
		textFieldMenorD.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMenorD.setForeground(Color.WHITE);
		textFieldMenorD.setEditable(false);
		textFieldMenorD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMenorD.setColumns(10);
		textFieldMenorD.setBounds(324, 88, 70, 20);
		panel.add(textFieldMenorD);
		
		lblNewLabel = new JLabel("Mais recente:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 119, 90, 14);
		panel.add(lblNewLabel);
		
		textFieldRecenteNome = new JTextField();
		textFieldRecenteNome.setBackground(colorBG);
		textFieldRecenteNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldRecenteNome.setForeground(Color.WHITE);
		textFieldRecenteNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecenteNome.setEditable(false);
		textFieldRecenteNome.setColumns(10);
		textFieldRecenteNome.setBounds(110, 116, 204, 20);
		panel.add(textFieldRecenteNome);
		
		textFieldRecente = new JTextField();
		textFieldRecente.setBackground(colorBG);
		textFieldRecente.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldRecente.setForeground(Color.WHITE);
		textFieldRecente.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecente.setEditable(false);
		textFieldRecente.setColumns(10);
		textFieldRecente.setBounds(324, 116, 70, 20);
		panel.add(textFieldRecente);
		
		lblMaisAntiga = new JLabel("Mais antiga:");
		lblMaisAntiga.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblMaisAntiga.setForeground(Color.WHITE);
		lblMaisAntiga.setBounds(10, 147, 90, 14);
		panel.add(lblMaisAntiga);
		
		textFieldAntigaNome = new JTextField();
		textFieldAntigaNome.setBackground(colorBG);
		textFieldAntigaNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAntigaNome.setForeground(Color.WHITE);
		textFieldAntigaNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntigaNome.setEditable(false);
		textFieldAntigaNome.setColumns(10);
		textFieldAntigaNome.setBounds(110, 144, 204, 20);
		panel.add(textFieldAntigaNome);
		
		textFieldAntiga = new JTextField();
		textFieldAntiga.setBackground(colorBG);
		textFieldAntiga.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAntiga.setForeground(Color.WHITE);
		textFieldAntiga.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntiga.setEditable(false);
		textFieldAntiga.setColumns(10);
		textFieldAntiga.setBounds(324, 144, 70, 20);
		panel.add(textFieldAntiga);
		
		lblQuantidadeDeMsicas = new JLabel("Quantidade de m\u00FAsicas cadastradas:");
		lblQuantidadeDeMsicas.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeMsicas.setForeground(Color.WHITE);
		lblQuantidadeDeMsicas.setBounds(10, 175, 223, 14);
		panel.add(lblQuantidadeDeMsicas);
		
		textFieldQtdCadastradas = new JTextField();
		textFieldQtdCadastradas.setBackground(colorBG);
		textFieldQtdCadastradas.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdCadastradas.setForeground(Color.WHITE);
		textFieldQtdCadastradas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdCadastradas.setEditable(false);
		textFieldQtdCadastradas.setColumns(10);
		textFieldQtdCadastradas.setBounds(243, 172, 151, 20);
		panel.add(textFieldQtdCadastradas);
		
		textFieldQtdGravadas = new JTextField();
		textFieldQtdGravadas.setBackground(colorBG);
		textFieldQtdGravadas.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdGravadas.setForeground(Color.WHITE);
		textFieldQtdGravadas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdGravadas.setEditable(false);
		textFieldQtdGravadas.setColumns(10);
		textFieldQtdGravadas.setBounds(234, 200, 160, 20);
		panel.add(textFieldQtdGravadas);
		
		lblQuantidadeDeMsicas_2 = new JLabel("Quantidade de m\u00FAsicas gravadas:");
		lblQuantidadeDeMsicas_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeMsicas_2.setForeground(Color.WHITE);
		lblQuantidadeDeMsicas_2.setBounds(10, 203, 214, 14);
		panel.add(lblQuantidadeDeMsicas_2);
		
		MusicaDAO mDAO = new MusicaDAO();

		Musica mMaior = new Musica();
		Musica mMenor = new Musica();
		Musica mRecente = new Musica();
		Musica mAntigo = new Musica();
		int mQtdCad = 0;
		int mQtdGrava = 0;

		mMaior = mDAO.getMusicaMaiorDuracao();
		mMenor = mDAO.getMusicaMenorDuracao();
		mRecente = mDAO.getMusicaRecente();
		mAntigo = mDAO.getMusicaAntiga();
		mQtdCad = mDAO.getQtdMusicasCadastradas();
		mQtdGrava = mDAO.getQtdMusicasGravadas();
		
		textFieldMaiorDNome.setText(mMaior.getNome());
		textFieldMaiorD.setText(mMaior.getDuracao().toString());

		textFieldMenorDNome.setText(mMenor.getNome());
		textFieldMenorD.setText(mMenor.getDuracao().toString());

		textFieldRecenteNome.setText(mRecente.getNome());
		textFieldRecente.setText(Integer.toString(mRecente.getAno()));

		textFieldAntigaNome.setText(mAntigo.getNome());
		textFieldAntiga.setText(Integer.toString(mAntigo.getAno()));

		textFieldQtdCadastradas.setText(Integer.toString(mQtdCad));
		textFieldQtdGravadas.setText(Integer.toString(mQtdGrava));
		
		lblNewLabel_1 = new JLabel("RELAT\u00D3RIO - M\u00FAsicas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 384, 31);
		panel.add(lblNewLabel_1);
	}
}

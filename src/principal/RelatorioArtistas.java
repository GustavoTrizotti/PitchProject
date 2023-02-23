package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ArtistaDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelatorioArtistas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQtdArtistasCad;
	private JLabel lblQuantidadeDeArtistas;
	private JTextField textFieldQtdArtistasGrava;
	private JLabel lblQuantidadeDeArtistas_2;
	private JTextField textFieldQtdCompositor;
	private JLabel lblQuantidadeDeArtistas_1;
	private JTextField textFieldQtdCantor;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioArtistas frame = new RelatorioArtistas();
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
	public RelatorioArtistas() {
		setTitle("Relat\u00F3rio - Artistas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 22, 57));
		panel.setBounds(0, 0, 334, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quantidade de artistas cadastrados:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 61, 216, 14);
		panel.add(lblNewLabel);
		
		textFieldQtdArtistasCad = new JTextField();
		textFieldQtdArtistasCad.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdArtistasCad.setForeground(new Color(255, 255, 255));
		textFieldQtdArtistasCad.setBackground(new Color(52, 42, 77));
		textFieldQtdArtistasCad.setEditable(false);
		textFieldQtdArtistasCad.setBounds(236, 58, 88, 20);
		panel.add(textFieldQtdArtistasCad);
		textFieldQtdArtistasCad.setColumns(10);
		
		lblQuantidadeDeArtistas = new JLabel("Quantidade de artistas gravados:");
		lblQuantidadeDeArtistas.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeArtistas.setForeground(Color.WHITE);
		lblQuantidadeDeArtistas.setBounds(10, 92, 216, 14);
		panel.add(lblQuantidadeDeArtistas);
		
		textFieldQtdArtistasGrava = new JTextField();
		textFieldQtdArtistasGrava.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdArtistasGrava.setForeground(Color.WHITE);
		textFieldQtdArtistasGrava.setEditable(false);
		textFieldQtdArtistasGrava.setColumns(10);
		textFieldQtdArtistasGrava.setBackground(new Color(52, 42, 77));
		textFieldQtdArtistasGrava.setBounds(224, 89, 100, 20);
		panel.add(textFieldQtdArtistasGrava);
		
		lblQuantidadeDeArtistas_2 = new JLabel("Quantidade de artistas compositores(as):");
		lblQuantidadeDeArtistas_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeArtistas_2.setForeground(Color.WHITE);
		lblQuantidadeDeArtistas_2.setBounds(10, 123, 251, 14);
		panel.add(lblQuantidadeDeArtistas_2);
		
		textFieldQtdCompositor = new JTextField();
		textFieldQtdCompositor.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdCompositor.setForeground(Color.WHITE);
		textFieldQtdCompositor.setEditable(false);
		textFieldQtdCompositor.setColumns(10);
		textFieldQtdCompositor.setBackground(new Color(52, 42, 77));
		textFieldQtdCompositor.setBounds(271, 120, 53, 20);
		panel.add(textFieldQtdCompositor);
		
		lblQuantidadeDeArtistas_1 = new JLabel("Quantidade de artistas cantores(as):");
		lblQuantidadeDeArtistas_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeArtistas_1.setForeground(Color.WHITE);
		lblQuantidadeDeArtistas_1.setBounds(10, 154, 223, 14);
		panel.add(lblQuantidadeDeArtistas_1);
		
		textFieldQtdCantor = new JTextField();
		textFieldQtdCantor.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdCantor.setForeground(Color.WHITE);
		textFieldQtdCantor.setEditable(false);
		textFieldQtdCantor.setColumns(10);
		textFieldQtdCantor.setBackground(new Color(52, 42, 77));
		textFieldQtdCantor.setBounds(243, 151, 81, 20);
		panel.add(textFieldQtdCantor);
		
		lblNewLabel_1 = new JLabel("RELAT\u00D3RIO - ARTISTAS");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 314, 36);
		panel.add(lblNewLabel_1);
		
		ArtistaDAO aDAO = new ArtistaDAO();
		
		int qtdCad = aDAO.qtdArtistasCadastrados();
		int qtdGrava = aDAO.qtdArtistasGravados();
		int qtdCantor = aDAO.qtdArtistasCantores();
		int qtdCompositor = aDAO.qtdArtistasCompositores();
		
		textFieldQtdArtistasCad.setText(Integer.toString(qtdCad));
		textFieldQtdArtistasGrava.setText(Integer.toString(qtdGrava));
		textFieldQtdCantor.setText(Integer.toString(qtdCantor));
		textFieldQtdCompositor.setText(Integer.toString(qtdCompositor));
	}
}

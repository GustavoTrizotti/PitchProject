package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Grava;
import dao.AlbumDAO;
import dao.ArtistaDAO;
import dao.GravaDAO;
import dao.MusicaDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class RelatorioGravacao extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRecente;
	private JTextField textFieldAntiga;
	private JTextField textFieldQtdGrava;
	private JTextField textFieldMaior;
	private JTextField textFieldMenor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioGravacao frame = new RelatorioGravacao();
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
	public RelatorioGravacao() {
		setTitle("Relat\u00F3rio");
		Color colorBG = new Color(32, 22, 57);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(colorBG);
		panel.setBounds(0, 0, 584, 211);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RELAT\u00D3RIO - GRAVA\u00C7\u00D5ES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 564, 35);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Grava\u00E7\u00E3o mais recente:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 57, 141, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Grava\u00E7\u00E3o mais antiga:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 85, 141, 14);
		panel.add(lblNewLabel_1_1);
		
		textFieldRecente = new JTextField();
		textFieldRecente.setEditable(false);
		textFieldRecente.setBackground(colorBG);
		textFieldRecente.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecente.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldRecente.setForeground(Color.WHITE);
		textFieldRecente.setBounds(161, 54, 413, 20);
		panel.add(textFieldRecente);
		textFieldRecente.setColumns(10);
		
		textFieldAntiga = new JTextField();
		textFieldAntiga.setEditable(false);
		textFieldAntiga.setBackground(colorBG);
		textFieldAntiga.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntiga.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAntiga.setForeground(Color.WHITE);
		textFieldAntiga.setColumns(10);
		textFieldAntiga.setBounds(161, 82, 413, 20);
		panel.add(textFieldAntiga);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade de grava\u00E7\u00F5es registradas:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 116, 227, 14);
		panel.add(lblNewLabel_1_1_1);
		
		textFieldQtdGrava = new JTextField();
		textFieldQtdGrava.setEditable(false);
		textFieldQtdGrava.setBackground(colorBG);
		textFieldQtdGrava.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdGrava.setForeground(Color.WHITE);
		textFieldQtdGrava.setBounds(247, 113, 327, 20);
		panel.add(textFieldQtdGrava);
		textFieldQtdGrava.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Grava\u00E7\u00E3o com maior dura\u00E7\u00E3o:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(10, 144, 192, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		textFieldMaior = new JTextField();
		textFieldMaior.setEditable(false);
		textFieldMaior.setBackground(colorBG);
		textFieldMaior.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMaior.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMaior.setForeground(Color.WHITE);
		textFieldMaior.setColumns(10);
		textFieldMaior.setBounds(204, 141, 370, 20);
		panel.add(textFieldMaior);
		
		textFieldMenor = new JTextField();
		textFieldMenor.setEditable(false);
		textFieldMenor.setBackground(colorBG);
		textFieldMenor.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMenor.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMenor.setForeground(Color.WHITE);
		textFieldMenor.setColumns(10);
		textFieldMenor.setBounds(204, 169, 370, 20);
		panel.add(textFieldMenor);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Grava\u00E7\u00E3o com menor dura\u00E7\u00E3o:");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(10, 172, 192, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		GravaDAO gDAO = new GravaDAO();
		AlbumDAO aDAO = new AlbumDAO();
		MusicaDAO mDAO = new MusicaDAO();
		ArtistaDAO arDAO = new ArtistaDAO();
		
		Grava gravacaoRecente = gDAO.getGravacaoRecente();
		Grava gravacaoAntiga = gDAO.getGravacaoAntiga();
		Grava gravacaoMaior = gDAO.getGravaMaiorDuracao();
		Grava gravacaoMenor = gDAO.getGravaMenorDuracao();
		int qtdGrava = gDAO.qtdGravacoes();
		
		String albumRecente = aDAO.getAlbum(gravacaoRecente.getCodigo_produto()).getNome();
		String musicaRecente = mDAO.getMusica(gravacaoRecente.getCodigo_musica()).getNome();
		String artistaRecente = arDAO.getArtista(gravacaoRecente.getCpf_artista()).getNome_artistico();
		
		String albumAntigo = aDAO.getAlbum(gravacaoAntiga.getCodigo_produto()).getNome();
		String musicaAntiga = mDAO.getMusica(gravacaoAntiga.getCodigo_musica()).getNome();
		String artistaAntigo = arDAO.getArtista(gravacaoAntiga.getCpf_artista()).getNome_artistico();
		
		String albumMaior = aDAO.getAlbum(gravacaoMaior.getCodigo_produto()).getNome();
		String musicaMaior = mDAO.getMusica(gravacaoMaior.getCodigo_musica()).getNome();
		String artistaMaior = arDAO.getArtista(gravacaoMaior.getCpf_artista()).getNome_artistico();
		
		String albumMenor = aDAO.getAlbum(gravacaoMenor.getCodigo_produto()).getNome();
		String musicaMenor = mDAO.getMusica(gravacaoMenor.getCodigo_musica()).getNome();
		String artistaMenor = arDAO.getArtista(gravacaoMenor.getCpf_artista()).getNome_artistico();
		
		textFieldRecente.setText(albumRecente + " / " + musicaRecente + " / " + artistaRecente);
		textFieldAntiga.setText(albumAntigo + " / " + musicaAntiga + " / " + artistaAntigo);
		textFieldMaior.setText(albumMaior + " / " + musicaMaior + " / " + artistaMaior);
		textFieldMenor.setText(albumMenor + " / " + musicaMenor + " / " + artistaMenor);
		textFieldQtdGrava.setText(Integer.toString(qtdGrava));
	}
}

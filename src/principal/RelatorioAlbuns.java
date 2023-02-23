package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Album;
import bean.Musica;
import dao.AlbumDAO;
import dao.MusicaDAO;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RelatorioAlbuns extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAntigoNome;
	private JTextField textFieldAntigo;
	private JTextField textFieldRecenteNome;
	private JTextField textFieldRecente;
	
	private int btnLocate;
	private JLabel lblNewLabel;
	private JLabel lblMaisAntiga;
	private JLabel lblQuantidadeDeMsicas;
	private JTextField textFieldQtdCadastradas;
	private JTextField textFieldQtdGravadas;
	private JLabel lblQuantidadeDeMsicas_2;
	private JTextField textFieldQtdGravadoras;
	private JTextField textFieldQtdDistribuidoras;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioAlbuns frame = new RelatorioAlbuns();
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
	public RelatorioAlbuns() {
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
		panel.setBackground(new Color(32, 22, 57));
		panel.setBounds(0, 0, 404, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaior = new JLabel("Mais antigo:");
		labelMaior.setFont(new Font("Poppins", Font.PLAIN, 12));
		labelMaior.setForeground(Color.WHITE);
		labelMaior.setBounds(10, 51, 90, 14);
		panel.add(labelMaior);
		
		JLabel labelMenor = new JLabel("Mais recente:");
		labelMenor.setFont(new Font("Poppins", Font.PLAIN, 12));
		labelMenor.setForeground(Color.WHITE);
		labelMenor.setBounds(10, 79, 90, 14);
		panel.add(labelMenor);
		
		textFieldAntigoNome = new JTextField();
		textFieldAntigoNome.setBackground(colorBG);
		textFieldAntigoNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAntigoNome.setForeground(Color.WHITE);
		textFieldAntigoNome.setEditable(false);
		textFieldAntigoNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntigoNome.setBounds(110, 48, 204, 20);
		panel.add(textFieldAntigoNome);
		textFieldAntigoNome.setColumns(10);
		
		textFieldAntigo = new JTextField();
		textFieldAntigo.setBackground(colorBG);
		textFieldAntigo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAntigo.setForeground(Color.WHITE);
		textFieldAntigo.setEditable(false);
		textFieldAntigo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAntigo.setColumns(10);
		textFieldAntigo.setBounds(324, 48, 70, 20);
		panel.add(textFieldAntigo);
		
		textFieldRecenteNome = new JTextField();
		textFieldRecenteNome.setBackground(colorBG);
		textFieldRecenteNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldRecenteNome.setForeground(Color.WHITE);
		textFieldRecenteNome.setEditable(false);
		textFieldRecenteNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecenteNome.setColumns(10);
		textFieldRecenteNome.setBounds(110, 76, 204, 20);
		panel.add(textFieldRecenteNome);
		
		textFieldRecente = new JTextField();
		textFieldRecente.setBackground(colorBG);
		textFieldRecente.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldRecente.setForeground(Color.WHITE);
		textFieldRecente.setEditable(false);
		textFieldRecente.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRecente.setColumns(10);
		textFieldRecente.setBounds(324, 76, 70, 20);
		panel.add(textFieldRecente);
		
		lblNewLabel = new JLabel("Quantidade de distribuidoras:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 107, 214, 14);
		panel.add(lblNewLabel);
		
		lblMaisAntiga = new JLabel("Quantidade de gravadoras:");
		lblMaisAntiga.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblMaisAntiga.setForeground(Color.WHITE);
		lblMaisAntiga.setBounds(10, 135, 176, 14);
		panel.add(lblMaisAntiga);
		
		lblQuantidadeDeMsicas = new JLabel("Quantidade de \u00E1lbuns cadastrados:");
		lblQuantidadeDeMsicas.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeMsicas.setForeground(Color.WHITE);
		lblQuantidadeDeMsicas.setBounds(10, 163, 235, 14);
		panel.add(lblQuantidadeDeMsicas);
		
		textFieldQtdCadastradas = new JTextField();
		textFieldQtdCadastradas.setBackground(colorBG);
		textFieldQtdCadastradas.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdCadastradas.setForeground(Color.WHITE);
		textFieldQtdCadastradas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdCadastradas.setEditable(false);
		textFieldQtdCadastradas.setColumns(10);
		textFieldQtdCadastradas.setBounds(234, 160, 160, 20);
		panel.add(textFieldQtdCadastradas);
		
		textFieldQtdGravadas = new JTextField();
		textFieldQtdGravadas.setBackground(colorBG);
		textFieldQtdGravadas.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdGravadas.setForeground(Color.WHITE);
		textFieldQtdGravadas.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdGravadas.setEditable(false);
		textFieldQtdGravadas.setColumns(10);
		textFieldQtdGravadas.setBounds(218, 188, 176, 20);
		panel.add(textFieldQtdGravadas);
		
		lblQuantidadeDeMsicas_2 = new JLabel("Quantidade de \u00E1lbuns gravados:");
		lblQuantidadeDeMsicas_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblQuantidadeDeMsicas_2.setForeground(Color.WHITE);
		lblQuantidadeDeMsicas_2.setBounds(10, 191, 214, 14);
		panel.add(lblQuantidadeDeMsicas_2);
		
		textFieldQtdGravadoras = new JTextField();
		textFieldQtdGravadoras.setBackground(colorBG);
		textFieldQtdGravadoras.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdGravadoras.setForeground(Color.WHITE);
		textFieldQtdGravadoras.setText("5");
		textFieldQtdGravadoras.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdGravadoras.setEditable(false);
		textFieldQtdGravadoras.setColumns(10);
		textFieldQtdGravadoras.setBounds(196, 132, 198, 20);
		panel.add(textFieldQtdGravadoras);
		
		textFieldQtdDistribuidoras = new JTextField();
		textFieldQtdDistribuidoras.setBackground(colorBG);
		textFieldQtdDistribuidoras.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldQtdDistribuidoras.setForeground(Color.WHITE);
		textFieldQtdDistribuidoras.setText("5");
		textFieldQtdDistribuidoras.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldQtdDistribuidoras.setEditable(false);
		textFieldQtdDistribuidoras.setColumns(10);
		textFieldQtdDistribuidoras.setBounds(196, 104, 198, 20);
		panel.add(textFieldQtdDistribuidoras);
		
		AlbumDAO aDAO = new AlbumDAO();

		Album aAntigo = new Album();
		Album aRecente = new Album();
		int aQtdDist = 0;
		int aQtdGravadora = 0;
		int aQtdCad = 0;
		int aQtdGrava = 0;

		aAntigo = aDAO.getAlbumAntigo();
		aRecente = aDAO.getAlbumRecente();
		aQtdDist = aDAO.getQtdDistribuidoras();
		aQtdGravadora = aDAO.getQtdGravadoras();
		aQtdCad = aDAO.getQtdAlbunsCadastrados();
		aQtdGrava = aDAO.getQtdAlbunsGravados();

		textFieldAntigoNome.setText(aAntigo.getNome());
		textFieldAntigo.setText(Integer.toString(aAntigo.getAno()));

		textFieldRecenteNome.setText(aRecente.getNome());
		textFieldRecente.setText(Integer.toString(aRecente.getAno()));

		textFieldQtdDistribuidoras.setText(Integer.toString(aQtdDist));
		textFieldQtdGravadoras.setText(Integer.toString(aQtdGravadora));
		textFieldQtdCadastradas.setText(Integer.toString(aQtdCad));
		textFieldQtdGravadas.setText(Integer.toString(aQtdGrava));
		
		lblNewLabel_1 = new JLabel("RELAT\u00D3RIO - \u00C1lbuns");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 11, 384, 29);
		panel.add(lblNewLabel_1);
	}
}

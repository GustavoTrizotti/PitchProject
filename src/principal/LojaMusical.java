package principal;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Album;
import bean.Artista;
import bean.ComboItem;
import bean.Grava;
import bean.Musica;
import dao.AlbumDAO;
import dao.ArtistaDAO;
import dao.GravaDAO;
import dao.MusicaDAO;

import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LojaMusical extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panelMenu;
	private JPanel panelMusicas;
	private JLayeredPane layeredPaneMusicas;
	private JPanel panelAlbuns;
	private JLayeredPane layeredPaneAlbuns;
	private JPanel panelArtistas;
	private JLayeredPane layeredPaneArtistas;
	private JPanel panelGravacoes;
	private JLayeredPane layeredPaneGravacoes;
	private JPanel panelMC;
	private JPanel panelMU;
	private JPanel panelMD;
	private JPanel panelMR;
	private JPanel panelAC;
	private JPanel panelAU;
	private JPanel panelAD;
	private JPanel panelAR;
	private JPanel panelArC;
	private JPanel panelArU;
	private JPanel panelArD;
	private JPanel panelArR;
	private JPanel panelGC;
	private JPanel panelGU;
	private JPanel panelGD;
	private JPanel panelGR;
	private JButton btnVoltarMD;
	private JTextField textFieldMCCodigo;
	private JTextField textFieldMCNome;
	private JTextField textFieldMCDuracao;
	private JTextField textFieldMCAno;
	private JTextField textFieldMCCreditos;
	private JTextField textFieldMUNome;
	private JTextField textFieldMUDuracao;
	private JTextField textFieldMUAno;
	private JTextField textField_MUCreditos;
	private JButton btnVoltarAC;
	private JTextField textFieldACCodigo;
	private JTextField textFieldACNome;
	private JLabel lblNewLabel_9;
	private JTextField textFieldACAno;
	private JLabel lblNewLabel_11;
	private JTextField textFieldACDistribuidora;
	private JLabel lblNewLabel_12;
	private JTextField textFieldACGravadora;
	private JLabel lblNewLabel_13;
	private JTextField textFieldACLote;
	private JLabel lblNewLabel_14;
	private JButton btnVoltarMR;
	private JButton btnVoltarAU;
	private JTextField textFieldAUNome;
	private JLabel lblNewLabel_16;
	private JTextField textFieldAUAno;
	private JLabel lblNewLabel_17;
	private JTextField textFieldAUDistribuidora;
	private JLabel lblNewLabel_18;
	private JTextField textFieldAUGravadora;
	private JLabel lblNewLabel_19;
	private JTextField textFieldAULote;
	private JLabel lblNewLabel_20;
	private JButton btnAUAlterar;
	private JButton btnVoltarAD;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_21;
	private JComboBox comboBoxADCodigo;
	private JButton btnADDeletar;
	private JButton btnVoltarAR;
	private JButton btnVoltarArC;
	private JLabel lblNewLabel_24;
	private JTextField textFieldArCCPF;
	private JLabel lblNewLabel_25;
	private JTextField textFieldArCNome;
	private JLabel lblNewLabel_26;
	private JTextField textFieldArCDataNasc;
	private JLabel lblNewLabel_27;
	private JTextField textFieldArCEspecializacao;
	private JButton btnArCInserir;
	private JButton btnVoltarArU;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JTextField textFieldArUNome;
	private JLabel lblNewLabel_31;
	private JTextField textFieldArUDataNasc;
	private JLabel lblNewLabel_32;
	private JTextField textFieldArUEspecializacao;
	private JButton btnArUAlterar;
	private JComboBox comboBoxArUCPF;
	private JButton btnVoltarArD;
	private JComboBox comboBoxArDCPF;
	private JLabel lblNewLabel_34;
	private JButton btnArDDeletar;
	private JButton btnVoltarArR;
	private JButton btnVoltarGC;
	private JLabel lblNewLabel_37;
	private JComboBox comboBoxGCCPF;
	private JLabel lblNewLabel_38;
	private JComboBox comboBoxGCCodigoA;
	private JLabel lblNewLabel_39;
	private JComboBox comboBoxGCCodigoM;
	private JLabel lblNewLabel_40;
	private JTextField textFieldGCDataGravacao;
	private JTextField textFieldGCEstilo;
	private JLabel lblNewLabel_41;
	private JButton btnGCInserir;
	private JButton btnVoltarGU;
	private JLabel lblNewLabel_43;
	private JComboBox comboBoxGUCPF;
	private JLabel lblNewLabel_44;
	private JComboBox comboBoxGUCodigoA;
	private JLabel lblNewLabel_45;
	private JComboBox comboBoxGUCodigoM;
	private JLabel lblNewLabel_46;
	private JTextField textFieldGUDataGravacao;
	private JTextField textFieldGUEstilo;
	private JLabel lblNewLabel_47;
	private JButton btnGUAlterar;
	private JButton btnVoltarGD;
	private JLabel lblNewLabel_49;
	private JComboBox comboBoxGDCPF;
	private JLabel lblNewLabel_50;
	private JComboBox comboBoxGDCodigoA;
	private JLabel lblNewLabel_51;
	private JComboBox comboBoxGDCodigoM;
	private JButton btnGDDeletar;
	private JComboBox comboBoxAUCodigo;
	private ArrayList<Integer> codigosAlbuns = new ArrayList<>();
	private ArrayList<Integer> codigosMusicas = new ArrayList<>();
	private ArrayList<String> cpfArtistas = new ArrayList<>();
	private ArrayList<Date> dataGravacao = new ArrayList<>();
	private JComboBox comboBoxMDCodigo;
	private JComboBox comboBoxMUCodigo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnMostrarMsica;
	private JTextField textFieldMRCodigo;
	private JButton btnVoltarGR;
	private JTable tableAlbuns;
	private JTextField textFieldARCodigo;
	private JTable tableArtistas;
	private JScrollPane scrollPane_1;
	private JTextField textFieldArREstilo;
	private JTable tableGrava;
	private JScrollPane scrollPaneGR;
	private JButton btnGRMostrarTodos;
	private JTextField textFieldMREstilo;
	private JTable tableMREstilo;
	private JScrollPane scrollPaneMusicasR;
	private JTextField textFieldAREstilo;
	private JTable tableAREstilo;
	private JButton btnAlbuns;
	private JButton btnArtistas;
	private JButton btnGravar;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_35;
	private JTable tableArEstilo;
	private JButton btnSelectAr;
	private JLabel lblNewLabel_56;
	private JTextField textFieldArRCPF;
	private JLabel lblNewLabel_42;
	private JTextField textFieldGUNome;
	private JTextField textFieldGUNomeA;
	private JTextField textFieldGUNomeM;
	private JLabel lblNewLabel_48;
	private JTextField textFieldGRDuracaoTotal;
	private JLabel lblNewLabel_63;
	private JButton btnGRProcurar;
	private JComboBox comboBoxGRData;
	private JComboBox comboBoxGRDataDuracao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LojaMusical frame = new LojaMusical();
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
	public LojaMusical() {
		setForeground(new Color(255, 255, 255));
		setFont(new Font("Poppins", Font.PLAIN, 12));
		setBackground(new Color(0, 0, 0));
		setResizable(false);
		setTitle("PITCH");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 464);
		
		MusicaDAO mDAO = new MusicaDAO();
		AlbumDAO aDAO = new AlbumDAO();
		ArtistaDAO arDAO = new ArtistaDAO();
		GravaDAO gDAO = new GravaDAO();
		codigosMusicas = mDAO.getCodigos();
		
		Color colorBG = new Color(32, 22, 57);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(32, 22, 57));
		setJMenuBar(menuBar);
		
		JMenu menuMusicas = new JMenu("Musicas");
		menuMusicas.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuMusicas.setForeground(new Color(255, 255, 255));
		menuBar.add(menuMusicas);
		
		JMenuItem menuItemMC = new JMenuItem("Inserir");
		menuItemMC.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/CREATE.png")));
		menuItemMC.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemMC.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemMC.setForeground(new Color(255, 255, 255));
		menuItemMC.setBackground(colorBG);
		menuItemMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SWITCH TO INSERT MUSIC
				Switch_Screen(layeredPane, panelMusicas);
				Switch_Screen(layeredPaneMusicas, panelMC);
			}
		});
		menuMusicas.add(menuItemMC);
		
		JMenuItem menuItemMU = new JMenuItem("Alterar");
		menuItemMU.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/UPDATE.png")));
		menuItemMU.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemMU.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemMU.setForeground(new Color(255, 255, 255));
		menuItemMU.setBackground(colorBG);
		menuItemMU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMusicas);
				Switch_Screen(layeredPaneMusicas, panelMU);
				
				addComboItemMusicas(comboBoxMUCodigo, codigosMusicas, mDAO);
			}
		});
		menuMusicas.add(menuItemMU);
		
		JMenuItem menuItemMD = new JMenuItem("Deletar");
		menuItemMD.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/DELETE.png")));
		menuItemMD.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemMD.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemMD.setForeground(new Color(255, 255, 255));
		menuItemMD.setBackground(colorBG);
		menuItemMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMusicas);
				Switch_Screen(layeredPaneMusicas, panelMD);
				
				addComboItemMusicas(comboBoxMDCodigo, codigosMusicas, mDAO);
			}
		});
		menuMusicas.add(menuItemMD);
		
		JMenuItem menuItemMR = new JMenuItem("Relat\u00F3rio");
		menuItemMR.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/READ.png")));
		menuItemMR.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemMR.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemMR.setForeground(new Color(255, 255, 255));
		menuItemMR.setBackground(colorBG);
		menuItemMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMusicas);
				Switch_Screen(layeredPaneMusicas, panelMR);
				
				addTableItemMusicas(table, mDAO);
			}
		});
		menuMusicas.add(menuItemMR);
		
		JMenu menuAlbuns = new JMenu("Albuns");
		menuAlbuns.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuAlbuns.setForeground(new Color(255, 255, 255));
		menuBar.add(menuAlbuns);
		
		JMenuItem menuItemAC = new JMenuItem("Inserir");
		menuItemAC.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/CREATE.png")));
		menuItemAC.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAC.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAC.setForeground(new Color(255, 255, 255));
		menuItemAC.setBackground(colorBG);
		menuItemAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelAlbuns);
				Switch_Screen(layeredPaneAlbuns, panelAC);
			}
		});
		menuAlbuns.add(menuItemAC);
		
		JMenuItem menuItemAU = new JMenuItem("Alterar");
		menuItemAU.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/UPDATE.png")));
		menuItemAU.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAU.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAU.setForeground(new Color(255, 255, 255));
		menuItemAU.setBackground(colorBG);
		menuItemAU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelAlbuns);
				Switch_Screen(layeredPaneAlbuns, panelAU);
				
				addComboItemAlbuns(comboBoxAUCodigo, codigosAlbuns);
			}
		});
		menuAlbuns.add(menuItemAU);
		
		JMenuItem menuItemAD = new JMenuItem("Deletar");
		menuItemAD.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/DELETE.png")));
		menuItemAD.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAD.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAD.setForeground(new Color(255, 255, 255));
		menuItemAD.setBackground(colorBG);
		menuItemAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelAlbuns);
				Switch_Screen(layeredPaneAlbuns, panelAD);
				
				addComboItemAlbuns(comboBoxADCodigo, codigosAlbuns);
			}
		});
		menuAlbuns.add(menuItemAD);
		
		JMenuItem menuItemAR = new JMenuItem("Relat\u00F3rio");
		menuItemAR.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/READ.png")));
		menuItemAR.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAR.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAR.setForeground(new Color(255, 255, 255));
		menuItemAR.setBackground(colorBG);
		menuItemAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelAlbuns);
				Switch_Screen(layeredPaneAlbuns, panelAR);
				
				addTableItemAlbuns(tableAlbuns, aDAO);
			}
		});
		menuAlbuns.add(menuItemAR);
		
		JMenu menuArtista = new JMenu("Artistas");
		menuArtista.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuArtista.setForeground(new Color(255, 255, 255));
		menuBar.add(menuArtista);
		
		JMenuItem menuItemAtC = new JMenuItem("Inserir");
		menuItemAtC.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/CREATE.png")));
		menuItemAtC.setForeground(new Color(255, 255, 255));
		menuItemAtC.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAtC.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAtC.setBackground(colorBG);
		menuItemAtC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelArtistas);
				Switch_Screen(layeredPaneArtistas, panelArC);
			}
		});
		menuArtista.add(menuItemAtC);
		
		JMenuItem menuItemAtU = new JMenuItem("Alterar");
		menuItemAtU.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/UPDATE.png")));
		menuItemAtU.setForeground(new Color(255, 255, 255));
		menuItemAtU.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAtU.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAtU.setBackground(colorBG);
		menuItemAtU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelArtistas);
				Switch_Screen(layeredPaneArtistas, panelArU);
				
				addComboItemArtistas(comboBoxArUCPF, cpfArtistas);
			}
		});
		menuArtista.add(menuItemAtU);
		
		JMenuItem menuItemAtD = new JMenuItem("Deletar");
		menuItemAtD.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/DELETE.png")));
		menuItemAtD.setForeground(new Color(255, 255, 255));
		menuItemAtD.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAtD.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAtD.setBackground(colorBG);
		menuItemAtD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelArtistas);
				Switch_Screen(layeredPaneArtistas, panelArD);
				
				addComboItemArtistas(comboBoxArDCPF, cpfArtistas);
			}
		});
		menuArtista.add(menuItemAtD);
		
		JMenuItem menuItemAtR = new JMenuItem("Relat\u00F3rio");
		menuItemAtR.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/READ.png")));
		menuItemAtR.setForeground(new Color(255, 255, 255));
		menuItemAtR.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemAtR.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemAtR.setBackground(colorBG);
		menuItemAtR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelArtistas);
				Switch_Screen(layeredPaneArtistas, panelArR);
				
				addTableItemArtistas(tableArtistas, arDAO);
			}
		});
		menuArtista.add(menuItemAtR);
		
		JMenu menuGravacoes = new JMenu("Grava\u00E7\u00F5es");
		menuGravacoes.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuGravacoes.setForeground(new Color(255, 255, 255));
		menuBar.add(menuGravacoes);
		
		JMenuItem menuItemGC = new JMenuItem("Inserir");
		menuItemGC.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/CREATE.png")));
		menuItemGC.setBackground(colorBG);
		menuItemGC.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemGC.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemGC.setForeground(new Color(255, 255, 255));
		menuItemGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelGravacoes);
				Switch_Screen(layeredPaneGravacoes, panelGC);
				
				addComboItemAlbuns(comboBoxGCCodigoA, codigosAlbuns);
				addComboItemMusicas(comboBoxGCCodigoM, codigosMusicas, mDAO);
				addComboItemArtistas(comboBoxGCCPF, cpfArtistas);
			}
		});
		menuGravacoes.add(menuItemGC);
		
		JMenuItem menuItemGU = new JMenuItem("Alterar");
		menuItemGU.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/UPDATE.png")));
		menuItemGU.setBackground(colorBG);
		menuItemGU.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemGU.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemGU.setForeground(new Color(255, 255, 255));
		menuItemGU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelGravacoes);
				Switch_Screen(layeredPaneGravacoes, panelGU);
				
				addComboItemAlbuns(comboBoxGUCodigoA, codigosAlbuns);
				addComboItemMusicas(comboBoxGUCodigoM, codigosMusicas, mDAO);
				addComboItemArtistas(comboBoxGUCPF, cpfArtistas);
			}
		});
		menuGravacoes.add(menuItemGU);
		
		JMenuItem menuItemGD = new JMenuItem("Deletar");
		menuItemGD.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/DELETE.png")));
		menuItemGD.setBackground(colorBG);
		menuItemGD.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemGD.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemGD.setForeground(new Color(255, 255, 255));
		menuItemGD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelGravacoes);
				Switch_Screen(layeredPaneGravacoes, panelGD);
				
				addComboItemAlbuns(comboBoxGDCodigoA, codigosAlbuns);
				addComboItemMusicas(comboBoxGDCodigoM, codigosMusicas, mDAO);
				addComboItemArtistas(comboBoxGDCPF, cpfArtistas);
			}
		});
		menuGravacoes.add(menuItemGD);
		
		JMenuItem menuItemGR = new JMenuItem("Relat\u00F3rio");
		menuItemGR.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/READ.png")));
		menuItemGR.setBackground(colorBG);
		menuItemGR.setHorizontalAlignment(SwingConstants.LEFT);
		menuItemGR.setFont(new Font("Poppins", Font.PLAIN, 14));
		menuItemGR.setForeground(new Color(255, 255, 255));
		menuItemGR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelGravacoes);
				Switch_Screen(layeredPaneGravacoes, panelGR);
				
				addTableItemGrava(tableGrava, gDAO);
				addComboItemDataGrava(comboBoxGRData, dataGravacao);
				addComboItemDataGrava(comboBoxGRDataDuracao, dataGravacao);
			}
		});
		menuGravacoes.add(menuItemGR);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 654, 404);
		contentPane.add(layeredPane);
		
		panelMenu = new JPanel();
		layeredPane.setLayer(panelMenu, 0);
		panelMenu.setBounds(0, 0, 655, 405);
		layeredPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JButton btnMusicas = new JButton("MÚSICAS");
		btnMusicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMusicas);
				Switch_Screen(layeredPaneMusicas, panelMC);
			}
		});
		btnMusicas.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnMusicas.setForeground(new Color(255, 255, 255));
		btnMusicas.setBackground(new Color(32, 22, 57));
		btnMusicas.setBounds(67, 253, 119, 47);
		panelMenu.add(btnMusicas);
		
		btnAlbuns = new JButton("ÁLBUNS");
		btnAlbuns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelAlbuns);
				Switch_Screen(layeredPaneAlbuns, panelAC);
			}
		});
		btnAlbuns.setForeground(Color.WHITE);
		btnAlbuns.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnAlbuns.setBackground(new Color(32, 22, 57));
		btnAlbuns.setBounds(209, 253, 119, 47);
		panelMenu.add(btnAlbuns);
		
		btnArtistas = new JButton("ARTISTAS");
		btnArtistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelArtistas);
				Switch_Screen(layeredPaneArtistas, panelArC);
			}
		});
		btnArtistas.setForeground(Color.WHITE);
		btnArtistas.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArtistas.setBackground(new Color(32, 22, 57));
		btnArtistas.setBounds(351, 254, 119, 47);
		panelMenu.add(btnArtistas);
		
		btnGravar = new JButton("GRAVAR");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelGravacoes);
				Switch_Screen(layeredPaneGravacoes, panelGC);
				
				addComboItemAlbuns(comboBoxGCCodigoA, codigosAlbuns);
				addComboItemMusicas(comboBoxGCCodigoM, codigosMusicas, mDAO);
				addComboItemArtistas(comboBoxGCCPF, cpfArtistas);
			}
		});
		btnGravar.setForeground(Color.WHITE);
		btnGravar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGravar.setBackground(new Color(32, 22, 57));
		btnGravar.setBounds(490, 254, 119, 47);
		panelMenu.add(btnGravar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_MENU.png")));
		lblNewLabel.setBounds(0, 0, 655, 405);
		panelMenu.add(lblNewLabel);
		
		panelMusicas = new JPanel();
		layeredPane.setLayer(panelMusicas, 0);
		panelMusicas.setBounds(0, 0, 655, 405);
		layeredPane.add(panelMusicas);
		panelMusicas.setLayout(null);
		
		layeredPaneMusicas = new JLayeredPane();
		layeredPaneMusicas.setBounds(0, 0, 655, 405);
		panelMusicas.add(layeredPaneMusicas);
		
		panelMC = new JPanel();
		layeredPaneMusicas.setLayer(panelMC, 0);
		panelMC.setBounds(0, 0, 655, 405);
		layeredPaneMusicas.add(panelMC);
		panelMC.setLayout(null);
		
		JButton btnVoltarMC = new JButton("Voltar");
		btnVoltarMC.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarMC.setForeground(new Color(255, 255, 255));
		btnVoltarMC.setBackground(new Color(32, 22, 57));
		btnVoltarMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarMC.setBounds(525, 327, 100, 40);
		panelMC.add(btnVoltarMC);
		
		textFieldMCCodigo = new JTextField();
		textFieldMCCodigo.setToolTipText("");
		textFieldMCCodigo.setForeground(Color.WHITE);
		textFieldMCCodigo.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMCCodigo.setBackground(new Color(32, 22, 57));
		textFieldMCCodigo.setBounds(85, 125, 86, 20);
		panelMC.add(textFieldMCCodigo);
		textFieldMCCodigo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("C\u00F3digo:");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(25, 128, 50, 14);
		panelMC.add(lblNewLabel_5);
		
		textFieldMCNome = new JTextField();
		textFieldMCNome.setForeground(Color.WHITE);
		textFieldMCNome.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMCNome.setBackground(new Color(32, 22, 57));
		textFieldMCNome.setColumns(10);
		textFieldMCNome.setBounds(85, 156, 270, 20);
		panelMC.add(textFieldMCNome);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nome:");
		lblNewLabel_5_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1.setBounds(25, 159, 50, 14);
		panelMC.add(lblNewLabel_5_1);
		
		textFieldMCDuracao = new JTextField();
		textFieldMCDuracao.setForeground(Color.WHITE);
		textFieldMCDuracao.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMCDuracao.setBackground(new Color(32, 22, 57));
		textFieldMCDuracao.setColumns(10);
		textFieldMCDuracao.setBounds(85, 187, 270, 20);
		panelMC.add(textFieldMCDuracao);
		
		JLabel lblNewLabel_5_2 = new JLabel("Dura\u00E7\u00E3o:");
		lblNewLabel_5_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2.setBounds(10, 190, 65, 14);
		panelMC.add(lblNewLabel_5_2);
		
		textFieldMCAno = new JTextField();
		textFieldMCAno.setForeground(Color.WHITE);
		textFieldMCAno.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMCAno.setBackground(new Color(32, 22, 57));
		textFieldMCAno.setColumns(10);
		textFieldMCAno.setBounds(85, 218, 86, 20);
		panelMC.add(textFieldMCAno);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Ano:");
		lblNewLabel_5_2_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2_1.setForeground(Color.WHITE);
		lblNewLabel_5_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_1.setBounds(25, 221, 50, 14);
		panelMC.add(lblNewLabel_5_2_1);
		
		textFieldMCCreditos = new JTextField();
		textFieldMCCreditos.setForeground(Color.WHITE);
		textFieldMCCreditos.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMCCreditos.setBackground(new Color(32, 22, 57));
		textFieldMCCreditos.setColumns(10);
		textFieldMCCreditos.setBounds(85, 249, 270, 20);
		panelMC.add(textFieldMCCreditos);
		
		JButton btnMCInserir = new JButton("Cadastrar");
		btnMCInserir.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnMCInserir.setBackground(new Color(32, 22, 57));
		btnMCInserir.setForeground(new Color(255, 255, 255));
		// ADICIONAR MÚSICA
		btnMCInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicaDAO mDAO = new MusicaDAO();
				Musica m = new Musica();
				
				if ((textFieldMCCodigo.getText().equals("")) || (textFieldMCNome.getText().equals("")) || (textFieldMCDuracao.getText().equals("")) || (textFieldMCAno.getText().equals("")) || (textFieldMCCreditos.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					int codigo = Integer.parseInt(textFieldMCCodigo.getText());
					String nome = textFieldMCNome.getText();
					String duracao = textFieldMCDuracao.getText();
					Time duracaoTime = Time.valueOf(duracao);
					int ano = Integer.parseInt(textFieldMCAno.getText());
					String creditos = textFieldMCCreditos.getText();
					
					m.setCodigo(codigo);
					if (nome.length() > 40) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 40)");
					} else {
						m.setNome(nome);
						m.setDuracao(duracaoTime);
						m.setAno(ano);
						if (creditos.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Créditos > 30)");
						} else {
							m.setCreditos(creditos);
							if (mDAO.inserir(m) > 0) {
								JOptionPane.showMessageDialog(null, "Música adicionada com sucesso!");
								codigosMusicas.clear();
								codigosMusicas = mDAO.getCodigos(); 
								System.out.println(codigosMusicas);
							} else {
								JOptionPane.showMessageDialog(null, "Falha ao adicionar a música!");
							}
						}
					}
					
				}
			}
		});
		btnMCInserir.setBounds(106, 327, 100, 40);
		panelMC.add(btnMCInserir);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Cr\u00E9ditos:");
		lblNewLabel_5_2_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2_2.setForeground(Color.WHITE);
		lblNewLabel_5_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_2.setBounds(10, 252, 65, 14);
		panelMC.add(lblNewLabel_5_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_MC.png")));
		lblNewLabel_2.setBounds(0, 0, 655, 394);
		panelMC.add(lblNewLabel_2);
		
		panelMU = new JPanel();
		layeredPaneMusicas.setLayer(panelMU, 0);
		panelMU.setBounds(0, 0, 655, 405);
		layeredPaneMusicas.add(panelMU);
		panelMU.setLayout(null);
		
		JButton btnVoltarMU = new JButton("Voltar");
		btnVoltarMU.setForeground(new Color(255, 255, 255));
		btnVoltarMU.setBackground(new Color(32, 22, 57));
		btnVoltarMU.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnVoltarMU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarMU.setBounds(524, 327, 100, 40);
		panelMU.add(btnVoltarMU);
		
		textFieldMUNome = new JTextField();
		textFieldMUNome.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMUNome.setEnabled(false);
		textFieldMUNome.setForeground(new Color(255, 255, 255));
		textFieldMUNome.setBackground(new Color(32, 22, 57));
		textFieldMUNome.setColumns(10);
		textFieldMUNome.setBounds(92, 143, 270, 20);
		panelMU.add(textFieldMUNome);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Nome:");
		lblNewLabel_5_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_1_1.setBounds(26, 146, 56, 14);
		panelMU.add(lblNewLabel_5_1_1);
		
		textFieldMUDuracao = new JTextField();
		textFieldMUDuracao.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMUDuracao.setForeground(new Color(255, 255, 255));
		textFieldMUDuracao.setBackground(new Color(32, 22, 57));
		textFieldMUDuracao.setEnabled(false);
		textFieldMUDuracao.setColumns(10);
		textFieldMUDuracao.setBounds(92, 174, 270, 20);
		panelMU.add(textFieldMUDuracao);
		
		JLabel lblNewLabel_5_2_3 = new JLabel("Dura\u00E7\u00E3o:");
		lblNewLabel_5_2_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_3.setBounds(26, 177, 56, 14);
		panelMU.add(lblNewLabel_5_2_3);
		
		textFieldMUAno = new JTextField();
		textFieldMUAno.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textFieldMUAno.setForeground(new Color(255, 255, 255));
		textFieldMUAno.setBackground(new Color(32, 22, 57));
		textFieldMUAno.setEnabled(false);
		textFieldMUAno.setColumns(10);
		textFieldMUAno.setBounds(92, 205, 120, 20);
		panelMU.add(textFieldMUAno);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Ano:");
		lblNewLabel_5_2_1_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_1_1.setBounds(26, 208, 56, 14);
		panelMU.add(lblNewLabel_5_2_1_1);
		
		textField_MUCreditos = new JTextField();
		textField_MUCreditos.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		textField_MUCreditos.setForeground(new Color(255, 255, 255));
		textField_MUCreditos.setBackground(new Color(32, 22, 57));
		textField_MUCreditos.setEnabled(false);
		textField_MUCreditos.setColumns(10);
		textField_MUCreditos.setBounds(92, 236, 270, 20);
		panelMU.add(textField_MUCreditos);
		
		JLabel lblNewLabel_5_2_2_1 = new JLabel("Cr\u00E9ditos:");
		lblNewLabel_5_2_2_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_5_2_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_2_2_1.setBounds(26, 239, 56, 14);
		panelMU.add(lblNewLabel_5_2_2_1);
		
		comboBoxMUCodigo = new JComboBox();
		comboBoxMUCodigo.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		comboBoxMUCodigo.setForeground(new Color(255, 255, 255));
		comboBoxMUCodigo.setBackground(new Color(32, 22, 57));
		
		// ADD ITEM TO COMBOBOX (Music - UPDATE)
		// addComboItemMusicas(comboBoxMUCodigo, codigosMusicas, mDAO);
	
		comboBoxMUCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicaDAO mDAO = new MusicaDAO();
				String item = comboBoxMUCodigo.getSelectedItem().toString();
				
				int codigo = Integer.parseInt(item);
				Musica musicaSelected = mDAO.getMusica(codigo);
				
				textFieldMUNome.setText(musicaSelected.getNome());
				textFieldMUNome.setEnabled(true);
				
				DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
				textFieldMUDuracao.setText(formatter.format(musicaSelected.getDuracao()));
				textFieldMUDuracao.setEnabled(true);

				textFieldMUNome.setText(musicaSelected.getNome());
				textFieldMUNome.setEnabled(true);
				
				textFieldMUNome.setText(musicaSelected.getNome());
				textFieldMUNome.setEnabled(true);
				
				textFieldMUAno.setText(Integer.toString(musicaSelected.getAno()));
				textFieldMUAno.setEnabled(true);
				
				textField_MUCreditos.setText(musicaSelected.getCreditos());
				textField_MUCreditos.setEnabled(true);
			}
		});
		comboBoxMUCodigo.setBounds(92, 110, 120, 22);
		panelMU.add(comboBoxMUCodigo);
		
		// ALTERAR MÃ¯Â¿Â½sica
		JButton btnMUAlterar = new JButton("Alterar");
		btnMUAlterar.setBackground(new Color(32, 22, 57));
		btnMUAlterar.setForeground(new Color(255, 255, 255));
		btnMUAlterar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnMUAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMUCodigo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					String codigoStr = comboBoxMUCodigo.getSelectedItem().toString();
					int codigo = Integer.parseInt(codigoStr);
					
					Musica m = new Musica();
					MusicaDAO mDAO = new MusicaDAO();
					
					String nome = textFieldMUNome.getText();
					Time duracao = Time.valueOf(textFieldMUDuracao.getText());
					int ano = Integer.parseInt(textFieldMUAno.getText());
					String creditos = textField_MUCreditos.getText();
					
					if ((nome.equals("")) || (textFieldMUDuracao.getText().equals("")) || (textFieldMUAno.getText().equals("")) || (creditos.equals(""))) {
						JOptionPane.showMessageDialog(null, "Dados inválidos!");
					} else {
						m.setCodigo(codigo);
						if (nome.length() > 40) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 40)");
						} else {
							m.setNome(nome);
						}
						m.setDuracao(duracao);
						m.setAno(ano);
						if (creditos.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Créditos > 30)");
						} else {
							m.setCreditos(creditos);
						}
						int opcao = JOptionPane.showConfirmDialog(null, "Deseja alterar a música de código " + codigo + "?");
						if (opcao == 0) {
							if (mDAO.alterar(m) > 0) {
								JOptionPane.showMessageDialog(null, "Música alterada com sucesso!");
							} else {
								JOptionPane.showMessageDialog(null, "Falha ao alterar a música!");
							}
						}
					}
				}
			}
		});
		btnMUAlterar.setBounds(155, 290, 120, 40);
		panelMU.add(btnMUAlterar);
		
		JLabel lblNewLabel_52 = new JLabel("C\u00F3digo:");
		lblNewLabel_52.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_52.setForeground(new Color(255, 255, 255));
		lblNewLabel_52.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_52.setBounds(26, 114, 56, 14);
		panelMU.add(lblNewLabel_52);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_MU.png")));
		lblNewLabel_1.setBounds(0, 0, 655, 394);
		panelMU.add(lblNewLabel_1);
		
		panelMD = new JPanel();
		layeredPaneMusicas.setLayer(panelMD, 0);
		panelMD.setBounds(0, 0, 655, 405);
		layeredPaneMusicas.add(panelMD);
		panelMD.setLayout(null);
		
		btnVoltarMD = new JButton("Voltar");
		btnVoltarMD.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarMD.setBackground(new Color(32, 22, 57));
		btnVoltarMD.setForeground(new Color(255, 255, 255));
		btnVoltarMD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarMD.setBounds(525, 327, 99, 39);
		panelMD.add(btnVoltarMD);
		
		comboBoxMDCodigo = new JComboBox();
		comboBoxMDCodigo.setFont(new Font("Poppins", Font.PLAIN, 14));
		comboBoxMDCodigo.setForeground(new Color(255, 255, 255));
		comboBoxMDCodigo.setBackground(new Color(32, 22, 57));
		
		// ADD ITEM TO COMBOBOX (Music - DELETE)
		addComboItemMusicas(comboBoxMDCodigo, codigosMusicas, mDAO);
	
		comboBoxMDCodigo.setBounds(278, 178, 99, 28);
		panelMD.add(comboBoxMDCodigo);
		
		JLabel lblNewLabel_6 = new JLabel("C\u00F3digo:");
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 16));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(278, 144, 99, 23);
		panelMD.add(lblNewLabel_6);
		
		JButton btnMDDeletar = new JButton("Deletar");
		btnMDDeletar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnMDDeletar.setBackground(new Color(32, 22, 57));
		btnMDDeletar.setForeground(new Color(255, 255, 255));
		btnMDDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMDCodigo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					int index = comboBoxMDCodigo.getSelectedIndex();
					String codigoStr = comboBoxMDCodigo.getSelectedItem().toString();
					int codigo = Integer.parseInt(codigoStr);
					
					Musica m = new Musica();
					MusicaDAO mDAO = new MusicaDAO();
					GravaDAO gDAO = new GravaDAO();
					
					m.setCodigo(codigo);
					
					if (comboBoxMDCodigo.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Código inválido!");
					} else {
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir a música de código " + codigo + "?");
						if (confirm == 0) {
							if (gDAO.removerMusica(codigo) > 0) {
								if (mDAO.remover(m) > 0) {
									JOptionPane.showMessageDialog(null, "Música excluída com sucesso!");
									comboBoxMDCodigo.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir a música!");
								}
							} else {
								if (mDAO.remover(m) > 0) {
									JOptionPane.showMessageDialog(null, "Música excluída com sucesso!");
									comboBoxMDCodigo.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir a músicaa!");
								}
							}
						}
					}
				}
			}
		});
		btnMDDeletar.setBounds(279, 238, 99, 39);
		panelMD.add(btnMDDeletar);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_MD.png")));
		lblNewLabel_3.setBounds(0, 0, 655, 394);
		panelMD.add(lblNewLabel_3);
		
		panelMR = new JPanel();
		layeredPaneMusicas.setLayer(panelMR, 0);
		panelMR.setBounds(0, 0, 655, 405);
		layeredPaneMusicas.add(panelMR);
		panelMR.setLayout(null);
		
		btnVoltarMR = new JButton("Voltar");
		btnVoltarMR.setForeground(Color.WHITE);
		btnVoltarMR.setBackground(new Color(32, 22, 57));
		btnVoltarMR.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarMR.setBounds(541, 343, 97, 37);
		panelMR.add(btnVoltarMR);
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.setForeground(Color.WHITE);
		btnMostrarTodos.setBackground(new Color(32, 22, 57));
		btnMostrarTodos.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTableItemMusicas(table, mDAO);
			}
		});
		btnMostrarTodos.setBounds(23, 343, 142, 37);
		panelMR.add(btnMostrarTodos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 37, 378, 296);
		scrollPane.getViewport().setBackground(new Color(32, 22, 57));
		panelMR.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Poppins", Font.PLAIN, 12));
		table.setBackground(new Color(32, 22, 57));
		table.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		table.getTableHeader().setBackground(new Color(32, 22, 57));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Dura\u00E7\u00E3o", "Ano", "Cr\u00E9ditos"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnMostrarMsica = new JButton("Mostrar Música");
		btnMostrarMsica.setForeground(Color.WHITE);
		btnMostrarMsica.setBackground(new Color(32, 22, 57));
		btnMostrarMsica.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnMostrarMsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(textFieldMRCodigo.getText());
				
				if (textFieldMRCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					if (mDAO.existeMusica(codigo) > 0) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						
						DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
						DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
						DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
						leftRender.setHorizontalAlignment(JLabel.LEADING);
						rightRender.setHorizontalAlignment(JLabel.RIGHT);
						centerRender.setHorizontalAlignment(JLabel.CENTER);
						
						Musica m = new Musica();
						m = mDAO.getMusica(codigo);
						model.addRow(new Object[]{m.getCodigo(), m.getNome(),  m.getDuracao(), m.getAno(), m.getCreditos()});
						table.getColumnModel().getColumn(0).setCellRenderer(centerRender);
						table.getColumnModel().getColumn(3).setCellRenderer(centerRender);
						table.getColumnModel().getColumn(2).setCellRenderer(centerRender);
					} else {
						JOptionPane.showMessageDialog(null, "Essa música não existe!");
					}
				}
			}
		});
		btnMostrarMsica.setBounds(175, 343, 145, 37);
		panelMR.add(btnMostrarMsica);
		
		textFieldMRCodigo = new JTextField();
		textFieldMRCodigo.setForeground(Color.WHITE);
		textFieldMRCodigo.setBounds(398, 347, 71, 30);
		textFieldMRCodigo.setBackground(new Color(32, 22, 57));
		panelMR.add(textFieldMRCodigo);
		textFieldMRCodigo.setColumns(10);
		
		JLabel lblNewLabel_53 = new JLabel("Código:");
		lblNewLabel_53.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_53.setForeground(new Color(255, 255, 255));
		lblNewLabel_53.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_53.setBounds(330, 347, 58, 30);
		panelMR.add(lblNewLabel_53);
		
		JButton btnMRRelatorio = new JButton("Relatório");
		btnMRRelatorio.setForeground(Color.WHITE);
		btnMRRelatorio.setBackground(new Color(32, 22, 57));
		btnMRRelatorio.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnMRRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioMusicas r = new RelatorioMusicas();
				r.setVisible(true);
				r.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnMRRelatorio.setBounds(412, 37, 226, 30);
		panelMR.add(btnMRRelatorio);
		
		JLabel lblNewLabel_59 = new JLabel("Selecionar por estilo de gravação:");
		lblNewLabel_59.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_59.setForeground(new Color(255, 255, 255));
		lblNewLabel_59.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_59.setBounds(411, 78, 234, 30);
		panelMR.add(lblNewLabel_59);
		
		JLabel lblNewLabel_60 = new JLabel("Estilo:");
		lblNewLabel_60.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_60.setForeground(new Color(255, 255, 255));
		lblNewLabel_60.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_60.setBounds(410, 123, 40, 14);
		panelMR.add(lblNewLabel_60);
		
		textFieldMREstilo = new JTextField();
		textFieldMREstilo.setForeground(Color.WHITE);
		textFieldMREstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldMREstilo.setBackground(new Color(32, 22, 57));
		textFieldMREstilo.setBounds(460, 119, 178, 23);
		panelMR.add(textFieldMREstilo);
		textFieldMREstilo.setColumns(10);
		
		JButton btnMRSelectEstilo = new JButton("Selecionar");
		btnMRSelectEstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnMRSelectEstilo.setBackground(new Color(32, 22, 57));
		btnMRSelectEstilo.setForeground(Color.WHITE);
		btnMRSelectEstilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estilo = textFieldMREstilo.getText();
				
				if (estilo.equals("")) {
					JOptionPane.showMessageDialog(null, "Estilo inválido!");
				} else {
					ArrayList<Musica> musicas = mDAO.selectMusicaEstilo(estilo);
					if (musicas.size() == 0) {
						JOptionPane.showMessageDialog(null, "Esse estilo não possui gravações!");
					} else {
						DefaultTableModel model = (DefaultTableModel) tableMREstilo.getModel();
						model.setRowCount(0);
						
						for (int i = 0; i < musicas.size(); i++) {
							Musica m = new Musica();
							m = musicas.get(i);
							model.addRow(new Object[] {m.getCodigo(), m.getNome(), m.getAno(), estilo});
						}
					}
				}
			}
		});
		btnMRSelectEstilo.setBounds(470, 156, 125, 23);
		panelMR.add(btnMRSelectEstilo);
		
		scrollPaneMusicasR = new JScrollPane();
		scrollPaneMusicasR.getViewport().setBackground(new Color(32, 22, 57));
		scrollPaneMusicasR.setBounds(411, 190, 234, 142);
		panelMR.add(scrollPaneMusicasR);
		
		tableMREstilo = new JTable();
		tableMREstilo.setBackground(new Color(32, 22, 57));
		tableMREstilo.setForeground(new Color(255, 255, 255));
		tableMREstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableMREstilo.getTableHeader().setBackground(new Color(32, 22, 57));
		tableMREstilo.getTableHeader().setForeground(new Color(255, 255, 255));
		tableMREstilo.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPaneMusicasR.setViewportView(tableMREstilo);
		tableMREstilo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Ano", "Estilo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_MR.png")));
		lblNewLabel_4.setBounds(0, 0, 655, 394);
		panelMR.add(lblNewLabel_4);
		
		panelAlbuns = new JPanel();
		layeredPane.setLayer(panelAlbuns, 0);
		panelAlbuns.setBounds(0, 0, 655, 405);
		layeredPane.add(panelAlbuns);
		panelAlbuns.setLayout(null);
		
		layeredPaneAlbuns = new JLayeredPane();
		layeredPaneAlbuns.setBounds(0, 0, 655, 405);
		panelAlbuns.add(layeredPaneAlbuns);
		
		panelAC = new JPanel();
		layeredPaneAlbuns.setLayer(panelAC, 0);
		panelAC.setBounds(0, 0, 655, 406);
		layeredPaneAlbuns.add(panelAC);
		panelAC.setLayout(null);
		
		btnVoltarAC = new JButton("Voltar");
		btnVoltarAC.setBackground(new Color(32, 22, 57));
		btnVoltarAC.setForeground(Color.WHITE);
		btnVoltarAC.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarAC.setBounds(524, 326, 99, 39);
		panelAC.add(btnVoltarAC);
		
		JLabel lblNewLabel_8 = new JLabel("C\u00F3digo:");
		lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(53, 123, 56, 14);
		panelAC.add(lblNewLabel_8);
		
		textFieldACCodigo = new JTextField();
		textFieldACCodigo.setBackground(new Color(32, 22, 57));
		textFieldACCodigo.setForeground(Color.WHITE);
		textFieldACCodigo.setBounds(119, 120, 120, 20);
		panelAC.add(textFieldACCodigo);
		textFieldACCodigo.setColumns(10);
		
		textFieldACNome = new JTextField();
		textFieldACNome.setBackground(new Color(32, 22, 57));
		textFieldACNome.setForeground(Color.WHITE);
		textFieldACNome.setColumns(10);
		textFieldACNome.setBounds(119, 151, 299, 20);
		panelAC.add(textFieldACNome);
		
		lblNewLabel_9 = new JLabel("Nome:");
		lblNewLabel_9.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(53, 154, 56, 14);
		panelAC.add(lblNewLabel_9);
		
		textFieldACAno = new JTextField();
		textFieldACAno.setBackground(new Color(32, 22, 57));
		textFieldACAno.setForeground(Color.WHITE);
		textFieldACAno.setColumns(10);
		textFieldACAno.setBounds(119, 182, 120, 20);
		panelAC.add(textFieldACAno);
		
		lblNewLabel_11 = new JLabel("Ano:");
		lblNewLabel_11.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setBounds(53, 185, 56, 14);
		panelAC.add(lblNewLabel_11);
		
		textFieldACDistribuidora = new JTextField();
		textFieldACDistribuidora.setBackground(new Color(32, 22, 57));
		textFieldACDistribuidora.setForeground(Color.WHITE);
		textFieldACDistribuidora.setColumns(10);
		textFieldACDistribuidora.setBounds(119, 213, 299, 20);
		panelAC.add(textFieldACDistribuidora);
		
		lblNewLabel_12 = new JLabel("Distribuidora:");
		lblNewLabel_12.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setForeground(Color.WHITE);
		lblNewLabel_12.setBounds(10, 216, 99, 14);
		panelAC.add(lblNewLabel_12);
		
		textFieldACGravadora = new JTextField();
		textFieldACGravadora.setBackground(new Color(32, 22, 57));
		textFieldACGravadora.setForeground(Color.WHITE);
		textFieldACGravadora.setColumns(10);
		textFieldACGravadora.setBounds(119, 244, 299, 20);
		panelAC.add(textFieldACGravadora);
		
		lblNewLabel_13 = new JLabel("Gravadora:");
		lblNewLabel_13.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(10, 247, 99, 14);
		panelAC.add(lblNewLabel_13);
		
		textFieldACLote = new JTextField();
		textFieldACLote.setBackground(new Color(32, 22, 57));
		textFieldACLote.setForeground(Color.WHITE);
		textFieldACLote.setColumns(10);
		textFieldACLote.setBounds(119, 275, 120, 20);
		panelAC.add(textFieldACLote);
		
		lblNewLabel_14 = new JLabel("Lote:");
		lblNewLabel_14.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(53, 278, 56, 14);
		panelAC.add(lblNewLabel_14);
		
		JButton btnACInserir = new JButton("Cadastrar");
		btnACInserir.setBackground(new Color(32, 22, 57));
		btnACInserir.setForeground(Color.WHITE);
		btnACInserir.setFont(new Font("Poppins", Font.PLAIN, 14));
		// INSERIR Ã¯Â¿Â½LBUM
		btnACInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlbumDAO aDAO = new AlbumDAO();
				Album a = new Album();
				
				int codigo = Integer.parseInt(textFieldACCodigo.getText());
				String nome = textFieldACNome.getText();
				int ano = Integer.parseInt(textFieldACAno.getText());
				String distribuidora = textFieldACDistribuidora.getText();
				String gravadora = textFieldACGravadora.getText();
				int lote = Integer.parseInt(textFieldACLote.getText());
				
				if ((textFieldACCodigo.getText().equals("")) || (nome.equals("")) || (textFieldACAno.getText().equals("")) || (distribuidora.equals("")) || (gravadora.equals("")) || (textFieldACLote.getText().equals(""))) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					a.setCodigo_produto(codigo);
					if (nome.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 30)");
					} else {
						a.setNome(nome);
					}
					if (distribuidora.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Distribuidora > 30)");
					} else {
						a.setDistribuidora(distribuidora);
					}
					if (gravadora.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Gravadora > 30)");
					} else {
						a.setGravadora(gravadora);
					}
					a.setAno(ano);
					a.setLote(lote);
					if (aDAO.inserir(a) > 0) {
						JOptionPane.showMessageDialog(null, "Álbum adicionado!");
						codigosAlbuns.add(a.getCodigo_produto());
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao adicionar o Álbum!");
					}
				}
			}
		});
		btnACInserir.setBounds(186, 326, 120, 39);
		panelAC.add(btnACInserir);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_AC.png")));
		lblNewLabel_7.setBounds(0, 0, 655, 395);
		panelAC.add(lblNewLabel_7);
		
		panelAU = new JPanel();
		layeredPaneAlbuns.setLayer(panelAU, 0);
		panelAU.setBounds(0, 0, 655, 406);
		layeredPaneAlbuns.add(panelAU);
		panelAU.setLayout(null);
		
		btnVoltarAU = new JButton("Voltar");
		btnVoltarAU.setBackground(colorBG);
		btnVoltarAU.setForeground(new Color(255, 255, 255));
		btnVoltarAU.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarAU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarAU.setBounds(516, 326, 99, 39);
		panelAU.add(btnVoltarAU);
		
		textFieldAUNome = new JTextField();
		textFieldAUNome.setForeground(new Color(255, 255, 255));
		textFieldAUNome.setBackground(colorBG);
		textFieldAUNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAUNome.setEnabled(false);
		textFieldAUNome.setColumns(10);
		textFieldAUNome.setBounds(109, 148, 299, 20);
		panelAU.add(textFieldAUNome);
		
		lblNewLabel_16 = new JLabel("Nome:");
		lblNewLabel_16.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setForeground(new Color(255, 255, 255));
		lblNewLabel_16.setBounds(43, 151, 56, 14);
		panelAU.add(lblNewLabel_16);
		
		textFieldAUAno = new JTextField();
		textFieldAUAno.setForeground(new Color(255, 255, 255));
		textFieldAUAno.setBackground(colorBG);
		textFieldAUAno.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAUAno.setEnabled(false);
		textFieldAUAno.setColumns(10);
		textFieldAUAno.setBounds(109, 179, 120, 20);
		panelAU.add(textFieldAUAno);
		
		lblNewLabel_17 = new JLabel("Ano:");
		lblNewLabel_17.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setForeground(new Color(255, 255, 255));
		lblNewLabel_17.setBounds(43, 182, 56, 14);
		panelAU.add(lblNewLabel_17);
		
		textFieldAUDistribuidora = new JTextField();
		textFieldAUDistribuidora.setForeground(new Color(255, 255, 255));
		textFieldAUDistribuidora.setBackground(colorBG);
		textFieldAUDistribuidora.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAUDistribuidora.setEnabled(false);
		textFieldAUDistribuidora.setColumns(10);
		textFieldAUDistribuidora.setBounds(109, 210, 299, 20);
		panelAU.add(textFieldAUDistribuidora);
		
		lblNewLabel_18 = new JLabel("Distribuidora:");
		lblNewLabel_18.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setForeground(new Color(255, 255, 255));
		lblNewLabel_18.setBounds(10, 213, 89, 14);
		panelAU.add(lblNewLabel_18);
		
		textFieldAUGravadora = new JTextField();
		textFieldAUGravadora.setForeground(new Color(255, 255, 255));
		textFieldAUGravadora.setBackground(colorBG);
		textFieldAUGravadora.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAUGravadora.setEnabled(false);
		textFieldAUGravadora.setColumns(10);
		textFieldAUGravadora.setBounds(109, 241, 299, 20);
		panelAU.add(textFieldAUGravadora);
		
		lblNewLabel_19 = new JLabel("Gravadora:");
		lblNewLabel_19.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_19.setForeground(new Color(255, 255, 255));
		lblNewLabel_19.setBounds(10, 244, 89, 14);
		panelAU.add(lblNewLabel_19);
		
		textFieldAULote = new JTextField();
		textFieldAULote.setForeground(new Color(255, 255, 255));
		textFieldAULote.setBackground(colorBG);
		textFieldAULote.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAULote.setEnabled(false);
		textFieldAULote.setColumns(10);
		textFieldAULote.setBounds(109, 272, 120, 20);
		panelAU.add(textFieldAULote);
		
		lblNewLabel_20 = new JLabel("Lote:");
		lblNewLabel_20.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		lblNewLabel_20.setBounds(43, 275, 56, 14);
		panelAU.add(lblNewLabel_20);
		btnAUAlterar = new JButton("Alterar");
		btnAUAlterar.setBackground(colorBG);
		btnAUAlterar.setForeground(new Color(255, 255, 255));
		btnAUAlterar.setFont(new Font("Poppins", Font.PLAIN, 14));
		
		// ALTERAR ALBUM
		btnAUAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxAUCodigo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					String codigoStr = comboBoxAUCodigo.getSelectedItem().toString();
					int codigo = Integer.parseInt(codigoStr);
					
					Album a = new Album();
					AlbumDAO aDAO = new AlbumDAO();
					
					String nome = textFieldAUNome.getText();
					int ano = Integer.parseInt(textFieldAUAno.getText());
					String distribuidora = textFieldAUDistribuidora.getText();
					String gravadora = textFieldAUGravadora.getText();
					int lote = Integer.parseInt(textFieldAULote.getText());
					
					if ((nome.equals("")) || (distribuidora.equals("")) || (gravadora.equals("")) || (textFieldAUAno.getText().equals("")) || (textFieldAULote.getText().equals(""))) { 
						JOptionPane.showMessageDialog(null, "Dados inválidos!");
					} else {
						a.setCodigo_produto(codigo);
						if (nome.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 30)");
						} else {
							a.setNome(nome);
						}
						if (distribuidora.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Distribuidora > 30)");
						} else {
							a.setDistribuidora(distribuidora);
						}
						if (gravadora.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Gravadora > 30)");
						} else {
							a.setGravadora(gravadora);
						}
						a.setAno(ano);
						a.setLote(lote);
						
						if (aDAO.alterar(a) > 0) {
							JOptionPane.showMessageDialog(null, "Álbum alterado com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível alterar o álbum!");
						}
					}
				}
			}
		});
		btnAUAlterar.setBounds(165, 315, 100, 40);
		panelAU.add(btnAUAlterar);
		
		JLabel lblNewLabel_17_1 = new JLabel("C\u00F3digo:");
		lblNewLabel_17_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_17_1.setBounds(43, 119, 56, 14);
		panelAU.add(lblNewLabel_17_1);
		
		comboBoxAUCodigo = new JComboBox();
		comboBoxAUCodigo.setForeground(new Color(255, 255, 255));
		comboBoxAUCodigo.setBackground(colorBG);
		comboBoxAUCodigo.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxAUCodigo.setBounds(109, 115, 120, 22);
		panelAU.add(comboBoxAUCodigo);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_AU.png")));
		lblNewLabel_10.setBounds(0, 0, 655, 395);
		panelAU.add(lblNewLabel_10);
		
		// CHANGE TEXTFIELD AND GET SELECTED ITEM - Album
		comboBoxAUCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlbumDAO aDAO = new AlbumDAO();
				String item = comboBoxAUCodigo.getSelectedItem().toString();
				
				int codigo = Integer.parseInt(item);
				Album albumSelected = aDAO.getAlbum(codigo);
				
				textFieldAUNome.setText(albumSelected.getNome());
				textFieldAUNome.setEnabled(true);
				
				textFieldAUAno.setText(Integer.toString(albumSelected.getAno()));
				textFieldAUAno.setEnabled(true);
				
				textFieldAUDistribuidora.setText(albumSelected.getDistribuidora());
				textFieldAUDistribuidora.setEnabled(true);
				
				textFieldAUGravadora.setText(albumSelected.getGravadora());
				textFieldAUGravadora.setEnabled(true);
				
				textFieldAULote.setText(Integer.toString(albumSelected.getLote()));
				textFieldAULote.setEnabled(true);
			}
		});
		
		panelAD = new JPanel();
		layeredPaneAlbuns.setLayer(panelAD, 0);
		panelAD.setBounds(0, 0, 655, 406);
		layeredPaneAlbuns.add(panelAD);
		panelAD.setLayout(null);
		
		btnVoltarAD = new JButton("Voltar");
		btnVoltarAD.setBackground(colorBG);
		btnVoltarAD.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarAD.setForeground(new Color(255, 255, 255));
		btnVoltarAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarAD.setBounds(516, 326, 99, 39);
		panelAD.add(btnVoltarAD);
		
		lblNewLabel_21 = new JLabel("C\u00F3digo:");
		lblNewLabel_21.setForeground(new Color(255, 255, 255));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_21.setBounds(278, 148, 99, 23);
		panelAD.add(lblNewLabel_21);
		
		comboBoxADCodigo = new JComboBox();
		comboBoxADCodigo.setBackground(colorBG);
		comboBoxADCodigo.setForeground(new Color(255, 255, 255));
		comboBoxADCodigo.setBounds(278, 182, 99, 30);
		panelAD.add(comboBoxADCodigo);
		
		// DELETE Album
		btnADDeletar = new JButton("Deletar");
		btnADDeletar.setBackground(colorBG);
		btnADDeletar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnADDeletar.setForeground(new Color(255, 255, 255));
		btnADDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxADCodigo.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					int index = comboBoxADCodigo.getSelectedIndex();
					String codigoStr = comboBoxADCodigo.getSelectedItem().toString();
					int codigo = Integer.parseInt(codigoStr);
					
					Album a = new Album();
					AlbumDAO aDAO = new AlbumDAO();
					GravaDAO gDAO = new GravaDAO();
					
					a.setCodigo_produto(codigo);
					
					if (comboBoxADCodigo.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Código inválido!");
					} else {
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir o álbum de código " + codigo + "?");
						if (confirm == 0) {
							if (gDAO.removerAlbum(codigo) > 0) {
								if (aDAO.remover(a) > 0) {
									JOptionPane.showMessageDialog(null, "Álbum excluído com sucesso!");
									comboBoxADCodigo.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir o álbum!");
								}
							} else {
								if (aDAO.remover(a) > 0) {
									JOptionPane.showMessageDialog(null, "Álbum excluído com sucesso!");
									comboBoxADCodigo.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir o álbum!");
								}
							}
						}
					}
				}
			}
		});
		btnADDeletar.setBounds(278, 238, 99, 39);
		panelAD.add(btnADDeletar);
		
		lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_AD.png")));
		lblNewLabel_15.setBounds(0, 0, 655, 395);
		panelAD.add(lblNewLabel_15);
		
		panelAR = new JPanel();
		layeredPaneAlbuns.setLayer(panelAR, 0);
		panelAR.setBounds(0, 0, 655, 406);
		layeredPaneAlbuns.add(panelAR);
		panelAR.setLayout(null);
		
		btnVoltarAR = new JButton("Voltar");
		btnVoltarAR.setBackground(colorBG);
		btnVoltarAR.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarAR.setForeground(new Color(255, 255, 255));
		btnVoltarAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		
		JLabel lblNewLabel_60_1 = new JLabel("Estilo:");
		lblNewLabel_60_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_60_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_60_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_60_1.setBounds(442, 117, 46, 14);
		panelAR.add(lblNewLabel_60_1);
		btnVoltarAR.setBounds(531, 341, 99, 39);
		panelAR.add(btnVoltarAR);
		
		JScrollPane scrollPaneAlbuns = new JScrollPane();
		scrollPaneAlbuns.getViewport().setBackground(colorBG);
		scrollPaneAlbuns.setBounds(24, 47, 408, 275);
		panelAR.add(scrollPaneAlbuns);
		
		tableAlbuns = new JTable();
		tableAlbuns.setForeground(Color.WHITE);
		tableAlbuns.setBackground(colorBG);
		tableAlbuns.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableAlbuns.getTableHeader().setBackground(new Color(52, 42, 92));
		tableAlbuns.getTableHeader().setForeground(Color.WHITE);
		tableAlbuns.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPaneAlbuns.setViewportView(tableAlbuns);
		tableAlbuns.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Ano", "Distribuidora", "Gravadora", "Lote"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnARMostrarTodos = new JButton("Mostrar Todos");
		btnARMostrarTodos.setBackground(colorBG);
		btnARMostrarTodos.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnARMostrarTodos.setForeground(new Color(255, 255, 255));
		btnARMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTableItemAlbuns(tableAlbuns, aDAO);
			}
		});
		btnARMostrarTodos.setBounds(24, 341, 144, 39);
		panelAR.add(btnARMostrarTodos);
		
		JButton btnARMostrarA = new JButton("Mostrar Álbum");
		btnARMostrarA.setBackground(colorBG);
		btnARMostrarA.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnARMostrarA.setForeground(new Color(255, 255, 255));
		btnARMostrarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(textFieldARCodigo.getText());
				
				if (textFieldARCodigo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Código inválido!");
				} else {
					if (aDAO.existeAlbum(codigo) > 0) {
						DefaultTableModel model = (DefaultTableModel) tableAlbuns.getModel();
						model.setRowCount(0);
						
						Album a = new Album();
						a = aDAO.getAlbum(codigo);
						model.addRow(new Object[] {a.getCodigo_produto(), a.getNome(), a.getAno(), a.getDistribuidora(), a.getGravadora(), a.getLote()});
					} else {
						JOptionPane.showMessageDialog(null, "Esse álbum não existe!");
					}
				}
			}
		});
		btnARMostrarA.setBounds(178, 341, 143, 39);
		panelAR.add(btnARMostrarA);
		
		textFieldARCodigo = new JTextField();
		textFieldARCodigo.setForeground(new Color(255, 255, 255));
		textFieldARCodigo.setBackground(colorBG);
		textFieldARCodigo.setFont(new Font("Poppins", Font.PLAIN, 14));
		textFieldARCodigo.setBounds(402, 341, 70, 39);
		panelAR.add(textFieldARCodigo);
		textFieldARCodigo.setColumns(10);
		
		JLabel lblNewLabel_55 = new JLabel("Código:");
		lblNewLabel_55.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_55.setForeground(new Color(255, 255, 255));
		lblNewLabel_55.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_55.setBounds(331, 341, 61, 39);
		panelAR.add(lblNewLabel_55);
		
		JButton btnARRelatorio = new JButton("Relatório");
		btnARRelatorio.setBackground(colorBG);
		btnARRelatorio.setForeground(new Color(255, 255, 255));
		btnARRelatorio.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnARRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioAlbuns rA = new RelatorioAlbuns();
				rA.setVisible(true);
				rA.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnARRelatorio.setBounds(442, 46, 203, 31);
		panelAR.add(btnARRelatorio);
		
		textFieldAREstilo = new JTextField();
		textFieldAREstilo.setForeground(new Color(255, 255, 255));
		textFieldAREstilo.setBackground(colorBG);
		textFieldAREstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldAREstilo.setColumns(10);
		textFieldAREstilo.setBounds(498, 113, 147, 22);
		panelAR.add(textFieldAREstilo);
		
		JButton btnARSelectEstilo = new JButton("Selecionar");
		btnARSelectEstilo.setBackground(colorBG);
		btnARSelectEstilo.setForeground(new Color(255, 255, 255));
		btnARSelectEstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnARSelectEstilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estilo = textFieldAREstilo.getText();

				if (estilo.equals("")) {
					JOptionPane.showMessageDialog(null, "Estilo inválido!");
				} else {
					ArrayList<Album> albuns = aDAO.selectAlbumEstilo(estilo);
					if (albuns.size() == 0) {
						JOptionPane.showMessageDialog(null, "Esse estilo não possui gravações!");
					} else {
						DefaultTableModel model = (DefaultTableModel) tableAREstilo.getModel();
						model.setRowCount(0);

						for (int i = 0; i < albuns.size(); i++) {
							Album a = new Album();
							a = albuns.get(i);
							model.addRow(new Object[] {a.getCodigo_produto(), a.getNome(), a.getAno(), estilo});
						}
					}
				}
			}
		});
		btnARSelectEstilo.setBounds(442, 143, 203, 23);
		panelAR.add(btnARSelectEstilo);
		
		JLabel lblNewLabel_59_1 = new JLabel("Selecionar por estilo de gravação:");
		lblNewLabel_59_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_59_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_59_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_59_1.setBounds(442, 88, 203, 14);
		panelAR.add(lblNewLabel_59_1);
		
		JScrollPane scrollPaneAR = new JScrollPane();
		scrollPaneAR.getViewport().setBackground(colorBG);
		scrollPaneAR.setBounds(442, 177, 203, 145);
		panelAR.add(scrollPaneAR);
		
		tableAREstilo = new JTable();
		tableAREstilo.setForeground(Color.WHITE);
		tableAREstilo.setBackground(colorBG);
		tableAREstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableAREstilo.getTableHeader().setBackground(new Color(52, 42, 77));
		tableAREstilo.getTableHeader().setForeground(Color.WHITE);
		tableAREstilo.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		
		scrollPaneAR.setViewportView(tableAREstilo);
		tableAREstilo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Ano", "Estilo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_AR.png")));
		lblNewLabel_22.setBounds(0, 0, 655, 395);
		panelAR.add(lblNewLabel_22);
		
		panelArtistas = new JPanel();
		layeredPane.setLayer(panelArtistas, 0);
		panelArtistas.setBounds(0, 0, 655, 405);
		layeredPane.add(panelArtistas);
		panelArtistas.setLayout(null);
		
		layeredPaneArtistas = new JLayeredPane();
		layeredPaneArtistas.setBounds(0, 0, 655, 405);
		panelArtistas.add(layeredPaneArtistas);
		
		panelArC = new JPanel();
		layeredPaneArtistas.setLayer(panelArC, 0);
		panelArC.setBounds(0, 0, 654, 405);
		layeredPaneArtistas.add(panelArC);
		panelArC.setLayout(null);
		
		btnVoltarArC = new JButton("Voltar");
		btnVoltarArC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarArC.setBackground(colorBG);
		btnVoltarArC.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarArC.setForeground(new Color(255, 255, 255));
		btnVoltarArC.setBounds(516, 326, 99, 39);
		panelArC.add(btnVoltarArC);
		
		lblNewLabel_24 = new JLabel("CPF:");
		lblNewLabel_24.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_24.setForeground(new Color(255, 255, 255));
		lblNewLabel_24.setBounds(94, 130, 56, 14);
		panelArC.add(lblNewLabel_24);
		
		textFieldArCCPF = new JTextField();
		textFieldArCCPF.setForeground(new Color(255, 255, 255));
		textFieldArCCPF.setBackground(colorBG);
		textFieldArCCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArCCPF.setBounds(160, 127, 120, 20);
		panelArC.add(textFieldArCCPF);
		textFieldArCCPF.setColumns(10);
		
		lblNewLabel_25 = new JLabel("Nome:");
		lblNewLabel_25.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_25.setForeground(new Color(255, 255, 255));
		lblNewLabel_25.setBounds(94, 161, 56, 14);
		panelArC.add(lblNewLabel_25);
		
		textFieldArCNome = new JTextField();
		textFieldArCNome.setForeground(new Color(255, 255, 255));
		textFieldArCNome.setBackground(colorBG);
		textFieldArCNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArCNome.setColumns(10);
		textFieldArCNome.setBounds(160, 158, 299, 20);
		panelArC.add(textFieldArCNome);
		
		lblNewLabel_26 = new JLabel("Data de Nascimento:");
		lblNewLabel_26.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_26.setForeground(new Color(255, 255, 255));
		lblNewLabel_26.setBounds(10, 192, 140, 14);
		panelArC.add(lblNewLabel_26);
		
		textFieldArCDataNasc = new JTextField();
		textFieldArCDataNasc.setForeground(new Color(255, 255, 255));
		textFieldArCDataNasc.setBackground(colorBG);
		textFieldArCDataNasc.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArCDataNasc.setColumns(10);
		textFieldArCDataNasc.setBounds(160, 189, 299, 20);
		panelArC.add(textFieldArCDataNasc);
		
		lblNewLabel_27 = new JLabel("Especializa\u00E7\u00E3o:");
		lblNewLabel_27.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_27.setForeground(new Color(255, 255, 255));
		lblNewLabel_27.setBounds(30, 223, 120, 14);
		panelArC.add(lblNewLabel_27);
		
		textFieldArCEspecializacao = new JTextField();
		textFieldArCEspecializacao.setForeground(new Color(255, 255, 255));
		textFieldArCEspecializacao.setBackground(colorBG);
		textFieldArCEspecializacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArCEspecializacao.setColumns(10);
		textFieldArCEspecializacao.setBounds(160, 220, 299, 20);
		panelArC.add(textFieldArCEspecializacao);
		
		// INSERT Artista
		btnArCInserir = new JButton("Cadastrar");
		btnArCInserir.setBackground(colorBG);
		btnArCInserir.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArCInserir.setForeground(new Color(255, 255, 255));
		btnArCInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artista a = new Artista();
				ArtistaDAO aDAO = new ArtistaDAO();
				
				String cpf = textFieldArCCPF.getText();
				String nome = textFieldArCNome.getText();
				String dataNascStr = textFieldArCDataNasc.getText();
				Date dataNasc = Date.valueOf(dataNascStr);
				String especializacao = textFieldArCEspecializacao.getText();
				
				if ((cpf.equals("") || (nome.equals("")) || (dataNascStr.equals("")) || (especializacao.equals("")))) {
					JOptionPane.showMessageDialog(null, "Dados inválidos");
				} else {
					if (cpf.length() > 11) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (CPF > 11)");
					} else if (nome.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 30)");
					} else if (especializacao.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Especializacao > 30)");
					} else {
						a.setCpf(cpf);
						a.setData_nascimento(dataNasc);
						a.setNome_artistico(nome);
						a.setEspecializacao(especializacao);
						if (aDAO.inserir(a) > 0) {
							JOptionPane.showMessageDialog(null, "Artista adicionado com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Falha ao adicionar o artista!");
						}
					}
				}
			}
		});
		btnArCInserir.setBounds(200, 270, 120, 39);
		panelArC.add(btnArCInserir);
		
		lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_ArC.png")));
		lblNewLabel_23.setBounds(0, 0, 654, 394);
		panelArC.add(lblNewLabel_23);
		
		panelArU = new JPanel();
		layeredPaneArtistas.setLayer(panelArU, 0);
		panelArU.setBounds(0, 0, 654, 405);
		layeredPaneArtistas.add(panelArU);
		panelArU.setLayout(null);
		
		btnVoltarArU = new JButton("Voltar");
		btnVoltarArU.setBackground(colorBG);
		btnVoltarArU.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarArU.setForeground(new Color(255, 255, 255));
		btnVoltarArU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarArU.setBounds(516, 326, 99, 39);
		panelArU.add(btnVoltarArU);
		
		lblNewLabel_29 = new JLabel("CPF:");
		lblNewLabel_29.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_29.setForeground(new Color(255, 255, 255));
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_29.setBounds(104, 123, 56, 14);
		panelArU.add(lblNewLabel_29);
		
		lblNewLabel_30 = new JLabel("Nome:");
		lblNewLabel_30.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_30.setForeground(new Color(255, 255, 255));
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_30.setBounds(104, 154, 56, 14);
		panelArU.add(lblNewLabel_30);
		
		textFieldArUNome = new JTextField();
		textFieldArUNome.setBackground(colorBG);
		textFieldArUNome.setForeground(new Color(255, 255, 255));
		textFieldArUNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArUNome.setEnabled(false);
		textFieldArUNome.setColumns(10);
		textFieldArUNome.setBounds(170, 151, 299, 20);
		panelArU.add(textFieldArUNome);
		
		lblNewLabel_31 = new JLabel("Data de Nascimento:");
		lblNewLabel_31.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_31.setForeground(new Color(255, 255, 255));
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_31.setBounds(10, 185, 150, 14);
		panelArU.add(lblNewLabel_31);
		
		textFieldArUDataNasc = new JTextField();
		textFieldArUDataNasc.setBackground(colorBG);
		textFieldArUDataNasc.setForeground(new Color(255, 255, 255));
		textFieldArUDataNasc.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArUDataNasc.setEnabled(false);
		textFieldArUDataNasc.setColumns(10);
		textFieldArUDataNasc.setBounds(170, 182, 299, 20);
		panelArU.add(textFieldArUDataNasc);
		
		lblNewLabel_32 = new JLabel("Especializa\u00E7\u00E3o:");
		lblNewLabel_32.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_32.setForeground(new Color(255, 255, 255));
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_32.setBounds(40, 216, 120, 14);
		panelArU.add(lblNewLabel_32);
		
		textFieldArUEspecializacao = new JTextField();
		textFieldArUEspecializacao.setBackground(colorBG);
		textFieldArUEspecializacao.setForeground(new Color(255, 255, 255));
		textFieldArUEspecializacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldArUEspecializacao.setEnabled(false);
		textFieldArUEspecializacao.setColumns(10);
		textFieldArUEspecializacao.setBounds(170, 213, 299, 20);
		panelArU.add(textFieldArUEspecializacao);
		
		// UPDATE Artista
		btnArUAlterar = new JButton("Alterar");
		btnArUAlterar.setBackground(colorBG);
		btnArUAlterar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArUAlterar.setForeground(new Color(255, 255, 255));
		btnArUAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxArUCPF.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				} else {
					String cpf = comboBoxArUCPF.getSelectedItem().toString();
					
					ArtistaDAO aDAO = new ArtistaDAO();
					Artista a = new Artista();
					
					String nome = textFieldArUNome.getText();
					String dataNascStr = textFieldArUDataNasc.getText();
					Date dataNasc = Date.valueOf(dataNascStr);
					String especializacao = textFieldArUEspecializacao.getText();
					
					if (((nome.equals("")) || (dataNascStr.equals("")) || (especializacao.equals("")))) {
						JOptionPane.showMessageDialog(null, "Dados inválidos");
					} else {
						if (nome.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Nome > 30)");
						} else if (especializacao.length() > 30) {
							JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Especializacao > 30)");
						} else {
							a.setCpf(cpf);
							a.setData_nascimento(dataNasc);
							a.setNome_artistico(nome);
							a.setEspecializacao(especializacao);
							int option = JOptionPane.showConfirmDialog(null, "Deseja alterar o artista de CPF " + cpf + "?");
							if (option == 0) {
								if (aDAO.alterar(a) > 0) {
									JOptionPane.showMessageDialog(null, "Artista alterado com sucesso!");
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao alterar o artista!");
								}
							}
						}
					}
				}
			}
		});
		btnArUAlterar.setBounds(220, 265, 99, 39);
		panelArU.add(btnArUAlterar);
		
		comboBoxArUCPF = new JComboBox();
		comboBoxArUCPF.setBackground(colorBG);
		comboBoxArUCPF.setForeground(new Color(255, 255, 255));
		comboBoxArUCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxArUCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtistaDAO aDAO = new ArtistaDAO();
				String cpf = comboBoxArUCPF.getSelectedItem().toString();
				
				Artista artistaSelected = aDAO.getArtista(cpf);
				
				textFieldArUNome.setText(artistaSelected.getNome_artistico());
				textFieldArUNome.setEnabled(true);
				
				textFieldArUDataNasc.setText(artistaSelected.getData_nascimento().toString());
				textFieldArUDataNasc.setEnabled(true);
				
				textFieldArUEspecializacao.setText(artistaSelected.getEspecializacao());
				textFieldArUEspecializacao.setEnabled(true);
			}
		});
		comboBoxArUCPF.setBounds(170, 120, 120, 20);
		panelArU.add(comboBoxArUCPF);
		
		lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_ArU.png")));
		lblNewLabel_28.setBounds(0, 0, 654, 394);
		panelArU.add(lblNewLabel_28);
		
		panelArD = new JPanel();
		layeredPaneArtistas.setLayer(panelArD, 0);
		panelArD.setBounds(0, 0, 654, 405);
		layeredPaneArtistas.add(panelArD);
		panelArD.setLayout(null);
		
		btnVoltarArD = new JButton("Voltar");
		btnVoltarArD.setBackground(colorBG);
		btnVoltarArD.setForeground(new Color(255, 255, 255));
		btnVoltarArD.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarArD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarArD.setBounds(516, 326, 99, 39);
		panelArD.add(btnVoltarArD);
		
		comboBoxArDCPF = new JComboBox();
		comboBoxArDCPF.setBackground(colorBG);
		comboBoxArDCPF.setForeground(new Color(255, 255, 255));
		comboBoxArDCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxArDCPF.setBounds(278, 183, 99, 28);
		panelArD.add(comboBoxArDCPF);
		
		lblNewLabel_34 = new JLabel("CPF:");
		lblNewLabel_34.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_34.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_34.setForeground(new Color(255, 255, 255));
		lblNewLabel_34.setBounds(278, 149, 99, 23);
		panelArD.add(lblNewLabel_34);
		
		// DELETE Artista
		btnArDDeletar = new JButton("Deletar");
		btnArDDeletar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnArDDeletar.setBackground(new Color(62, 52, 87));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnArDDeletar.setBackground(colorBG);
			}
		});
		btnArDDeletar.setBackground(colorBG);
		btnArDDeletar.setForeground(new Color(255, 255, 255));
		btnArDDeletar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArDDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxArDCPF.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				} else {
					int index = comboBoxArDCPF.getSelectedIndex();
					String cpf = comboBoxArDCPF.getSelectedItem().toString();
					
					Artista a = new Artista();
					ArtistaDAO aDAO = new ArtistaDAO();
					GravaDAO gDAO = new GravaDAO();
					
					a.setCpf(cpf);
					
					if (comboBoxArDCPF.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "CPF inválido!");
					} else {
						int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir o artista de CPF " + cpf + "?");
						if (confirm == 0) {
							if (gDAO.removerArtista(cpf) > 0) {
								if (aDAO.remover(a) > 0) {
									JOptionPane.showMessageDialog(null, "Artista excluído com sucesso!");
									comboBoxArDCPF.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir o artista!");
								}
							} else {
								if (aDAO.remover(a) > 0) {
									JOptionPane.showMessageDialog(null, "Artista excluído com sucesso!");
									comboBoxArDCPF.removeItemAt(index);
								} else {
									JOptionPane.showMessageDialog(null, "Falha ao excluir o artista!");
								}
							}
						}
					}
				}
			}
		});
		btnArDDeletar.setBounds(278, 238, 99, 39);
		panelArD.add(btnArDDeletar);
		
		lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_ArD.png")));
		lblNewLabel_33.setBounds(0, 0, 654, 394);
		panelArD.add(lblNewLabel_33);
		
		panelArR = new JPanel();
		layeredPaneArtistas.setLayer(panelArR, 1);
		panelArR.setBounds(0, 0, 654, 394);
		layeredPaneArtistas.add(panelArR);
		panelArR.setLayout(null);
		
		btnVoltarArR = new JButton("Voltar");
		btnVoltarArR.setBackground(colorBG);
		btnVoltarArR.setForeground(new Color(255, 255, 255));
		btnVoltarArR.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarArR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarArR.setBounds(531, 341, 99, 39);
		panelArR.add(btnVoltarArR);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setBackground(colorBG);
		scrollPane_1.setBounds(20, 47, 412, 276);
		panelArR.add(scrollPane_1);
		
		tableArtistas = new JTable();
		tableArtistas.setBackground(colorBG);
		tableArtistas.setForeground(Color.WHITE);
		tableArtistas.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableArtistas.getTableHeader().setBackground(colorBG);
		tableArtistas.getTableHeader().setForeground(Color.WHITE);
		tableArtistas.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tableArtistas);
		tableArtistas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "Nome Art\u00EDstico", "Data de Nascimento", "Especializa\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnArRMostrarTodos = new JButton("Mostrar Todos");
		btnArRMostrarTodos.setBackground(colorBG);
		btnArRMostrarTodos.setForeground(new Color(255, 255, 255));
		btnArRMostrarTodos.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArRMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTableItemArtistas(tableArtistas, arDAO);
			}
		});
		btnArRMostrarTodos.setBounds(20, 341, 150, 39);
		panelArR.add(btnArRMostrarTodos);
		
		JButton btnArRMostrarAr = new JButton("Mostrar Artista");
		btnArRMostrarAr.setBackground(colorBG);
		btnArRMostrarAr.setForeground(new Color(255, 255, 255));
		btnArRMostrarAr.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnArRMostrarAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldArRCPF.getText();
				
				if (cpf.equals("")) {
					JOptionPane.showMessageDialog(null, "CPF inválido!");
				} else {
					if (arDAO.existeArtista(cpf) > 0) {
						DefaultTableModel model = (DefaultTableModel) tableArtistas.getModel();
						model.setRowCount(0);
						
						Artista a = new Artista();
						a = arDAO.getArtista(cpf);
						model.addRow(new Object[] {a.getCpf(), a.getNome_artistico(), a.getData_nascimento(), a.getEspecializacao()});
					} else {
						JOptionPane.showMessageDialog(null, "Esse artista não existe!");
					}
				}
			}
		});
		btnArRMostrarAr.setBounds(180, 341, 150, 39);
		panelArR.add(btnArRMostrarAr);
		
		textFieldArREstilo = new JTextField();
		textFieldArREstilo.setBackground(colorBG);
		textFieldArREstilo.setForeground(new Color(255, 255, 255));
		textFieldArREstilo.setBounds(490, 116, 157, 20);
		panelArR.add(textFieldArREstilo);
		textFieldArREstilo.setColumns(10);
		
		JLabel lblNewLabel_57 = new JLabel("Estilo:");
		lblNewLabel_57.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_57.setForeground(new Color(255, 255, 255));
		lblNewLabel_57.setBounds(442, 119, 38, 14);
		panelArR.add(lblNewLabel_57);
		
		JButton btnArRelatorio = new JButton("Relatório");
		btnArRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioArtistas ra = new RelatorioArtistas();
				ra.setVisible(true);
				ra.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnArRelatorio.setBackground(colorBG);
		btnArRelatorio.setForeground(new Color(255, 255, 255));
		btnArRelatorio.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnArRelatorio.setBounds(442, 47, 205, 33);
		panelArR.add(btnArRelatorio);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.getViewport().setBackground(colorBG);
		scrollPane_3.setBounds(442, 174, 205, 149);
		panelArR.add(scrollPane_3);
		
		tableArEstilo = new JTable();
		tableArEstilo.setBackground(colorBG);
		tableArEstilo.setForeground(Color.WHITE);
		tableArEstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableArEstilo.getTableHeader().setBackground(colorBG);
		tableArEstilo.getTableHeader().setForeground(Color.WHITE);
		tableArEstilo.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPane_3.setViewportView(tableArEstilo);
		tableArEstilo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "Nome", "Especializa\u00E7\u00E3o", "Estilo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JLabel lblNewLabel_54 = new JLabel("Selecionar artista estilo gravação:");
		lblNewLabel_54.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_54.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_54.setForeground(new Color(255, 255, 255));
		lblNewLabel_54.setBounds(442, 91, 202, 14);
		panelArR.add(lblNewLabel_54);
		
		btnSelectAr = new JButton("Selecionar");
		btnSelectAr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estilo = textFieldArREstilo.getText();
				
				if (estilo.equals("")) {
					JOptionPane.showMessageDialog(null, "Estilo inválido");
				} else {
					ArtistaDAO aDAO = new ArtistaDAO();
					ArrayList<Artista> artistas = aDAO.getArtistaEstilo(estilo);
					if (artistas.size() == 0) {
						JOptionPane.showMessageDialog(null, "Esse estilo não possui gravações!");
					} else {
						DefaultTableModel model = (DefaultTableModel) tableArEstilo.getModel();
						model.setRowCount(0);
						
						Artista a = new Artista();
						for (int i = 0; i < artistas.size(); i++) {
							a = artistas.get(i);
							model.addRow(new Object[] {a.getCpf(), a.getNome_artistico(), a.getEspecializacao(), estilo});
						}
					}
				}
			}
		});
		btnSelectAr.setBackground(colorBG);
		btnSelectAr.setForeground(new Color(255, 255, 255));
		btnSelectAr.setFont(new Font("Poppins", Font.PLAIN, 12));
		btnSelectAr.setBounds(442, 147, 205, 20);
		panelArR.add(btnSelectAr);
		
		lblNewLabel_56 = new JLabel("CPF:");
		lblNewLabel_56.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_56.setForeground(Color.WHITE);
		lblNewLabel_56.setBounds(340, 341, 50, 39);
		panelArR.add(lblNewLabel_56);
		
		textFieldArRCPF = new JTextField();
		textFieldArRCPF.setBackground(colorBG);
		textFieldArRCPF.setForeground(new Color(255, 255, 255));
		textFieldArRCPF.setColumns(10);
		textFieldArRCPF.setBounds(386, 341, 94, 39);
		panelArR.add(textFieldArRCPF);
		
		lblNewLabel_35 = new JLabel("");
		lblNewLabel_35.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_ArR.png")));
		lblNewLabel_35.setBounds(0, 0, 654, 394);
		panelArR.add(lblNewLabel_35);
		
		panelGravacoes = new JPanel();
		layeredPane.setLayer(panelGravacoes, 0);
		panelGravacoes.setBounds(0, 0, 655, 405);
		layeredPane.add(panelGravacoes);
		panelGravacoes.setLayout(null);
		
		layeredPaneGravacoes = new JLayeredPane();
		layeredPaneGravacoes.setBounds(0, 0, 655, 405);
		panelGravacoes.add(layeredPaneGravacoes);
		
		panelGC = new JPanel();
		layeredPaneGravacoes.setLayer(panelGC, 0);
		panelGC.setBounds(0, 0, 654, 394);
		layeredPaneGravacoes.add(panelGC);
		panelGC.setLayout(null);
		
		btnVoltarGC = new JButton("Voltar");
		btnVoltarGC.setBackground(colorBG);
		btnVoltarGC.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarGC.setForeground(Color.WHITE);
		btnVoltarGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarGC.setBounds(516, 325, 99, 39);
		panelGC.add(btnVoltarGC);
		
		lblNewLabel_37 = new JLabel("CPF:");
		lblNewLabel_37.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_37.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_37.setForeground(Color.WHITE);
		lblNewLabel_37.setBounds(123, 119, 57, 14);
		panelGC.add(lblNewLabel_37);
		
		comboBoxGCCPF = new JComboBox();
		comboBoxGCCPF.setBackground(colorBG);
		comboBoxGCCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGCCPF.setForeground(new Color(255, 255, 255));
		comboBoxGCCPF.setBounds(190, 115, 120, 22);
		panelGC.add(comboBoxGCCPF);
		
		lblNewLabel_38 = new JLabel("C\u00F3digo do \u00C1lbum:");
		lblNewLabel_38.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_38.setForeground(Color.WHITE);
		lblNewLabel_38.setBounds(60, 155, 120, 14);
		panelGC.add(lblNewLabel_38);
		
		comboBoxGCCodigoA = new JComboBox();
		comboBoxGCCodigoA.setBackground(colorBG);
		comboBoxGCCodigoA.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGCCodigoA.setForeground(new Color(255, 255, 255));
		comboBoxGCCodigoA.setBounds(190, 151, 120, 22);
		panelGC.add(comboBoxGCCodigoA);
		
		lblNewLabel_39 = new JLabel("C\u00F3digo da M\u00FAsica:");
		lblNewLabel_39.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_39.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_39.setForeground(Color.WHITE);
		lblNewLabel_39.setBounds(60, 188, 120, 14);
		panelGC.add(lblNewLabel_39);
		
		comboBoxGCCodigoM = new JComboBox();
		comboBoxGCCodigoM.setBackground(colorBG);
		comboBoxGCCodigoM.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGCCodigoM.setForeground(new Color(255, 255, 255));
		comboBoxGCCodigoM.setBounds(190, 184, 120, 22);
		panelGC.add(comboBoxGCCodigoM);
		
		lblNewLabel_40 = new JLabel("Data de Grava\u00E7\u00E3o:");
		lblNewLabel_40.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_40.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_40.setForeground(Color.WHITE);
		lblNewLabel_40.setBounds(60, 220, 120, 14);
		panelGC.add(lblNewLabel_40);
		
		textFieldGCDataGravacao = new JTextField();
		textFieldGCDataGravacao.setBackground(colorBG);
		textFieldGCDataGravacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGCDataGravacao.setForeground(new Color(255, 255, 255));
		textFieldGCDataGravacao.setBounds(190, 217, 299, 20);
		panelGC.add(textFieldGCDataGravacao);
		textFieldGCDataGravacao.setColumns(10);
		
		textFieldGCEstilo = new JTextField();
		textFieldGCEstilo.setBackground(colorBG);
		textFieldGCEstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGCEstilo.setForeground(new Color(255, 255, 255));
		textFieldGCEstilo.setColumns(10);
		textFieldGCEstilo.setBounds(190, 248, 299, 20);
		panelGC.add(textFieldGCEstilo);
		
		lblNewLabel_41 = new JLabel("Estilo da Grava\u00E7\u00E3o:");
		lblNewLabel_41.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_41.setForeground(Color.WHITE);
		lblNewLabel_41.setBounds(60, 251, 120, 14);
		panelGC.add(lblNewLabel_41);
		
		btnGCInserir = new JButton("Cadastrar");
		btnGCInserir.setBackground(colorBG);
		btnGCInserir.setForeground(new Color(255, 255, 255));
		btnGCInserir.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGCInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grava g = new Grava();
				GravaDAO gDAO = new GravaDAO();
				
				String cpf = comboBoxGCCPF.getSelectedItem().toString();
				String codigoMStr = comboBoxGCCodigoM.getSelectedItem().toString();
				String codigoAStr = comboBoxGCCodigoA.getSelectedItem().toString();
				int codigoM = Integer.parseInt(codigoMStr);
				int codigoA = Integer.parseInt(codigoAStr);
				
				String dataGravaStr = textFieldGCDataGravacao.getText();
				Date dataGrava = Date.valueOf(dataGravaStr);
				
				String estilo = textFieldGCEstilo.getText();
				
				if (cpf.equals("") || codigoMStr.equals("") || codigoAStr.equals("") || dataGravaStr.equals("") || estilo.equals("")) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					if (estilo.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Estilo > 30)");
					} else {
						g.setCpf_artista(cpf);
						g.setCodigo_produto(codigoA);
						g.setCodigo_musica(codigoM);
						g.setData_gravacao(dataGrava);
						g.setEstilo(estilo);
						if (gDAO.gravar(g) > 0) {
							JOptionPane.showMessageDialog(null, "Gravação cadastrada com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao realizar a gravação!");
						}
					}
				}
			}
		});
		btnGCInserir.setBounds(190, 300, 120, 39);
		panelGC.add(btnGCInserir);
		
		JLabel lblNewLabel_36 = new JLabel("");
		lblNewLabel_36.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_GC.png")));
		lblNewLabel_36.setBounds(0, 0, 654, 393);
		panelGC.add(lblNewLabel_36);
		
		panelGU = new JPanel();
		layeredPaneGravacoes.setLayer(panelGU, 0);
		panelGU.setBounds(0, 0, 654, 404);
		layeredPaneGravacoes.add(panelGU);
		panelGU.setLayout(null);
		
		btnVoltarGU = new JButton("Voltar");
		btnVoltarGU.setBackground(colorBG);
		btnVoltarGU.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarGU.setForeground(new Color(255, 255, 255));
		btnVoltarGU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarGU.setBounds(524, 327, 99, 39);
		panelGU.add(btnVoltarGU);
		
		lblNewLabel_43 = new JLabel("CPF:");
		lblNewLabel_43.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_43.setForeground(new Color(255, 255, 255));
		lblNewLabel_43.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_43.setBounds(124, 119, 56, 14);
		panelGU.add(lblNewLabel_43);
		
		comboBoxGUCPF = new JComboBox();
		comboBoxGUCPF.setBackground(colorBG);
		comboBoxGUCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGUCPF.setForeground(new Color(255, 255, 255));
		comboBoxGUCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArtistaDAO aDAO = new ArtistaDAO();
				String cpf = comboBoxGUCPF.getSelectedItem().toString();
				Artista a = aDAO.getArtista(cpf);
				
				textFieldGUDataGravacao.setEnabled(false);
				textFieldGUEstilo.setEnabled(false);
				textFieldGUDataGravacao.setText("");
				textFieldGUEstilo.setText("");
				
				textFieldGUNome.setText(a.getNome_artistico());
			}
		});
		comboBoxGUCPF.setBounds(190, 115, 120, 22);
		panelGU.add(comboBoxGUCPF);
		
		lblNewLabel_44 = new JLabel("C\u00F3digo do \u00C1lbum:");
		lblNewLabel_44.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_44.setForeground(new Color(255, 255, 255));
		lblNewLabel_44.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_44.setBounds(60, 152, 120, 14);
		panelGU.add(lblNewLabel_44);
		
		comboBoxGUCodigoA = new JComboBox();
		comboBoxGUCodigoA.setBackground(colorBG);
		comboBoxGUCodigoA.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGUCodigoA.setForeground(new Color(255, 255, 255));
		comboBoxGUCodigoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlbumDAO aDAO = new AlbumDAO();
				int codigo = Integer.parseInt(comboBoxGUCodigoA.getSelectedItem().toString());
				Album a = aDAO.getAlbum(codigo);
				
				textFieldGUDataGravacao.setEnabled(false);
				textFieldGUEstilo.setEnabled(false);
				textFieldGUDataGravacao.setText("");
				textFieldGUEstilo.setText("");
				
				textFieldGUNomeA.setText(a.getNome());
			}
		});
		comboBoxGUCodigoA.setBounds(190, 148, 120, 22);
		panelGU.add(comboBoxGUCodigoA);
		
		lblNewLabel_45 = new JLabel("C\u00F3digo da M\u00FAsica:");
		lblNewLabel_45.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_45.setForeground(new Color(255, 255, 255));
		lblNewLabel_45.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_45.setBounds(60, 181, 120, 14);
		panelGU.add(lblNewLabel_45);
		
		comboBoxGUCodigoM = new JComboBox();
		comboBoxGUCodigoM.setBackground(colorBG);
		comboBoxGUCodigoM.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGUCodigoM.setForeground(new Color(255, 255, 255));
		comboBoxGUCodigoM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusicaDAO mDAO = new MusicaDAO();
				int codigo = Integer.parseInt(comboBoxGUCodigoM.getSelectedItem().toString());
				Musica m = mDAO.getMusica(codigo);
				
				textFieldGUDataGravacao.setEnabled(false);
				textFieldGUEstilo.setEnabled(false);
				textFieldGUDataGravacao.setText("");
				textFieldGUEstilo.setText("");
				
				textFieldGUNomeM.setText(m.getNome());
			}
		});
		comboBoxGUCodigoM.setBounds(190, 177, 120, 22);
		panelGU.add(comboBoxGUCodigoM);
		
		lblNewLabel_46 = new JLabel("Data de Grava\u00E7\u00E3o:");
		lblNewLabel_46.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_46.setForeground(new Color(255, 255, 255));
		lblNewLabel_46.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_46.setBounds(60, 209, 120, 14);
		panelGU.add(lblNewLabel_46);
		
		textFieldGUDataGravacao = new JTextField();
		textFieldGUDataGravacao.setBackground(colorBG);
		textFieldGUDataGravacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGUDataGravacao.setForeground(new Color(255, 255, 255));
		textFieldGUDataGravacao.setEnabled(false);
		textFieldGUDataGravacao.setColumns(10);
		textFieldGUDataGravacao.setBounds(190, 206, 299, 20);
		panelGU.add(textFieldGUDataGravacao);
		
		textFieldGUEstilo = new JTextField();
		textFieldGUEstilo.setBackground(colorBG);
		textFieldGUEstilo.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGUEstilo.setForeground(new Color(255, 255, 255));
		textFieldGUEstilo.setEnabled(false);
		textFieldGUEstilo.setColumns(10);
		textFieldGUEstilo.setBounds(190, 234, 299, 20);
		panelGU.add(textFieldGUEstilo);
		
		lblNewLabel_47 = new JLabel("Estilo da Grava\u00E7\u00E3o:");
		lblNewLabel_47.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_47.setForeground(new Color(255, 255, 255));
		lblNewLabel_47.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_47.setBounds(60, 237, 120, 14);
		panelGU.add(lblNewLabel_47);
		
		btnGUAlterar = new JButton("Alterar");
		btnGUAlterar.setBackground(colorBG);
		btnGUAlterar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGUAlterar.setForeground(new Color(255, 255, 255));
		btnGUAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grava g = new Grava();
				GravaDAO gDAO = new GravaDAO();
				
				String cpf = comboBoxGUCPF.getSelectedItem().toString();
				int codigoA = Integer.parseInt(comboBoxGUCodigoA.getSelectedItem().toString());
				int codigoM = Integer.parseInt(comboBoxGUCodigoM.getSelectedItem().toString());
				Date dataGravacao = Date.valueOf(textFieldGUDataGravacao.getText());
				String estilo = textFieldGUEstilo.getText();
				
				if (cpf.equals("") || estilo.equals("")) {
					JOptionPane.showMessageDialog(null, "Dados inválidos!");
				} else {
					if (estilo.length() > 30) {
						JOptionPane.showMessageDialog(null, "Limite de caracteres atingido! (Estilo > 30)");
					} else {
						g.setCodigo_musica(codigoM);
						g.setCodigo_produto(codigoA);
						g.setCpf_artista(cpf);
						g.setData_gravacao(dataGravacao);
						g.setEstilo(estilo);
						if (gDAO.alterar(g) > 0) {
							JOptionPane.showMessageDialog(null, "Gravação alterada com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao alterar a gravação!");
						}
					}
				}
			}
		});
		btnGUAlterar.setBounds(190, 289, 100, 40);
		panelGU.add(btnGUAlterar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(colorBG);
		btnProcurar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnProcurar.setForeground(new Color(255, 255, 255));
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GravaDAO gDAO = new GravaDAO();
				Grava g = new Grava();
				
				String cpf = comboBoxGUCPF.getSelectedItem().toString();
				String codigoAStr = comboBoxGUCodigoA.getSelectedItem().toString();
				String codigoMStr = comboBoxGUCodigoM.getSelectedItem().toString();
				
				int codigoA = Integer.parseInt(codigoAStr);
				int codigoM = Integer.parseInt(codigoMStr);
				
				g = gDAO.getGrava(cpf, codigoA, codigoM);
				if (gDAO.existeGrava(cpf, codigoA, codigoM) > 0) {
					textFieldGUDataGravacao.setEnabled(true);
					textFieldGUEstilo.setEnabled(true);
					textFieldGUDataGravacao.setText(g.getData_gravacao().toString());
					textFieldGUEstilo.setText(g.getEstilo());
				} else {
					JOptionPane.showMessageDialog(null, "Essa gravação não existe!");
					textFieldGUDataGravacao.setText("");
					textFieldGUEstilo.setText("");
					textFieldGUDataGravacao.setEnabled(false);
					textFieldGUEstilo.setEnabled(false);
				}
			}
		});
		btnProcurar.setBounds(300, 289, 120, 40);
		panelGU.add(btnProcurar);
		
		textFieldGUNome = new JTextField();
		textFieldGUNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGUNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGUNome.setForeground(new Color(255, 255, 255));
		textFieldGUNome.setBackground(new Color(62, 52, 102));
		textFieldGUNome.setBounds(320, 116, 169, 20);
		panelGU.add(textFieldGUNome);
		textFieldGUNome.setColumns(10);
		
		textFieldGUNomeA = new JTextField();
		textFieldGUNomeA.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGUNomeA.setBackground(new Color(62, 52, 102));
		textFieldGUNomeA.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGUNomeA.setForeground(new Color(255, 255, 255));
		textFieldGUNomeA.setColumns(10);
		textFieldGUNomeA.setBounds(320, 149, 169, 20);
		panelGU.add(textFieldGUNomeA);
		
		textFieldGUNomeM = new JTextField();
		textFieldGUNomeM.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGUNomeM.setBackground(new Color(62, 52, 102));
		textFieldGUNomeM.setFont(new Font("Poppins", Font.PLAIN, 12));
		textFieldGUNomeM.setForeground(new Color(255, 255, 255));
		textFieldGUNomeM.setColumns(10);
		textFieldGUNomeM.setBounds(320, 178, 169, 20);
		panelGU.add(textFieldGUNomeM);
		
		lblNewLabel_42 = new JLabel("");
		lblNewLabel_42.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_GU.png")));
		lblNewLabel_42.setBounds(0, 0, 654, 393);
		panelGU.add(lblNewLabel_42);
		
		panelGD = new JPanel();
		layeredPaneGravacoes.setLayer(panelGD, 0);
		panelGD.setBounds(0, 0, 654, 404);
		layeredPaneGravacoes.add(panelGD);
		panelGD.setLayout(null);
		
		btnVoltarGD = new JButton("Voltar");
		btnVoltarGD.setBackground(colorBG);
		btnVoltarGD.setForeground(new Color(255, 255, 255));
		btnVoltarGD.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarGD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarGD.setBounds(524, 327, 99, 39);
		panelGD.add(btnVoltarGD);
		
		lblNewLabel_49 = new JLabel("CPF:");
		lblNewLabel_49.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_49.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_49.setForeground(new Color(255, 255, 255));
		lblNewLabel_49.setBounds(278, 100, 99, 14);
		panelGD.add(lblNewLabel_49);
		
		comboBoxGDCPF = new JComboBox();
		comboBoxGDCPF.setBackground(colorBG);
		comboBoxGDCPF.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGDCPF.setForeground(new Color(255, 255, 255));
		comboBoxGDCPF.setBounds(278, 125, 99, 22);
		panelGD.add(comboBoxGDCPF);
		
		lblNewLabel_50 = new JLabel("C\u00F3digo do \u00C1lbum:");
		lblNewLabel_50.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_50.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_50.setForeground(new Color(255, 255, 255));
		lblNewLabel_50.setBounds(267, 222, 120, 14);
		panelGD.add(lblNewLabel_50);
		
		comboBoxGDCodigoA = new JComboBox();
		comboBoxGDCodigoA.setBackground(colorBG);
		comboBoxGDCodigoA.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGDCodigoA.setForeground(new Color(255, 255, 255));
		comboBoxGDCodigoA.setBounds(267, 183, 120, 22);
		panelGD.add(comboBoxGDCodigoA);
		
		lblNewLabel_51 = new JLabel("C\u00F3digo da M\u00FAsica:");
		lblNewLabel_51.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_51.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_51.setForeground(new Color(255, 255, 255));
		lblNewLabel_51.setBounds(267, 158, 120, 14);
		panelGD.add(lblNewLabel_51);
		
		comboBoxGDCodigoM = new JComboBox();
		comboBoxGDCodigoM.setBackground(colorBG);
		comboBoxGDCodigoM.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGDCodigoM.setForeground(new Color(255, 255, 255));
		comboBoxGDCodigoM.setBounds(267, 247, 120, 22);
		panelGD.add(comboBoxGDCodigoM);
		
		btnGDDeletar = new JButton("Deletar");
		btnGDDeletar.setBackground(colorBG);
		btnGDDeletar.setForeground(new Color(255, 255, 255));
		btnGDDeletar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGDDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GravaDAO gDAO = new GravaDAO();
				Grava g = new Grava();
				
				String cpf = comboBoxGDCPF.getSelectedItem().toString();
				int codigoA = Integer.parseInt(comboBoxGDCodigoA.getSelectedItem().toString());
				int codigoM = Integer.parseInt(comboBoxGDCodigoM.getSelectedItem().toString());
				
				if (gDAO.existeGrava(cpf, codigoA, codigoM) > 0) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a gravação?");
					if (opcao == 0) {
						g.setCodigo_musica(codigoM);
						g.setCodigo_produto(codigoA);
						g.setCpf_artista(cpf);
						if (gDAO.remover(g) > 0) {
							JOptionPane.showMessageDialog(null, "Gravação excluída com sucesso!");
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível excluir a gravação!");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Gravação não encontrada!");
				}
			}
		});
		btnGDDeletar.setBounds(278, 291, 99, 39);
		panelGD.add(btnGDDeletar);
		
		lblNewLabel_48 = new JLabel("");
		lblNewLabel_48.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_GD.png")));
		lblNewLabel_48.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_48.setBounds(0, 0, 654, 393);
		panelGD.add(lblNewLabel_48);
		
		panelGR = new JPanel();
		layeredPaneGravacoes.setLayer(panelGR, 0);
		panelGR.setBounds(0, 0, 654, 394);
		layeredPaneGravacoes.add(panelGR);
		panelGR.setLayout(null);
		
		btnVoltarGR = new JButton("Voltar");
		btnVoltarGR.setBackground(colorBG);
		btnVoltarGR.setForeground(Color.WHITE);
		btnVoltarGR.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnVoltarGR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch_Screen(layeredPane, panelMenu);
			}
		});
		btnVoltarGR.setBounds(555, 340, 89, 32);
		panelGR.add(btnVoltarGR);
		
		scrollPaneGR = new JScrollPane();
		scrollPaneGR.getViewport().setBackground(colorBG);
		scrollPaneGR.getViewport().setForeground(Color.white);
		scrollPaneGR.setBounds(10, 40, 350, 280);
		panelGR.add(scrollPaneGR);
		
		tableGrava = new JTable();
		tableGrava.setBackground(colorBG);
		tableGrava.setFont(new Font("Poppins", Font.PLAIN, 12));
		tableGrava.setForeground(Color.WHITE);
		tableGrava.getTableHeader().setBackground(colorBG);
		tableGrava.getTableHeader().setForeground(Color.WHITE);
		tableGrava.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 12));
		scrollPaneGR.setViewportView(tableGrava);
		tableGrava.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data Grava\u00E7\u00E3o", "CPF Artista", "C\u00F3digo \u00C1lbum", "C\u00F3digo M\u00FAsica", "Estilo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnGRMostrarTodos = new JButton("Mostrar Todos");
		btnGRMostrarTodos.setBackground(colorBG);
		btnGRMostrarTodos.setForeground(Color.WHITE);
		btnGRMostrarTodos.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGRMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTableItemGrava(tableGrava, gDAO);
			}
		});
		btnGRMostrarTodos.setBounds(10, 340, 146, 32);
		panelGR.add(btnGRMostrarTodos);
		
		JButton btnGRMostrar = new JButton("Mostrar Gravação");
		btnGRMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataStr = comboBoxGRData.getSelectedItem().toString();
				DefaultTableModel model = (DefaultTableModel) tableGrava.getModel();
				model.setRowCount(0);
				if (dataStr.equals("")) {
					JOptionPane.showMessageDialog(null, "Data inválida!");
				} else {
					Date data = Date.valueOf(dataStr);
					GravaDAO gDAO = new GravaDAO();
					
					Grava g = gDAO.getGravaData(data);
					model.addRow(new Object[] {g.getData_gravacao(), g.getCpf_artista(), g.getCodigo_musica(), g.getCodigo_produto(), g.getEstilo()});
				}
				
			}
		});
		btnGRMostrar.setBackground(colorBG);
		btnGRMostrar.setForeground(Color.WHITE);
		btnGRMostrar.setFont(new Font("Poppins", Font.PLAIN, 13));
		btnGRMostrar.setBounds(166, 340, 157, 32);
		panelGR.add(btnGRMostrar);
		
		JLabel lblNewLabel_61 = new JLabel("Data de Gravação:");
		lblNewLabel_61.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_61.setForeground(Color.WHITE);
		lblNewLabel_61.setBounds(333, 349, 116, 14);
		panelGR.add(lblNewLabel_61);
		
		JButton btnGRRelatorio = new JButton("Relatório");
		btnGRRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioGravacao rg = new RelatorioGravacao();
				rg.setVisible(true);
				rg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		btnGRRelatorio.setBackground(colorBG);
		btnGRRelatorio.setForeground(Color.WHITE);
		btnGRRelatorio.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnGRRelatorio.setBounds(370, 40, 274, 40);
		panelGR.add(btnGRRelatorio);
		
		textFieldGRDuracaoTotal = new JTextField();
		textFieldGRDuracaoTotal.setEditable(false);
		textFieldGRDuracaoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldGRDuracaoTotal.setBackground(colorBG);
		textFieldGRDuracaoTotal.setForeground(Color.WHITE);
		textFieldGRDuracaoTotal.setFont(new Font("Poppins", Font.PLAIN, 18));
		textFieldGRDuracaoTotal.setBounds(370, 253, 274, 67);
		panelGR.add(textFieldGRDuracaoTotal);
		textFieldGRDuracaoTotal.setColumns(10);
		
		lblNewLabel_63 = new JLabel("Data de Gravação:");
		lblNewLabel_63.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_63.setForeground(Color.WHITE);
		lblNewLabel_63.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_63.setBounds(370, 164, 116, 14);
		panelGR.add(lblNewLabel_63);
		
		btnGRProcurar = new JButton("Procurar");
		btnGRProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataStr = comboBoxGRDataDuracao.getSelectedItem().toString();
				textFieldGRDuracaoTotal.setText("");
				if (dataStr.equals("")) {
					JOptionPane.showMessageDialog(null, "Data inválida!");
				} else {
					Date data = Date.valueOf(dataStr);
					GravaDAO gDAO = new GravaDAO();
					
					textFieldGRDuracaoTotal.setText("Duração Total: " + gDAO.getDuracaoGrava(data).toString());
				}
			}
		});
		btnGRProcurar.setBackground(colorBG);
		btnGRProcurar.setForeground(Color.WHITE);
		btnGRProcurar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnGRProcurar.setBounds(444, 210, 131, 32);
		panelGR.add(btnGRProcurar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(370, 91, 274, 2);
		panelGR.add(separator);
		
		JLabel lblNewLabel_62 = new JLabel("Duração total de uma gravação:");
		lblNewLabel_62.setForeground(Color.WHITE);
		lblNewLabel_62.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_62.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_62.setBounds(370, 104, 274, 40);
		panelGR.add(lblNewLabel_62);
		
		comboBoxGRData = new JComboBox();
		comboBoxGRData.setBackground(colorBG);
		comboBoxGRData.setFont(new Font("Poppins", Font.PLAIN, 12));
		comboBoxGRData.setForeground(Color.WHITE);
		comboBoxGRData.setBounds(456, 345, 89, 22);
		panelGR.add(comboBoxGRData);
		
		comboBoxGRDataDuracao = new JComboBox();
		comboBoxGRDataDuracao.setFont(new Font("Poppins", Font.PLAIN, 14));
		comboBoxGRDataDuracao.setBackground(colorBG);
		comboBoxGRDataDuracao.setForeground(Color.WHITE);
		comboBoxGRDataDuracao.setBounds(496, 160, 148, 22);
		panelGR.add(comboBoxGRDataDuracao);
		
		JLabel lblNewLabel_58 = new JLabel("New label");
		lblNewLabel_58.setIcon(new ImageIcon(LojaMusical.class.getResource("/img/BG_GR.png")));
		lblNewLabel_58.setBounds(0, 0, 654, 393);
		panelGR.add(lblNewLabel_58);
	}
	
	public void Switch_Screen(JLayeredPane l, JPanel p) {
		l.removeAll();
		l.add(p);
		l.repaint();
		l.revalidate();
	}
	
	public void addComboItemMusicas(JComboBox cb, ArrayList<Integer> array, MusicaDAO mDAO) {
		cb.removeAllItems();
		array.clear();
		array = mDAO.getCodigos();
		
		for (int i = 0; i < array.size(); i++) {
			cb.addItem(new ComboItem(Integer.toString(array.get(i)), Integer.toString(i)));
		}
	}
	
	public void addComboItemAlbuns(JComboBox cb, ArrayList<Integer> array) {
		AlbumDAO aDAO = new AlbumDAO();
		cb.removeAllItems();
		array.clear();
		array = aDAO.getCodigos();
		
		for (int i = 0; i < array.size(); i++) {
			cb.addItem(new ComboItem(Integer.toString(array.get(i)), Integer.toString(i)));
		}
	}
	
	public void addComboItemArtistas(JComboBox cb, ArrayList<String> array) {
		ArtistaDAO aDAO = new ArtistaDAO();
		cb.removeAllItems();
		array.clear();
		array = aDAO.getCpfs();
		
		for (int i = 0; i < array.size(); i++) {
			cb.addItem(new ComboItem(array.get(i), Integer.toString(i)));
		}
	}
	
	public void addComboItemDataGrava(JComboBox cb, ArrayList<Date> array) {
		GravaDAO gDAO = new GravaDAO();
		cb.removeAllItems();
		array.clear();
		array = gDAO.getDataGravacao();
		
		for (int i = 0; i < array.size(); i++) {
			cb.addItem(new ComboItem(array.get(i).toString(), Integer.toString(i)));
		}
	}
	
	public void addTableItemMusicas(JTable t, MusicaDAO mDAO) {
		DefaultTableModel model = (DefaultTableModel) t.getModel();
		model.setRowCount(0);
		
		DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
		DefaultTableCellRenderer rightRender = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		leftRender.setHorizontalAlignment(JLabel.LEADING);
		rightRender.setHorizontalAlignment(JLabel.RIGHT);
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		
		
		ArrayList<Musica> musicas = new ArrayList<>();
		musicas = mDAO.getMusicas();
		for (int i = 0; i < musicas.size(); i++) {
			Musica m = musicas.get(i);
			model.addRow(new Object[]{m.getCodigo(), m.getNome(),  m.getDuracao(), m.getAno(), m.getCreditos()});
		}
		t.getColumnModel().getColumn(0).setCellRenderer(centerRender);
		t.getColumnModel().getColumn(3).setCellRenderer(centerRender);
		t.getColumnModel().getColumn(2).setCellRenderer(centerRender);
	}
	
	public void addTableItemAlbuns(JTable t, AlbumDAO aDAO) {
		DefaultTableModel model = (DefaultTableModel) t.getModel();
		model.setRowCount(0);
		
		ArrayList<Album> albuns = new ArrayList<>();
		albuns = aDAO.getAlbuns();
		for (int i = 0; i < albuns.size(); i++) {
			Album a = albuns.get(i);
			model.addRow(new Object[] {a.getCodigo_produto(), a.getNome(), a.getAno(), a.getDistribuidora(), a.getGravadora(), a.getLote()});
		}
	}
	
	public void addTableItemArtistas(JTable t, ArtistaDAO aDAO) {
		DefaultTableModel model = (DefaultTableModel) t.getModel();
		model.setRowCount(0);
		
		ArrayList<Artista> artistas = new ArrayList<>();
		artistas = aDAO.getArtistas();
		for (int i = 0; i < artistas.size(); i++) {
			Artista a = artistas.get(i);
			model.addRow(new Object[] {a.getCpf(), a.getNome_artistico(), a.getData_nascimento(), a.getEspecializacao()});
		}
	}
	
	public void addTableItemGrava(JTable t, GravaDAO gDAO) {
		DefaultTableModel model = (DefaultTableModel) t.getModel();
		model.setRowCount(0);
		
		ArrayList<Grava> gravacoes = new ArrayList<>();
		gravacoes = gDAO.getGravacao();
		for (int i = 0; i < gravacoes.size(); i++) {
			Grava g = gravacoes.get(i);
			model.addRow(new Object[] {g.getData_gravacao(), g.getCpf_artista(), g.getCodigo_produto(), g.getCodigo_musica(), g.getEstilo()});
		}
	}
}

package gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class JanelaPrincipal {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtTelefone;
	private JTextField textField_4;
	private JTextField textBusca;

	public JanelaPrincipal() {
		JFrame frame = new JFrame("Sistema de Gerenciamento");
		frame.setSize(new Dimension(900, 600));
		frame.setMinimumSize(new Dimension(675, 450));
		frame.setPreferredSize(new Dimension(900, 600));

		JTabbedPane tabsPrincipais = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabsPrincipais, BorderLayout.CENTER);

		TabPedido tabPedido = new TabPedido();

		JPanel painelHome = painelHome();
		tabsPrincipais.addTab("Home", null, painelHome, null);
		JPanel painelPedido = painelPedido();
		tabsPrincipais.addTab("Pedidos", null, painelPedido, null);
		JPanel painelProduto = painelProduto();
		tabsPrincipais.addTab("Produtos", null, painelProduto, null);
		JPanel painelDevolucao = painelDevolucao();
		tabsPrincipais.addTab("Devolução", null, painelDevolucao, null);
		JPanel painelManutencao = painelManutencao();
		tabsPrincipais.addTab("Manutenção", null, painelManutencao, null);
		JPanel painelLote = painelLote();
		tabsPrincipais.addTab("Lotes", null, painelLote, null);
		JPanel painelFinanceiro = painelFinanceiro();
		tabsPrincipais.addTab("Financeiro", null, painelFinanceiro, null);
		JPanel painelFornecedor = painelFornecedor();
		tabsPrincipais.addTab("Fornecedores", null, painelFornecedor, null);
		JPanel painelSolicitarPecas = painelSolicitarPecas();
		tabsPrincipais.addTab("Solicitar peças", null, painelSolicitarPecas, null);

		frame.getContentPane().add(barraMenu(), BorderLayout.NORTH);

		frame.setVisible(true);

	}

	private JPanel painelHome() {
		JPanel painelHome = new JPanel();
		painelHome.setLayout(new MigLayout("", "[]", "[]"));

		return painelHome;
	}

	private JPanel painelPedido() {
		String[] columnNames = { "Modelo", "Estado", "Quantidade", "Fornecedor", "" };
		Object[][] data = new Object[500][5];

		JPanel painelPedido = new JPanel();
		painelPedido.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		{
			JTabbedPane tabsPedidos = new JTabbedPane(JTabbedPane.LEFT);
			painelPedido.add(tabsPedidos, "cell 0 1,grow");
			{
				JPanel painelCriarPedido = new JPanel();
				painelCriarPedido.setBorder(new LineBorder(Color.BLACK, 2));
				tabsPedidos.addTab("Criar pedido", null, painelCriarPedido, null);
				painelCriarPedido.setLayout(new MigLayout("", "[grow]", "[307.00,grow][70px:n,grow]"));
				{
					JPanel painelBusca = new JPanel();
					painelCriarPedido.add(painelBusca, "cell 0 0,grow");
					painelBusca.setLayout(new MigLayout("", "[::175px,grow][grow][grow]", "[][grow]"));
					{
						JLabel lblTags = new JLabel("Tags");
						painelBusca.add(lblTags, "cell 0 0,alignx left");
					}
					{
						JTextField textoBusca = new JTextField();
						textoBusca.setName("");
						painelBusca.add(textoBusca, "cell 1 0,grow");
						textoBusca.setColumns(10);
					}
					{
						JButton botaoBuscar = new JButton("Buscar");
						painelBusca.add(botaoBuscar, "cell 2 0");
					}

					JTable table = new JTable(data, columnNames);
					table.setEnabled(false);
					table.setFont(new Font("Serif", Font.PLAIN, 24));
					table.getColumnModel().getColumn(0).setPreferredWidth(300);
					table.getColumnModel().getColumn(1).setMaxWidth(150);
					table.getColumnModel().getColumn(2).setMaxWidth(75);
					table.getColumnModel().getColumn(4).setMaxWidth(100);
					table.setRowHeight(75);

					{
						JScrollPane scrollPane = new JScrollPane(table);
						scrollPane.setEnabled(true);
						scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
						painelBusca.add(scrollPane, "cell 1 1 2 1,grow");
					}
				}
				{
					JPanel painelCarrinho = new JPanel();
					painelCarrinho.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					painelCriarPedido.add(painelCarrinho, "cell 0 1,grow");
					painelCarrinho.setLayout(new MigLayout("", "[]", "[]"));
				}
			}
			{
				JPanel painelBuscarPedido = new JPanel();
				tabsPedidos.addTab("Buscar Pedido", null, painelBuscarPedido, null);
			}
		}

		return painelPedido;
	}

	private JPanel painelProduto() {
		JPanel painelProduto = new JPanel();
		painelProduto.setLayout(new MigLayout("", "[]", "[]"));

		return painelProduto;
	}

	private JPanel painelDevolucao() {
		JPanel painelDevolucao = new JPanel();
		painelDevolucao.setLayout(new MigLayout("", "[]", "[]"));

		return painelDevolucao;
	}

	private JPanel painelManutencao() {
		JPanel painelManutencao = new JPanel();
		painelManutencao.setLayout(new MigLayout("", "[]", "[]"));

		return painelManutencao;
	}

	private JPanel painelLote() {
		JPanel painelLotes = new JPanel();
		painelLotes.setLayout(new MigLayout("", "[]", "[]"));

		return painelLotes;
	}

	private JPanel painelFinanceiro() {
		JPanel painelFinanceiro = new JPanel();
		painelFinanceiro.setLayout(new MigLayout("", "[]", "[]"));

		return painelFinanceiro;
	}

	private JPanel painelFornecedor() {
		
		String[] columnNames = { "Nome", "Endereço", "Ramo", "Telefone", "Email" };
		Object[][] data = new Object[500][5];
		
		JPanel painelFornecedor = new JPanel();
		painelFornecedor.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		{
			JTabbedPane tabsFornecedores = new JTabbedPane(JTabbedPane.LEFT);
			painelFornecedor.add(tabsFornecedores, "cell 0 1,grow");
			{
				JPanel painelAdicionar = new JPanel();
				tabsFornecedores.addTab("Adicionar", null, painelAdicionar, null);
				painelAdicionar.setLayout(new MigLayout("", "[][grow][50px:n]",
						"[0px:n,grow][][25px:n:30px][0px:n,grow][][25px:n:30px][0px:n,grow][][25px:n:30px][0px:n,grow][][25px:n:30px][0px:n,grow][][25px:n:30px][0px:n,grow][][25px:n:30px][grow][][grow]"));
				{
					JLabel lblNome = new JLabel("Nome");
					painelAdicionar.add(lblNome, "cell 1 1");
				}
				{
					textField = new JTextField();
					painelAdicionar.add(textField, "cell 1 2,grow");
					textField.setColumns(10);
				}
				{
					JLabel lblEndereco = new JLabel("Endere\u00E7o");
					painelAdicionar.add(lblEndereco, "cell 1 4");
				}
				{
					textField_1 = new JTextField();
					painelAdicionar.add(textField_1, "cell 1 5,growx");
					textField_1.setColumns(10);
				}
				{
					JLabel lblRamo = new JLabel("Ramo");
					painelAdicionar.add(lblRamo, "cell 1 7");
				}
				{
					textField_2 = new JTextField();
					painelAdicionar.add(textField_2, "cell 1 8,growx");
					textField_2.setColumns(10);
				}
				{
					JLabel lblCNPJ = new JLabel("CNPJ");
					painelAdicionar.add(lblCNPJ, "cell 1 10");
				}
				{
					textField_3 = new JTextField();
					painelAdicionar.add(textField_3, "cell 1 11,growx");
					textField_3.setColumns(10);
				}
				{
					JLabel lblTelefone = new JLabel("Telefone");
					painelAdicionar.add(lblTelefone, "cell 1 13");
				}
				{
					txtTelefone = new JTextField();

					painelAdicionar.add(txtTelefone, "cell 1 14,growx");
					txtTelefone.setColumns(10);
				}
				{
					JLabel lblEmail = new JLabel("Email");
					painelAdicionar.add(lblEmail, "cell 1 16");
				}
				{
					textField_4 = new JTextField();
					painelAdicionar.add(textField_4, "cell 1 17,growx");
					textField_4.setColumns(10);
				}
				{
					JButton btnCriarFornecedor = new JButton("Adicionar");
					painelAdicionar.add(btnCriarFornecedor, "cell 1 19,alignx center");
				}

			}
			{
				JPanel painelConsultar = new JPanel();
				tabsFornecedores.addTab("Consultar", null, painelConsultar, null);
				painelConsultar.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
				{
					textBusca = new JTextField();
					painelConsultar.add(textBusca, "cell 0 0,grow");
					textBusca.setColumns(10);
				}
				{
					JComboBox<String> comboBox = new JComboBox<String>();
					painelConsultar.add(comboBox, "cell 1 0,alignx left");
				}
				{
					JPanel panel = new JPanel();
					painelConsultar.add(panel, "cell 0 1 2 1,grow");
					panel.setLayout(new MigLayout("", "[grow]", "[grow]"));
					{
						JTable table = new JTable(data,columnNames);
						table.setRowHeight(30);
						JScrollPane scrollPane = new JScrollPane(table);
						panel.add(scrollPane, "cell 0 0,grow");
					}
				}

			}
		}

		return painelFornecedor;
	}

	private JPanel painelSolicitarPecas() {
		JPanel painelSolicitarItem = new JPanel();
		painelSolicitarItem.setLayout(new MigLayout("", "[]", "[]"));

		return painelSolicitarItem;
	}

	private JMenuBar barraMenu() {

		JMenuBar menuBar = new JMenuBar();
		{
			JMenu menuArquivo = new JMenu("Arquivo");
			menuBar.add(menuArquivo);
			{
				JMenuItem mntmSair = new JMenuItem("Sair");
				mntmSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0);
					}
				});
				menuArquivo.add(mntmSair);
			}
		}
		{
			JMenu menuArquivo = new JMenu("Op\u00E7\u00F5es");
			menuBar.add(menuArquivo);
		}
		{
			JMenu menuAjuda = new JMenu("Ajuda");
			menuBar.add(menuAjuda);
		}

		return menuBar;

	}

}

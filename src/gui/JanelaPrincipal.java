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

public class JanelaPrincipal {

	public JanelaPrincipal() {
		JFrame frame = new JFrame("Sistema de Gerenciamento");
		frame.setSize(new Dimension(900, 600));
		frame.setMinimumSize(new Dimension(675, 450));
		frame.setPreferredSize(new Dimension(900, 600));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		TabPedido tabPedido = new TabPedido();

		JPanel painelHome = painelHome();
		tabbedPane.addTab("Home", null, painelHome, null);
		JPanel painelPedido = painelPedido();
		tabbedPane.addTab("Pedido", null, painelPedido, null);
		JPanel painelProduto = painelProduto();
		tabbedPane.addTab("Produto", null, painelProduto, null);
		JPanel painelDevolucao = painelDevolucao();
		tabbedPane.addTab("Devolução", null, painelDevolucao, null);

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
		Object[][] data = new Object[500][500];

		JPanel painelPedido = new JPanel();
		painelPedido.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
			painelPedido.add(tabbedPane, "cell 0 1,grow");
			{
				JPanel painelCriarPedido = new JPanel();
				painelCriarPedido.setBorder(new LineBorder(Color.BLACK, 2));
				tabbedPane.addTab("Criar pedido", null, painelCriarPedido, null);
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
					table.getColumnModel().getColumn(1).setPreferredWidth(500);
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
				tabbedPane.addTab("Buscar Pedido", null, painelBuscarPedido, null);
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
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("", "[]", "[]"));

		return painel;
	}

	private JPanel painelLote() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("", "[]", "[]"));

		return painel;
	}

	private JPanel painelFinanceiro() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("", "[]", "[]"));

		return painel;
	}

	private JPanel painelFornecedor() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("", "[]", "[]"));

		return painel;
	}

	private JPanel painelSolicitarPecas() {
		JPanel painel = new JPanel();
		painel.setLayout(new MigLayout("", "[]", "[]"));

		return painel;
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

package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;


/*IMPORTANTE: essas classes serão usadas para inicializar as tabs da janela principal. PORÉM, como parece que 
fazendo desse jeito não dá pra editar no WindowBuilder Editor a partir da janela principal, por enquanto as tabs serão inicializadas 
na janela principal*/
public class TabPedido {
	
	private JPanel painelPedido = new JPanel();
	
	protected JPanel getPainelPedido() {
		return this.painelPedido;
	}
	
	public TabPedido() {
		painelPedido.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
			painelPedido.add(tabbedPane, "cell 0 1,grow");
			{
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(Color.BLACK, 2));
				tabbedPane.addTab("New tab", null, panel, null);
				panel.setLayout(new MigLayout("", "[grow]", "[231.00,grow][grow]"));
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1, "cell 0 0,grow");
					panel_1.setLayout(new MigLayout("", "[][grow][grow]", "[][grow]"));
					{
						JTextField textField = new JTextField();
						panel_1.add(textField, "cell 1 0,growx");
						textField.setColumns(10);
					}
					{
						JButton Buscar = new JButton("New button");
						panel_1.add(Buscar, "cell 2 0");
					}
					 JTable table = new JTable();
					{
						JScrollPane scrollPane = new JScrollPane(table);
						panel_1.add(scrollPane, "cell 1 1 2 1,grow");
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					panel.add(panel_1, "cell 0 1,grow");
					panel_1.setLayout(new MigLayout("", "[]", "[]"));
				}
			}
		}
	}

}

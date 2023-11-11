package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private ButtonsPanel type, icon, content, buttons, options, input;

	private String message, title;
	private Icon m_icon;
	private Object date = new Date();
	private Color color;
	private Component component;
	private URL icon_route;

	// --------------------------------------------------------------------------------
	public MainPanel() {

		String[] icons = { "Rojo", "Amarillo", "Verde", "Azul", "BSOD", "Cara feliz" };
		String[] colors = { "Rojo", "Amarillo", "Verde", "Azul" };
		// ------------------------------------------------------------------------------------------------------
		message = JOptionPane.showInputDialog(null, "Introduzca el mensaje de las ventanas", "Prank Error",
				JOptionPane.QUESTION_MESSAGE);
		title = JOptionPane.showInputDialog(null, "Introduzca el título de las ventanas", "Prank Error",
				JOptionPane.QUESTION_MESSAGE);

		String m_icon_q = (String) JOptionPane.showInputDialog(null, "Elija el icono", "Prank Error",
				JOptionPane.QUESTION_MESSAGE, null, icons, icons[4]);
		String color_s = (String) JOptionPane.showInputDialog(null, "Elija el color del componente", "Prank Error",
				JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
		// -----------------------------------------------------
		if (color_s == null) {
			color_s = "Negro";
		}
		if (m_icon_q == null) {
			m_icon_q = "BSOD";
		}
		// -----------------------------------------------------

		switch (m_icon_q) {
		case "Rojo":
			icon_route = getClass().getResource("/img/rojo.png");
			m_icon = new ImageIcon(icon_route);
			break;
		case "Amarillo":
			icon_route = getClass().getResource("/img/amarillo.png");
			m_icon = new ImageIcon(icon_route);
			break;
		case "Verde":
			icon_route = getClass().getResource("/img/verde.png");
			m_icon = new ImageIcon(icon_route);
			break;
		case "Azul":
			icon_route = getClass().getResource("/img/azul.png");
			m_icon = new ImageIcon(icon_route);
			break;
		case "BSOD":
			icon_route = getClass().getResource("/img/sad.png");
			m_icon = new ImageIcon(icon_route);
			break;
		case "Cara feliz":
			icon_route = getClass().getResource("/img/happy.png");
			m_icon = new ImageIcon(icon_route);
			break;
		default:
			icon_route = getClass().getResource("/img/sad.png");
			m_icon = new ImageIcon(icon_route);
		}

		// -----------------------------------------------------------------

		switch (color_s) {
		case "Rojo":
			color = Color.RED;
			break;
		case "Amarillo":
			color = Color.YELLOW;
			break;
		case "Verde":
			color = Color.GREEN.darker();
			break;
		case "Azul":
			color = Color.BLUE;

			break;
		default:
			color = Color.BLACK;

		}
		component = new Message_Panel(color);
		// -----------------------------------------------------------------------------

		setLayout(new BorderLayout());
		JMenuBar bar = new JMenuBar();
		JMenu window = new JMenu("Ventana");
		JMenu message_opcion = new JMenu("Mensaje");
		JMenu text = new JMenu("Texto");

		message_opcion.add(text);
		URL exit_url = getClass().getResource("/img/x.png");
		JMenuItem exit = new JMenuItem("Salir", new ImageIcon(exit_url));
		JMenuItem message_title = new JMenuItem("Título");
		JMenuItem message_text = new JMenuItem("Contenido");
		JMenuItem message_icon = new JMenuItem("Icono");
		JMenuItem message_color = new JMenuItem("Color del componente");
		message_text.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				message = JOptionPane.showInputDialog(null, "Introduzca el mensaje de las ventanas", "Prank Error",
						JOptionPane.QUESTION_MESSAGE);
			}

		});
		message_title.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				title = JOptionPane.showInputDialog(null, "Introduzca el título de las ventanas", "Prank Error",
						JOptionPane.QUESTION_MESSAGE);
			}

		});
		message_icon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String m_icon_q = (String) JOptionPane.showInputDialog(null, "Elija el icono", "Prank Error",
						JOptionPane.QUESTION_MESSAGE, null, icons, icons[4]);
				if (m_icon_q == null) {
					m_icon_q = "BSOD";
				}
				switch (m_icon_q) {

				case "Rojo":
					icon_route = getClass().getResource("/img/rojo.png");
					m_icon = new ImageIcon(icon_route);
					break;
				case "Amarillo":
					icon_route = getClass().getResource("/img/amarillo.png");
					m_icon = new ImageIcon(icon_route);
					break;
				case "Verde":
					icon_route = getClass().getResource("/img/verde.png");
					m_icon = new ImageIcon(icon_route);
					break;
				case "Azul":
					icon_route = getClass().getResource("/img/azul.png");
					m_icon = new ImageIcon(icon_route);
					break;
				case "BSOD":
					icon_route = getClass().getResource("/img/sad.png");
					m_icon = new ImageIcon(icon_route);
					break;
				case "Cara feliz":
					icon_route = getClass().getResource("/img/happy.png");
					m_icon = new ImageIcon(icon_route);
					break;
				default:
					icon_route = getClass().getResource("/img/sad.png");
					m_icon = new ImageIcon(icon_route);

				}
			}

		});
		message_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String color_s = (String) JOptionPane.showInputDialog(null, "Elija el color del componente",
						"Prank Error", JOptionPane.QUESTION_MESSAGE, null, colors, colors[0]);
				// -------------------------------------------------------------------------------------------------------------
				if (color_s == null) {
					color_s = "Negro";
				}

				switch (color_s) {
				case "Rojo":
					color = Color.RED;
					break;
				case "Amarillo":
					color = Color.YELLOW;
					break;
				case "Verde":
					color = Color.GREEN.darker();
					break;
				case "Azul":
					color = Color.BLUE;

					break;
				default:
					color = Color.BLACK;

				}
				component = new Message_Panel(color);

			}

		});
		text.add(message_title);
		text.add(message_text);

		exit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		});
		window.add(exit);
		message_opcion.add(message_icon);
		message_opcion.add(message_color);
		bar.add(window);
		bar.add(message_opcion);
		add(bar, BorderLayout.NORTH);
		BoxPanel boxPanel = new BoxPanel();
		add(boxPanel);
		JPanel buttonsPanel = new JPanel();
		JButton show = new JButton("Mostrar");

		// -------------------------------------------------------------------------------
		show.addActionListener(new ShowAction());
		buttonsPanel.add(show);

		add(buttonsPanel, BorderLayout.SOUTH);
	}
	// ------------------------------------------------------------------------------------------------------------

	// -----------------------------------------------------------------------
	private class BoxPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public BoxPanel() {
			setLayout(new GridLayout(2, 3, 5, 5));
			// -----------------------------------------------------------------------------------------
			String types[] = { "Mensaje", "Confirmar", "Opción", "Entrada", };
			String type_message[] = { "Error", "Advertencia", "Información", "Pregunta", "Ninguno" };
			String content_message[] = { "Texto", "Icono", "Componente", "Otros", "Object[]" };
			// -----------------------------------------------------------------------------------------------
			type = new ButtonsPanel("Tipo", types);

			icon = new ButtonsPanel("Icono", type_message);
			content = new ButtonsPanel("Contenido", content_message);
			buttons = new ButtonsPanel("Confirmar",
					new String[] { "OK", "Sí y no", "Sí, no y cancelar", "OK y cancelar" });
			options = new ButtonsPanel("Opcion", new String[] { "String[]", "Icon[]", "Object[]" });
			input = new ButtonsPanel("Entrada", new String[] { "Campo de texto", "Combobox" });
			// ------------------------------------------------------------------
			add(type);
			add(icon);
			add(content);
			add(buttons);
			add(options);
			add(input);
			// -------------------------------------------------------------------------------
		}

	}

	// --------------------------------------------------------------------
	// -----------------------------------------------------------------------
	public Object getMessage() {
		String s = content.getSelection();
		if (s.equals("Texto"))
			return message;
		else if (s.equals("Icono"))
			return m_icon;
		else if (s.equals("Componente"))
			return component;
		else if (s.equals("Otros"))
			return date;

		else if (s.equals("Object[]"))
			return new Object[] { message, m_icon, component, date };
		else
			return null;

	}

	// -----------------------------------------------------
	public int getType(ButtonsPanel p) {
		String s = p.getSelection();
		if (s.equals("Error") || s.equals("Sí y no"))
			return 0;

		else if (s.equals("Advertencia") || s.equals("OK y cancelar"))
			return 2;

		else if (s.equals("Información") || s.equals("Sí, no y cancelar"))
			return 1;

		else if (s.equals("Pregunta"))
			return 3;

		else if (s.equals("Ninguno") || s.equals("OK"))
			return -1;

		else
			return -1;

	}

	// ------------------------------------------------------------------------
	public Object[] getOptions(ButtonsPanel p){
		String s = p.getSelection();
		if (s.equals("String[]"))
			return new String[] { "Rojo", "Amarillo", "Verde", "Azul" };
		else if (s.equals("Icon[]")) {

			URL red_url = getClass().getResource("/img/rojo.png"),
					yellow_url = getClass().getResource("/img/amarillo.png"),
					green_url = getClass().getResource("/img/verde.png"),
					blue_url = getClass().getResource("/img/azul.png");
			return new Icon[] { new ImageIcon(red_url), new ImageIcon(yellow_url), new ImageIcon(green_url),
					new ImageIcon(blue_url) };
		}

		else if (s.equals("Object[]"))
			return new Object[] { message, m_icon, component, date };
		else
			return null;

	};

	// --------------------------------------------------------------------------------------

	private class ShowAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				switch (type.getSelection()) {
				case "Mensaje":
					JOptionPane.showMessageDialog(MainPanel.this, getMessage(), title, getType(icon));
					break;
				case "Confirmar":
					JOptionPane.showConfirmDialog(MainPanel.this, getMessage(), title, getType(buttons), getType(icon));
					break;
				case "Entrada":
					if (input.getSelection().equals("Campo de texto"))
						JOptionPane.showInputDialog(MainPanel.this, getMessage(), title, getType(icon));
					else
						JOptionPane.showInputDialog(MainPanel.this, getMessage(), title, getType(icon), null,
								new String[] { "Rojo", "Amarillo", "Azul" }, "Rojo");
					break;
				case "Opción":
					JOptionPane.showOptionDialog(MainPanel.this, getMessage(), title, getType(buttons), getType(icon),
							null, getOptions(options), null);
				}

			} catch (HeadlessException he) {
				System.out.println();
			}
		}

	}

}
// ------------------------------------------------------------------------------------

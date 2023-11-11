package panels;

import javax.swing.*;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ButtonsPanel(String t, String[] o) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), t));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		group = new ButtonGroup();
		for (String i : o) {
			JRadioButton button = new JRadioButton(i);
			button.setActionCommand(i);
			group.add(button);
			add(button);
			button.setSelected(i == o[0]);

		}
	}

	public String getSelection() {

		return group.getSelection().getActionCommand();

	}

	private ButtonGroup group;
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Browser extends JFrame
{
	private final int BUTTON_WIDE = 170;
	private final int BUTTON_TALL = 30;
	
	/***** DECLARATION SECTION *****/
	private ArrayList<Drinks> drinks;
	private ArrayList<JPanel> panels;
	private ArrayList<JButton> buttons;
	private int length = 35;
	
	Browser()
	{
		/***** FORMATTING FRAME *****/
		super("BROWSE COCKTAILS");
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setVisible(true);
		setLocationRelativeTo(null);
		
		/***** ADDING BUTTONS *****/
		drinks = MainMenu.getDrinkList();
		buttons = new ArrayList<JButton>();
		panels = new ArrayList<JPanel>();
		
		for(int i = 0; i<drinks.size(); i++)
		{
			buttons.add(new JButton(drinks.get(i).getName()));
			panels.add(new JPanel());
			buttons.get(i).addActionListener(new BrowseMenuListener());
			panels.get(i).add(buttons.get(i));
			add(panels.get(i));
			buttons.get(i).setPreferredSize
							(new Dimension(BUTTON_WIDE, BUTTON_TALL));
			length += 45;
		}
		
		setSize(225, length);
		setResizable(false);
		
		//pack();
	}
	
	private class BrowseMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			for(int i = 0; i<drinks.size(); i++)
			{
				if(command.equals(drinks.get(i).getName()))
				{
					JOptionPane.showMessageDialog
								(null, drinks.get(i).toString());
					closeFrame();
				}
			}
			
		}
	}
	private void closeFrame()
	{
		super.dispose();
	}
}

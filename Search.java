import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Search extends JFrame
{
	private final String INGREDIENT= "Search by ingredient",
						 NAME = "Search by Cocktail Name";
	private final int BUTTON_WIDE = 170,
					  BUTTON_TALL = 30;
	private String tempString;
	private String command;
	private int length, i;
	private ArrayList<Drinks> drinkList;
	private ArrayList<Ingredients> tempList;
	private ArrayList<JPanel> panels;
	private ArrayList<JButton> buttons;
	private JPanel searchPanel;
	private JPanel resultPanel;
	private JButton ingredientButton;
	private JButton nameButton;
	private JTextField ingredientSearch;
	private JTextField nameSearch;
	
	public Search()
	{
		/***** FORMATTING FRAME *****/
		super("SEARCH COCKTAILS");
		setVisible(true);
		setLocationRelativeTo(null);
				
		/***** CREATING GUI *****/
		nameSearch = new JTextField(15);
		nameButton = new JButton(NAME);
		nameButton.addActionListener(new SearchMenuListener());
		ingredientSearch = new JTextField(15);
		ingredientButton = new JButton(INGREDIENT);
		ingredientButton.addActionListener(new SearchMenuListener());
		
		
		/***** FORMATTING PANEL *****/
		searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 2, 5, 5));
				
		
		searchPanel.add(nameSearch);
		searchPanel.add(nameButton);
		searchPanel.add(ingredientSearch);
		searchPanel.add(ingredientButton);
		
		add(searchPanel);
		
		pack();
	}
	
	private class SearchMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			command = e.getActionCommand();
			createResultPanel();
		}
	}
	
	private class BrowseMenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			command = e.getActionCommand();
			for(int i = 0; i < drinkList.size(); i++)
			{
				if(command.equals(drinkList.get(i).getName()))
				{
					JOptionPane.showMessageDialog
								(null, drinkList.get(i).toString());
					closeFrame();
				}
			}
		}
	}
	
	private void createResultPanel()
	{
		drinkList = MainMenu.getDrinkList();
		buttons = new ArrayList<JButton>();
		panels = new ArrayList<JPanel>();
		resultPanel = new JPanel();
		
		if(command.equals(NAME))
		{
			int count = 0;
			tempString = nameSearch.getText();
			remove(searchPanel);
			length = 40;
			for(int i = 0; i < drinkList.size(); i++)
			{
				if(drinkList.get(i).getName().equalsIgnoreCase(tempString))
				{
					length += 45;
					buttons.add(new JButton
									(drinkList.get(i).getName()));
					buttons.get(count).addActionListener
										(new BrowseMenuListener());
					buttons.get(count).setPreferredSize
						(new Dimension(BUTTON_WIDE, BUTTON_TALL));
					panels.add(new JPanel());
					panels.get(count).add(buttons.get(count));
					resultPanel.add(panels.get(count));
					count ++;
				}
			}
			add(resultPanel);
			setSize(225, length);
		}
		else if(command.equals(INGREDIENT))
		{
			int count = 0;
			tempString = ingredientSearch.getText();
			remove(searchPanel);
			length = 40;
			for(int i = 0; i < drinkList.size(); i++)
			{
				
				for(int num = 0; num < drinkList.get(i).getIngredients().size(); num++)
				{
					
					if(drinkList.get(i).getIngredients().get(num).getName().equalsIgnoreCase(tempString))
					{
						length += 45;
						buttons.add(new JButton(drinkList.get(i).getName()));
						buttons.get(count).addActionListener(new BrowseMenuListener());
						buttons.get(count).setPreferredSize
							(new Dimension(BUTTON_WIDE, BUTTON_TALL));
						panels.add(new JPanel());
						resultPanel.add(buttons.get(count));
						panels.get(count).add(buttons.get(count));
						resultPanel.add(panels.get(count));
						count ++;
					}
				}
			}
			add(resultPanel);
			setSize(225, length);
		}
	}
	
	private void closeFrame()
	{
		super.dispose();
	}
}

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
  
public class ComboSelections extends JFrame{
  
   public ComboSelections() {
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   getContentPane().setLayout(new FlowLayout());
	   Vector v = new Vector();
	   v.add(new JCheckBox("1", false));
	   v.add(new JCheckBox("2", false));
	   v.add(new JCheckBox("3", false));
	   v.add(new JCheckBox("4", false));
	   v.add(new JCheckBox("5", false));
	   
	   Vector v2 = new Vector();
	   v2.add(new JCheckBox("a",false));
	   v2.add(new JCheckBox("b",false));
	   v2.add(new JCheckBox("c",false));
	   v2.add(new JCheckBox("d",false));
	   v2.add(new JCheckBox("e",false));
	   
	   
	   JPanel wrapper = new JPanel();
	   wrapper.add(new CustomComboCheck(v));
	   getContentPane().add( wrapper );
	   
//	   getContentPane().add(new CustomComboCheck(v));
	   CustomComboCheck ccc = new CustomComboCheck(v2);
	   ccc.setPreferredSize(new Dimension(200, 100)); 
	   getContentPane().add(ccc);

   }
  
    public static void main(String[] args) {
    	ComboSelections cs = new ComboSelections();
    	cs.setSize(250, 350);
    	cs.setVisible(true);
    }
}

class CustomComboCheck extends JComboBox {
	
	private ArrayList<Boolean> selected;
	private Vector items;
	
	public CustomComboCheck(Vector v) {
		super(v);
		
		items = v;
		selected = new ArrayList<Boolean>();
		Collections.fill(selected, Boolean.FALSE);
		for (int i = 0; i < v.size(); i++) {
			selected.add(false);
		}
		
		setRenderer(new ComboRenderer());
		
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedItem();
				
			}
			
		});
	}
	
	private void selectedItem()
	{
		Object selectedItem = getSelectedItem();
		int index = getSelectedIndex();
		if (selectedItem instanceof JCheckBox) {
			JCheckBox check = (JCheckBox) selectedItem;
			check.setSelected(!check.isSelected());
			selected.set(index, !selected.get(index));
			repaint();
		}
	}
	public ArrayList<String> getSelected() {
		ArrayList<String> selectedItems = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof JCheckBox) {
				JCheckBox check = (JCheckBox) items.get(i);
				if (selected.get(i)) {
					selectedItems.add(check.getText());
				}
			}
		}
		return selectedItems;
	}
	
	public ArrayList<Integer> getSelectedIndices() {
		ArrayList<Integer> selectedIndices = new ArrayList<>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof JCheckBox) {
				JCheckBox check = (JCheckBox) items.get(i);
				if (selected.get(i)) {
					selectedIndices.add(i);
				}
			}
		}
		return selectedIndices;
	}
	
	public void setSelected(int index, boolean selectState) {
		  Object item = getItemAt(index);
		  if (item instanceof JCheckBox) {
			  JCheckBox check = (JCheckBox) item;
			  check.setSelected(selectState);
			  selected.set(index, selectState);
		  }

	}
	
}

class ComboRenderer implements ListCellRenderer {


	private JLabel label;
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		
		ArrayList<String> selected = new ArrayList<>();
        for (int i = 0; i < list.getModel().getSize(); i++) {
            Object item = list.getModel().getElementAt(i);
            if (item instanceof JCheckBox) {
            	JCheckBox check = (JCheckBox) item;
            	if(check.isSelected()) selected.add(check.getText());
            }
        }
        
		if (index == -1) {
			String text = String.join(", ", selected);
			return new JLabel(text);
		}
		
		// if value is a component
		if (value instanceof Component) {
			Component c=(Component) value;
			if(isSelected) {
				c.setBackground(list.getSelectionBackground());
				c.setForeground(list.getSelectionForeground());
			}
			else {
				c.setBackground(list.getBackground());
				c.setForeground(list.getForeground());
			}
			
			return c;
		}
		else {
			if (label == null ) {
				label = new JLabel(value.toString());
			}
			else {
				label.setText(value.toString());
			}
			return label;
		}
	}
}




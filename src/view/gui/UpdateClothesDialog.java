package view.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateClothesDialog extends JDialog implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JTextField txtClothesNo = new JTextField();
	private JTextField txtClothesType = new JTextField();
	private JTextField txtRent = new JTextField();
	private JButton btnSubmit=new JButton("Submit");
	private JButton btnReset=new JButton("Reset");
	
	
	public UpdateClothesDialog (ManageRentalsDialog dialog)
	{
		super(dialog, "Update Clothes",true);
		
		JPanel pnlCenter=new JPanel(new GridLayout(3,2,10,10));
		JPanel pnlSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		pnlCenter.setBorder(BorderFactory.createEmptyBorder(10,10,5,10));
		pnlSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		pnlCenter.add(new JLabel("Clothes number:", JLabel.RIGHT));
		pnlCenter.add(txtClothesNo);
		pnlCenter.add(new JLabel("New Clothes Type:", JLabel.RIGHT));
		pnlCenter.add(txtClothesType);
		pnlCenter.add(new JLabel("New Rent(RM):", JLabel.RIGHT));
		pnlCenter.add(txtRent);
		
		pnlSouth.add(btnSubmit);
		pnlSouth.add(btnReset);
		
		btnSubmit.addActionListener(this);
		btnReset.addActionListener(this);
		
		this.add(pnlCenter);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		this.getRootPane().setDefaultButton(btnSubmit);
		this.setResizable(false);
		this.pack();
		this.setLocationRelativeTo(dialog);
		this.setVisible(true);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent event) 
	{
		Object source = event.getSource();
		if (source==btnSubmit)
		{
			reset();
		}
		
		else if(source==btnReset)
		{
			reset();
		}
	}
	
	private void reset()
	{
		txtClothesNo.setText("");
		txtClothesType.setText("");
		txtRent.setText("");
	}
	
}
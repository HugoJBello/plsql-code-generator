package utilities;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.file.Files;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ui2 {

	private JFrame frame;
	private JTextField txtI;
	private JTextField txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ui2 window = new ui2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ui2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);

		JScrollPane dbms_scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("dbms_output", null, dbms_scrollPane_1, null);

		JPanel buttonPane = new JPanel();
		dbms_scrollPane_1.setRowHeaderView(buttonPane);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[]{48, -33, 0, 0, 0, 0};
		gbl_buttonPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPane.setLayout(gbl_buttonPane);

		JLabel lblGenerateDbmsoutputFrom = new JLabel("dbms_output from:");
		GridBagConstraints gbc_lblGenerateDbmsoutputFrom = new GridBagConstraints();
		gbc_lblGenerateDbmsoutputFrom.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenerateDbmsoutputFrom.gridx = 2;
		gbc_lblGenerateDbmsoutputFrom.gridy = 1;
		buttonPane.add(lblGenerateDbmsoutputFrom, gbc_lblGenerateDbmsoutputFrom);

		final JRadioButton rdbtnAnObject = new JRadioButton("an object");
		GridBagConstraints gbc_rdbtnAnObject = new GridBagConstraints();
		gbc_rdbtnAnObject.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAnObject.gridx = 3;
		gbc_rdbtnAnObject.gridy = 1;
		buttonPane.add(rdbtnAnObject, gbc_rdbtnAnObject);

		final JRadioButton rdbtnAType = new JRadioButton("a type");
		rdbtnAType.setSelected(true);
		GridBagConstraints gbc_rdbtnAType = new GridBagConstraints();
		gbc_rdbtnAType.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAType.gridx = 3;
		gbc_rdbtnAType.gridy = 2;
		buttonPane.add(rdbtnAType, gbc_rdbtnAType);

		JLabel lblVariableName = new JLabel("Variable name");
		lblVariableName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblVariableName = new GridBagConstraints();
		gbc_lblVariableName.anchor = GridBagConstraints.EAST;
		gbc_lblVariableName.insets = new Insets(0, 0, 5, 5);
		gbc_lblVariableName.gridx = 2;
		gbc_lblVariableName.gridy = 4;
		buttonPane.add(lblVariableName, gbc_lblVariableName);

		txtResult = new JTextField();
		txtResult.setText("result");
		txtResult.setColumns(10);
		GridBagConstraints gbc_txtResult = new GridBagConstraints();
		gbc_txtResult.anchor = GridBagConstraints.EAST;
		gbc_txtResult.insets = new Insets(0, 0, 5, 5);
		gbc_txtResult.gridx = 3;
		gbc_txtResult.gridy = 4;
		buttonPane.add(txtResult, gbc_txtResult);

		JLabel lblIndexedBy = new JLabel("indexed by      ");
		lblIndexedBy.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblIndexedBy = new GridBagConstraints();
		gbc_lblIndexedBy.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndexedBy.anchor = GridBagConstraints.EAST;
		gbc_lblIndexedBy.gridx = 2;
		gbc_lblIndexedBy.gridy = 5;
		buttonPane.add(lblIndexedBy, gbc_lblIndexedBy);

		txtI = new JTextField();
		txtI.setText("i");
		GridBagConstraints gbc_txtI = new GridBagConstraints();
		gbc_txtI.insets = new Insets(0, 0, 5, 5);
		gbc_txtI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtI.gridx = 3;
		gbc_txtI.gridy = 5;
		buttonPane.add(txtI, gbc_txtI);
		txtI.setColumns(10);

		final JCheckBox chckbxWithLoop = new JCheckBox("With Loop");
		GridBagConstraints gbc_chckbxWithLoop = new GridBagConstraints();
		gbc_chckbxWithLoop.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxWithLoop.gridx = 2;
		gbc_chckbxWithLoop.gridy = 7;
		buttonPane.add(chckbxWithLoop, gbc_chckbxWithLoop);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 8;
		buttonPane.add(btnGenerate, gbc_btnNewButton);

		final JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		dbms_scrollPane_1.setViewportView(tabbedPane_1);


		final JTextArea inputTextArea = new JTextArea();
		tabbedPane_1.addTab("Declaration", null, inputTextArea, null);
		inputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));
		final JTextArea outputTextArea = new JTextArea();
		tabbedPane_1.addTab("Generated dbms_output", null, outputTextArea, null);
		outputTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

		rdbtnAnObject.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	             if (rdbtnAnObject.isSelected()){rdbtnAType.setSelected(false);}
	        }
	    });
		rdbtnAType.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	             if (rdbtnAnObject.isSelected()){rdbtnAnObject.setSelected(false);}
	        }
	    });
		
		btnGenerate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = inputTextArea.getText();
				if (rdbtnAType.isSelected()){
					TableToDbmsOutput dbms = new TableToDbmsOutput();
					dbms.setVariableName(txtResult.getText());
					dbms.setIndexName(txtI.getText());
					dbms.setWithLoop(chckbxWithLoop.isSelected()); 		
					String output = dbms.convert(input);
					outputTextArea.setText(output);
				} else {
					if (rdbtnAnObject.isSelected()){
						ObjectToDbmsOutput dbms = new ObjectToDbmsOutput();
						dbms.setVariableName(txtResult.getText());
						dbms.setIndexName(txtI.getText());
						dbms.setWithLoop(chckbxWithLoop.isSelected()); 		
						String output = dbms.convert(input);
						outputTextArea.setText(output);
					}
				}
			tabbedPane_1.setSelectedIndex(1);	
			} 
		});



	}

}

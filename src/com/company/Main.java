package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class Main {

	private static JTextField textField1;
	private static JTextField textField2;

    public static void main(String[] args) {
	    JFrame frame = new JFrame("Лаба 2");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(475,135));
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
		JLabel label1 = new JLabel("Укажите путь к входному файлу: ");
		label1.setBounds(5,5,200,20);
		panel.add(label1);
		textField1 = new JTextField();
		textField1.setBounds(5,30,200,20);
		textField1.setEnabled(false);
		panel.add(textField1);
		JButton fileOpen = new JButton("...");
		fileOpen.setBounds(205,30,20,19);
		panel.add(fileOpen);
		JLabel label2 = new JLabel("Укажите путь к выходному файлу: ");
		label2.setBounds(235,5,205,20);
		panel.add(label2);
		textField2 = new JTextField();
		textField2.setBounds(235,30,200,20);
		textField2.setEnabled(false);
		panel.add(textField2);
		JButton fileSave = new JButton("...");
		fileSave.setBounds(435,30,20,19);
		panel.add(fileSave);
		JButton startParse = new JButton("Начать поиск слов");
		startParse.setBounds(5,60,450,30);
		panel.add(startParse);
		frame.getContentPane().add(panel);
	    frame.pack();
	    frame.setVisible(true);
		fileOpen.addActionListener(e -> clickSelectFile("Open"));
		fileSave.addActionListener(e -> clickSelectFile("Save"));
		startParse.addActionListener(e -> {
			HashMap<String, Integer> hashMap = ReadWriteClass.ReadFile(textField1.getText());
			Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
			Comparator<Map.Entry<String, Integer>> valueComparator = new ComparatorClass<Map.Entry<String, Integer>>();
			List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<>(entries);
			listOfEntries.sort(valueComparator);
			ReadWriteClass.WriteFile(listOfEntries,textField2.getText());

		});
    }

    private static void clickSelectFile(String status) {
    	JFileChooser fc = new JFileChooser();
    	if (status.equals("Open")) {
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				textField1.setText(file.getPath());
			}
		} else if (status.equals("Save")) {
    		int returnVal = fc.showSaveDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				textField2.setText(file.getPath());
			}
		}

	}

}

package com.sample;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FrameWithButtons {
	
	public int counter = 0;
	
	public void wyswietl(String pytanie, String[] opcje) {
        JPanel panel = new JPanel(new GridLayout(opcje.length + 1, 1));
        panel.add(new JLabel(pytanie));
        JRadioButton[] buttons = new JRadioButton[opcje.length];
        ButtonGroup buttonGroup = new ButtonGroup(); //trzeba bylo dodac, zeby kilka na raz sie nie zaznaczalo
        int i = 0;
        for (String str : opcje) {
        	buttons[i] = new JRadioButton(str);
            panel.add(buttons[i]);
            buttonGroup.add(buttons[i]);
            i++;
        }
        buttons[0].setSelected(true);
        JOptionPane.showMessageDialog(null, panel, pytanie, JOptionPane.PLAIN_MESSAGE);
        for (JRadioButton checkBox : buttons) {
        	if (checkBox.isSelected()) {
        		//return checkBox.getText();
        		DroolsTest dr = new DroolsTest();
        		dr.kotek = (String) checkBox.getText();
        		counter++;
        	}
        }
        //return "Kotek";
    }
}

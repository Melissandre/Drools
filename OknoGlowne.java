package com.sample;

import javax.swing.JFrame;

public class OknoGlowne extends JFrame {
	
	private DroolsTest test;
	
	private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
	
	public OknoGlowne() {
		test = new DroolsTest();
		setTitle("Wybierz swój cel podróży");
		initComponents();
	}
	
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wybierz cel podróży");
        setBounds(new java.awt.Rectangle(200, 200, 0, 0));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(610, 435));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Wybierz z nami cel swojej podróży");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 20, 550, 60);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 340, 120, 20);
        jLabel2.setIcon(new javax.swing.ImageIcon("src/podroz.png")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 90, 499, 228);

        pack();
    }                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	this.setVisible(false);
    	test.startDrools();
    }
}

package com.sample;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javafx.scene.control.ComboBox;

import javax.swing.*;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
	
	//NewJFrame frame = new NewJFrame("kot",new String[]{"kot"});
	public static String kotek;

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            //Message message = new Message();
            //message.setMessage("Hello World");
            //message.setStatus(Message.HELLO);
            //ksession.insert(message);
            DisplayFrame disp = new DisplayFrame();
            (new Thread(disp)).start();
            ksession.insert(disp);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
    
    public static class Question {
    	public String nazwaPytania;
    	public Question (String nazwa) {
    		this.nazwaPytania = nazwa;
    	}
    }
    
    public static class Chosen {
    	public String nazwa;
    	public Chosen (String nazwa) {
    		this.nazwa = nazwa;
    	}
    }
    
    private static class SwingBlocker implements ActionListener{
    	@Override public void actionPerformed(ActionEvent arg0) {
    	            //System.out.println(dialog.getAnswer());
    	        }
    	}
    
    public static class DisplayFrame implements Runnable{
    	
    	SwingBlocker blocker = new SwingBlocker();
    	
    	public DisplayFrame() {
    		System.out.println("Utworzono displayFrame");
    	}
    	
    	public void setQuestion2 (String nazwaPytania, String[] lista) {
    		NewJFrame frame = new NewJFrame(nazwaPytania,lista);
    		frame.setVisible(true);
    		//String f = frame.getNew();
    		//System.out.println("toCreateNewOne "+ f);
    		//return frame.toCreateNewOne;
    	}
    	
    	public String getKotek() {
    		return DroolsTest.kotek;
    	}
    	/*
    	public String koteczek() {
    		String kociu = this.kotek;
    		return kociu;
    	}
    	*/
    	public void waiting(int miliseconds){

        	try {
        	Thread.sleep( miliseconds);
        	}
        	catch (InterruptedException e) {}	
        	}
    	
    	public void run() {
    		
    	}
    }
/*
    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
*/
}

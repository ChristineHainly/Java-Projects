/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplelogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author Christine
 */
public class SimpleLogin {
// Creates/Appends to the file log.txt
    public void writeNewEntry(String x, String username) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
            // Creates a time stamp from the internal clock
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd, HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
                        
            // Separates each log entry
            bw.write("***");
            bw.newLine();
            
            // Prints the date/time and the data entered as the argument
            bw.write(dtf.format(now) + " EST, User: " + username + ", Status: "+ x);
            bw.newLine();
            
            // Tests if the file was created: System.out.print("File Created!");
        } catch (IOException e) {
            throw new RuntimeException(e);
            //System.out.print("Print to log did not work");
        }
    }

    private JFrame frame;
    private JTextField txtUsername;
    private JTextField txtPassword;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SimpleLogin window = new SimpleLogin();
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
    public SimpleLogin() {
            initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel.setBounds(211, 27, 89, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(100, 93, 62, 14);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(100, 131, 62, 14);
        frame.getContentPane().add(lblPassword);

        txtUsername = new JTextField();
        txtUsername.setBounds(187, 90, 171, 20);
        frame.getContentPane().add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setBounds(187, 128, 171, 20);
        frame.getContentPane().add(txtPassword);
        txtPassword.setColumns(10);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent arg0) {
                String username = getUserName();
                String password = getPassword();
                Authenticate(username, password);
            }
        });
        btnLogin.setBounds(136, 205, 89, 23);
        frame.getContentPane().add(btnLogin);

        JButton btnClear = new JButton("Clear");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                txtUsername.setText(null);
                txtPassword.setText(null);
            }
        });
        btnClear.setBounds(267, 205, 89, 23);
        frame.getContentPane().add(btnClear);

        JSeparator separator = new JSeparator();
        separator.setBounds(39, 182, 406, 2);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(39, 58, 406, 2);
        frame.getContentPane().add(separator_1);
    }
    public String getUserName() {                
        String username = txtUsername.getText();
        return username;
    }

    public String getPassword() {
        String password = txtPassword.getText();
        return password;
    }

    public void Authenticate(String username, String password) {
        if (password.contains("TestPassword") && username.contains("TestUser")){
            writeNewEntry("Pass", username);
            txtPassword.setText(null);
            txtUsername.setText(null);
            JOptionPane.showMessageDialog(null, "Welcome!!", "Homescreen", JOptionPane.DEFAULT_OPTION);
        }else {
            writeNewEntry("Fail", username);
            JOptionPane.showMessageDialog(null, "Incorrect Login Information", "Login Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.setText(null);
            txtUsername.setText(null);
        }
    }
}

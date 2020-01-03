package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserView {

    private JPanel rootPanel;
    private JPanel NavPanel;
    private JButton btnSignIn;
    private JButton btnSignUp;
    private JPanel CardPanel;
    private JPanel RegisterPanel;
    private JTextField txtUsernameSU;
    private JPasswordField txtPassWordSU;
    private JPasswordField txtCPasswordSU;
    private JButton btnRegister;
    private JPanel LoginPanel;
    private JButton btnLogin;
    private JTextField txtUsernameSI;
    private JPasswordField txtPasswordSI;

    CardLayout cardLayout;

    public UserView() {
        cardLayout = (CardLayout) CardPanel.getLayout();

        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(CardPanel, "Login");
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(CardPanel, "Register");
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

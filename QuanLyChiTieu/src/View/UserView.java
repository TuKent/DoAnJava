package View;

import Controller.NewMembersControllerImpl;
import Controller.NewUsersController;
import Model.TableObserver;
import Model.User;
import Model.UsersModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
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

    private UsersModel usersModel;

    public UserView(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public String getTxtUsernameSU() {
        return txtUsernameSU.getText();
    }

    public String getTxtPassWordSU() {
        System.out.println(txtPassWordSU.getText());
        return (txtPassWordSU.getPassword().toString());
    }

    public String getTxtCPasswordSU() {
        System.out.println(txtCPasswordSU.toString());
        return (txtCPasswordSU.getPassword().toString());
    }


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
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegister(e);
            }
        });
    }

    private void onRegister(ActionEvent e) {
        NewUsersController controller = new NewMembersControllerImpl(rootPanel,usersModel, this);
        controller.newMember();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

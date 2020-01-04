package View;

import Controller.NewMembersControllerImpl;
import Controller.NewUsersController;
import Model.TableObserver;
import Model.User;
import Model.UsersModel;
import Model.UsersModelImpl;

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

    public CardLayout getCardLayout() {
        return cardLayout;
    }


    public JPanel getCardPanel() {
        return CardPanel;
    }

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
    private JTextField textTotal;
    private JComboBox comboBox1;
    private JTable PayTable;
    private JButton btnAddPay;
    private JButton btnEditPay;
    private JButton btnDeletePay;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;

    CardLayout cardLayout;

    private UsersModel usersModel;

    public UserView(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    //REGISTER FORM
    public String getTxtUsernameSU() {
        return txtUsernameSU.getText();
    }

    public String getTxtPassWordSU() {
        return new String(txtPassWordSU.getPassword());
    }

    public String getTxtCPasswordSU() {
        return new String(txtCPasswordSU.getPassword());
    }


    //LOGIN FORM


    public String getTxtUsernameSI() {
        return txtUsernameSI.getText();
    }

    public String getTxtPasswordSI() {
        return new String(txtPasswordSI.getPassword());
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
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin(e);
            }
        });
    }

    private void onRegister(ActionEvent e) {
        usersModel = new UsersModelImpl();
        NewUsersController controller = new NewMembersControllerImpl(rootPanel,usersModel, this);
        controller.newMember();
    }

    private void onLogin(ActionEvent e)
    {
        usersModel = new UsersModelImpl();
        NewUsersController controller = new NewMembersControllerImpl(rootPanel,usersModel,this);
        controller.oldMember();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

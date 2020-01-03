package Controller;

import Model.UsersModel;
import Model.User;
import Model.User;
import Model.UsersModel;
import View.UserView;
import View.UserView;

import javax.swing.*;
import java.awt.*;

public class NewMembersControllerImpl implements NewUsersController {
    private Component parent;

    private UsersModel model;

    private UserView view;

    public NewMembersControllerImpl(Component parent, UsersModel model, UserView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void newMember() {
        String mFullName = view.getTxtUsernameSU();
        String mPassword = view.getTxtPassWordSU();
        String mCpassword = view.getTxtCPasswordSU();

        if (view.getTxtUsernameSU().trim().equals("")) {
            JOptionPane.showMessageDialog(parent, "User không được bỏ trống", "Something wrong here!", JOptionPane.OK_OPTION);

        }
        else if (view.getTxtPassWordSU().trim().equals(""))
        {
            JOptionPane.showMessageDialog(parent, "Password không được bỏ trống", "Something wrong here!", JOptionPane.OK_OPTION);
        }
        else if (view.getTxtPassWordSU().toString() != view.getTxtCPasswordSU().toString())
        {
            JOptionPane.showMessageDialog(parent, "Password không trùng khớp", "Something wrong here!", JOptionPane.OK_OPTION);
        }
        else
        {
            User user = new User();
            user.setFullName(mFullName);
            user.setPassword(mPassword);
            model.addUser(user);
        }
    }
}

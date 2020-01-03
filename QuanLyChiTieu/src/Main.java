import View.UserView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args)  {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("ỨNG DỤNG QUẢN LÝ CHI TIÊU");
        jFrame.setContentPane(new UserView().getRootPanel());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setPreferredSize(new Dimension(800,520));
        jFrame.pack();
        jFrame.setVisible(true);

    }


}

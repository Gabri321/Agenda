package ui;

import Business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JPanel rootPanel;
    private JLabel N;
    private JTextField nameText;
    private JTextField phoneText;
    private JButton saveButton;
    private JButton cancelButton;
    private ContactBusiness mContactBusiness;

    public ContactForm() {
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLocation(dim.width / 2 - getWidth() / 2, dim.height / 2 - dim.height / 2);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setListeners();
        mContactBusiness = new ContactBusiness();

    }


    private void setListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    String name = nameText.getText();
                    String phone = phoneText.getText();

                    mContactBusiness.save(name, phone);
                    new MainPanel();
                    dispose();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Nome ou celular não podem ser vazios");
                }

            }

        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainPanel();
                dispose();

            }
        });

    }
}



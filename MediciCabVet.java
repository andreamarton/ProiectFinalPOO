package cabinetVeterinar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MediciCabVet extends JFrame{
    private  int statusMed;
    private JPanel MyPanel2;
    private JButton LogIn;
    private JRadioButton ButonRadio3;
    private JRadioButton ButonRadio1;
    private JRadioButton ButonRadio2;

    private Proiect2 proiect2frame;
    public MediciCabVet(int statusMed)
    {
        this.statusMed=statusMed;
    }
    public MediciCabVet()
    {
        setTitle("LOG IN");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel MyPanel2 = new JPanel();
        add(MyPanel2);

        JButton LogIn = new JButton("Log In");
        MyPanel2.add(LogIn);

        ButonRadio1 = new JRadioButton("Doctor Ana-Maria");
        ButonRadio2 = new JRadioButton("Doctor Alin");
        ButonRadio3 = new JRadioButton("Doctor Rezident Mihai");

        // Add radio buttons to a ButtonGroup
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(ButonRadio1);
        buttonGroup.add(ButonRadio2);
        buttonGroup.add(ButonRadio3);

        MyPanel2.add(ButonRadio1);
        MyPanel2.add(ButonRadio2);
        MyPanel2.add(ButonRadio3);
        LogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ButonRadio1.isSelected())
                    statusMed=1;
                if(ButonRadio2.isSelected())
                    statusMed=2;
                if(ButonRadio3.isSelected())
                    statusMed=3;
                Proiect2 frame = new Proiect2(statusMed);
                frame.setVisible(true);
                JOptionPane.showMessageDialog(null,"Logare cu succes","LOG IN",JOptionPane.INFORMATION_MESSAGE);
                dispose();

            }

        });
        ButonRadio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButonRadio2.setSelected(false);
                ButonRadio3.setSelected(false);
            }
        });
        ButonRadio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButonRadio1.setSelected(false);
                ButonRadio3.setSelected(false);
            }
        });
        ButonRadio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ButonRadio2.setSelected(false);
                ButonRadio1.setSelected(false);
            }
        });
        pack();
        setVisible(true);
    }
}

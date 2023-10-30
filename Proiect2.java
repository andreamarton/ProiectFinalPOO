package cabinetVeterinar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Proiect2 extends JFrame {

    private JButton ButonAdaugare; ///buton pt adaugarea datelor
    private JPanel MyPanel;
    private JLabel NumeStapan; ///text sa stie utilizatorul ce sa introduca
    private JTextField NumeStapanTF;///din acest textfield se va citi numele stapanului
    private JLabel SpecieAnimal;
    private JTextField SpecieAnimalTF;///din acest textfield se va citi specia animalului
    private JLabel Status;
    private JRadioButton TipConsult;
    private JRadioButton TipInternat;
    private JList AfisarePacientiTF;
    private JButton AfisareIntroduceri;
    private JLabel CodCip;
    private JTextField codCipTF;
    public List<CabinetVet> pacient = new ArrayList<>();///lista pacientilor
<<<<<<< HEAD
    private boolean ok1 =false;
    private boolean ok2=false;
    private boolean ok3=false;
=======

>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
    public Proiect2(int statusMed) {

        setTitle("CABINET VETERINAR");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel = new JPanel();
        MyPanel.setBackground(Color.LIGHT_GRAY); //setarea culorii pt cab vet
        MyPanel.setLayout(new GridLayout(10, 2));
        MyPanel.setBounds(100, 100, 75, 25);

        ButonAdaugare = new JButton("Adauga Pacient");
        NumeStapan = new JLabel("Nume Stapan:");
        NumeStapanTF = new JTextField();
        SpecieAnimal = new JLabel("Specie Animal:");
        SpecieAnimalTF = new JTextField();
        Status = new JLabel("Status:");
        TipConsult = new JRadioButton("Consult");
        TipInternat = new JRadioButton("Internat");
        CodCip = new JLabel("Cod Cip:");
        codCipTF = new JTextField();
        AfisarePacientiTF = new JList();


        MyPanel.add(NumeStapan);
        MyPanel.add(NumeStapanTF);
        MyPanel.add(SpecieAnimal);
        MyPanel.add(SpecieAnimalTF);
        MyPanel.add(Status);
        MyPanel.add(TipConsult);
        MyPanel.add(new JLabel()); // Add an empty label for spacing
        MyPanel.add(TipInternat);
        MyPanel.add(CodCip);
        MyPanel.add(codCipTF);
        MyPanel.add(new JLabel()); // Add an empty label for spacing
        MyPanel.add(ButonAdaugare);
        MyPanel.add(AfisarePacientiTF);
        MyPanel.add(AfisareIntroduceri);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(TipConsult);
        statusGroup.add(TipInternat);

        ButonAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabinetVet stapan =new CabinetVet(); ///se creaza obiectul
                try {
                    if (NumeStapanTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        //exceptie de a nu adauga cifre in campul "nume"
                        if(!NumeStapanTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE LA NUME");
                        }
                        else {
                            ok1=true;
                            stapan.setName(NumeStapanTF.getText());
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
<<<<<<< HEAD
                                JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);
=======
                          //AfisarePacientiTF.setText(String.valueOf(a.getMessage()));
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
                        }
                    });
                }
                try {
                    if (SpecieAnimalTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE");
                    else {
                        //exceptie in cazul in care care introducemm cifre in acest camp
                        if(!SpecieAnimalTF.getText().matches("[aA-zZ]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT LITERE LA SPECIE");
                        }
                        else {
                            ok2=true;
                            stapan.setSpecieAnimal(SpecieAnimalTF.getText());
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
<<<<<<< HEAD
                            JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);
=======
                           // AfisarePacientiTF.setText(String.valueOf(a.getMessage()));
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
                        }
                    });
                }
                try {
                    if (codCipTF.getText().isEmpty())
                        throw new InvalidNameException("INTRODUCETI TOATE DATELE"); //in caz ca nu s-a introdus nimic
                    else {
<<<<<<< HEAD
                        //validare date
=======
                        //exceptia in care adaugam litere in loc de cifre
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
                        if(!codCipTF.getText().matches("[0-9]+$")) {
                            throw new InvalidNameException("NU INTRODUCETI DECAT CIFRE LA CIP");
                        }
                        else {
                            ok3=true;
                            stapan.setCodCip(codCipTF.getText());///se face citirea codului
                        }
                    }
                }catch (InvalidNameException a) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
<<<<<<< HEAD
                            JOptionPane.showMessageDialog(null,a.getMessage(),"EROARE",JOptionPane.ERROR_MESSAGE);
=======
                           // AfisarePacientiTF.setText(String.valueOf(a.getMessage()));
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9

                        }
                    });
                }
                if (TipConsult.isSelected()) {
                    stapan.setStatus(0);
                }
                if(TipInternat.isSelected())
                    stapan.setStatus(1);

                pacient.add(stapan);
                //Fereastra de mesaj-modala
<<<<<<< HEAD
                if(ok1 & ok2 & ok3)
                    JOptionPane.showMessageDialog(null,"Adaugare cu succes","FEREASTRA CONFIRMARE",JOptionPane.INFORMATION_MESSAGE);
=======
                JOptionPane.showMessageDialog(null,"Adaugare cu succes","FEREASTRA CONFIRMARE",JOptionPane.INFORMATION_MESSAGE);
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
            }
        });
        AfisareIntroduceri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> listaPacienti = new ArrayList<>();
<<<<<<< HEAD
                MediciCabVet m1=new MediciCabVet();
                //afisarea listei cu toti pacientii
=======
                //crearea unei liste cu toti pacientii
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
                for (CabinetVet cab : pacient){
                    StringBuffer sb = new StringBuffer();
                    sb.append("Stapan: ");
                    sb.append(cab.getName());
                    sb.append(" specie: ");
                    sb.append(cab.getSpecieAnimal());
                    sb.append("  status: ");
                    sb.append(cab.getStatus());
                    sb.append("  numarul cipului: ");
                    sb.append(cab.getCodCip());
                    listaPacienti.add(sb.toString());
<<<<<<< HEAD
                    sb.append(m1);
=======
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9
                }
                AfisarePacientiTF.setListData(listaPacienti.toArray());
            }
        });
        add(MyPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(false);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 407dd9677af1cd1dedbc9df25b4d492aa785b0a9

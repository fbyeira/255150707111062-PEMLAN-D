package bab9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormDaftarUlang extends JFrame {

    JLabel lblTitle;
    JLabel lblNama, lblNIM, lblJurusan, lblAlamat;

    RoundedTextField txtNama, txtNIM, txtJurusan;

    RoundedTextArea txtAlamat;

    JButton btnSubmit;

    public FormDaftarUlang() {

        // FRAME
        setTitle("Form Daftar Ulang");
        setSize(550, 520);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // BACKGROUND
        getContentPane().setBackground(new Color(255, 240, 245));

        // TITLE
        lblTitle = new JLabel("FORM DAFTAR ULANG");

        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));

        lblTitle.setForeground(new Color(199, 21, 133));

        lblTitle.setBounds(120, 30, 350, 30);

        add(lblTitle);

        // LABEL
        lblNama = new JLabel("Nama");
        lblNIM = new JLabel("NIM");
        lblJurusan = new JLabel("Jurusan");
        lblAlamat = new JLabel("Alamat");

        lblNama.setBounds(50, 100, 100, 25);
        lblNIM.setBounds(50, 160, 100, 25);
        lblJurusan.setBounds(50, 220, 100, 25);
        lblAlamat.setBounds(50, 280, 100, 25);

        add(lblNama);
        add(lblNIM);
        add(lblJurusan);
        add(lblAlamat);

        // TEXTFIELD OVAL
        txtNama = new RoundedTextField(20);

        txtNIM = new RoundedTextField(20);

        txtJurusan = new RoundedTextField(20);

        // TEXTAREA OVAL
        txtAlamat = new RoundedTextArea();

        // WARNA
        txtNama.setBackground(new Color(255, 228, 225));

        txtNIM.setBackground(new Color(255, 228, 225));

        txtJurusan.setBackground(new Color(255, 228, 225));

        txtAlamat.setBackground(new Color(255, 228, 225));

        // FONT
        txtNama.setFont(new Font("Verdana", Font.PLAIN, 14));

        txtNIM.setFont(new Font("Verdana", Font.PLAIN, 14));

        txtJurusan.setFont(new Font("Verdana", Font.PLAIN, 14));

        txtAlamat.setFont(new Font("Verdana", Font.PLAIN, 14));

        // POSISI
        txtNama.setBounds(170, 95, 250, 40);

        txtNIM.setBounds(170, 155, 250, 40);

        txtJurusan.setBounds(170, 215, 250, 40);

        txtAlamat.setBounds(170, 275, 250, 90);

        add(txtNama);
        add(txtNIM);
        add(txtJurusan);
        add(txtAlamat);

        // BUTTON
        btnSubmit = new JButton("Submit");

        btnSubmit.setBounds(200, 390, 120, 45);

        btnSubmit.setBackground(new Color(255, 182, 193));

        btnSubmit.setForeground(Color.BLACK);

        btnSubmit.setFont(new Font("Verdana", Font.BOLD, 14));

        add(btnSubmit);

        // ENTER PINDAH FIELD
        txtNama.addActionListener(e -> txtNIM.requestFocus());

        txtNIM.addActionListener(e -> txtJurusan.requestFocus());

        txtJurusan.addActionListener(e -> txtAlamat.requestFocus());

        // EVENT BUTTON
        btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // VALIDASI
                if (txtNama.getText().isEmpty()
                        || txtNIM.getText().isEmpty()
                        || txtJurusan.getText().isEmpty()
                        || txtAlamat.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Semua data harus diisi!"
                    );
                }

                else {

                    int jawab = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah data sudah benar?"
                    );

                    // JIKA OK
                    if (jawab == JOptionPane.OK_OPTION) {

                        JFrame hasil = new JFrame();

                        hasil.setTitle("Data Mahasiswa");

                        hasil.setSize(400, 300);

                        hasil.setLayout(null);

                        hasil.getContentPane().setBackground(
                                new Color(255, 240, 245));

                        JTextArea area = new JTextArea();

                        area.setBounds(30, 30, 300, 180);

                        area.setFont(new Font("Verdana", Font.PLAIN, 14));

                        area.setBackground(new Color(255, 228, 225));

                        area.setText(
                                "Nama : " + txtNama.getText()
                                + "\nNIM : " + txtNIM.getText()
                                + "\nJurusan : " + txtJurusan.getText()
                                + "\nAlamat : " + txtAlamat.getText()
                        );

                        hasil.add(area);

                        hasil.setVisible(true);
                    }
                }
            }
        });

        setVisible(true);
    }

    // MAIN
    public static void main(String[] args) {

        new FormDaftarUlang();
    }
}

// CLASS TEXTFIELD OVAL
class RoundedTextField extends JTextField {

    public RoundedTextField(int size) {

        super(size);

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(getBackground());

        g.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                40,
                40
        );

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {

        g.setColor(new Color(255, 182, 193));

        g.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                40,
                40
        );
    }
}

// CLASS TEXTAREA OVAL
class RoundedTextArea extends JTextArea {

    public RoundedTextArea() {

        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(getBackground());

        g.fillRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                40,
                40
        );

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {

        g.setColor(new Color(255, 182, 193));

        g.drawRoundRect(
                0,
                0,
                getWidth() - 1,
                getHeight() - 1,
                40,
                40
        );
    }
}
package bab9.Modul8;

import java.awt.*;
import java.awt.event.*;

public class GUIBab8 extends Frame {

    Label title;
    Label lbTugas, lbKuis, lbUTS, lbUAS, lbHasil;

    TextField txtTugas, txtKuis, txtUTS, txtUAS, txtHasil;

    CheckboxGroup cbg;

    Checkbox pemlan, asd, matkomlan, probstat;

    Button btnHitung;

    TextArea area;

    public GUIBab8() {

        // Layout
        setLayout(null);

        // Background utama
        setBackground(new Color(255, 240, 245));

        // Judul
        title = new Label("PROGRAM HITUNG NILAI MAHASISWA");

        title.setFont(new Font("Verdana", Font.BOLD, 18));
        title.setForeground(new Color(199, 21, 133));

        add(title);

        title.setBounds(60, 50, 400, 30);

        // Checkbox Group
        cbg = new CheckboxGroup();

        pemlan = new Checkbox("Pemlan", cbg, false);
        asd = new Checkbox("ASD", cbg, false);
        matkomlan = new Checkbox("Matkomlan", cbg, false);
        probstat = new Checkbox("Probstat", cbg, false);

        add(pemlan);
        add(asd);
        add(matkomlan);
        add(probstat);

        pemlan.setBounds(40, 100, 100, 20);
        asd.setBounds(150, 100, 100, 20);
        matkomlan.setBounds(260, 100, 100, 20);
        probstat.setBounds(380, 100, 100, 20);

        // Label
        lbTugas = new Label("Nilai Tugas");
        lbKuis = new Label("Nilai Kuis");
        lbUTS = new Label("Nilai UTS");
        lbUAS = new Label("Nilai UAS");
        lbHasil = new Label("Hasil Akhir");

        add(lbTugas);
        add(lbKuis);
        add(lbUTS);
        add(lbUAS);
        add(lbHasil);

        lbTugas.setBounds(50, 160, 100, 20);
        lbKuis.setBounds(50, 200, 100, 20);
        lbUTS.setBounds(50, 240, 100, 20);
        lbUAS.setBounds(50, 280, 100, 20);
        lbHasil.setBounds(50, 320, 100, 20);

        // TextField
        txtTugas = new TextField();
        txtKuis = new TextField();
        txtUTS = new TextField();
        txtUAS = new TextField();
        txtHasil = new TextField();

        // WARNA TEXTFIELD
        txtTugas.setBackground(new Color(255, 228, 225));
        txtKuis.setBackground(new Color(204, 255, 229));
        txtUTS.setBackground(new Color(255, 228, 225));
        txtUAS.setBackground(new Color(204, 255, 229));
        txtHasil.setBackground(new Color(255, 240, 245));

        add(txtTugas);
        add(txtKuis);
        add(txtUTS);
        add(txtUAS);
        add(txtHasil);

        txtTugas.setBounds(180, 160, 150, 25);
        txtKuis.setBounds(180, 200, 150, 25);
        txtUTS.setBounds(180, 240, 150, 25);
        txtUAS.setBounds(180, 280, 150, 25);
        txtHasil.setBounds(180, 320, 150, 25);

        // ENTER pindah field
        txtTugas.addActionListener(e -> txtKuis.requestFocus());

        txtKuis.addActionListener(e -> txtUTS.requestFocus());

        txtUTS.addActionListener(e -> txtUAS.requestFocus());

        txtUAS.addActionListener(e -> btnHitung.requestFocus());

        // Button
        btnHitung = new Button("Hitung");

        btnHitung.setBackground(new Color(255, 182, 193));

        // FONT TOMBOL HITAM
        btnHitung.setForeground(Color.BLACK);

        add(btnHitung);

        btnHitung.setBounds(370, 320, 80, 30);

        // TextArea
        area = new TextArea();

        area.setBackground(new Color(240, 255, 240));

        add(area);

        area.setBounds(50, 380, 400, 120);

        // Event tombol hitung
        btnHitung.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                double tugas = Double.parseDouble(txtTugas.getText());
                double kuis = Double.parseDouble(txtKuis.getText());
                double uts = Double.parseDouble(txtUTS.getText());
                double uas = Double.parseDouble(txtUAS.getText());

                double hasil = 0;

                String matkul = "";

                // PEMLAN
                if (pemlan.getState()) {

                    hasil = (0.2 * tugas)
                            + (0.2 * kuis)
                            + (0.3 * uts)
                            + (0.3 * uas);

                    matkul = "Pemlan";
                }

                // ASD
                else if (asd.getState()) {

                    hasil = (0.25 * tugas)
                            + (0.15 * kuis)
                            + (0.3 * uts)
                            + (0.3 * uas);

                    matkul = "ASD";
                }

                // MATKOMLAN
                else if (matkomlan.getState()) {

                    hasil = (0.3 * tugas)
                            + (0.2 * kuis)
                            + (0.2 * uts)
                            + (0.3 * uas);

                    matkul = "Matkomlan";
                }

                // PROBSTAT
                else if (probstat.getState()) {

                    hasil = (0.1 * tugas)
                            + (0.2 * kuis)
                            + (0.3 * uts)
                            + (0.4 * uas);

                    matkul = "Probstat";
                }

                // tampil hasil
                txtHasil.setText(String.valueOf(hasil));

                // masuk ke textarea
                area.append(
                        matkul
                        + " = "
                        + hasil
                        + "\n"
                );
            }
        });

        // BIAR TOMBOL X BISA DIPENCET
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                dispose();
            }
        });

        // Frame
        setTitle("GUI BAB 8");
        setSize(520, 560);
        setVisible(true);
    }

    public static void main(String[] args) {

        new GUIBab8();
    }
}

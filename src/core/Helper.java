package core;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void setTheme() {

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            try {
                UIManager.setLookAndFeel(info.getClassName());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        }

    }

    public static void showMsg(String str) {

        String msg;
        String title;

        switch (str) {
            case "fill" -> {
                msg = "Lütfen Tüm Alanları Doldurunuz !";
                title = "Hata !";
            }
            case "done" -> {
                msg = "İşlem Başarılı";
                title = "Sonuc";
            }
            default -> {
                msg = str;
                title = "Mesaj";
            }
        }
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }

}

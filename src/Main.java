import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteDialogo clientedialogo = new ClienteDialogo();
        clientedialogo.setContentPane(clientedialogo.getContenedor());
        clientedialogo.setVisible(true);
        clientedialogo.setSize(400,600);
        clientedialogo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

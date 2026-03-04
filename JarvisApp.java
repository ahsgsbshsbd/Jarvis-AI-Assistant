package jarvis;

import javax.swing.*;
import java.awt.*;

public class JarvisApp {

    private JTextArea chat;
    private JTextField input;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JarvisApp().start());
    }

    public void start() {

        JFrame frame = new JFrame("Jarvis AI Assistant");
        frame.setSize(600,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chat = new JTextArea();
        chat.setEditable(false);

        JScrollPane scroll = new JScrollPane(chat);

        input = new JTextField();

        JButton send = new JButton("Send");
        JButton voice = new JButton("🎤");

        send.addActionListener(e -> sendMessage());

        voice.addActionListener(e -> {
            String speech = VoiceInput.listen();
            input.setText(speech);
        });

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(input,BorderLayout.CENTER);
        bottom.add(send,BorderLayout.EAST);
        bottom.add(voice,BorderLayout.WEST);

        frame.add(scroll,BorderLayout.CENTER);
        frame.add(bottom,BorderLayout.SOUTH);

        frame.setVisible(true);

        say("Jarvis online.");
    }

    private void sendMessage() {

        String msg = input.getText();
        input.setText("");

        chat.append("\nYou: " + msg);

        String response = InternetTools.process(msg);

        chat.append("\nJarvis: " + response);

        SpeechOutput.speak(response);

        MemoryManager.save(msg + " -> " + response);
    }

    private void say(String text) {
        chat.append("\nJarvis: " + text);
        SpeechOutput.speak(text);
    }
}

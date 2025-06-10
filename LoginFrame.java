import javax.swing.*;


public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Student Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("Username:");
        l1.setBounds(30, 30, 80, 25);
        add(l1);

        JTextField tf1 = new JTextField();
        tf1.setBounds(120, 30, 120, 25);
        add(tf1);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30, 70, 80, 25);
        add(l2);

        JPasswordField pf = new JPasswordField();
        pf.setBounds(120, 70, 120, 25);
        add(pf);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 110, 100, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String username = tf1.getText();
            String password = new String(pf.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all fields.");
                return;
            }

            if (DAO.validateLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                new RegisterCourseFrame(username).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}

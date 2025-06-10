public class Registercourse import javax.swing.*;

public class RegisterCourseFrame extends JFrame {
    public RegisterCourseFrame(String username) {
        setTitle("Register Course");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel courseLabel = new JLabel("Enter Course:");
        courseLabel.setBounds(30, 30, 100, 25);
        add(courseLabel);

        JTextField courseField = new JTextField();
        courseField.setBounds(130, 30, 120, 25);
        add(courseField);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(90, 80, 100, 30);
        add(registerBtn);

        registerBtn.addActionListener(e -> {
            String course = courseField.getText();

            if (course.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Course field cannot be empty.");
                return;
            }

            ModelClass model = new ModelClass(username, course);
            boolean success = DAO.registerCourse(model);

            if (success) {
                JOptionPane.showMessageDialog(this, "Course Registered!");
            } else {
                JOptionPane.showMessageDialog(this, "Registration Failed.");
            }
        });
    }
}
{
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoApp extends JFrame {
    JTextField taskField;
    DefaultListModel<String> listModel;
    JList<String> taskList;

    ToDoApp() {
        setTitle("To-Do List with Time");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        taskField = new JTextField();
        add(taskField, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addBtn = new JButton("Add Task");
        JButton deleteBtn = new JButton("Delete Task");
        panel.add(addBtn);
        panel.add(deleteBtn);
        add(panel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                listModel.addElement(task + " (Added: " + timeStamp + ")");
                taskField.setText("");
            }
        });

        deleteBtn.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoApp().setVisible(true));
    }
}
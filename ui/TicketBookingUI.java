package ui;

import operations.*;
import reporting.*;
import ticketing.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

public class TicketBookingUI extends JFrame {
    private JTextField nameField;
    private JComboBox<String> scheduleBox;
    private BookingManager manager;

    public TicketBookingUI() {
        Map<String, Schedule> schedules = ScheduleLoader.loadSchedules();
        manager = new BookingManager(schedules);

        setTitle("Boat Ticket Booking");
        setSize(400, 200);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 30, 200, 20);
        add(nameField);

        JLabel scheduleLabel = new JLabel("Schedule:");
        scheduleLabel.setBounds(30, 70, 100, 20);
        add(scheduleLabel);

        scheduleBox = new JComboBox<>();
        for (String id : schedules.keySet()) {
            scheduleBox.addItem(id);
        }
        scheduleBox.setBounds(100, 70, 200, 20);
        add(scheduleBox);

        JButton bookBtn = new JButton("Book");
        bookBtn.setBounds(150, 110, 100, 30);
        add(bookBtn);

        bookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String scheduleId = (String) scheduleBox.getSelectedItem();
                try {
                    Ticket ticket = manager.bookTicket(name, "BOAT1", scheduleId);
                    JOptionPane.showMessageDialog(null, "Booked: " + ticket.getTicketId());
                } catch (OverbookingException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}

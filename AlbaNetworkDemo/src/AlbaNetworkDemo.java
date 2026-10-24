import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public final class AlbaNetworkDemo {
    private static final Color BG = new Color(17, 19, 25);
    private static final Color PANEL = new Color(25, 28, 36);
    private static final Color PANEL2 = new Color(31, 35, 44);
    private static final Color LINE = new Color(49, 54, 66);
    private static final Color TEXT = new Color(238, 240, 246);
    private static final Color MUTED = new Color(147, 154, 170);
    private static final Color ACCENT = new Color(111, 133, 255);
    private final JFrame frame = new JFrame("Alba Network · Demo");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AlbaNetworkDemo().show());
    }

    private void show() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(900, 580));
        frame.setSize(1040, 680);
        frame.setLocationRelativeTo(null);
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG);
        root.setBorder(new EmptyBorder(18, 18, 14, 18));
        root.add(header(), BorderLayout.NORTH);
        root.add(content(), BorderLayout.CENTER);
        frame.setContentPane(root);
        frame.setVisible(true);
    }

    private JComponent header() {
        JPanel panel = new JPanel(new BorderLayout(16, 0));
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(0, 0, 18, 0));
        JPanel brand = new JPanel(new BorderLayout(12, 0));
        brand.setOpaque(false);
        JLabel logo = new JLabel("A", SwingConstants.CENTER);
        logo.setFont(new Font("Dialog", Font.BOLD, 22));
        logo.setForeground(Color.WHITE);
        logo.setOpaque(true);
        logo.setBackground(ACCENT);
        logo.setPreferredSize(new Dimension(46, 46));
        logo.setBorder(new LineBorder(new Color(145, 160, 255), 1, true));
        JPanel names = new JPanel();
        names.setOpaque(false);
        names.setLayout(new BoxLayout(names, BoxLayout.Y_AXIS));
        names.add(label("Alba Network", 21, TEXT, Font.BOLD));
        names.add(Box.createVerticalStrut(3));
        names.add(label("Виртуальные сети", 12, MUTED, Font.PLAIN));
        brand.add(logo, BorderLayout.WEST);
        brand.add(names, BorderLayout.CENTER);
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 4));
        right.setOpaque(false);
        right.add(pill("DEMO", new Color(49, 57, 91), new Color(194, 202, 255)));
        right.add(pill("●  Не подключено", new Color(39, 47, 44), new Color(153, 211, 175)));
        panel.add(brand, BorderLayout.WEST);
        panel.add(right, BorderLayout.EAST);
        return panel;
    }

    private JComponent content() {
        JPanel body = new JPanel(new BorderLayout(14, 0));
        body.setOpaque(false);
        body.add(networksPanel(), BorderLayout.WEST);
        body.add(detailsPanel(), BorderLayout.CENTER);
        return body;
    }

    private JComponent networksPanel() {
        JPanel outer = card();
        outer.setPreferredSize(new Dimension(275, 0));
        outer.setLayout(new BorderLayout(0, 12));
        outer.setBorder(new EmptyBorder(18, 16, 16, 16));
        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(label("МОИ СЕТИ", 11, MUTED, Font.BOLD), BorderLayout.WEST);
        JButton plus = button("+ Создать", ACCENT, Color.WHITE);
        plus.addActionListener(e -> showInfo("Создание сети будет добавлено позже."));
        top.add(plus, BorderLayout.EAST);
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(networkItem("Alba Friends", "alba-demo", true, "3"));
        list.add(Box.createVerticalStrut(8));
        list.add(networkItem("Игровая сеть", "game-room-demo", false, "0"));
        list.add(Box.createVerticalGlue());
        outer.add(top, BorderLayout.NORTH);
        outer.add(list, BorderLayout.CENTER);
        outer.add(label("Это демонстрационные данные", 11, MUTED, Font.PLAIN), BorderLayout.SOUTH);
        return outer;
    }

    private JComponent networkItem(String name, String id, boolean selected, String count) {
        JPanel p = new JPanel(new BorderLayout(10, 0));
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 68));
        p.setPreferredSize(new Dimension(240, 68));
        p.setBackground(selected ? new Color(43, 48, 69) : PANEL);
        p.setBorder(new CompoundBorder(new LineBorder(selected ? new Color(87, 103, 176) : LINE, 1, true),
                                      new EmptyBorder(10, 10, 10, 10)));
        JLabel icon = new JLabel("⌘", SwingConstants.CENTER);
        icon.setFont(new Font("Dialog", Font.BOLD, 20));
        icon.setForeground(selected ? new Color(186, 195, 255) : MUTED);
        icon.setPreferredSize(new Dimension(32, 32));
        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.add(label(name, 13, TEXT, Font.BOLD));
        text.add(Box.createVerticalStrut(5));
        text.add(label(id, 11, MUTED, Font.PLAIN));
        JLabel badge = pill(count, selected ? new Color(64, 75, 124) : PANEL2, TEXT);
        p.add(icon, BorderLayout.WEST);
        p.add(text, BorderLayout.CENTER);
        p.add(badge, BorderLayout.EAST);
        p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return p;
    }

    private JComponent detailsPanel() {
        JPanel outer = card();
        outer.setLayout(new BorderLayout(0, 14));
        outer.setBorder(new EmptyBorder(18, 18, 16, 18));
        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setOpaque(false);
        JPanel heading = new JPanel();
        heading.setOpaque(false);
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.add(label("Alba Friends", 19, TEXT, Font.BOLD));
        heading.add(Box.createVerticalStrut(5));
        heading.add(label("Идентификатор сети: alba-demo", 12, MUTED, Font.PLAIN));
        titleRow.add(heading, BorderLayout.WEST);
        JButton join = button("Подключиться", new Color(44, 51, 72), TEXT);
        join.addActionListener(e -> showInfo("Подключение к VPN в демо-версии отключено."));
        titleRow.add(join, BorderLayout.EAST);
        JPanel columns = new JPanel(new BorderLayout());
        columns.setOpaque(false);
        columns.setBorder(new EmptyBorder(8, 0, 0, 0));
        JPanel colHeader = new JPanel(new BorderLayout());
        colHeader.setOpaque(false);
        colHeader.setBorder(new EmptyBorder(0, 2, 10, 2));
        colHeader.add(label("УЧАСТНИКИ", 11, MUTED, Font.BOLD), BorderLayout.WEST);
        colHeader.add(label("3 участника", 11, MUTED, Font.PLAIN), BorderLayout.EAST);
        JPanel people = new JPanel();
        people.setOpaque(false);
        people.setLayout(new BoxLayout(people, BoxLayout.Y_AXIS));
        people.add(person("Вы", "Этот компьютер · локальный макет", "ЛОКАЛЬНО", ACCENT));
        people.add(Box.createVerticalStrut(8));
        people.add(person("Player_One", "192.168.100.2 · пример", "ОФЛАЙН", new Color(110, 120, 143)));
        people.add(Box.createVerticalStrut(8));
        people.add(person("Player_Two", "192.168.100.3 · пример", "ОФЛАЙН", new Color(110, 120, 143)));
        columns.add(colHeader, BorderLayout.NORTH);
        columns.add(people, BorderLayout.CENTER);
        outer.add(titleRow, BorderLayout.NORTH);
        outer.add(columns, BorderLayout.CENTER);
        return outer;
    }

    private JComponent person(String name, String detail, String state, Color color) {
        JPanel p = new JPanel(new BorderLayout(12, 0));
        p.setMaximumSize(new Dimension(Integer.MAX_VALUE, 68));
        p.setPreferredSize(new Dimension(450, 68));
        p.setBackground(PANEL2);
        p.setBorder(new CompoundBorder(new LineBorder(LINE, 1, true), new EmptyBorder(10, 12, 10, 12)));
        JLabel avatar = new JLabel(name.substring(0, 1).toUpperCase(), SwingConstants.CENTER);
        avatar.setFont(new Font("Dialog", Font.BOLD, 15));
        avatar.setForeground(Color.WHITE);
        avatar.setOpaque(true);
        avatar.setBackground(color);
        avatar.setPreferredSize(new Dimension(38, 38));
        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
        text.add(label(name, 13, TEXT, Font.BOLD));
        text.add(Box.createVerticalStrut(5));
        text.add(label(detail, 11, MUTED, Font.PLAIN));
        p.add(avatar, BorderLayout.WEST);
        p.add(text, BorderLayout.CENTER);
        p.add(pill(state, new Color(44, 47, 57), MUTED), BorderLayout.EAST);
        return p;
    }

    private JPanel card() {
        JPanel p = new JPanel();
        p.setBackground(PANEL);
        p.setBorder(new LineBorder(LINE, 1, true));
        return p;
    }

    private JLabel label(String text, int size, Color color, int style) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Dialog", style, size));
        l.setForeground(color);
        return l;
    }

    private JLabel pill(String text, Color background, Color foreground) {
        JLabel l = label("  " + text + "  ", 11, foreground, Font.BOLD);
        l.setOpaque(true);
        l.setBackground(background);
        l.setBorder(new CompoundBorder(new LineBorder(background, 1, true), new EmptyBorder(5, 3, 5, 3)));
        return l;
    }

    private JButton button(String text, Color background, Color foreground) {
        JButton b = new JButton(text);
        b.setFont(new Font("Dialog", Font.BOLD, 12));
        b.setForeground(foreground);
        b.setBackground(background);
        b.setFocusPainted(false);
        b.setBorder(new CompoundBorder(new LineBorder(background.equals(ACCENT) ? ACCENT : LINE, 1, true),
                                       new EmptyBorder(8, 12, 8, 12)));
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return b;
    }

    private void showInfo(String message) {
        JOptionPane.showMessageDialog(frame, message, "Alba Network · Demo", JOptionPane.INFORMATION_MESSAGE);
    }
}

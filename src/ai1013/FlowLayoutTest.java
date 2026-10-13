package ai1013;

import center.CenterFrame2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlowLayoutTest extends JFrame {

    public FlowLayoutTest() {
        setTitle("FlowLayout 연습");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 15));

        ArrayList<JButton> list = new ArrayList<JButton>(5);

        for (int i = 0; i < 5; i++) {

            JButton btn = new JButton("버튼" + (i + 1)) {

                Color originalColor = getBackground();

                @Override
                protected void paintComponent(Graphics g) {

                    if (getModel().isPressed()) {
                        g.setColor(Color.YELLOW);
                    } else {
                        g.setColor(originalColor);
                    }

                    g.fillRect(0, 0, getWidth(), getHeight());

                    super.paintComponent(g);
                }
            };

            btn.setContentAreaFilled(false);
            btn.setOpaque(false);

            list.add(btn);
            add(btn);
        }

        int w = 250, h = 250;
        Point point = CenterFrame2.getLocation(w, h);
        setBounds(point.x, point.y, w, h);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutTest();
    }
}
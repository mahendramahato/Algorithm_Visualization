import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class Map extends JPanel {
    Node[][] map;
    Random r = new Random();
    private int cells = 10;

    public class Node {
        private int cellType = 0;
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getType() {
            return cellType;
        }

        public void setType(int cell) {
            cellType = cell;
        }

        // constructor for node
        public Node(int cell, int x, int y) {
            cellType = cell;
            this.x = x;
            this.y = y;
        }
    }

    public void generateMap() {
        for (int i = 0; i < cells * cells; i++) {
            Node current;
            do {
                int x = r.nextInt(cells);
                int y = r.nextInt(cells);
                current = map[x][y];
            } while (current.getType() == 2);
            current.setType(2);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < cells; j++) {
                switch (map[i][j].getType()) {
                    case 0:
                        g.setColor(Color.GREEN);
                        break;
                    case 1:
                        g.setColor(Color.RED);
                        break;
                    case 2:
                        g.setColor(Color.BLACK);
                        break;
                    case 3:
                        g.setColor(Color.WHITE);
                        break;
                    case 4:
                        g.setColor(Color.CYAN);
                        break;
                    case 5:
                        g.setColor(Color.YELLOW);
                        break;
                }
                g.fillRect(i * 60, j * 60, 600, 600);
                g.setColor(Color.BLACK);
                g.drawRect(i * 60, j * 60, 600, 600);
            }
        }
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(850, 650);
        frame.setTitle("Algorithm Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ;

        // jpanel for adding components inside the jframe
        // JPanel panel = new JPanel();
        // panel.setBorder(BorderFactory.createTitledBorder("Menu"));
        // panel.setLayout(null);
        // panel.setBounds(10, 10, 210, 600);
        // frame.getContentPane().add(panel);

        // half space for the grid
        frame.getContentPane().add(new Map());
    }

}

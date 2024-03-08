import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Fractal extends JFrame {
    static Dimension dimension;

    public Fractal() {
        setTitle("Fractals Project - Chinmay Mangalwedhe");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        epilepsyWarning();
        setJMenuBar(menuBar());
        pack();
        setLocationRelativeTo(null);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5 * (dimension.width - getWidth())), (int) (.5 *(dimension.height - getHeight())), getWidth(), getHeight());
    }

    public void epilepsyWarning() {
        int button = JOptionPane.showConfirmDialog(
                null, """
                The following program contains flashing images when using the slider. Would you like to proceed to use the program?
                The program will take some time to load.""", "Epilepsy Warning", JOptionPane.YES_NO_OPTION);

        if (button == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }

    public JMenuBar menuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(500, 20));

        JMenu file = new JMenu("File");
        file.setPreferredSize(new Dimension(33, 10));
        JMenuItem exit = new JMenuItem("Exit");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });

        file.add(exit);
        menuBar.add(file);

        JMenu aboutMe = new JMenu("About");
        menuBar.setPreferredSize(new Dimension(500, 20));

        JMenuItem me = new JMenuItem("Chinmay Mangalwedhe");
        me.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showConfirmDialog(null, """
                        Created by Chinmay Mangalwedhe.
                        2023.
                        Cypress Ranch High School.
                        cmangalwedhe@gmail.com
                        github.com/cmangalwedhe""", "About me", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JMenuItem projectDescription = new JMenuItem("UI Tutorial");
        projectDescription.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showConfirmDialog(null, """
                        Scroll in with mouse zooms in ten percent.
                        Scroll out with mouse zooms out ten percent
                        Slider on top of each fractal lets you see what the first hundred iterations look like.
                        For better visualizations, press the slider and use the arrow keys (+ zoom in, - zoom out) to have better step-by-step analysis.
                        All fractals by default are set to 100 iterations.
                        For performance reasons, once you use the slider, the max iterations will be 100.
                        Scrolling can become slow when the fractal is at 100 iterations.
                        Thank you for viewing!
                        """, "UI Tutorial", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        aboutMe.add(me);
        aboutMe.add(projectDescription);
        menuBar.add(aboutMe);

        final JPanel[] currentPanel = {null};

        JMenu selectFractalMenu = new JMenu("Choose Fractal");
        JMenuItem mandelbrot = new JMenuItem("Mandelbrot");
        mandelbrot.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new Mandelbrot();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new Mandelbrot();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);

            }
        });

        JMenuItem juliaSetOne = new JMenuItem("Complex Plane: z^4 + c");
        juliaSetOne.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new JuliaSetOne();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new JuliaSetOne();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);

            }
        });

        JMenuItem burningShip = new JMenuItem("Burning Ship");
        burningShip.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new BurningShip();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new BurningShip();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);
            }
        });

        JMenuItem customFractal = new JMenuItem("Weird Fractal");
        customFractal.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new CustomFractal();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new CustomFractal();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);

            }
        });

        JMenuItem sierpinskiTriangle = new JMenuItem("Sierpinski Triangle");
        sierpinskiTriangle.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new Gasket();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new Gasket();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);
            }
        });

        JMenuItem weirdFractal2 = new JMenuItem("Weird Fractal 2.0");
        weirdFractal2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new WeirdFractal2();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new WeirdFractal2();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);
            }
        });

        JMenuItem dragonCurve = new JMenuItem("Dragon Curve");
        dragonCurve.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new DragonCurve();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new DragonCurve();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);
            }
        });

        JMenuItem levyCurve = new JMenuItem("Levy 'C' Curve");
        levyCurve.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentPanel[0] == null) {
                    currentPanel[0] = new LevyCurve();
                    add(currentPanel[0]);
                    revalidate();
                } else {
                    remove(currentPanel[0]);
                    currentPanel[0] = new LevyCurve();
                    add(currentPanel[0]);
                    revalidate();
                }
                pack();
                setLocationRelativeTo(null);
            }
        });

        selectFractalMenu.add(mandelbrot);
        selectFractalMenu.add(juliaSetOne);
        selectFractalMenu.add(burningShip);
        selectFractalMenu.add(customFractal);
        selectFractalMenu.add(sierpinskiTriangle);
        selectFractalMenu.add(sierpinskiTriangle);
        selectFractalMenu.add(weirdFractal2);
        selectFractalMenu.add(dragonCurve);
        selectFractalMenu.add(levyCurve);


        menuBar.add(selectFractalMenu);
        return menuBar;
    }


    public static void main(String[] args) {
        new Fractal();
    }
}

class BurningShip extends JPanel {
    private static int MAX_ITERATIONS = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static double ZOOM = 150;

    private BufferedImage image;

    public BurningShip() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
        zoom();
    }

    public void zoom() {
        addMouseWheelListener(e -> {
            int a = e.getWheelRotation();

            if (a < 0) {
                ZOOM *= 1.1;
            } else if (a > 0) {
                ZOOM *= 0.9;
            }

            repaint();
        });
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double scaledX = (x - WIDTH / 2) / ZOOM;
                double scaledY = (y - HEIGHT / 2) / ZOOM;

                double zx = scaledX;
                double zy = scaledY;

                int iter = MAX_ITERATIONS;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double tmp = zx * zx - zy * zy + scaledX;
                    zy = Math.abs(2 * zx * zy) + scaledY;
                    zx = tmp;
                    iter--;
                }

                image.setRGB(x, y, iter << 6 - iter);
            }
        }

        g.drawImage(image, 0, 0, this);
    }
}

class Mandelbrot extends JPanel {
    private static int MAX_ITERATIONS = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static double ZOOM = 150;

    private BufferedImage image;

    public Mandelbrot() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
        zoom();
    }

    public void zoom() {
        addMouseWheelListener(e -> {
            int a = e.getWheelRotation();

            if (a < 0) {
                ZOOM *= 1.1;
            } else if (a > 0) {
                ZOOM *= 0.9;
            }

            repaint();
        });

    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                double zx = 0;
                double zy = 0;
                double cX = (i - WIDTH / 2.) / ZOOM;
                double cY = (j - HEIGHT / 2.) / ZOOM;
                int iter = MAX_ITERATIONS;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }

                image.setRGB(i, j, iter << 15 - iter);
            }
        }

        g.drawImage(image, 0, 0, this);
    }
}

class WeirdFractal2 extends JPanel {

    private static int MAX_ITERATIONS = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static double ZOOM = 150;

    private BufferedImage image;

    public WeirdFractal2() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
        zoom();
    }

    public void zoom() {
        addMouseWheelListener(e -> {
            int a = e.getWheelRotation();

            if (a < 0) {
                ZOOM *= 1.1;
            } else if (a > 0) {
                ZOOM *= 0.9;
            }

            repaint();
        });
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx = 0;
                double zy = 0;
                double cX = (x - WIDTH / 2.) / ZOOM;
                double cY = (y - HEIGHT / 2.) / ZOOM;
                int iter = MAX_ITERATIONS;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double tmp = Math.pow(zx, 3) - zx * zy * zy - 2 * zx * zy * zy + cX;
                    zy = zx * zx * zy + 2 * zx * zx * zy - zy * zy + cY;
                    zx = tmp;
                    iter--;
                }

                image.setRGB(x, y, iter << 15 - iter);
            }
        }

        g.drawImage(image, 0, 0, this);
    }
}

class JuliaSetOne extends JPanel {
    private static int MAX_ITERATIONS = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static double SCALE_FACTOR = 150;

    private BufferedImage image;

    public JuliaSetOne() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
        zoom();
    }

    public void zoom() {
        addMouseWheelListener(e -> {
            int a = e.getWheelRotation();

            if (a < 0) {
                SCALE_FACTOR *= 1.1;
            } else if (a > 0) {
                SCALE_FACTOR *= 0.9;
            }

            repaint();
        });
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx = 0;
                double zy = 0;
                double cX = (x - WIDTH / 2.) / SCALE_FACTOR;
                double cY = (y - HEIGHT / 2.) / SCALE_FACTOR;
                int iter = MAX_ITERATIONS;

                while ((zx * zx + zy * zy < 4) && (iter > 0)) {
                    double tmp = Math.pow(zx, 4) - 6 * zx * zx * zy * zy + Math.pow(zy, 4) + cX;
                    zy = 4 * Math.pow(zx, 3) * zy - 4 * zx * Math.pow(zy, 3) + cY;
                    zx = tmp;
                    iter--;
                }

                image.setRGB(x, y, iter << 15 - iter);
            }
        }

        g.drawImage(image, 0, 0, this);
    }
}

class CustomFractal extends JPanel {

    private static int MAX_ITERATIONS = 100;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static double ZOOM = 150;

    private BufferedImage image;

    public CustomFractal() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
        zoom();
    }

    public void zoom() {
        addMouseWheelListener(e -> {
            int a = e.getWheelRotation();

            if (a < 0) {
                ZOOM *= 1.1;
            } else if (a > 0) {
                ZOOM *= 0.9;
            }

            repaint();
        });
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                double zx = 0;
                double zy = 0;
                double cX = (x - WIDTH / 2.) / ZOOM;
                double cY = (y - HEIGHT / 2.) / ZOOM;
                int iter = MAX_ITERATIONS;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double temp = Math.pow(zx, 3) - 3 * zx * zy * zy + cX;
                    zy = 3 * zx * zx * zy - Math.pow(zy, 3) + cY;
                    zx = temp;
                    iter--;
                }

                image.setRGB(x, y, iter << 15 - iter);
            }
        }

        g.drawImage(image, 0, 0, this);
    }
}

class Gasket extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static int MAX_ITERATIONS = 7;

    public Gasket() {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        createSlider();
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(1);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.SOUTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    @Override
    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        gasket(window, (WIDTH - 20) / 2, 10, WIDTH - 50, HEIGHT - 50, 30, HEIGHT - 50, MAX_ITERATIONS);
    }

    public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3, int n) {
        //base case goes here
        if (n == 0)
            return;
        //make a random color here
        Color random = new Color((int) (Math.random() * 246) + 10, (int) (Math.random() * 246) + 10, (int) (Math.random() * 246) + 10);
        //draw lines to make a triangle or use fillPolygon
        window.setColor(random);
        window.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        //make some recursive calls
        gasket(window, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x3 + x1) / 2, (y3 + y1) / 2, n - 1);
        gasket(window, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2, n - 1);
        gasket(window, (x3 + x1) / 2, (y3 + y1) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3, n - 1);
    }
}

class DragonCurve extends JPanel {

    private static final int WIDTH = 800, HEIGHT = 600;
    private static int MAX_ITERATIONS = 15;

    public DragonCurve() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        createSlider();
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    private void drawDragonCurve(Graphics2D g, int x1, int y1, int x2, int y2, int level) {
        if (level == 0) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            int dx = x2 - x1;
            int dy = y2 - y1;

            int midX = (x1 + x2) / 2 + (dy / 2);
            int midY = (y1 + y2) / 2 - (dx / 2);

            drawDragonCurve(g, x1, y1, midX, midY, level - 1);
            drawDragonCurve(g, x2, y2, midX, midY, level - 1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(new Color((int) (Math.random() * 246) + 10, (int) (Math.random() * 246) + 10, (int) (Math.random() * 246) + 10));
        drawDragonCurve(g2D, WIDTH / 4, HEIGHT * 3 / 4, WIDTH * 3 / 4, HEIGHT * 3 / 4, MAX_ITERATIONS);
    }
}

class LevyCurve extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static int MAX_ITERATIONS = 14;

    public LevyCurve() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        createSlider();
    }

    public void createSlider() {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 20, 1);

        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(3);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setBackground(new Color(255, 255, 255));
        add(slider, BorderLayout.NORTH);

        slider.addChangeListener(e -> {
            MAX_ITERATIONS = slider.getValue();
            repaint();
        });
    }

    private void drawCurve(Graphics2D g, int x1, int y1, int x2, int y2, int level) {
        if (level <= 0) {
            g.drawLine(x1, y1, x2, y2);
        } else {
            int dx = x2 - x1;
            int dy = y2 - y1;

            int x3 = x1 + dx / 2 - dy / 2;
            int y3 = y1 + dx / 2 + dy / 2;

            drawCurve(g, x1, y1, x3, y3, level - 1);
            drawCurve(g, x3, y3, x2, y2, level - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2D.setColor(Color.WHITE);
        drawCurve(g2D, (WIDTH) / 4, (HEIGHT-350) * 3 / 4, (WIDTH) * 3 / 4, (HEIGHT-350) * 3 / 4, MAX_ITERATIONS);
    }
}

package com.gui;

import com.plotter.Plot;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The main frame of the src.main.java.com.plotter.Function Plotter application.
 * The "GUI".
 * The "GUI" knows the "model", it depends on the "model",
 * and it cannot exist without the "model".
 * The "model" of a src.main.java.com.gui.PlotterFrame is a src.main.java.com.plotter.Plot.
 */
public final class PlotterFrame extends JFrame {

    /**
     * Create a new src.main.java.com.gui.PlotterFrame for the given src.main.java.com.plotter.Plot.
     *
     * @param plot The model to show.
     */
    public PlotterFrame(final Plot plot) {
        super();
        setTitle("src.main.java.com.plotter.Function Plotter");
        setLayout(new BorderLayout());

        final PlotCanvas pv = new PlotCanvas(plot);
        final ShadeCanvas sv = new ShadeCanvas(plot);

        final SidePanel s = new SidePanel(plot);
        // creating the panel and adding the Canvases
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(pv, BorderLayout.CENTER);
        panel.add(sv, BorderLayout.SOUTH);

        final JPanel rightPanel = new JPanel(new GridLayout(3, 1));

        final JButton zoomInButton = new JButton("zoom in");
        zoomInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                pv.zoomIn();
                repaint();
            }
        });

        final JButton zoomOutButton = new JButton("zoom out");
        zoomOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                pv.zoomOut();
                repaint();
            }
        });

        final JButton saveButton = new JButton("save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                final BufferedImage img = new BufferedImage(
                        pv.getWidth(),
                        pv.getHeight(),
                        BufferedImage.TYPE_INT_ARGB);
                final Graphics2D g2d = img.createGraphics();
                pv.paintComponent(g2d);
                final JFileChooser j = new JFileChooser();
                j.setFileFilter(new FileNameExtensionFilter("png files", "png"));
                j.setFileFilter(new FileNameExtensionFilter("jpg files", "jng"));

                final int accept = j.showSaveDialog(null);

                final File f;
                if (accept == JFileChooser.APPROVE_OPTION) {
                    f = j.getSelectedFile();
                    try {
                        ImageIO.write(img, "png", f);
                    } catch (IOException exception) {
                        JOptionPane.showMessageDialog(null,
                                "FIle couldn't be saved");
                    }
                }

            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rightPanel.add(zoomInButton);
        rightPanel.add(zoomOutButton);
        rightPanel.add(saveButton);
        add(rightPanel, BorderLayout.EAST);
        add(s, BorderLayout.WEST);

        add(panel, BorderLayout.CENTER);
        add(new RangePanel(plot.getRange()), BorderLayout.SOUTH);

        s.addListener(new SidePanelListener() {
            @Override
            public void sidePanelChanged(final SidePanel sidePanel) {
                pack();
                repaint();
            }
        });
        pack();
    }

}
package com.gui;

import com.plotter.Function;
import com.plotter.FunctionException;
import com.plotter.Plot;
import com.plotter.PlotListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class SidePanel extends JPanel {

    private final ArrayList<FunctionPanel> functions;
    private final ArrayList<SidePanelListener> listeners;
    private final CustomButton addButton = new CustomButton(new ImageIcon("src/main/resources/add32.png"),
            "Adds a new src.main.java.com.plotter.Function");
    private final Plot model;

    /**
     * Creates a src.main.java.com.gui.SidePanel.
     *
     * @param plot the model.
     */
    public SidePanel(final Plot plot) {
        super();
        functions = new ArrayList<>();
        model = plot;
        listeners = new ArrayList<>();

        final GridLayout layout = new GridLayout(10, 1);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                addFunction();
            }
        });

        addButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        model.addListener(new PlotListener() {
            @Override
            public void firePlotChanged(final Plot plot) {
                fireSidePanelChanged();
            }
        });

        setLayout(layout);
        add(addButton);
        addFunction();

    }

    /**
     * Adds a new src.main.java.com.gui.FunctionPanel in the sidePanel.
     */
    public void addFunction() {
        Function function = null;
        try {
            function = new Function("x");
            function.setRange(0, 10);
        } catch (final FunctionException exception) {
            JOptionPane.showMessageDialog(null, this.getName()
                    + "error encountered: \n" + exception.getMessage());
        }
        final FunctionPanel functionPanel = new FunctionPanel(this, function);
        model.addFunction(function);

        functions.add(functionPanel);
        remove(addButton);
        add(functionPanel);
        add(addButton);
        fireSidePanelChanged();
    }


    /**
     * Remove a listener.
     *
     * @param li a src.main.java.com.gui.SidePanelListener.
     */
    public void removeListener(final SidePanelListener li) {
        listeners.remove(li);
    }

    /**
     * Adds a Listener.
     *
     * @param li a src.main.java.com.gui.SidePanelListener.
     */
    public void addListener(final SidePanelListener li) {
        listeners.add(li);
    }

    /**
     * Removes functionPanel.
     *
     * @param functionPanel the functionPanel to be removed.
     */
    public void removeFunction(final FunctionPanel functionPanel) {
        final int index = functions.indexOf(functionPanel);
        functions.remove(functionPanel);
        model.removeFunction(model.getFunction(index));
        remove(functionPanel);
        fireSidePanelChanged();
    }


    private void fireSidePanelChanged() {
        for (final SidePanelListener li : listeners) {
            li.sidePanelChanged(this);
        }
    }

}

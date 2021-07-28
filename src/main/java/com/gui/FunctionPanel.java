package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import src.main.java.com.plotter.Function;
import src.main.java.com.plotter.FunctionException;

public class FunctionPanel extends JComponent {

    private final Function function;
    private SidePanel parent;
    private static ImageIcon enable = new ImageIcon("src/main/resources/enable32.png");
    private static ImageIcon disable = new ImageIcon("src/main/resources/disable32.png");
    private static ImageIcon remove = new ImageIcon("src/main/resources/remove32.png");


    /**
     * Creates a functionPanel.
     * @param parent the parent of the panel.
     * @param func the function.
     */
    public FunctionPanel(final SidePanel parent, final Function func) {
        super();

        function = func;
        this.parent = parent;

        final BorderLayout layout = new BorderLayout();
        layout.setHgap(10);
        setLayout(layout);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addExpressionField();
        addRangePanel();
        addEnableButton();
        addRemoveIButton();

    }

    private void addEnableButton() {
        final CustomButton enabledButton = new CustomButton(enable, "Enables drawing a function");
        enabledButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                if (function.isDrawable()) {
                    disableFunction();
                    enabledButton.setIcon(disable);
                } else {
                    enableFunction();
                    enabledButton.setIcon(enable);
                }
            }
        });

        add(enabledButton, BorderLayout.WEST);
    }

    private void addRemoveIButton() {
        final CustomButton removeButton = new CustomButton(remove, "Removes a function");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                removeSelf();
            }
        });

        add(removeButton, BorderLayout.EAST);
    }

    private void addRangePanel() {

        final JPanel rangePanel = new JPanel(new FlowLayout());
        rangePanel.setPreferredSize(new Dimension(80, 30));
        rangePanel.setMaximumSize(new Dimension(200, 30));



        final JTextField rangeMinField = new JTextField("0");
        rangeMinField.setPreferredSize(new Dimension(50, 30));
        rangeMinField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                function.setMin(Double.parseDouble(rangeMinField.getText()));
            }
        });

        final JTextField rangeMaxField = new JTextField("10");
        rangeMaxField.setPreferredSize(new Dimension(50, 30));
        rangeMaxField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                function.setMax(Double.parseDouble(rangeMaxField.getText()));
            }
        });

        rangePanel.add(rangeMinField);
        rangePanel.add(rangeMaxField);
        add(rangePanel, BorderLayout.CENTER);

    }

    private void addExpressionField() {
        final JTextField expressionField = new JTextField("x");
        expressionField.setPreferredSize(new Dimension(200, 30));
        expressionField.setMaximumSize(new Dimension(250, 30));

        expressionField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent actionEvent) {
                try {
                    function.setExpression(expressionField.getText());
                } catch (final FunctionException exception) {
                    JOptionPane.showMessageDialog(null,
                             "Expression Field error encountered: \n" + exception.getMessage());
                }
            }
        });

        add(expressionField, BorderLayout.NORTH);
    }

    private void enableFunction() {
        function.setDrawable(true);
    }

    private void disableFunction() {
        function.setDrawable(false);
    }

    private void removeSelf() {
        parent.removeFunction(this);
    }


}

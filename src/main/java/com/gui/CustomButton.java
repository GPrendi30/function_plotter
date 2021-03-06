package com.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CustomButton extends JButton {


    /**
     * Create a customButton.
     *
     * @param i           an Icon for the button.
     * @param description a String that describes the button.
     */
    public CustomButton(final ImageIcon i, final String description) {
        super(i);
        setBorder(null);
        setMargin(new Insets(10, 0, 10, 0));

        setBackground(new Color(255, 255, 255));

        setMaximumSize(new Dimension(125, 125));
        setMinimumSize(new Dimension(64, 64));

        setToolTipText(description);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(final java.awt.event.MouseEvent evt) {
                setBackground(Color.GRAY);
            }

            public void mouseExited(final java.awt.event.MouseEvent evt) {
                setBackground(new Color(255, 255, 255));
            }
        });
    }


}

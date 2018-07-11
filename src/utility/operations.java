/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Dimension;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author anishgarg
 */
public class operations {
    public static void openInternalFrame(JDesktopPane deskpane, JInternalFrame frame) {
        frame.setVisible(true);
        deskpane.add(frame);
        try {
            frame.setSelected(true);
            Dimension desktopSize = deskpane.getSize();
            Dimension jInternalFrameSize = frame.getSize();
            frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);
        } catch (PropertyVetoException ex) {
        }
    }
}

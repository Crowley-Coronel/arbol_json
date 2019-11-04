package jsonpretty;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author Test
 */
class MyTreeCellRenderer extends DefaultTreeCellRenderer implements TreeCellRenderer {

    @Override
    public java.awt.Component getTreeCellRendererComponent(javax.swing.JTree tree,
            Object value,
            boolean bSelected,
            boolean bExpanded,
            boolean bLeaf,
            int iRow,
            boolean bHasFocus) {

        // Find out which node we are rendering and get its text
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        String labelText = (String) node.toString();
        setText(labelText);
        Icon iconoAbrir = new ImageIcon(getClass().getClassLoader().getResource("resources/open.png"));
        Icon closeIcon = new ImageIcon("resources/close.png");
        Icon iconoleaf = new ImageIcon("resources/square.png");
        setForeground(java.awt.Color.white);
        setBackground(java.awt.Color.red);
        setOpenIcon(iconoAbrir);
        setClosedIcon(closeIcon);
        setLeafIcon(iconoleaf);
        setIcon(iconoleaf);

        return this;
    }
}

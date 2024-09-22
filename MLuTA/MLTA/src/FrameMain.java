import util.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.List;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableMassive;
    private JButton buttonOpenFile;
    private JButton buttonGetResult;
    private JScrollPane JScrollMassive;
    private JPanel JPanelOpen;
    private JPanel JPanelResult;
    private JTextField textFieldResult;
    private JButton methodKramerButton;
    private JTable tableMassive2;
    private JTable tableMassive3;
    private JButton buttonMulti;
    private JScrollPane JScrollMassive2;
    private JButton openFile2Button;
    private JButton buttonReverse;
    private JButton buttonMethodReverse;
    private JButton button1Gauss;
    private JButton ownVectorsButton;

    private JFileChooser fileChooserOpen;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableMassive, 70, true, true, true, true);
        tableMassive.setRowHeight(25);
        JTableUtils.initJTableForArray(tableMassive2, 70, true, true, true, true);
        tableMassive2.setRowHeight(25);
        JTableUtils.initJTableForArray(tableMassive3, 70, true, true, true, true);
        tableMassive3.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("finding the nth order of the matrix");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);


        this.pack();

        buttonOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        double[][] arr = ArrayUtils.readDoubleArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableMassive, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonGetResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double result = Program.findDeterminant2(matrix);
                    textFieldResult.setText("определитель: " + result);

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        methodKramerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder s = new StringBuilder();
                try {
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double[] result = Program.matrixNewKramer(matrix);
                    if (result.length == 1) {
                        textFieldResult.setText("система не имеет решений");
                    } else {
                        for (int i = 1; i < result.length; i++) {
                            if (i == result.length - 1) {
                                s.append("x").append(i).append(": ").append(result[i]);
                            } else {
                                s.append("x").append(i).append(": ").append(result[i]).append(", ");
                            }
                        }
                        textFieldResult.setText(String.valueOf(s));
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buttonMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double[][] matrix2 = JTableUtils.readDoubleMatrixFromJTable(tableMassive2);
                    double[][] result = Program.matrixMulti(matrix, matrix2);
                    JTableUtils.writeArrayToJTable(tableMassive3, result);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        openFile2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        double[][] arr = ArrayUtils.readDoubleArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableMassive2, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double[][] result = Program.reverseMatrix(matrix);
                    double[][] check = Program.matrixMulti(matrix, result);
                    for (int i = 0; i < check.length; i++) {
                        for (int j = 0; j < check[0].length; j++) {
                            System.out.print(j != check[0].length - 1 ? check[i][j] + ", " : check[i][j]);
                        }
                        System.out.println();
                    }
                    JTableUtils.writeArrayToJTable(tableMassive3, result);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonMethodReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder s = new StringBuilder();
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double[] result = Program.methodReverse(matrix);
                    for (int i = 0; i < result.length; i++) {
                        if (i == result.length - 1) {
                            s.append("x").append(i + 1).append(": ").append(result[i]);
                        } else {
                            s.append("x").append(i + 1).append(": ").append(result[i]).append(", ");
                        }
                    }
                    textFieldResult.setText(String.valueOf(s));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button1Gauss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder s = new StringBuilder();
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    double[][] result = Program.methodGaussa(matrix);
                    if (Program.checkExistResults(result) != 0) {
                        for (int i = 0; i < result[0].length; i++) {
                            double j = result[0][i] == -0 ? 0 : result[0][i];
                            if (i == result[0].length - 1) {
                                s.append("x").append(i + 1).append(": ").append(j);
                            } else {
                                s.append("x").append(i + 1).append(": ").append(j).append(", ");
                            }
                        }
                        textFieldResult.setText(String.valueOf(s));
                    } else {
                        for (int j = 0; j < result.length; j++) {
                            s.append("C").append(j + 1).append('(');
                            for (int i = 0; i < result[0].length; i++) {
                                double k = result[j][i] == -0 ? 0 : result[j][i];
                                s.append(k).append(" ");
                            }
                            if (j == result.length - 1) {
                                s.append(")");
                            } else {
                                s.append(")").append(" + ");
                            }
                        }
                        textFieldResult.setText(String.valueOf(s));
                    }
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });

        ownVectorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder s = new StringBuilder();
                    double[][] matrix = JTableUtils.readDoubleMatrixFromJTable(tableMassive);
                    List<OwnMatrix> result = Program.ownVectors(matrix);
                    for (int z = 0; z < result.size(); z++) {
                        if (Program.checkExistResults(result.get(z).vector) != 0) {
                            s.append("y").append(z+1).append(" = ").append(result.get(z).value).append(": ").append("(");
                            for (int i = 0; i < result.get(z).vector[0].length; i++) {
                                s.append(result.get(z).vector[0][i]);
                                if (i != result.get(z).vector[0].length-1) {
                                    s.append(", ");
                                }
                            }
                            s.append(") ");
                        } else { // неизвестные корни
                            for (int j = 0; j < result.get(z).vector.length; j++) {
                                s.append("y").append(z+1).append(" = ").append(result.get(z).value).append(": ").append("(");
                                for (int i = 0; i < result.get(z).vector[0].length; i++) {
                                    s.append(result.get(z).vector[j][i]);
                                    if (i != result.get(z).vector[j].length - 1) {
                                        s.append(", ");
                                    }
                                }
                                s.append(") ");
                            }
                        }
                    }
                    textFieldResult.setText(String.valueOf(s));
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(10, 10, 10, 10), -1, -1));
        JScrollMassive = new JScrollPane();
        panelMain.add(JScrollMassive, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 200), null, 0, false));
        tableMassive = new JTable();
        JScrollMassive.setViewportView(tableMassive);
        JPanelOpen = new JPanel();
        JPanelOpen.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(JPanelOpen, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonOpenFile = new JButton();
        buttonOpenFile.setText("Открыть файл");
        JPanelOpen.add(buttonOpenFile, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonGetResult = new JButton();
        buttonGetResult.setText("Определитель");
        JPanelOpen.add(buttonGetResult, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        methodKramerButton = new JButton();
        methodKramerButton.setText("Метод Крамера");
        JPanelOpen.add(methodKramerButton, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonMethodReverse = new JButton();
        buttonMethodReverse.setText("Метод обратной матрицы");
        JPanelOpen.add(buttonMethodReverse, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPanelResult = new JPanel();
        JPanelResult.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(JPanelResult, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldResult = new JTextField();
        JPanelResult.add(textFieldResult, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        JScrollMassive2 = new JScrollPane();
        panelMain.add(JScrollMassive2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableMassive2 = new JTable();
        JScrollMassive2.setViewportView(tableMassive2);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        openFile2Button = new JButton();
        openFile2Button.setText("Открыть файл 2");
        panel1.add(openFile2Button, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonMulti = new JButton();
        buttonMulti.setText("Умножить матрицы");
        panel1.add(buttonMulti, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonReverse = new JButton();
        buttonReverse.setText("Обратная матрица");
        panel1.add(buttonReverse, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button1Gauss = new JButton();
        button1Gauss.setText("Метод Гаусса");
        panel1.add(button1Gauss, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panelMain.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableMassive3 = new JTable();
        scrollPane1.setViewportView(tableMassive3);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}

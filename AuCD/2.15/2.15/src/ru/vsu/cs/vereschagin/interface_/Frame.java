package ru.vsu.cs.vereschagin.interface_;

import ru.vsu.cs.vereschagin.logic.LinkedList;
import ru.vsu.cs.vereschagin.logic.LinkedListUtils;
import ru.vsu.cs.vereschagin.util.JTableUtils;
import ru.vsu.cs.vereschagin.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class Frame  extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JButton buttonTask;
    private JButton buttonLoad;
    private JTable tableOutput;
    private JButton buttonSave;
    private JTextField textFieldAdd;
    private JButton buttonAdd;
    private JTextField textFieldDelete;
    private JButton buttonDelete;

    private LinkedList<Integer> linkedList = null;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public Frame() {

        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, false, true, false, false);
        JTableUtils.initJTableForArray(tableOutput, 40, false, true, false, false);

        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");


        JTableUtils.writeArrayToJTable(tableInput, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        linkedList = LinkedListUtils.arrToList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        buttonTask.addActionListener(actionEvent ->{
            if(linkedList != null){
                LinkedList<Integer> listUtils = linkedList.sumPair();
                int[] arr = LinkedListUtils.listToArr(listUtils);
                JTableUtils.writeArrayToJTable(tableOutput, arr);
            }
        });

        buttonLoad.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    linkedList = LinkedListUtils.listFromFile(fileChooserOpen.getSelectedFile().getPath());
                    updateTable();
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonSave.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    LinkedListUtils.write(file, LinkedListUtils.arrToList(JTableUtils.readIntArrayFromJTable(tableOutput)).toString());
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonAdd.addActionListener(actionEvent -> {
            if(!textFieldAdd.getText().isEmpty()){
                try{
                    int a = Integer.parseInt(textFieldAdd.getText());
                    linkedList.add(a);
                    updateTable();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonDelete.addActionListener(actionEvent ->{
            if(textFieldDelete.getText().isEmpty()){
                linkedList.removeLast();
                updateTable();
            }else{
                try{
                    linkedList.remove(Integer.parseInt(textFieldDelete.getText().trim()));
                    updateTable();
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }

            }
        });

    }

    private void updateTable(){
        int[] arr = LinkedListUtils.listToArr(linkedList);
        JTableUtils.writeArrayToJTable(tableInput, arr);
    }
}

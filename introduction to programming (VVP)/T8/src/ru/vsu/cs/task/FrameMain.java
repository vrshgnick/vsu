package ru.vsu.cs.task;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import ru.vsu.cs.utils.ArrayUtils;
import ru.vsu.cs.utils.JTableUtils;
import ru.vsu.cs.utils.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;


public class FrameMain extends JFrame {
	private JPanel panelMain;
	private JTable tableInput;
	private JTable tableOutput;
	private JButton buttonLoadInputFromFile;
	private JButton buttonSaveInputInfoFile;
	private JButton buttonSaveOutputIntoFile;
	private JButton buttonRandomInput;
	private JButton buttonSolve;
	private JButton buttonClear;

	private final JFileChooser fileChooserOpen;
	private final JFileChooser fileChooserSave;


	public FrameMain() {
		this.setTitle("Task");
		this.setContentPane(panelMain);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();

		JTableUtils.initJTableForArray(tableInput, 40, true, true, true, true);
		JTableUtils.initJTableForArray(tableOutput, 40, true, true, true, true);
		tableOutput.setEnabled(false);
		tableInput.setRowHeight(25);
		tableOutput.setRowHeight(25);

		fileChooserOpen = new JFileChooser();
		fileChooserSave = new JFileChooser();
		fileChooserOpen.setCurrentDirectory(new File(Program.defaultFileDirectory));
		fileChooserSave.setCurrentDirectory(new File(Program.defaultFileDirectory));
		FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
		fileChooserOpen.addChoosableFileFilter(filter);
		fileChooserSave.addChoosableFileFilter(filter);
		fileChooserSave.setAcceptAllFileFilterUsed(false);
		fileChooserOpen.setAcceptAllFileFilterUsed(false);

		fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
		fileChooserSave.setApproveButtonText("Save");

		JTableUtils.writeArrayToJTable(tableInput, new int[2][5]);

		this.pack();


		buttonLoadInputFromFile.addActionListener(actionEvent -> {
			try {
				if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
					int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
					JTableUtils.writeArrayToJTable(tableInput, arr);
				}
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
		buttonSaveInputInfoFile.addActionListener(actionEvent -> {
			try {
				if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
					int[][] arr = JTableUtils.readIntMatrixFromJTable(tableInput);
					String file = fileChooserSave.getSelectedFile().getPath();
					ArrayUtils.writeArrayToFile(file, arr);
				}
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
		buttonSaveOutputIntoFile.addActionListener(actionEvent -> {
			try {
				if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
					int[][] arr = JTableUtils.readIntMatrixFromJTable(tableOutput);
					String file = fileChooserSave.getSelectedFile().getPath();
					ArrayUtils.writeArrayToFile(file, arr);
				}
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
		buttonRandomInput.addActionListener(actionEvent -> {
			try {
				int[][] arr = ArrayUtils.createRandomIntMatrix(
						tableInput.getRowCount(), tableInput.getColumnCount(), 100);
				JTableUtils.writeArrayToJTable(tableInput, arr);
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
		buttonClear.addActionListener(actionEvent -> {
			try {
				for (int r = 0; r < tableInput.getRowCount(); r++) {
					for (int c = 0; c < tableInput.getColumnCount(); c++) {
						tableInput.setValueAt(null, r, c);
					}
				}
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
		buttonSolve.addActionListener(actionEvent -> {
			try {
				int[][] arr = JTableUtils.readIntMatrixFromJTable(tableInput);
				Solver.sortMatrix(arr);
				JTableUtils.writeArrayToJTable(tableOutput, arr);
			} catch (Exception e) {
				SwingUtils.showErrorMessageBox(e);
			}
		});
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
		panelMain.setLayout(new GridLayoutManager(5, 1, new Insets(10, 10, 10, 10), 10, 10));
		final JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setVerticalScrollBarPolicy(21);
		panelMain.add(scrollPane1,
					  new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
										  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
										  GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 200), null, 0,
										  false));
		tableInput = new JTable();
		scrollPane1.setViewportView(tableInput);
		final JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(21);
		panelMain.add(scrollPane2,
					  new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
										  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
										  GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 200), null, 0,
										  false));
		tableOutput = new JTable();
		scrollPane2.setViewportView(tableOutput);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		panelMain.add(panel1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  null, null, null, 0, false));
		final Spacer spacer1 = new Spacer();
		panel1.add(spacer1,
				   new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		buttonSolve = new JButton();
		buttonSolve.setText("Решить");
		panel1.add(buttonSolve,
				   new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
		panelMain.add(panel2, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  null, null, null, 0, false));
		buttonSaveOutputIntoFile = new JButton();
		buttonSaveOutputIntoFile.setText("Сохранить в файл");
		panel2.add(buttonSaveOutputIntoFile,
				   new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final Spacer spacer2 = new Spacer();
		panel2.add(spacer2,
				   new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
		panelMain.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
												  null, null, null, 0, false));
		final Spacer spacer3 = new Spacer();
		panel3.add(spacer3,
				   new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(100, -1), null, 0,
									   false));
		buttonRandomInput = new JButton();
		buttonRandomInput.setText("Случайно");
		panel3.add(buttonRandomInput,
				   new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		buttonClear = new JButton();
		buttonClear.setText("Очистить");
		panel3.add(buttonClear,
				   new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		buttonLoadInputFromFile = new JButton();
		buttonLoadInputFromFile.setText("Загрузить из файла");
		panel3.add(buttonLoadInputFromFile,
				   new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		buttonSaveInputInfoFile = new JButton();
		buttonSaveInputInfoFile.setText("Сохранить в файл");
		panel3.add(buttonSaveInputInfoFile,
				   new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
									   GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
									   GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return panelMain;
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}
}
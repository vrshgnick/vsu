package ru.vsu.cs.graphics;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ru.vsu.cs.logic.ArrayListList;
import ru.vsu.cs.logic.List;

public class AppController {

    private List<String> list = new ArrayListList<>();

    @FXML
    private ListView<String> mapArrayList;

    @FXML
    private TextField keyField;

    @FXML
    private TextField valueField;

    @FXML
    private TextField addAllField;

    @FXML
    private TextField resultLabel;

    @FXML
    private void onEqualsButtonClick() {
        String element = resultLabel.getText().trim();
        if (element.isEmpty()) {
            resultLabel.setText("Please enter an element.");
            return;
        }

        boolean isEqual = list.contains(element);
        resultLabel.setText(isEqual ? "Elements are equal." : "Elements are not equal.");
    }

    @FXML
    private void OnIndexOfButtonClick() {
        String element = resultLabel.getText().trim();
        if (element.isEmpty()) {
            resultLabel.setText("Please enter an element.");
            return;
        }

        int index = list.indexOf(element);
        resultLabel.setText(index >= 0 ? "Index: " + index : "Element not found.");
    }


    @FXML
    public void onAddButtonClick() {
        try {
            int index = Integer.parseInt(keyField.getText());
            String value = valueField.getText();
            list.add(index, value);
            updateListView();
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Add operation");
        }
    }

    @FXML
    public void onAddFirstButtonClick() {
        String value = valueField.getText();
        list.addFirst(value);
        updateListView();
    }

    @FXML
    public void onAddLastButtonClick() {
        String value = valueField.getText();
        list.addLast(value);
        updateListView();
    }

    @FXML
    public void onContainsButtonClick() {
        String value = valueField.getText();
        boolean result = list.contains(value);
        resultLabel.setText("Contains: " + result);
    }

    @FXML
    public void onContainsAllButtonClick() {
        try {
            String[] elements = addAllField.getText().split(",");
            List<String> newList = new ArrayListList<>();
            for (String element : elements) {
                newList.addLast(element.trim());
            }
            boolean result = list.containsAll(newList);
            resultLabel.setText("Contains All: " + result);
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Contains All operation");
        }
    }

    @FXML
    public void onGetButtonClick() {
        try {
            int index = Integer.parseInt(keyField.getText());
            String result = list.get(index);
            resultLabel.setText("Get: " + result);
        } catch (Exception e) {
            showAlert("Error", "Invalid index for Get operation");
        }
    }

    @FXML
    public void onGetFirstButtonClick() {
        String result = list.getFirst();
        resultLabel.setText("Get First: " + result);
    }

    @FXML
    public void onGetLastButtonClick() {
        String result = list.getLast();
        resultLabel.setText("Get Last: " + result);
    }

    @FXML
    public void onHashCodeButtonClick() {
        int hashCode = list.hashCode();
        resultLabel.setText("HashCode: " + hashCode);
    }

    @FXML
    public void onRemoveButtonClick() {
        try {
            int index = Integer.parseInt(keyField.getText());
            String removedElement = list.remove(index);
            resultLabel.setText("Removed: " + removedElement);
            updateListView();
        } catch (Exception e) {
            showAlert("Error", "Invalid index for Remove operation");
        }
    }

    @FXML
    public void onRemoveFirstButtonClick() {
        String removedElement = list.removeFirst();
        resultLabel.setText("Removed First: " + removedElement);
        updateListView();
    }

    @FXML
    public void onRemoveLastButtonClick() {
        String removedElement = list.removeLast();
        resultLabel.setText("Removed Last: " + removedElement);
        updateListView();
    }

    @FXML
    public void onIndexOfButtonClick() {
        try {
            String value = valueField.getText();
            int index = list.indexOf(value);
            resultLabel.setText("Index of: " + index);
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Index Of operation");
        }
    }

    @FXML
    public void onLastIndexOfButtonClick() {
        try {
            String value = valueField.getText();
            int index = list.lastIndexOf(value);
            resultLabel.setText("Last Index of: " + index);
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Last Index Of operation");
        }
    }

    @FXML
    public void onIsEmptyButtonClick() {
        boolean result = list.isEmpty();
        resultLabel.setText("Is Empty: " + result);
    }

    @FXML
    public void onReversedButtonClick() {
        List<String> reversedList = list.reversed();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversedList.size(); i++) {
            sb.append(reversedList.get(i)).append(", ");
        }
        resultLabel.setText("Reversed: " + sb.toString());
    }

    @FXML
    public void onSetButtonClick() {
        try {
            int index = Integer.parseInt(keyField.getText());
            String value = valueField.getText();
            list.set(index, value);
            updateListView();
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Set operation");
        }
    }

    @FXML
    public void onSizeButtonClick() {
        int size = list.size();
        resultLabel.setText("Size: " + size);
    }

    @FXML
    public void onClearButtonClick() {
        list.clear();
        updateListView();
        resultLabel.setText("List cleared");
    }

    @FXML
    public void onAddAllButtonClick() {
        try {
            String[] pairs = addAllField.getText().split(",");
            for (String pair : pairs) {
                String[] parts = pair.split("=");
                if (parts.length == 2) {
                    int index = Integer.parseInt(parts[0].trim());
                    String value = parts[1].trim();
                    list.add(index, value);
                }
            }
            updateListView();
        } catch (Exception e) {
            showAlert("Error", "Invalid input for Add All operation");
        }
    }

    private void updateListView() {
        mapArrayList.getItems().clear();
        for (int i = 0; i < list.size(); i++) {
            mapArrayList.getItems().add(list.get(i));
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


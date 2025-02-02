package org.example.task2_figura;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField inputField;

    @FXML
    private Canvas canvas;



    // Метод для проверки ввода с использованием регулярного выражения
    private boolean checkWithRegExp(String input) {
        return input.matches("[1-5]"); // Проверка, что введено число от 1 до 5
    }
    @FXML
    private void handleDrawButtonAction() {
        GraphicsContext gr = canvas.getGraphicsContext2D();

        // Проверка ввода
        if (!checkWithRegExp(inputField.getText()) || inputField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setHeaderText(null);
            alert.setContentText("Введено не число или число не из диапазона от 1 до 5!");
            alert.showAndWait();
            return;
        }

        // Получение числа из текстового поля
        int numberOfSides = Integer.parseInt(inputField.getText());

        // Создание фигуры с помощью фабрики
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.createShape(numberOfSides);

        // Очистка Canvas и отрисовка фигуры
        gr.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        shape.draw(gr);
    }
}
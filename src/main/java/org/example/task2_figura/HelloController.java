package org.example.task2_figura;

import javafx.fxml.FXML;

import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class HelloController {
    @FXML
    private Pane drawingPane; // Панель для рисования

    private Memento temp; // Временное хранилище для текущей фигуры
    private MemoSelect memoSelect = new MemoSelect(); // Управление множеством состояний

    // Инициализация стартового набора фигур
    public void initialize() {
        Circle circle = new Circle(100, 100, 50);
        Rectangle rectangle = new Rectangle(200, 200, 100, 100);

        drawingPane.getChildren().addAll(circle, rectangle);

        // Добавляем обработчики событий для каждой фигуры
        for (var node : drawingPane.getChildren()) {
            if (node instanceof Shape) {
                Shape shape = (Shape) node;
                shape.setOnMousePressed(this::onBegin);
                shape.setOnMouseDragged(this::onDrag);
                shape.setOnMouseReleased(this::onEnd);
            }
        }
    }

    // Обработчик начала перетаскивания
    public void onBegin(MouseEvent event) {
        if (event.getSource() instanceof Shape) {
            Shape shape = (Shape) event.getSource();
            temp = new Memento(shape); // Создаем снимок состояния
            memoSelect.push(temp); // Сохраняем состояние в Caretaker
            temp.initState().toFront(); // Выделяем фигуру
        }
    }

    // Обработчик перетаскивания
    public void onDrag(MouseEvent event) {
        if (temp == null) return;
        Shape shape = temp.initState();

        // Получаем координаты мыши относительно панели
        double mouseX = event.getX();
        double mouseY = event.getY();

        // Перемещаем фигуру так, чтобы её центр был под курсором
        shape.setLayoutX(mouseX - shape.getBoundsInLocal().getWidth() / 2);
        shape.setLayoutY(mouseY - shape.getBoundsInLocal().getHeight() / 2);
    }

    // Обработчик завершения перетаскивания
    public void onEnd(MouseEvent event) {
        if (temp == null) return;
        Shape shape = temp.getState(); // Восстанавливаем состояние

        // Получаем координаты мыши относительно панели
        double mouseX = event.getX();
        double mouseY = event.getY();

        // Устанавливаем финальное положение фигуры
        shape.setLayoutX(mouseX - shape.getBoundsInLocal().getWidth() / 2);
        shape.setLayoutY(mouseY - shape.getBoundsInLocal().getHeight() / 2);

        temp = null; // Сбрасываем временное хранилище
    }
}
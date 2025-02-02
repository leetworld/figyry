module org.example.task2_figura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.task2_figura to javafx.fxml;
    exports org.example.task2_figura;
}
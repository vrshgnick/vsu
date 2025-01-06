module ru.vsu.cs.graphics {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;

    opens ru.vsu.cs.graphics to javafx.fxml;
    exports ru.vsu.cs.graphics;
    exports ru.vsu.cs.logic;
}

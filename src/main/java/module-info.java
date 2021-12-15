module start {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires commons.io;

    opens controller to javafx.fxml;
    opens start to javafx.fxml;
    exports controller;
    exports start;
}

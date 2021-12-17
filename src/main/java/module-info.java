module start {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.base;
    requires java.sql;


    opens controller to javafx.fxml;
    opens start to javafx.fxml,javafx.base;
    opens model to javafx.fxml,javafx.base;
    
    exports model;
    exports controller;
    exports start;
}

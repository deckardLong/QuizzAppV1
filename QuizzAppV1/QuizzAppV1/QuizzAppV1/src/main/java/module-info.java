module com.nhgl.quizzappv1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.nhgl.quizzappv1 to javafx.fxml;
    exports com.nhgl.quizzappv1;
}

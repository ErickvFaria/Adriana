module CRUDProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens CRUD.controller to javafx.fxml;
    opens CRUD.model to javafx.fxml;

    exports CRUD;
    exports CRUD.controller;
    exports CRUD.model;
}

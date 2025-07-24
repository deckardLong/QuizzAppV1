package com.nhgl.quizzappv1;

import com.nhgl.pojo.Category;
import com.nhgl.pojo.Choice;
import com.nhgl.pojo.Level;
import com.nhgl.pojo.Question;
import com.nhgl.services.BaseServices;
import com.nhgl.services.CategoryServices;
import com.nhgl.services.LevelServices;
import com.nhgl.services.UpdateQuestionServices;
import com.nhgl.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QuestionsController implements Initializable {

    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private VBox vboxChoices;
    @FXML
    private TextArea txtContent;
    @FXML
    private ToggleGroup toggleChoices;

    private final static BaseServices cateService = new CategoryServices();
    private final static BaseServices levelService = new LevelServices();
    private final static UpdateQuestionServices uQService = new UpdateQuestionServices();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbCates.setItems(FXCollections.observableList(cateService.list()));
            this.cbLevels.setItems(FXCollections.observableList(levelService.list()));
        } catch (SQLException ex) {
        }
    }

    public void handleAddChoice(ActionEvent event) {
        HBox h = new HBox();
        h.getStyleClass().add("Background");

        RadioButton rdo = new RadioButton();
        rdo.setToggleGroup(toggleChoices);
        TextField txt = new TextField();
        txt.getStyleClass().add("Input");
        txt.setPromptText("Nội dung lựa chọn");

        h.getChildren().addAll(rdo, txt);

        this.vboxChoices.getChildren().add(h);
    }

    public void handleAddQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());

            for (var c : this.vboxChoices.getChildren()) {
                HBox h = (HBox) c;

                b.addChoice(new Choice(((TextField) h.getChildren().get(1)).getText(),
                        ((RadioButton) h.getChildren().get(0)).isSelected()));
            }

            uQService.addQuestion(b.build());
            
            MyAlert.getInstance().showMsg("Thêm câu hỏi thành công!");
        } catch (SQLException ex) {
            MyAlert.getInstance().showMsg("Thêm câu hỏi thất bại, lý do: " 
                    + ex.getMessage(), Alert.AlertType.ERROR);
        } catch (Exception ex) {
            MyAlert.getInstance().showMsg("Dữ liệu bị lỗi!", Alert.AlertType.ERROR);
        }
    }
}

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    @FXML
    public TextArea chatFld;

    @FXML
    public TextField editText;

//    public Controller() {
//        editText.setOnKeyPressed(event -> {
//            if (event.getCode().equals(KeyCode.ENTER)){
//                sendMessage();
//            }
//        });
//    }

    public void btnSend(ActionEvent actionEvent) {
        sendMessage();
    }

    private void sendMessage(){
        chatFld.appendText(editText.getText() + "\n");
        editText.clear();
        editText.requestFocus();
    }
}

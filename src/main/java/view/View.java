package view;

import javafx.stage.Stage;
import model.Direction;
import model.Move;

public interface View {
    void handleMove(Direction direction);
    void handleLook(Direction direction);

}

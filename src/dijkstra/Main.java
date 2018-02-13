package dijkstra;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application
{
    final Button btn_open = new Button();
    final Button btn_search = new Button();
    final Label lbl_ = new Label();
    final TextField txt_from = new TextField();
    final TextField txt_to = new TextField();
    final TextField txt_res = new TextField();
    final Alert alertError = new Alert(Alert.AlertType.ERROR);
        
    @Override
    public void start(Stage stage)
    {
        this.btn_open.setText("Open file");
        this.btn_open.setPrefSize(420, 25);
        //this.btn_open.setStyle("-fx-background-color: white; -fx-border-color: grey; -fx-border-width: 1px;");
        this.btn_search.setText("Shortest route");
        this.btn_search.setPrefSize(420, 25);
        this.txt_res.setEditable(false);
        this.lbl_.setPrefSize(420, 32);
        this.alertError.setTitle("Hiba");
        
        btn_open.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                FileChooser chooser = new FileChooser();
                File file = chooser.showOpenDialog(stage);
                Scanner sc = null;
                try
                {
                    Scanner scanner = new Scanner(file);
                } catch (Exception e) {
                }
                while(sc.hasNext())
                {
                    String from = sc.next();
                    String to = sc.next();
                    int dist = sc.nextInt();
                    
                    Node nfrom = NodeFactory.getNode(from);
                    Node nto = NodeFactory.getNode(to);
                    
                    nfrom.addNeig(nto, dist);
                }
            }
        });
        
        btn_search.setOnAction(actionEvent ->
        {
            txt_res.setText("");
            
            try
            {
                List<String> dlist = Dijkstra.searchPath(txt_from.getText(), txt_to.getText());
                for (int i = 0; i < dlist.size(); i++)
                {
                    txt_res.setText(txt_res.getText() + dlist.get(i) + " -> ");
                }
            } catch (Exception ex) {
                this.alertError.setHeaderText(ex.getMessage());
                this.alertError.showAndWait();
            }
        });
        
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background: RGB(185, 209, 234);");
        //vbox.setStyle("-fx-background: #cecece;");
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(btn_open);
        vbox.getChildren().add(txt_from);
        vbox.getChildren().add(txt_to);
        vbox.getChildren().add(lbl_);
        vbox.getChildren().add(btn_search);
        vbox.getChildren().add(txt_res);
        
        Scene scene = new Scene(vbox, 420, 260);
        stage.setTitle("Dijkstra");
        stage.maxWidthProperty().setValue(420);
        stage.maxHeightProperty().setValue(260);
        stage.minWidthProperty().setValue(420);
        stage.minHeightProperty().setValue(260);
        stage.setScene(scene);
        stage.show(); 
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
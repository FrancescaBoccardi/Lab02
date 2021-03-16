package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary words = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParole;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtParole.setText("");
    	txtResult.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	if(!txtParole.getText().matches("[a-zA-Z\s\\?]*")) {
    		txtResult.setText("ERRORE: le parole non possono contenere numeri e/o caratteri speciali");
    		return;
    	}
    	
    	if(txtParole.getText().isBlank()) {
    		txtResult.setText("ERRORE: inserire almeno una parola");
    		return;
    	}
    	
    	String parole[] = txtParole.getText().toLowerCase().split(" ");
    	
    	if(parole.length==1) {
    		
			int num = 0;
			for(int i=0;i<parole[0].length();i++) {
				if(parole[0].charAt(i)=='?') {
					num++;
				}
			}
			
			if(num==1) {
				parole[0] = parole[0].replace("?", "[a-z]");
			}
    		
			
    		if(words.translateWord(parole[0])!=null) {
    			txtResult.setText(words.translateWord(parole[0]));
    		}
    		else {
    			txtResult.setText("ERRORE: parola non esistente nel dizionario");
    		} 
    		
    	}else if(parole.length==2){
    		words.addWord(parole[0], parole[1]);
    		txtResult.setText("Parola aggiunta correttamente");
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
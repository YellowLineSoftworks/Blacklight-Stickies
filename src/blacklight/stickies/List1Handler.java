package blacklight.stickies;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class List1Handler {
    public static void runHandler() {
        String intotext = "";
        String path = EventHandler.array[EventHandler.gui.listValue].toString();
        FileInputStream fstream;
        try {fstream = new FileInputStream(path);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String news = null;
        while ((news = br.readLine()) != null) {
            
            intotext = intotext + news + "\n";
        
        }} catch (Exception e) {}
        EventHandler.gui.jTextArea2.setText(intotext);
        EventHandler.filepath = path;
        EventHandler.isFirstTime = false;
        }
}

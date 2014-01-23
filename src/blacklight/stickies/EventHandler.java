package blacklight.stickies;

import java.util.Arrays;
import java.io.*;

public class EventHandler {
    
    public static javax.swing.DefaultListModel model = new javax.swing.DefaultListModel();
    public static FileInputStream fstream;
    public static int L1Len = 0;
    public static int L2Len = 0;
    public static String[] folders = new String[0];
    public static int fcount = 0;
    public static GUI gui;
    public static File[] array;
    public static boolean change = false;
    public static String filepath = null;
    public static boolean isTxt = false;
    public static boolean isFirstTime = true;
    public static boolean ifTrue = true;
    public static boolean wait = true;
    
    public static void main(String args[]) {
        
        while (ifTrue = true) {
        wait = true;
        gui = new GUI();
        gui.setVisible(true);
        gui.setResizable(false);
        gui.setTitle("Blacklight Stickies");
        int counter = 0;
        String[] list1 = getList1();
        model.setSize(L1Len);
        while (counter < L1Len) {
            model.add(counter, list1[counter]);
            counter++;
        }
        String cdir = System.getProperty("user.dir");
        cdir = cdir + "\\Projects";
        array = listPath(new File(cdir));
        int a = 0;
        int b = array.length;
        String mets;
        while (a < b) {
            
            mets = array[a].toString();
            int lio = mets.lastIndexOf("\\");
            int indexOf = mets.lastIndexOf(".");
            if (indexOf == -1) {
                String[] folder = new String[folders.length + 1];
                int count = 0;
                while (count < folders.length) {
                    folder[count] = folders[count];
                    count++;
                }
                folder[count] = mets;
                String newstr = mets.substring((lio + 1));
                model.addElement(newstr);
                a++;
            }
            if (indexOf != -1) {
                String toCompare = mets.substring(indexOf + 1);
                if ((toCompare.equals("txt")) == false) {
                    a++;
                }
                else {
                    String newstr = mets.substring((lio + 1));
                    model.addElement(newstr);
                    a++;
                }
            }            
            
        }
        while (wait == true) {
            try{Thread.sleep(50);} catch (Exception e) {}
        }
        gui.setVisible(false);
    }
        
    }
    
    public static void save(String contents, String name) throws Exception {
        
        File output = new File(name);
        FileWriter outFile = new FileWriter(output);
        BufferedWriter out = new BufferedWriter(outFile);
        out.write(contents);
        out.newLine();
        out.close();
        
    }
    
    public static String[] getList1() {
        
        String[] list;
        String news = null;
        int count = 0;
        String cdir = System.getProperty("user.dir");
        cdir = cdir + "\\bin\\inmydir.txt";
        try {fstream = new FileInputStream(cdir);} catch (Exception e) {}
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {while ((news = br.readLine()) != null) {
            
            L1Len++;
        
        }} catch (Exception e) {}
        news = null;
        list = new String[L1Len];
        try {fstream = new FileInputStream(cdir);} catch (Exception e) {}
        in = new DataInputStream(fstream);
        br = new BufferedReader(new InputStreamReader(in));
        try {while ((news = br.readLine()) != null) {
        
            list[count] = news;
            count++;
        
        }} catch (Exception e) {}
        return list;
        
    }
    
    public static String[] getList2() {
        
        String[] list;
        String news = null;
        int count = 0;
        String cdir = System.getProperty("user.dir");
        cdir = cdir + "\\Projects";
        try {fstream = new FileInputStream(cdir);} catch (Exception e) {}
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        try {while ((news = br.readLine()) != null) {
            
            L2Len++;
        
        }} catch (Exception e) {}
        news = null;
        list = new String[L2Len];
        try {fstream = new FileInputStream(cdir);} catch (Exception e) {}
        in = new DataInputStream(fstream);
        br = new BufferedReader(new InputStreamReader(in));
        try {while ((news = br.readLine()) != null) {
        
            list[count] = news;
            count++;
        
        }} catch (Exception e) {}
        return list;
        
    }

    public static File[] listPath(File path) {
     
        File files[]; 
        files = path.listFiles();
        Arrays.sort(files);
        for (int i = 0, n = files.length; i < n; i++) {
            if (files[i].isDirectory()) {

                listPath(files[i]);
                
            }
        }
        return files;
    }

}
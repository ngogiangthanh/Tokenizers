/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vn.hus.nlp.tokenizer.VietTokenizer;


public class Tags {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Chỉ định dường dẫn đến file log và file tokenizer.properties
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, "Cài đặt thư viện look and feel thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }

        MainFrm main = new MainFrm();
        main.setVisible(true);
    }

    public static String unAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
    }

    public static ArrayList<String> getTokenize(String input) {
        File currentDirFile = new File(".");
        String currentPathProject = currentDirFile.getAbsolutePath();
        String VN_TOKEN_PROPERTIES = currentPathProject.substring(0, currentPathProject.length() - 1) + "src/tokenizer.properties";
        ArrayList<String> outputs = new ArrayList<>();
        try {
            VietTokenizer tokenizer = new VietTokenizer(VN_TOKEN_PROPERTIES);
            //Gọi phương thức xử lý ngôn ngữ tokenize trong vnTokenizer 
            input = input.trim().replaceAll("[\\'\"\\“\\”\\‘\\’.,]", "");
            String[] results = tokenizer.tokenize(input.trim());
            //Duyệt từng phần tử sau khi đã xử lý ngôn ngữ

            UnuseWord skip = new UnuseWord();
            for (String rs : results) {
                StringTokenizer string = new StringTokenizer(rs);
                while (string.hasMoreTokens()) {
                    String element = string.nextToken();
                    element = element.replaceAll("_", " ").toLowerCase();
                    String element_unAccent = unAccent(element);
                    if (!skip.isUnuseWord(element) & !skip.isStopWords(element)) { //kiểm tra từ stop word hay không
                        if (!outputs.contains(element)) {
                            outputs.add(element);
                        }

                        if (!outputs.contains(element_unAccent)) {
                            outputs.add(element_unAccent);
                        }
                    }

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return outputs;
    }

}

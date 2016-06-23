/*
 * 
 * souris morte
 */
package tags;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import vn.hus.nlp.tokenizer.VietTokenizer;

public class frmMain extends javax.swing.JFrame {

    //Đối tượng hàng đợi lưu danh sách tất cả các file tài liệu
    private Queue<String> listPathOfFiles = new LinkedList<>();
    //Đối tượng lưu danh sách các từ tách trong các file ra
    private ListTerm listTerm = new ListTerm();
    //Đối tượng lưu danh sách các từ trong file csdl.txt
    private ListTerm listTermFromDB = new ListTerm();
    //Đối tượng lưu file output.txt
    private ListLine listLine = new ListLine();

    public frmMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        lbFile = new javax.swing.JLabel();
        lbPath = new javax.swing.JLabel();
        btnOpen = new javax.swing.JButton();
        btnVnTokenizer = new javax.swing.JButton();
        lbFileCSDL = new javax.swing.JLabel();
        lbPathCSDL = new javax.swing.JLabel();
        btnLoadData = new javax.swing.JButton();
        btnCreateFile = new javax.swing.JButton();
        spAlert = new javax.swing.JScrollPane();
        taAlert = new javax.swing.JTextArea();
        btnCreateFile2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(640, 480));

        lbFile.setText("File:");

        lbPath.setText("D:\\");

            btnOpen.setText("Open");
            btnOpen.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnOpenActionPerformed(evt);
                }
            });

            btnVnTokenizer.setText("vnTokenizer");
            btnVnTokenizer.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnVnTokenizerActionPerformed(evt);
                }
            });

            lbFileCSDL.setText("File");

            lbPathCSDL.setText("D:\\CSDL.txt");

            btnLoadData.setText("Load data");
            btnLoadData.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLoadDataActionPerformed(evt);
                }
            });

            btnCreateFile.setText("Create file");
            btnCreateFile.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCreateFileActionPerformed(evt);
                }
            });

            taAlert.setEditable(false);
            taAlert.setColumns(20);
            taAlert.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
            taAlert.setRows(5);
            spAlert.setViewportView(taAlert);

            btnCreateFile2.setText("Create file 2");
            btnCreateFile2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCreateFile2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jpMainLayout = new javax.swing.GroupLayout(jpMain);
            jpMain.setLayout(jpMainLayout);
            jpMainLayout.setHorizontalGroup(
                jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMainLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpMainLayout.createSequentialGroup()
                            .addComponent(lbFile)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbPath))
                        .addGroup(jpMainLayout.createSequentialGroup()
                            .addComponent(lbFileCSDL)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbPathCSDL)))
                    .addGap(110, 110, 110)
                    .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpMainLayout.createSequentialGroup()
                            .addComponent(btnOpen)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnVnTokenizer))
                        .addGroup(jpMainLayout.createSequentialGroup()
                            .addComponent(btnLoadData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCreateFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateFile2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(spAlert)
            );
            jpMainLayout.setVerticalGroup(
                jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMainLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVnTokenizer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFile)
                            .addComponent(lbPath)
                            .addComponent(btnOpen)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFileCSDL)
                            .addComponent(lbPathCSDL))
                        .addGroup(jpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadData)
                            .addComponent(btnCreateFile)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnCreateFile2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        //Gọi đối tượng cửa sổ chọn folder
        JFileChooser fc = new JFileChooser(lbPath.getText());
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setDialogTitle("Chọn thư mục chứa tài liệu");
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setApproveButtonText("Chọn");

        //Xử lý kết quả sau khi nhấn nút chọn từ cửa sổ
        int result = fc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            lbPath.setText(fc.getSelectedFile().toString());
            this.walk(lbPath.getText());
            this.taAlert.setText(this.taAlert.getText() + "Tải thư mục file hoàn tất!\n");
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    //Hàm đệ quy duyệt toàn bộ file có trong đường dẫn path
    public void walk(String path) {

        File root = new File(path);
        File[] list = root.listFiles();
        if (list == null) {
            return;
        }

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath());
                if (f.isFile()) {
                    this.listPathOfFiles.add(f.getAbsoluteFile().toString());
                }
            } else {
                this.listPathOfFiles.add(f.getAbsoluteFile().toString());
            }
        }
    }

    //Lấy và đọc từng file có trong đối tượng hàng đợi listPathOfFiles
    public boolean readStepByStep() {
        //Nếu hàng đợi vẫn còn phần tử - thực hiện đọc ra
        if (!this.listPathOfFiles.isEmpty()) {
            String filePath = this.listPathOfFiles.poll();
            if (filePath != null) {
                File file = null;
                try {
                    file = new File(filePath);

                    //Khai báo thủ tục cho vntokenizer
                    File currentDirFile = new File(".");
                    String currentPathProject = currentDirFile.getAbsolutePath();
                    String VN_TOKEN_PROPERTIES = currentPathProject.substring(0, currentPathProject.length() - 1) + "src/tokenizer.properties";
                    //Kết thúc Khai báo thủ tục cho vntokenizer
                    try {
                        //Tạo đối tượng vntokenizer
                        VietTokenizer tokenizer = new VietTokenizer(VN_TOKEN_PROPERTIES);
                        //Đọc nội dung trong từng file
                        String line;
                        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                            while ((line = br.readLine()) != null) {
                                //Tương ứng mỗi dòng trong file là tham số đầu vào của phương tách từ trong tokenizer
                                String[] results = tokenizer.tokenize(line);
                                //Tạo đối tượng xem xét xem từ đã tách có giá trị hay không
                                UnuseWord skip = new UnuseWord();
                                for (String rs : results) {
                                    StringTokenizer string = new StringTokenizer(rs);

                                    if (string.hasMoreTokens()) {
                                        string.nextToken();
                                    }
                                    while (string.hasMoreTokens()) {
                                        String element = string.nextToken();
                                        //Thay thế kí tự phân cách giữa cụm từ: Vd: Cần_Thơ => Cần Thơ
                                        element = element.replaceAll("_", " ").toLowerCase();
                                        if (!skip.isUnuseWord(element) & !skip.isStopWords(element)) { //Nếu không phải là kí tự đặc biệt và từ stop word thì lưu vào danh sách
                                            long current_size = this.listTerm.getSize();
                                            this.listTerm.addElement(new Element(current_size++, element));
                                        }

                                    }
                                }
                            }
                            br.close();
                        }

                    } catch (Exception ex) {
                        System.out.println("readStepByStep line 269: " + ex.getMessage());
                    }
                    return true;
                } catch (Exception ex) {
                    System.out.println("readStepByStep line 274: " + ex.getMessage());
                }
            }
        }
        return false;
    }

    public boolean readStepByStep_2() {
        //Nếu hàng đợi vẫn còn phần tử - thực hiện đọc ra
        if (!this.listPathOfFiles.isEmpty()) {
            String filePath = this.listPathOfFiles.poll();
            if (filePath != null) {
                File file = null;
                try {
                    file = new File(filePath);

                    //Khai báo thủ tục cho vntokenizer
                    File currentDirFile = new File(".");
                    String currentPathProject = currentDirFile.getAbsolutePath();
                    String VN_TOKEN_PROPERTIES = currentPathProject.substring(0, currentPathProject.length() - 1) + "src/tokenizer.properties";
                    //Kết thúc Khai báo thủ tục cho vntokenizer
                    try {
                        String[] arrayPath = file.getParent().split("\\\\");
                        LineElement newLineElement = new LineElement(file.getAbsolutePath(), arrayPath[arrayPath.length - 1]);
                        System.out.println(file.getAbsolutePath());
                        System.out.println(arrayPath[arrayPath.length - 1]);

                        //Tạo đối tượng vntokenizer
                        VietTokenizer tokenizer = new VietTokenizer(VN_TOKEN_PROPERTIES);
                        //Đọc nội dung trong từng file
                        String line;
                        try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                            while ((line = br.readLine()) != null) {
                            System.out.println(line);
                                //Tương ứng mỗi dòng trong file là tham số đầu vào của phương tách từ trong tokenizer
                                String[] results = tokenizer.tokenize(line);
                                //Tạo đối tượng xem xét xem từ đã tách có giá trị hay không
                                UnuseWord skip = new UnuseWord();
                                for (String rs : results) {
                                    StringTokenizer string = new StringTokenizer(rs);

                            System.out.println("1-"+string);
                                    while (string.hasMoreTokens()) {
                                        String element = string.nextToken();
                            System.out.println("2 - " + element);
                                        //Thay thế kí tự phân cách giữa cụm từ: Vd: Cần_Thơ => Cần Thơ
                                        element = element.replaceAll("_", " ").toLowerCase();

                                        if (!skip.isUnuseWord(element) & !skip.isStopWords(element)) { //Nếu không phải là kí tự đặc biệt và từ stop word thì lưu vào danh sách
                                          
                            System.out.println("3");
                            newLineElement.add(element);
                                        }

                                    }
                                }
                            }
                            br.close();
                        }

                    } catch (Exception ex) {
                        System.out.println("readStepByStep_2 line 331: " + ex.getMessage());
                    }
                    return true;
                } catch (Exception ex) {
                    System.out.println("readStepByStep_2 line 334: " + ex.getMessage());
                }
            }
        }
        return false;
    }

    private void btnVnTokenizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVnTokenizerActionPerformed
        //Xử lý nhấn nút vntokenizer
        this.listTerm.clearList();
        while (true) {
            if (!this.readStepByStep()) {
                break;
            }
        }
        this.taAlert.setText(this.taAlert.getText() + "Đọc nội dung thư mục hoàn tất!\n");
        //Lưu vào file text
        List<Element> list = this.listTerm.getList();
        PrintWriter writer;
        try {
            writer = new PrintWriter("D:\\CSDL.txt", "UTF-8");

            for (Element element : list) {
                writer.println(element.getIndex() + "#" + element.getTerm());
            }
            writer.close();
            this.taAlert.setText(this.taAlert.getText() + "Ghi nội dung file CSDL hoàn tất!\n");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("btnVnTokenizerActionPerformed line 363: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnVnTokenizerActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        //Gọi đối tượng cửa sổ chọn file
        this.listTermFromDB.clearList();
        JFileChooser fc = new JFileChooser(lbPathCSDL.getText());
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Chọn File CSDL");
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        fc.setApproveButtonText("Chọn");

        //Xử lý kết quả sau khi nhấn nút chọn từ cửa sổ
        int result = fc.showSaveDialog(this);
        long lineCount = 0;
        if (result == JFileChooser.APPROVE_OPTION) {
            this.lbPathCSDL.setText(fc.getSelectedFile().toString());
            //Xử lý đọc file csdl.txt
            try {
                FileReader fr = new FileReader(this.lbPathCSDL.getText());
                BufferedReader br = new BufferedReader(fr);

                String line;
                while ((line = br.readLine()) != null) {
                    lineCount++;
                    this.listTermFromDB.addElement(new Element(Long.parseLong(line.split("#")[0]), line.split("#")[1]));
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("btnLoadDataActionPerformed line 392: " + ex.getMessage());
            }

            this.taAlert.setText(this.taAlert.getText() + "Tải file CSDL ("+lineCount+" dòng) hoàn tất!\n");
        }
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnCreateFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFileActionPerformed
        //Xử lý tạo file kết quả
        this.listLine.clearList();
        //Duong dan "space" ten chu de "space" chi muc tu "space" tan so xuat hien "space"...

        //duyệt lại để lấy lại danh sách các file
        this.walk(lbPath.getText());
        this.taAlert.setText(this.taAlert.getText() + "Tải thư mục file hoàn tất!\n");
        //Đọc từng file
        while (true) {
            if (!this.readStepByStep_2()) {
                break;
            }
        }
        //
        this.listLine.setSizeOfBoW(this.listTermFromDB.getSize());
        //
        List<LineElement> list = this.listLine.getList();
        for (LineElement element : list) {
            HashMap<String, String> data = element.getData();
            data = LineElement.sortByValues(data);
            element.setData(data);
            for (Map.Entry pair : data.entrySet()) {
                try {
                    long index = this.listTermFromDB.find((String) pair.getValue().toString().split("#")[0]);
                    data.put(pair.getKey().toString(), index + "#" + (String) pair.getValue().toString().split("#")[1]);
                } catch (Exception ex) {
                    System.out.println("btnCreateFileActionPerformed line 427: " + ex.getMessage());
                }
            }
        }
        //
        Long sizeOfBow = this.listLine.getSizeOfBoW();

        PrintWriter writer;
        try {
            writer = new PrintWriter("D:\\OUTPUT.txt", "UTF-8");

            for (LineElement element : list) {
                String str = "";
                HashMap<String, String> data = element.getData();
                for (long i = 0; i < sizeOfBow; i++) {
                    String rs = LineElement.getKeysByValue(data, i + "");
                    if (!"".equals(rs)) {
                        str += rs.split("#")[0] + " " + rs.split("#")[1] + " ";
                    } else {
                        str += i + " " + 0 + " ";
                    }
                }
                System.out.println(str);
                writer.println(element.getPathOfFile() + " " + element.getTopicName() + " " + str);
            }

            writer.close();
            this.taAlert.setText(this.taAlert.getText() + "Ghi nội dung file OUTPUT.TXT hoàn tất!\n");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("btnCreateFileActionPerformed line 455: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnCreateFileActionPerformed

    private void btnCreateFile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFile2ActionPerformed
        Long sizeOfBow = this.listLine.getSizeOfBoW();
        List<LineElement> list = this.listLine.getList();

        PrintWriter writer;
        String str = "";
        try {
            writer = new PrintWriter("D:\\OUTPUT2.txt", "UTF-8");
            str = "chu_de ";
            for (long i = 0; i < sizeOfBow; i++) {
                str += i + " ";
            }

            writer.println(str);

            for (LineElement element : list) {
                HashMap<String, String> data = element.getData();
                str = "";
                for (long i = 0; i < sizeOfBow; i++) {
                    String rs = LineElement.getKeysByValue(data, i + "");
                    if (!"".equals(rs)) {
                        str += rs.split("#")[1] + " ";
                    } else {
                        str += 0 + " ";
                    }
                }
                writer.println(element.getTopicName() + " " + str);
            }

            writer.close();
            this.taAlert.setText(this.taAlert.getText() + "\nGhi nội dung file OUTPUT2.TXT hoàn tất!\n");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("btnCreateFile2ActionPerformed line 492: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnCreateFile2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateFile;
    private javax.swing.JButton btnCreateFile2;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnVnTokenizer;
    private javax.swing.JPanel jpMain;
    private javax.swing.JLabel lbFile;
    private javax.swing.JLabel lbFileCSDL;
    private javax.swing.JLabel lbPath;
    private javax.swing.JLabel lbPathCSDL;
    private javax.swing.JScrollPane spAlert;
    private javax.swing.JTextArea taAlert;
    // End of variables declaration//GEN-END:variables
}

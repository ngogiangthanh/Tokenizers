package bow_news;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import jvntextpro.JVnTextPro;

/**
 *
 * @author Ti-Hon Nguyen, Thanh-Nghi Do (CTU)
 */
public class BoW_News implements Bow {

    String dict_name = "dict.txt";					// output/dict.txt
    String vndict_name = "vndict.txt";				// output/vndict.txt
    String model_path = "model";					// model for vn
    String corpora_path = "D:/csdl-be";			// corpora
    String output_path = "output";					// path for dict.txt, libsvm_f.txt
    String stopword_name = "model/stopwords.txt";	// model/stopword.txt

    boolean jvntexpro = false;
    boolean without_stopword = false;

    // parsing command line
    public void cmdLine(String[] args) {

        boolean vflag = false;
        int i = 0;
        while (i < args.length && args[i].startsWith("-")) {
            String arg = args[i++];

            // use this type of check for "wordy" arguments
            if (arg.equals("-verbose")) {
                System.out.println("verbose mode on");
                vflag = true;
            } // use this type of check for arguments that require arguments
            else if (arg.equals("-output")) {
                if (i < args.length) {
                    output_path = args[i++];
                } else {
                    System.err.println("-output requires a dir_name");
                }
                if (vflag) {
                    System.out.println("output path = " + output_path);
                }
            } // use this type of check for arguments that require arguments
            else if (arg.equals("-corpora")) {
                if (i < args.length) {
                    corpora_path = args[i++];
                } else {
                    System.err.println("-corpora requires a dir_name");
                }
                if (vflag) {
                    System.out.println("corpora path = " + corpora_path);
                }
            } // use this type of check for arguments that require arguments
            else if (arg.equals("-model")) {
                if (i < args.length) {
                    model_path = args[i++];
                } else {
                    System.err.println("-model requires a dir_name");
                }
                if (vflag) {
                    System.out.println("model path = " + model_path);
                }
            } // use this type of check for arguments that require arguments
            else if (arg.equals("-stopword")) {
                if (i < args.length) {
                    stopword_name = args[i++];
                } else {
                    System.err.println("-stopword requires a file_name");
                }
                if (vflag) {
                    System.out.println("stopword file = " + stopword_name);
                    without_stopword = true;
                }
            } // use this type of check for a series of flag arguments
            else {
                for (int j = 1; j < arg.length(); j++) {
                    char flag = arg.charAt(j);
                    switch (flag) {
                        case 'v':
                            if (vflag) {
                                System.out.println("Option vietnam tokenizer");
                            }
                            jvntexpro = true;
                            break;
                        default:
                            System.err.println("ParseCmdLine: illegal option " + flag);
                            break;
                    }
                }
            }
        } // while (i < args.length && args[i].startsWith("-"))

        if (i == 0) {
            System.err.println("Usage: ParseCmdLine [-verbose] [-v] [-input dir_name] [-stopword file_name] [-model dir_name] [-output dir_name]");
        } else {
            System.out.println("Success!");
        }
    }

    public boolean jvnTextPro() {
        return jvntexpro;
    }

    public boolean withoutStopWord() {
        return without_stopword;
    }

    // utilities
    public void write_dict(ArrayList<String> words) {
        Path file = Paths.get(output_path + "/" + dict_name);
        try {
            Files.write(file, words, Charset.forName("UTF-8"));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void write_vndict(ArrayList<String> words) {
        Path file = Paths.get(output_path + "/" + vndict_name);
        try {
            Files.write(file, words, Charset.forName("UTF-8"));
        } catch (IOException e) {
        }
    }

    public void write_dict_without_stopwords(ArrayList<String> words) {
        Path file = Paths.get(output_path + "/" + dict_name);
        try {
            Files.write(file, words, Charset.forName("UTF-8"));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void write_vndict_without_stopwords(ArrayList<String> words) {
        Path file = Paths.get(output_path + "/" + vndict_name);
        try {
            Files.write(file, words, Charset.forName("UTF-8"));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void write_libsvm_f(String text_fw, String f_name) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(f_name, true))) {
            out.write(text_fw);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public String splitPunc(String text) {
        char[] punc_list
                = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '+', '_', '\t', '\r', '\f',
                    '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '\"', ',', '<', '.', '>', '/', '?', '\\', '\n'};
        char[] input = text.toCharArray();
        if (input.length > 0) {
            for (int i = 0; i < punc_list.length; i++) {
                for (int j = 0; j < input.length; j++) {
                    if (punc_list[i] == input[j]) {
                        input[j] = ' ';
                    }
                }
            }
        }
        return String.valueOf(input);
    }

    public String vnsplitPunc(String text) {
        char[] punc_list
                = {'`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '=', '+', '\t', '\r', '\f',
                    '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '\"', ',', '<', '.', '>', '/', '?', '\\', '\n'};

        char[] input = text.toCharArray();
        if (input.length > 0) {
            for (int i = 0; i < punc_list.length; i++) {
                for (int j = 0; j < input.length; j++) {
                    if (punc_list[i] == input[j]) {
                        input[j] = ' ';
                    }
                }
            }
        }
        return String.valueOf(input);
    }

    public boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isContent(String str, char s_char) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == s_char) {
                return true;
            }
        }
        return false;
    }

    public boolean isContentOnly(String str, char s_char) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != s_char) {
                return false;
            }
        }
        return true;
    }

    // splitter uni-gram 
    @Override
    public void splitter() {

        Charset charset = Charset.forName("UTF-8");
        ArrayList<String> words = new ArrayList<>();
        File dt_dir = new File(corpora_path);
        File[] sub_dir = dt_dir.listFiles();
        for (File sub_dir1 : sub_dir) {
            File[] files = sub_dir1.listFiles();
            for (File file1 : files) {
                Path file = Paths.get(file1.getPath());
                try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                    String line;
                    line = null;
                    while ((line = reader.readLine()) != null) {
                        String[] s = line.split(" ");
                        for (String item : s) {
                            String s_val = item.toLowerCase();
                            s_val = splitPunc(s_val);
                            String[] s_s_val = s_val.split(" ");
                            for (String val : s_s_val) {
                                val = val.trim();
                                if (isNumber(val) || !isChar(val) || isContent(val, '\t') || isContent(val, '\n') || isContent(val, '\r') || isContent(val, '\f')) {
                                } else {
                                    int idx_val = words.indexOf(val);
                                    if (idx_val != -1) {
                                    } else {
                                        words.add(val);
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                }
            }
        }
        //words.sort(null);
        Collections.sort(words);
        words.remove(0);
        write_dict(words);
        System.out.println("Finish!");

    } // public void splitter(String dt_path); 

    @Override
    public void remover_stop() {

        String wd_path = output_path + "/";
        if (jvnTextPro() == true) {
            wd_path = wd_path + vndict_name;
        } else {
            wd_path = wd_path + dict_name;
        }

        Charset charset = Charset.forName("UTF-8");
        ArrayList<String> st_words = new ArrayList<>();

        Path st_file = Paths.get(stopword_name);
        try (BufferedReader reader = Files.newBufferedReader(st_file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                st_words.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        Path wd_file = Paths.get(wd_path);
        ArrayList<String> words_dict = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(wd_file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                words_dict.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        ArrayList<String> dict_no_st = new ArrayList<>();
        for (int i = 0; i < words_dict.size(); i++) {
            String t = words_dict.get(i);
            if (!st_words.contains(t)) {
                dict_no_st.add(t);
            }
        }

        if (jvnTextPro() == true) {
            write_vndict_without_stopwords(dict_no_st);
        } else {
            write_dict_without_stopwords(dict_no_st);
        }

        System.out.println("Finish!");

    } // public void remover_stop(String st_path, String wd_path);	

    @Override
    public void to_libsvm() {
        int count = 0;
        String wd_path = output_path + "/" + dict_name;
        Charset charset = Charset.forName("UTF-8");

        Path wd_file = Paths.get(wd_path);
        ArrayList<String> words_dict = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(wd_file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                words_dict.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        File dt_dir = new File(corpora_path);
        File[] sub_dir = dt_dir.listFiles();

        String libsvm_kq = "";

        int wd_size = words_dict.size();
        ArrayList<Integer> tmp_w;
        tmp_w = new ArrayList<>();
        tmp_w.clear();
        for (int i = 0; i < wd_size; i++) {
            tmp_w.add(0);
        }

        for (File sub_dir1 : sub_dir) {
            File[] files = sub_dir1.listFiles();
            for (File file1 : files) {

                for (int i = 0; i < wd_size; i++) {
                    tmp_w.set(i, 0);
                }

                Path file = Paths.get(file1.getPath());

                try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] s = line.split(" ");
                        for (String item : s) {
                            String s_val = item.toLowerCase();
                            s_val = splitPunc(s_val);
                            String[] s_s_val = s_val.split(" ");
                            for (String val : s_s_val) {
                                val = val.trim();
                                if (isNumber(val) || !isChar(val) || isContent(val, '\t') || isContent(val, '\n') || isContent(val, '\r') || isContent(val, '\f')) {
                                } else {
                                    int idx_val = words_dict.indexOf(val);
                                    if (idx_val != -1) {
                                        int curent = tmp_w.get(idx_val);
                                        tmp_w.set(idx_val, curent + 1);
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException x) {
                    System.err.format("IOException: %s%n", x);
                }

                libsvm_kq = libsvm_kq + sub_dir1.getName();

                for (int t = 0; t < tmp_w.size(); t++) {
                    if (tmp_w.get(t) > 0) {
                        libsvm_kq = libsvm_kq + " " + String.valueOf(t + 1) + ":" + String.valueOf(tmp_w.get(t));
                    }
                }

                libsvm_kq = libsvm_kq + "\n";
                count += 1;
                if (count > 300) {
                    write_libsvm_f(libsvm_kq, output_path + "/libsvm_f.txt");
                    count = 0;
                    libsvm_kq = "";
                }
            }
        }

        if (count > 0) {
            write_libsvm_f(libsvm_kq, output_path + "/libsvm_f.txt");
        }
        System.out.println("Finish!");

    } // public void to_libsvm(String dt_path);

    // splitter for vietnamese text 
    @Override
    public void vnsplitter() {
        JVnTextPro textPro = new JVnTextPro();
        textPro.initSenSegmenter(model_path + "/jvnsensegmenter");
        textPro.initSenTokenization();
        textPro.initSegmenter(model_path + "/jvnsegmenter");

        ArrayList<String> words = new ArrayList<>();

        File dt_dir = new File(corpora_path);
        File[] sub_dir = dt_dir.listFiles();
        for (File sub_dir1 : sub_dir) {
            File[] files = sub_dir1.listFiles();
            for (File file1 : files) {
                String[] s;
                s = textPro.process(file1).split(" ");
                for (String item : s) {
                    String s_val = item.toLowerCase();
                    s_val = vnsplitPunc(s_val);
                    String[] s_s_val = s_val.split(" ");

                    for (String val : s_s_val) {
                        val = val.trim();
                        if (isNumber(val) || isContent(val, '\t') || isContent(val, '\n') || isContent(val, '\r') || isContent(val, '\f') || isContentOnly(val, '_')) {
                        } else if (!isChar(val) && !isContent(val, '_')) {
                        } else {
                            int idx_val = words.indexOf(val);
                            if (idx_val != -1) {
                            } else {
                                words.add(val);
                            }
                        }
                    }
                }
            }
        }
        //words.sort(null);
        Collections.sort(words);
        words.remove(0);
        write_vndict(words);
        System.out.println("Finish!");

    } // public void vnsplitter(String dt_path);

    @Override
    public void vnto_libsvm() {
        JVnTextPro textPro = new JVnTextPro();
        textPro.initSenSegmenter(model_path + "/jvnsensegmenter");
        textPro.initSenTokenization();
        textPro.initSegmenter(model_path + "/jvnsegmenter");

        String wd_path = output_path + "/vndict.txt";
        int count = 0;

        Charset charset = Charset.forName("UTF-8");

        Path wd_file = Paths.get(wd_path);
        ArrayList<String> words_dict = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(wd_file, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                words_dict.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        File dt_dir = new File(corpora_path);
        File[] sub_dir = dt_dir.listFiles();

        String libsvm_kq = "";

        int wd_size = words_dict.size();
        ArrayList<Integer> tmp_w;
        tmp_w = new ArrayList<>();

        for (int i = 0; i < wd_size; i++) {
            tmp_w.add(0);
        }

        String str_tmp;

        for (File sub_dir1 : sub_dir) {
            File[] files = sub_dir1.listFiles();
            for (File file1 : files) {

                for (int i = 0; i < wd_size; i++) {
                    tmp_w.set(i, 0);
                }

                String[] s;
                s = textPro.process(file1).split(" ");
                for (String item : s) {
                    String s_val = item.toLowerCase();
                    s_val = vnsplitPunc(s_val);
                    String[] s_s_val = s_val.split(" ");
                    for (String val : s_s_val) {
                        val = val.trim();
                        if (isNumber(val) || isContent(val, '\t') || isContent(val, '\n') || isContent(val, '\r') || isContent(val, '\f') || isContentOnly(val, '_')) {
                        } else {
                            int idx_val = words_dict.indexOf(val);
                            if (idx_val != -1) {
                                int curent = tmp_w.get(idx_val);
                                tmp_w.set(idx_val, curent + 1);
                            }
                        }
                    }
                }

                str_tmp = sub_dir1.getName();

                for (int t = 0; t < tmp_w.size(); t++) {
                    if (tmp_w.get(t) > 0) {
                        str_tmp = str_tmp + " " + String.valueOf(t + 1) + ":" + String.valueOf(tmp_w.get(t));
                    }
                }

                libsvm_kq = libsvm_kq + str_tmp + "\n";
                count += 1;
                str_tmp = null;
                if (count > 300) {
                    write_libsvm_f(libsvm_kq, output_path + "/vnlibsvm_f.txt");
                    count = 0;
                    libsvm_kq = "";
                }
            }
        }

        if (count > 0) {
            write_libsvm_f(libsvm_kq, output_path + "/vnlibsvm_f.txt");
        }
        System.out.println("Finish!");

    } // public void vnto_libsvm(String dt_path);

    @Override
    public void toBoW() {
        if (jvnTextPro() == true) {
            vnsplitter();
            if (withoutStopWord() == true) {
                remover_stop();
            }
            vnto_libsvm();
        } else {
            splitter();
            if (withoutStopWord() == true) {
                remover_stop();
            }
            to_libsvm();
        }
    }

    public static void main(String[] args) {
        BoW_News mb = new BoW_News();
        mb.cmdLine(args);
        mb.toBoW();
    }

}

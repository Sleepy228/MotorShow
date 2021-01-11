package sample.Windows;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WorkWithFile {
    private WorkWithFile() {}

    public static void WriteInFile(String path, String text) {
        File file = new File(path);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

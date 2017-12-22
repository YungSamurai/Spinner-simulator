package spinner.Files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YungSamurai on 07.08.2017.
 */
public class FileWorker {
    private static List<String> lines = new ArrayList<String>();
    private static int[] lines1;

    public static void write(String fileName, String text)
    {
        File file = new File(fileName);

        try{
            if(!file.exists()) file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readString(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        exists(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try{
                String s;
                while ((s = in.readLine()) != null)
                {
                    lines.add(s);
                }
            }finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static int[] readInteger(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        exists(fileName);

        try(BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile())))
        {
                lines1 = in.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines1;
    }
    private static void exists(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        if(!file.exists()) throw new FileNotFoundException(file.getName());
    }
}

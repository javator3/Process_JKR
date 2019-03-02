package pl.sda.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Process process;

        String homeDir = System.getProperty("user.home");
        System.out.println(homeDir);

        try {
//            process = Runtime.getRuntime().exec("cmd /c dir " + homeDir);
            process = Runtime.getRuntime().exec("cmd /c notepad " + homeDir + "\\nowy.txt");

//            process.getErrorStream(); // do sprawdzania błędów,trzeba przez readera

            System.out.println(process.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            System.out.println(reader);

            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

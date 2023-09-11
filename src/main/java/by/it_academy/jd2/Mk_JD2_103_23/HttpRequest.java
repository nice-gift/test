package by.it_academy.jd2.Mk_JD2_103_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpRequest {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            String firstName;
            String lastName;

            do {
                System.out.print("Enter your first name: ");
                firstName = scanner.nextLine();
            }
            while (firstName.isBlank());

            do {
                System.out.print("Enter your last name: ");
                lastName = scanner.nextLine();
            }
            while (lastName.isBlank());

            // Создаем URL-адрес для запроса
            URL url = new URL("http://127.0.0.1:8080/Mk-JD2-103-23/" +
                    "hello_with_name?firstName=" + firstName +
                    "&lastName=" + lastName);

            // Создаем объект HttpURLConnection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() == 200) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()))) {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println(response);
                    }
                }
            } else {
                System.err.println("Error " + con.getResponseCode());
            }
        }
    }
}

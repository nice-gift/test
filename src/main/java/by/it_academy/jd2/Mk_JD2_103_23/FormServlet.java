package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

@WebServlet(urlPatterns = "/form_servlet")
public class FormServlet extends HttpServlet {
    private String GENRE_PARAMETER = "genre";

    Musician future = new Musician("Future");
    Musician theWeeknd = new Musician("The Weeknd");
    Musician vityaAk = new Musician("Витя АК");
    Musician panzushot = new Musician("Панцушот");
    Musician[] musicians = new Musician[]{future, theWeeknd, vityaAk, panzushot};

    Genre folk = new Genre("Фолк-музыка");
    Genre country = new Genre("Кантри");
    Genre latin = new Genre("Латиноамериканская музыка");
    Genre blues = new Genre("Блюз");
    Genre rhythmAndBlues = new Genre("Ритм-н-блюз");
    Genre jazz = new Genre("Джаз");
    Genre chanson = new Genre("Шансон");
    Genre electronic = new Genre("Электронная музыка");
    Genre rock = new Genre("Рок");
    Genre hipHop = new Genre("Хип-хоп");
    List<Genre> genres = List.of(folk, country, latin, blues, rhythmAndBlues,
            jazz, chanson, electronic, rock, hipHop);

    StringBuffer buffer = new StringBuffer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        PrintWriter writer = resp.getWriter();
        String[] selectGenres = req.getParameterMap().get(GENRE_PARAMETER);
        if (selectGenres.length < 3) {
            writer.write("Ошибка! Отметьте минимум 3 варианта");
            return;
        } else {
            for (String g : selectGenres
            ) {
                switch (g) {
                    case "folk":
                        folk.setPoint(folk.getPoint() + 1);
                        break;
                    case "country":
                        country.setPoint(country.getPoint() + 1);
                        break;
                    case "latin":
                        latin.setPoint(latin.getPoint() + 1);
                        break;
                    case "blues":
                        blues.setPoint(blues.getPoint() + 1);
                        break;
                    case "rhythmAndBlues":
                        rhythmAndBlues.setPoint(rhythmAndBlues.getPoint() + 1);
                        break;
                    case "jazz":
                        jazz.setPoint(jazz.getPoint() + 1);
                        break;
                    case "chanson":
                        chanson.setPoint(chanson.getPoint() + 1);
                        break;
                    case "electronic":
                        electronic.setPoint(electronic.getPoint() + 1);
                        break;
                    case "rock":
                        rock.setPoint(rock.getPoint() + 1);
                        break;
                    case "hipHop":
                        hipHop.setPoint(hipHop.getPoint() + 1);
                        break;
                }
            }
        }

        String musician = req.getParameter("musician");

        switch (musician) {
            case "future":
                future.setPoint(future.getPoint() + 1);
                break;
            case "theWeeknd":
                theWeeknd.setPoint(theWeeknd.getPoint() + 1);
                break;
            case "vityaAk":
                vityaAk.setPoint(vityaAk.getPoint() + 1);
                break;
            case "panzu":
                panzushot.setPoint(panzushot.getPoint() + 1);
                break;
        }

        Arrays.sort(musicians);
        writer.write("Лучшие исполнители (в скобках указано количество баллов):\n");
        for (Musician m : musicians
        ) {
            writer.write(m.toString() + "\n");
        }

        writer.write("\n\nЛюбимые жанры\n");
        genres.stream()
                .sorted()
                .forEach(e -> writer.write(e + "\n"));

        buffer.append("\n\n" + req.getParameter("text") + "\n" + new Date() + "\n");
        writer.write(buffer.toString());
    }
}
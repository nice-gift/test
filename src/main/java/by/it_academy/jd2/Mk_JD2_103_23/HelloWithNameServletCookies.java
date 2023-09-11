package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/hello_with_name_cookies")
public class HelloWithNameServletCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        PrintWriter writer = resp.getWriter();
        Cookie myCookie;
        Cookie myCookie2;

        if (firstName != null && lastName != null) {
            Cookie[] myCookies = req.getCookies();
            if (myCookies.length == 0) {
                writer.write("Ошибка!");
                return;
            }
            myCookie = new Cookie("first", "myCookies[0]");
            myCookie2 = new Cookie("last", "myCookies[1]");


        } else {
            myCookie = new Cookie("first", "firstName");
            myCookie2 = new Cookie("last", "lastName");
            myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(myCookie);
            resp.addCookie(myCookie2);
        }


        writer.write("Hello " + myCookie + " " + myCookie2 + "!");
    }
}

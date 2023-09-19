package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/hello_with_name_cookies")
public class HelloWithNameServletCookies extends HttpServlet {
    public static final String FIRST_NAME_PARAM_NAME = "firstName";
    public static final String LAST_NAME_PARAM_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");

        String firstNameValue = getValueFromAnywhere(req, FIRST_NAME_PARAM_NAME);
        saveCookies(resp, FIRST_NAME_PARAM_NAME, firstNameValue);

        String lastNameValue = getValueFromAnywhere(req, LAST_NAME_PARAM_NAME);
        saveCookies(resp, LAST_NAME_PARAM_NAME, lastNameValue);

        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + firstNameValue + " " + lastNameValue + "!");
    }

    private String getValueFromAnywhere(HttpServletRequest request, String param) {
        String val = request.getParameter(param);

        if (val == null) {
            Cookie[] cookies = request.getCookies();
            val=Arrays.stream(cookies)
                    .filter(e -> e.getName().equalsIgnoreCase(param))
                    .map(Cookie::getValue)
                    .findFirst()
                    .orElse(null);
        }

        if (val == null) {
            throw new IllegalArgumentException("Не передан один из обязательных параметров");
        }
        return val;
    }

    private void saveCookies(HttpServletResponse response, String name, String value) {
        Cookie myCookie = new Cookie(name, URLEncoder.encode(value, StandardCharsets.UTF_8));
        myCookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        response.addCookie(myCookie);
    }
}

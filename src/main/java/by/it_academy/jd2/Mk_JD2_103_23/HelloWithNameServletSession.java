package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/session")
public class HelloWithNameServletSession extends HttpServlet {
    public static String FIRST_NAME_PARAM_NAME = "firstName";
    public static String LAST_NAME_PARAM_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession httpSession = req.getSession();

        String firstNameValue = getValueFromAnywhere(httpSession, req, FIRST_NAME_PARAM_NAME);
        saveSession(httpSession, FIRST_NAME_PARAM_NAME, firstNameValue);

        String lastNameValue = getValueFromAnywhere(httpSession, req, LAST_NAME_PARAM_NAME);
        saveSession(httpSession, LAST_NAME_PARAM_NAME, lastNameValue);

        PrintWriter writer = resp.getWriter();
        writer.write("Hello " + firstNameValue + " " + lastNameValue);
    }

    private String getValueFromAnywhere(HttpSession httpSession, HttpServletRequest req, String key) {
        String value = req.getParameter(key);

        if (value == null) {
            value = (String) httpSession.getAttribute(key);

            if (value == null) {
                throw new IllegalArgumentException("Не передано минмиальное количество параметров");
            }
        }
        return value;
    }

    private void saveSession(HttpSession httpSession, String key, String value) {
        httpSession.setAttribute(key, value);
    }
}

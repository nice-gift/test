package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(urlPatterns = "/print_only_name")
public class ServletPrintOnlyName extends HttpServlet {
    private String NAME_PARAMETER = "name";
//    private String NAME_PARAMETER_HEADER="ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
//        resp.setHeader("Content-Type","text/plain; charset=utf-8");

        PrintWriter writer = resp.getWriter();

        Map<String, String[]> params = req.getParameterMap();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String[]> m : params.entrySet()
        ) {
            if (m.getKey().contains("name")) {
                String[] names = m.getValue();
                for (String name : names
                ) {
                    if (Character.isUpperCase(name.charAt(0))) {
                        builder.append(name).append(" ");
                    }
                }
            }
        }

        writer.write(builder.toString());

//        with using getHeader()
//        String header= req.getHeader(NAME_PARAMETER_HEADER);
//        String[]names=req.getParameterMap().get(header);

//        String[] names = req.getParameterMap().get(NAME_PARAMETER);
//        if (names!= null) {
//            for (String n:names
//            ) {
//                writer.write("<p>"+ NAME_PARAMETER + ": " + n + "</p>");
//            }
//        }
    }
}

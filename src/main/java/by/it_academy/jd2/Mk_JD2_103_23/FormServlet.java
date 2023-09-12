package by.it_academy.jd2.Mk_JD2_103_23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

@WebServlet(urlPatterns = "/form_servlet")
public class FormServlet extends HttpServlet {
    private String NAME_PARAMETER = "name";
    //    private String NAME_PARAMETER_HEADER="ARRAY_NAME_PARAM";
    Musician future = new Musician("future");
    Musician theWeeknd = new Musician("theWeeknd");
    Musician vityaAk = new Musician("vityaAk");
    Musician panzushot = new Musician("panzushot");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/plain; charset=utf-8");
//        resp.setHeader("Content-Type","text/plain; charset=utf-8");

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

        TreeSet<Musician> musicians = new TreeSet<>();
        musicians.add(future);
        musicians.add(theWeeknd);
        musicians.add(vityaAk);
        musicians.add(panzushot);

        PrintWriter writer = resp.getWriter();
        for (Musician m : musicians
        ) {
            writer.write(m.toString() + "\n");
        }

//        Map<String, String[]> params = req.getParameterMap();
//        StringBuilder builder = new StringBuilder();
//        for (Map.Entry<String, String[]> m : params.entrySet()
//        ) {
//            if (m.getKey().contains("name")) {
//                String[] names = m.getValue();
//                for (String name : names
//                ) {
//                    if (Character.isUpperCase(name.charAt(0))) {
//                        builder.append(name).append(" ");
//                    }
//                }
//            }
//        }
//
//        writer.write(builder.toString());

//        Date now = new Date();
//
//        String musician = req.getParameter("musician");
//        writer.write(musician);
//        writer.write(now.toString());

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

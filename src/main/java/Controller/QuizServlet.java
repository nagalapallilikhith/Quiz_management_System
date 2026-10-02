package Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("QuizServlet started");

        QuestionDAO dao = new QuestionDAO();

        List<Map<String, String>> questions =
                dao.getALLQuestion();

        System.out.println(
                "Questions received by servlet = "
                + questions.size()
        );

        request.setAttribute("questions", questions);

        RequestDispatcher rd =
                request.getRequestDispatcher("/quiz.jsp");

        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
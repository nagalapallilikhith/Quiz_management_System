package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ResultServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Get total number of questions
        int total = Integer.parseInt(
                request.getParameter("total")
        );

        int score = 0;

        // Check each answer
        for (int i = 1; i <= total; i++) {

            String userAnswer =
                    request.getParameter("ans" + i);

            String correctAnswer =
                    request.getParameter("correct" + i);

            // Compare user's answer with correct answer
            if (userAnswer != null &&
                userAnswer.equals(correctAnswer)) {

                score++;
            }
        }

        // Send score and total to result.jsp
        request.setAttribute("score", score);
        request.setAttribute("total", total);

        // Forward to result.jsp
        RequestDispatcher rd =
                request.getRequestDispatcher("result.jsp");

        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // If someone directly opens ResultServlet,
        // send them back to the first page.
        response.sendRedirect("index.jsp");
    }
}
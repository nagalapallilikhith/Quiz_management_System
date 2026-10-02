package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDAO {

    public List<Map<String, String>> getALLQuestion() {

        List<Map<String, String>> questions =
                new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("Connection object = " + con);

            if (con == null) {
                System.out.println("DATABASE CONNECTION FAILED");
                return questions;
            }

            String sql = "SELECT * FROM QuestionBank";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Map<String, String> q =
                        new HashMap<>();

                q.put("id",
                        rs.getString("id"));

                q.put("question",
                        rs.getString("question"));

                q.put("option1",
                        rs.getString("option1"));

                q.put("option2",
                        rs.getString("option2"));

                q.put("option3",
                        rs.getString("option3"));

                q.put("option4",
                        rs.getString("option4"));

                q.put("correctoption",
                        rs.getString("correctoption"));

                questions.add(q);
            }

            System.out.println(
                    "TOTAL QUESTIONS = "
                    + questions.size()
            );

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("ERROR IN QUESTION DAO");
            e.printStackTrace();
        }

        return questions;
    }
}
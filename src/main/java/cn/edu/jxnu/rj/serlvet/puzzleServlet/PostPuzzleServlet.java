package cn.edu.jxnu.rj.serlvet.puzzleServlet;

import cn.edu.jxnu.rj.domain.Puzzle;
import cn.edu.jxnu.rj.service.Impl.PuzzleServiceImpl;
import cn.edu.jxnu.rj.service.PuzzleService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PostPuzzleServlet",urlPatterns = "/postPuzzle")
public class PostPuzzleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String puzzleTitle = request.getParameter("puzzleTitle");
        String puzzleContent = request.getParameter("puzzleContent");

        PuzzleService puzzleService = new PuzzleServiceImpl();
        Puzzle puzzle = puzzleService.insert(new Puzzle(2, puzzleTitle, puzzleContent));

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(puzzle);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

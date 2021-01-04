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
import java.util.List;

@WebServlet(name = "QueryAllPuzzleServlet",urlPatterns = "/queryAllPuzzle")
public class QueryAllPuzzleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        PuzzleService puzzleService = new PuzzleServiceImpl();
        List<Puzzle> puzzleList = puzzleService.getAllByUser(userId);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String json = gson.toJson(puzzleList);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package cn.edu.jxnu.rj.serlvet.puzzleServlet;

import cn.edu.jxnu.rj.service.Impl.PuzzleServiceImpl;
import cn.edu.jxnu.rj.service.PuzzleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletePuzzleServlet",urlPatterns = "/deletePuzzle")
public class DeletePuzzleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int puzzleId = Integer.parseInt(request.getParameter("puzzleId"));

        PuzzleService puzzleService = new PuzzleServiceImpl();
        puzzleService.delete(puzzleId);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

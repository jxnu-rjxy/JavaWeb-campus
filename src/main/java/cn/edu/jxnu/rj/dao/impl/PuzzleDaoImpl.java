package cn.edu.jxnu.rj.dao.impl;

import cn.edu.jxnu.rj.dao.PuzzleDao;
import cn.edu.jxnu.rj.domain.Puzzle;
import cn.edu.jxnu.rj.util.Jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PuzzleDaoImpl  implements PuzzleDao {
    @Override
    public Puzzle insert(Puzzle puzzle) {
        String sql = "insert into db_campus_puzzle(user_id,puzzle_title,puzzle_content) values(?,?,?)";
        Jdbc jdbc = new Jdbc();
        int i = jdbc.executeUpdate(sql, puzzle.getUserId(), puzzle.getPuzzleTitle(), puzzle.getPuzzleContent());
        Puzzle puzzle1 = findById(i);
        return puzzle1;
    }

    @Override
    public List<Puzzle> getAllByUser(int userId) {
        String sql = "select * from  db_campus_puzzle where user_id = ? order by gmt_create desc";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, userId);
        List<Puzzle> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int puzzleId1 = resultSet.getInt("puzzle_id");
                int userId1 = resultSet.getInt("user_id");
                String puzzleTitle = resultSet.getString("puzzle_title");
                String puzzleContent = resultSet.getString("puzzle_content");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                int puzzleLikes = resultSet.getInt("puzzle_likes");
                Puzzle puzzle = new Puzzle(puzzleId1,userId1,puzzleTitle,puzzleContent,gmtCreate,gmtModified,puzzleLikes);
                list.add(puzzle);
            }
            return  list;
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public Puzzle findById(int puzzleId) {
        String sql = "select * from  db_campus_puzzle where puzzle_id = ?";
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.executeQuery(sql, puzzleId);
        try {
            while (resultSet.next()){
                int puzzleId1 = resultSet.getInt("puzzle_id");
                int userId = resultSet.getInt("user_id");
                String puzzleTitle = resultSet.getString("puzzle_title");
                String puzzleContent = resultSet.getString("puzzle_content");
                Timestamp gmtCreate = resultSet.getTimestamp("gmt_create");
                Timestamp gmtModified = resultSet.getTimestamp("gmt_modified");
                int puzzleLikes = resultSet.getInt("puzzle_likes");
                Puzzle puzzle = new Puzzle(puzzleId1,userId,puzzleTitle,puzzleContent,gmtCreate,gmtModified,puzzleLikes);
                return  puzzle;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            jdbc.close();
        }
        return null;
    }

    @Override
    public void delete(int puzzleId) {
        String sql = "delete from db_campus_puzzle where puzzle_id = ?";
        Jdbc jdbc = new Jdbc();
        jdbc.executeUpdate(sql,puzzleId);
    }
}

package cn.edu.jxnu.rj.dao;

import cn.edu.jxnu.rj.domain.Puzzle;

import java.util.List;

public interface PuzzleDao {
    Puzzle insert(Puzzle puzzle);//发布问题
    List<Puzzle> getAllByUser(int userId);//查询某用户所有问题
    Puzzle findById(int puzzleId);//根据id查询
    void delete(int puzzleId);//删除问题
}

package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.dao.GiveLikeDao;
import cn.edu.jxnu.rj.dao.PuzzleDao;
import cn.edu.jxnu.rj.dao.impl.CommentDaoImpl;
import cn.edu.jxnu.rj.dao.impl.GiveLikeDaoImpl;
import cn.edu.jxnu.rj.dao.impl.PuzzleDaoImpl;
import cn.edu.jxnu.rj.domain.Puzzle;
import cn.edu.jxnu.rj.service.PuzzleService;

import java.util.List;

public class PuzzleServiceImpl implements PuzzleService {
    PuzzleDao puzzleDao = new PuzzleDaoImpl();
    @Override
    public Puzzle insert(Puzzle puzzle) {
        return puzzleDao.insert(puzzle);
    }

    @Override
    public List<Puzzle> getAllByUser(int userId) {
        return puzzleDao.getAllByUser(userId);
    }

    @Override
    public Puzzle findById(int puzzleId) {
        return puzzleDao.findById(puzzleId);
    }

    @Override
    public void delete(int puzzleId) {
        puzzleDao.delete(puzzleId);

        GiveLikeDao giveLikeDao = new GiveLikeDaoImpl();
        giveLikeDao.deleteAllByWork(2,puzzleId);//删除问题下的点赞记录

        CommentDao commentDao = new CommentDaoImpl();
        commentDao.deleteAllByWork(2,puzzleId);//删除问题下的所有评论；
    }
}

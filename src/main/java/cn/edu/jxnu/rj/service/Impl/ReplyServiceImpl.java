package cn.edu.jxnu.rj.service.Impl;

import cn.edu.jxnu.rj.dao.CommentDao;
import cn.edu.jxnu.rj.dao.MessageDao;
import cn.edu.jxnu.rj.dao.ReplyDao;
import cn.edu.jxnu.rj.dao.impl.CommentDaoImpl;
import cn.edu.jxnu.rj.dao.impl.MessageDaoImpl;
import cn.edu.jxnu.rj.dao.impl.ReplyDaoImpl;
import cn.edu.jxnu.rj.domain.Comment;
import cn.edu.jxnu.rj.domain.Message;
import cn.edu.jxnu.rj.domain.Reply;
import cn.edu.jxnu.rj.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    ReplyDao replyDao = new ReplyDaoImpl();
    @Override
    public void reply(Reply reply) {
        replyDao.insert(reply);
        MessageDao messageDao = new MessageDaoImpl();
        CommentDao commentDao = new CommentDaoImpl();
        Comment comment = commentDao.findById(reply.getComment_id());
        if(reply.getUser_id()!=comment.getUser_id()){
            messageDao.insert(new Message(reply.getUser_id(),comment.getUser_id(),2,reply.getReply_content(),comment.getComment_id(),2));
        }
    }

    @Override
    public void deleteReply(int replyId) {
        replyDao.delete(replyId);
    }

    @Override
    public List<Reply> getAllInComment(int commentId) {
        return replyDao.getAllByCommentId(commentId);
    }
}

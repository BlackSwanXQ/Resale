package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comment;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public Comments get(Long id) {
        return null;
    }

    @Override
    public Comment create(Long id, CreateOrUpdateComment newComment) {
        return null;
    }

    @Override
    public void delete(Long adId, Long commentId) {
    }

    @Override
    public Comment update(Long adId, Long commentId, CreateOrUpdateComment newComment) {
        return null;
    }
}

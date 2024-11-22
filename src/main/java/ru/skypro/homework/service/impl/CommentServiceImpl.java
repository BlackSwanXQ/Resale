package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentsDto get(Long id) {
        return null;
    }

    @Override
    public CommentDto create(Long id, CreateOrUpdateCommentDto newComment) {
        return null;
    }

    @Override
    public void delete(Long adId, Long commentId) {
    }

    @Override
    public CommentDto update(Long adId, Long commentId, CreateOrUpdateCommentDto newComment) {
        return null;
    }
}

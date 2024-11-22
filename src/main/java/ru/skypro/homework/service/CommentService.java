package ru.skypro.homework.service;

import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;

public interface CommentService {
    CommentsDto get(Long id);
    CommentDto create(Long id, CreateOrUpdateCommentDto newComment);
    void delete(Long adId, Long commentId);
    CommentDto update(Long adId, Long commentId, CreateOrUpdateCommentDto newComment);
}

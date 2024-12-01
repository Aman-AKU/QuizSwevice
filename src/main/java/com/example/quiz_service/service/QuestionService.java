package com.example.quiz_service.service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return (ResponseEntity<List<Question>>) questionDao.findByCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);

        }catch (Exception e){
            e.printStackTrace();
            
        }
        return new ResponseEntity<>( "Not added",HttpStatus.NOT_IMPLEMENTED);
    }

    public String  updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";

    }
}

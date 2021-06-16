package com.example.tubes.data;

import java.util.ArrayList;

public class IsiDataQuiz {
    private static String [] soal = {
            "Father, mother, brother and sister are my ...",
            "I have a father and mother. They are my ...",
            "My aunt's son is my..."
    };

    private static String [] quizDetail = {
            "parents, children, family, grandparents",
            "family, parents, children, grandparents",
            "nephew, cousin, niece, sister"
    };

    public static ArrayList<QuizData> getListData(){
        ArrayList<QuizData> list = new ArrayList<>();
        for (int position = 0; position<soal.length; position++){
            QuizData quizData = new QuizData();
            quizData.setJudul(soal[position]);
            quizData.setIsi(quizDetail[position]);
            list.add(quizData);
        }
        return list;
    }
}

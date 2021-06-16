package com.example.tubes.data;

public class KumpulanSoalKelas8 {
    private String textQuestions[] = {
            "1. Generally, girls are ______ than boys",
            "2. Cricket is an ______game.",
            "3. Arpita is looking _______ in this dress.",
            "4. She has a very ______voice.",
            "5. Diamond is the _______natural material."
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"talkative", "most talkative", "more talkative", "talkative"},
            {"exciting","excitengest","excitinger","excitengest"},
            {"Gorgeous","Gorgeouser","Gorgeousest","Gorgeousest"},
            {"sour bitter","sweet","Sweetest","sour bitter"},
            {"hard","hardest","harder","hard"}
    };

    private String mCorrectAnswers[] = {
            "more talkative",
            "exciting",
            "Gorgeous",
            "sweet",
            "hardest"
    };

    public int getLength() {
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num - 1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

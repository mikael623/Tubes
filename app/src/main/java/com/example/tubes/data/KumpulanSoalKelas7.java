package com.example.tubes.data;

public class KumpulanSoalKelas7 {
    private String textQuestions[] = {
            "1. The way to ask someone’s news is?",
            "2. It’s seven o’clock in the morning. Gina will go to school. She says......... to his parents.",
            "3. It’s nine o’clock in the night. Gia will go to sleep. He says....... to his parents",
            "4. Which one in the following is the expression of  leave-taking?",
            "5. Before Widi goes to school in the morning, what she says to her parent?"
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"How is life?", "Where are you?", "What is that?", "Do you like it?"},
            {"Good night", "Good afternoon", "Good bye", "Good morning"},
            {"Good night", "Good afternoon", "Good bye", "Good morning"},
            {"We have had a wonderful time.", "How do you do?", "How are you today?", "I am sorry, I have to leave now."},
            {"Chase my way.", "Go away.", "Just go.", "Cheerio."},
    };

    private String mCorrectAnswers[] = {
            "How is life?",
            "Good morning",
            "Good night",
            "I am sorry, I have to leave now.",
            "Cheerio."
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

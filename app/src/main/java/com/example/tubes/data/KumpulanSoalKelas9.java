package com.example.tubes.data;

public class KumpulanSoalKelas9 {
    private String textQuestions[] = {
            "1. I was sleeping when somebody knocked the door.",
            "2. I was working when Shanti came.",
            "3. Budi had lived in Bali.",
            "4. My father had eaten before I worked.",
            "5. The mechanic had been repairing my car."
    };

    // array of multiple choices for each question
    private String multipleChoice[][] = {
            {"I was slept when somebody knocked the door.", "I had slept when somebody knocked the door.", "I have slept when somebody knocked the door.", "I hadn't slept when somebody knocked the door."},
            {"I had not work when Shanti came.","I had not worked when Shanti come.","I had not worked when Shanti came.","I had not work when Shanti come."},
            {"Had Budi Live in Bali?","Had Budi lived in Bali?","Is Budi living in Bali?","Has Budi lived in Bali?"},
            {"Hadn’t my father eaten before I worked?","Hadn’t my father ate before I worked?","Had my father not eat before I worked?","Had my father ate before I worked?"},
            {"The mechanic had repaired my car.","The mechanic had repair my car.","The mechanic has been repairing my car.","The mechanic has repair my car."}
    };

    private String mCorrectAnswers[] = {
            "I had slept when somebody knocked the door.",
            "I had not worked when Shanti came.",
            "Had Budi lived in Bali?",
            "Hadn’t my father eaten before I worked?",
            "The mechanic had repaired my car."
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

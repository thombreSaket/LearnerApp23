package hhird.harsh123.com.learnerapp;

public class Questions {

    String question ;
    String opta;
    String optb;
    String optc;
    String optd;
    String ans;
    String tits;
    String qnum;

    public Questions(String qnum,String tits,String question, String opta, String optb, String optc, String optd, String ans) {
       this.qnum=qnum;
        this.tits=tits;
        this.question = question;
        this.opta = opta;
        this.optb = optb;
        this.optc = optc;
        this.optd = optd;
        this.ans = ans;
    }

    public String getQnum() {
        return qnum;
    }

    public String getTits() {
        return tits;
    }

    public String getQuestion() {
        return question;
    }

    public String getOpta() {
        return opta;
    }

    public String getOptb() {
        return optb;
    }

    public String getOptc() {
        return optc;
    }

    public String getOptd() {
        return optd;
    }

    public String getAns() {
        return ans;
    }
}

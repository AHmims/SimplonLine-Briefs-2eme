public class Niveau {
    private String question;
    private String[] reponse;
    private int solution;
    //

    public String getQuestion() {
        return question;
    }

    public String[] getReponse() {
        return reponse;
    }

    public int getSolution() {
        return solution;
    }

    //
    public Niveau(String question, String[] reponse, int solution){
        this.question = question;
        this.reponse = reponse;
        this.solution = solution;
    }
    //
    public boolean isCorrect(int rep){
        boolean res = false;
        if(rep == this.solution)
            res = true;
        return res;
    }
}

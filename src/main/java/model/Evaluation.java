
package model;

/**
 *
 * @author Sterbenxy13
 */
public class Evaluation {
    private Integer accumulatedGrade;
    private Integer evaluationCount;

    public Evaluation() {
        this.accumulatedGrade = 0;
        this.evaluationCount = 0;
    }
    
    public Evaluation(Integer value, Integer evaluationCount) {
        this.accumulatedGrade = value;
        this.evaluationCount = evaluationCount;
    }

    public Integer getAccumulatedGrade() {
        return accumulatedGrade;
    }

    public Integer getEvaluationCount() {
        return evaluationCount;
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Double getGrade() {
        if (this.evaluationCount == 0) {
            return 0.0;
        }
        return java.lang.Math.round(((double)this.accumulatedGrade / (double)this.evaluationCount) * 10.0) / 10.0;
    }
    
    public void addGrade(Integer grade) {
        this.accumulatedGrade += grade;
        this.evaluationCount ++;
    }
    
    
}

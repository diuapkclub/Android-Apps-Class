package decisionmakingcontrolandroid.diu.com.androidsqlitedbexample;

import java.io.Serializable;

public class Program {

    private Integer programId;
    private String programName;
    private String programHostName;
    private String programStartTime;
    private String programEndTime;
    private String programDuration;

    public Program(Integer programId, String programName, String programHostName, String programStartTime, String programEndTime, String programDuration) {
        this.programId = programId;
        this.programName = programName;
        this.programHostName = programHostName;
        this.programStartTime = programStartTime;
        this.programEndTime = programEndTime;
        this.programDuration = programDuration;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramHostName() {
        return programHostName;
    }

    public void setProgramHostName(String programHostName) {
        this.programHostName = programHostName;
    }

    public String getProgramStartTime() {
        return programStartTime;
    }

    public void setProgramStartTime(String programStartTime) {
        this.programStartTime = programStartTime;
    }

    public String getProgramEndTime() {
        return programEndTime;
    }

    public void setProgramEndTime(String programEndTime) {
        this.programEndTime = programEndTime;
    }

    public String getProgramDuration() {
        return programDuration;
    }

    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }

}
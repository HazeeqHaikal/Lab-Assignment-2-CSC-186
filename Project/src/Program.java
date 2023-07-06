public class Program {
    private String programCode;
    private String programDescription;
    private String duration;
    private String faculty;
    private String programHead;

    // default constructor
    public Program() {
        programCode = "";
        programDescription = "";
        duration = "";
        faculty = "";
        programHead = "";
    }

    // Normal constructor that set all data with values given through the parameter.
    public Program(String programCode, String programDescription, String duration, String faculty, String programHead) {
        this.programCode = programCode;
        this.programDescription = programDescription;
        this.duration = duration;
        this.faculty = faculty;
        this.programHead = programHead;
    }

    // Copy constructor that set all data with values given through the parameter.
    public Program(Program copyProgram) {
        this.programCode = copyProgram.programCode;
        this.programDescription = copyProgram.programDescription;
        this.duration = copyProgram.duration;
        this.faculty = copyProgram.faculty;
        this.programHead = copyProgram.programHead;
    }

    // getter and setter
    public String getProgramCode() {
        return this.programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramDescription() {
        return this.programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getProgramHead() {
        return this.programHead;
    }

    public void setProgramHead(String programHead) {
        this.programHead = programHead;
    }

    // toString method that return all data in a string format.
    @Override
    public String toString() {
        return "\nProgram Code: " + getProgramCode() + "\nProgram Description: " + getProgramDescription()
                + "\nProgram Level: " + programLevel()
                + "\nDuration: " + getDuration() + "\nFaculty: " + getFaculty() + "\nProgram Head: " + getProgramHead();
    }

    public String programLevel() {
        char thirdCharacter = getProgramCode().charAt(2);
        switch (thirdCharacter) {
            case '0':
                return "Certificate";
            case '1':
                return "Diploma";
            case '2':
                return "Bachelor";
            case '3':
                return "Master";
            case '4':
                return "Doctorate";
            default:
                return "Unknown";
        }
    }
}

package org.example.DTO;

public class ImportError {
    private String line;
    private String massage;

    public ImportError(String massage, String line) {
        this.massage = massage;
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}

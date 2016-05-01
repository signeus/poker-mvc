package models;

/**
 * Created by Kev on 20/04/2016.
 */
public class ResultStat {
    private int CPR;
    private double CSI;
    private double PN;
    private int intPN;

    public ResultStat(){
        this.CPR = 0;
        this.CSI = 0;
        this.PN = 0;
    }
    public ResultStat(int CPR, double CSI, double PN){
        this.CPR = CPR;
        this.CSI = CSI;
        this.PN = PN;
        this.intPN = new Double(PN).intValue();
    }
    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
        this.CPR = CPR;
    }

    public double getCSI() {
        return CSI;
    }

    public void setCSI(double CSI) {
        this.CSI = CSI;
    }

    public double getPN() {
        return PN;
    }

    public void setPN(double PN) {
        this.PN = PN;
    }

    public int getIntPN() {
        return intPN;
    }
}

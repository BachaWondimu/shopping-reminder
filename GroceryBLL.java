package OOP_Project;

public class GroceryBLL {
    private String[] dairy;
    private String[] pCare;
    private String[] produce;
    private String[] others;

    GroceryDAL dal = new GroceryDAL();

    String dairyFilePath = "Dairy.txt";
    String pCareFilePath = "personalCare.txt";
    String proFilePath = "Produce.txt";
    String othersFilePath = "Others.txt";


    GroceryBLL() {
    }


    public String[] getDairy() {
        int length = dal.readAll(dairyFilePath).size();
        dairy = new String[length];
        dal.readAll(dairyFilePath).toArray(dairy);
        return dairy;
    }

    public void setDairy(String[] dairy, boolean flag) {
        if (flag) {
            dal.addToList(dairy, dairyFilePath);
        } else {
            dal.writeNewList(dairy, dairyFilePath);
        }
    }


    public String[] getPersonalCare() {
        pCare = makeArray(pCareFilePath);
        return pCare;
    }

    public void setPersonalCare(String[] personalCare, boolean flag) {
        if (flag) {
            dal.addToList(personalCare, pCareFilePath);
        } else {
            dal.writeNewList(personalCare, pCareFilePath);
        }

    }


    public String[] getProduce() {
        produce = makeArray(proFilePath);
        return produce;
    }

    public void setProduce(String[] produce, boolean flag) {
        if (flag) {
            dal.addToList(produce, proFilePath);
        } else {
            dal.writeNewList(produce, proFilePath);
        }
    }


    public String[] getOther() {
        others = makeArray(othersFilePath);
        return others;
    }

    public void setOther(String[] other, boolean flag) {
        if (flag) {
            dal.addToList(other, othersFilePath);
        } else {
            dal.writeNewList(other, othersFilePath);
        }

    }


    private String[] makeArray(String fPath) {
        int length = dal.readAll(fPath).size();
        String[] temporary = new String[length];
        dal.readAll(fPath).toArray(temporary);
        return temporary;
    }

}

package DB_model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/9.
 */
public class ID implements Serializable {
    private String idType;
    private String idNum;


    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ID ID = (ID) o;

        if (idType != null ? !idType.equals(ID.idType) : ID.idType != null) return false;
        if (idNum != null ? !idNum.equals(ID.idNum) : ID.idNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType != null ? idType.hashCode() : 0;
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        return result;
    }
}

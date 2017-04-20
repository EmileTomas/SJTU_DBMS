package DB_model.Util;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/9.
 */
@Embeddable
public class IDInfo implements Serializable {
    private String idType;
    private String idNum;

    public IDInfo() {
    }

    public IDInfo(String idType, String idNum) {
        this.idType = idType;
        this.idNum = idNum;
    }


    public String getIdType() {
        return idType;
    }

    public IDInfo setIdType(String idType) {
        this.idType = idType;
        return this;
    }

    public String getIdNum() {
        return idNum;
    }

    public IDInfo setIdNum(String idNum) {
        this.idNum = idNum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDInfo)) return false;

        IDInfo idInfo = (IDInfo) o;

        if (idType != null ? !idType.equals(idInfo.idType) : idInfo.idType != null) return false;
        return idNum != null ? idNum.equals(idInfo.idNum) : idInfo.idNum == null;
    }

    @Override
    public int hashCode() {
        int result = idType != null ? idType.hashCode() : 0;
        result = 31 * result + (idNum != null ? idNum.hashCode() : 0);
        return result;
    }
}

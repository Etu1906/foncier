package sante;

import java.io.Serializable;
import java.sql.Date;
public class Operation implements Serializable {

  private static final long serialVersionUID = 1L;
  int idOperation;

  Date dateOperation;
  PartieCorps partieCorps;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getIdOperation() {
    return idOperation;
  }

  public void setIdOperation(int idOperation) {
    this.idOperation = idOperation;
  }

  public Date getDateOperation() {
    return dateOperation;
  }

  public void setDateOperation(Date dateOperation) {
    this.dateOperation = dateOperation;
  }

  public PartieCorps getPartieCorps() {
    return partieCorps;
  }

  public void setPartieCorps(PartieCorps partieCorps) {
    this.partieCorps = partieCorps;
  }
}

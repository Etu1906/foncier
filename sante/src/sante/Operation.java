package sante;

import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import serialisers.*;

@Entity
@Table(name = "operation")
public class Operation implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  int idOperation;

  @JsonbTypeSerializer(CustomDateSerializer.class)
  Date dateOperation;

  @ManyToOne
  @JoinColumn(name = "idPartieCorps")
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

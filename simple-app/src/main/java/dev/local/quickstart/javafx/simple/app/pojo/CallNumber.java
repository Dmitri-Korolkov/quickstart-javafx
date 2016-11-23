package dev.local.quickstart.javafx.simple.app.pojo;

public class CallNumber {

  private Integer id;

  private String name;

  private Integer number;

  public CallNumber() {
  }

  public CallNumber(Integer id, String name, Integer number) {
    this.id = id;
    this.name = name;
    this.number = number;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CallNumber that = (CallNumber) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return number != null ? number.equals(that.number) : that.number == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (number != null ? number.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CallNumber{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", number=" + number +
            '}';
  }
}

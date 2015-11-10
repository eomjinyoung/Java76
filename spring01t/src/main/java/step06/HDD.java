package step06;

public class HDD {
  protected int capacity;
  protected int rpm;
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + capacity;
    result = prime * result + rpm;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    HDD other = (HDD) obj;
    if (capacity != other.capacity)
      return false;
    if (rpm != other.rpm)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "HDD [capacity=" + capacity + ", rpm=" + rpm + "]";
  }
  
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public int getRpm() {
    return rpm;
  }
  public void setRpm(int rpm) {
    this.rpm = rpm;
  }
  
  
}

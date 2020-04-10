package com.ntapia.poker.domain.chip;

import java.util.Objects;

public class Chip implements Comparable<Chip> {

  private String label;
  private int value;

  public Chip(String label, int value) {
    this.label = label;
    this.value = value;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(Chip chip) {
    if (this.value == chip.getValue()) {
      return 0;
    }

    return this.value < chip.getValue() ? -1 : 1;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chip chip = (Chip) o;
    return value == chip.value &&
        Objects.equals(label, chip.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, value);
  }

  @Override
  public String toString() {
    return label;
  }
}

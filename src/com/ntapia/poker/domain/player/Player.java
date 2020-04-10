package com.ntapia.poker.domain.player;

import com.ntapia.poker.domain.chip.Chip;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Player {

  private String name;
  private List<Chip> chips;

  public Player(String name, List<Chip> chips) {
    this.name = name;
    this.chips = chips;
  }

  public Chip requestChip(int value) {
    if (chips.isEmpty()) {
      throw new PlayerWithoutFoundsException("Player without funds!");
    }

    Chip nextChip = chips.get(0);

    Iterator<Chip> iterator = chips.iterator();
    while (iterator.hasNext()) {
      Chip chip = iterator.next();
      if (value == chip.getValue()) {
        iterator.remove();
        return chip;
      }
      nextChip = nextChip.compareTo(chip) > 0 ? chip : nextChip;
    }

    chips.remove(nextChip);
    return nextChip;
  }

  public void addChips(List<Chip> chips){
    this.chips.addAll(chips);
  }

  public Chip bet(int value) {
    return requestChip(value);
  }

  public Chip call(int value) {
    return requestChip(value);
  }

  public void fold() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Chip> getChips() {
    return chips;
  }

  public void setChips(List<Chip> chips) {
    this.chips = chips;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name + " chips: " +
        this.chips.stream().map(Chip::getLabel)
            .collect(Collectors.joining(", "));
  }
}

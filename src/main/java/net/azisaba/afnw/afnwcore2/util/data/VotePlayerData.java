package net.azisaba.afnw.afnwcore2.util.data;

import java.util.UUID;

/**
 * Class containing player data related to voting bonuses
 *
 * @author m2en
 */
public class VotePlayerData {

  private final UUID uuid;
  private final int votes;

  public VotePlayerData(UUID uuid, int votes) {
    this.uuid = uuid;
    this.votes = votes;
  }
}

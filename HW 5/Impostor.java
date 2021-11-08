/**
 * This file defines an interface with the name Impostor.
 * They can freeze(Player p) and sabotage(Player p).
 * It will represent an Imposter in-game.
 */
public abstract interface Impostor {
    abstract void freeze(Player p);
    abstract void sabotage(Player p);
}

package abilities;

import player.Player;

public class AbilityFactory {
    /**/
    public Ability getAbilityType(final AbilityType abilityType, final Player player) {
        if (abilityType == null) {
            return null;
        }
        if (abilityType.equals(AbilityType.ignite)) {
            return new Ignite(player);
        }
        if (abilityType.equals(AbilityType.fireblast)) {
            return new Fireblast(player);
        }
        if (abilityType.equals(AbilityType.execute)) {
            return new Execute(player);
        }
        if (abilityType.equals(AbilityType.slam)) {
            return new Slam(player);
        }
        if (abilityType.equals(AbilityType.drain)) {
            return new Drain(player);
        }
        if (abilityType.equals(AbilityType.deflect)) {
            return new Deflect(player);
        }
        if (abilityType.equals(AbilityType.backstab)) {
            return new Backstab(player);
        }
        if (abilityType.equals(AbilityType.paralysis)) {
            return new Paralysis(player);
        }
        return null;
    }
}

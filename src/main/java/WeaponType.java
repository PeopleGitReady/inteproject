public enum WeaponType {

    COMMON(0, "common"),
    RARE(2, "RARE"),
    EPIC(4, "epic");

    private final int ADDED_DAMAGE_VALUE;
    private final String RARITY;

    WeaponType(int addedDamageValue, String rarity) {
        this.ADDED_DAMAGE_VALUE = addedDamageValue;
        this.RARITY = rarity;
    }

    public int getAddedDamageValue() {
        return ADDED_DAMAGE_VALUE;
    }




}

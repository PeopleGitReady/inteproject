public enum WeaponType {

    COMMON(0, "common"),
    RARE(2, "silver"),
    EPIC(4, "epic");

    private final int addedDamageValue;
    private final String rarity;

    WeaponType(int addedDamageValue, String rarity) {
        this.addedDamageValue = addedDamageValue;
        this.rarity = rarity;
    }

    public double getAddedDamageValue() {
        return addedDamageValue;
    }
    public String getRarity() {
        return rarity;
    }

}

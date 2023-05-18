public interface purchaseable {
    int getStoreValue();
    void setStoreValue(int storeValue);
    int getSellbackPrice();
    void setSellbackPrice(int sellbackPrice);
    void increaseAmount(int amount);
    void decreaseAmount(int amount);
    String getName();
    int getAmount();
}

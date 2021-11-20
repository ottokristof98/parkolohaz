package model;
public class Item {
    
    public String key;
    public Object value;

    private Item(String key, Object value) {
        this.key = key;
        this.value = value;
    }
    
    public static Item createNewItem(String key, Object value){
        Item item = new Item(key, value);
        return item;
    }
    
}

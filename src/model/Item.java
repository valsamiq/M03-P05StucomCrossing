package model;

/**
 * @author balsamiq
 */
public class Item {
    private String name;
    private Double price;
    private Double salePrice;
    private String type;
    private String style;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Double price, Double salePrice, String type, String style) {
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.type = type;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", price=" + price + ", salePrice=" + salePrice + ", type=" + type + ", style=" + style + '}';
    }
    
}
//   (\_(\
// =( °w° )=
//   )   ( //
//  (__ __)/
// balsamiq
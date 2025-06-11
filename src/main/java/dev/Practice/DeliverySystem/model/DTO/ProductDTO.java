package dev.Practice.DeliverySystem.model.DTO;

public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imgUrl;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public String getDesc() {
        return description;
    }
    public void setDesc(String desc) {
        this.description = desc;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public ProductDTO(Long id, String name, Double price, String desc, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = desc;
        this.imgUrl = imgUrl;
    }

    

}

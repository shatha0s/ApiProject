package pojos;

import java.util.ArrayList;

public class petPojo {
    private int id;
    private petcategoryPojo category ;
    private String name;
    private ArrayList<String> photoUrls;
    private ArrayList<pettagPojo> tags;
    private String status;

    public petPojo(){

    }

    public petPojo(int id, petcategoryPojo category, String name, ArrayList<String> photoUrls, ArrayList<pettagPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public petcategoryPojo getCategory() {
        return category;
    }

    public void setCategory(petcategoryPojo category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public ArrayList<pettagPojo> getTags() {
        return tags;
    }

    public void setTags(ArrayList<pettagPojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "petPojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}

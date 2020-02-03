package com.rishi.pascolan;

public class DataModel {

    private String image_url;
    private String names;
    private boolean isSelected = false ;


    public String getimage_url() {
        return image_url;
    }

    public String getnames() {
        return names;
    }

    public void setimage_url(String image_url) {
        this.image_url = image_url;
    }
    public void setnames(String names) {
        this.names = names;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }

}

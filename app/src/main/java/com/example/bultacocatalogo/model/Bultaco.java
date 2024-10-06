package com.example.bultacocatalogo.model;

public class Bultaco {
    private String urlImage;
    private String type;
    private String nickname;
    private int age;
    private int bithYear;
    private String[] verions;
    private String desc;

    public Bultaco(String urlImage, String type, String nickname, int age, int bithYear, String[] verions, String desc) {
        this.urlImage = urlImage;
        this.type = type;
        this.nickname = nickname;
        this.age = age;
        this.bithYear = bithYear;
        this.verions = verions;
        this.desc = desc;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getVerions() {
        return verions;
    }

    public void setVerions(String[] verions) {
        this.verions = verions;
    }

    public int getBithYear() {
        return bithYear;
    }

    public void setBithYear(int bithYear) {
        this.bithYear = bithYear;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVersionsBultacos(){
        String value = "";

        for (int i = 0; i < verions.length; i++){
            if (i==0){
                value = verions[i];
            }else{
                value = value + ", " + verions[i];
            }
        }
        return value;
    }

}

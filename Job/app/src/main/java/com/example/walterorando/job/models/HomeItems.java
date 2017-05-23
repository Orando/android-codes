package com.example.walterorando.job.models;

/**
 * Created by Walter Orando on 3/18/2016.
 */
public class HomeItems {
  private String id, userId, username, blog, timeStamp, category, userImage, title, content, media, path;
public HomeItems(){}

public HomeItems(String id, String userId, String username, String blog, String timeStamp, String category, String userImage, String title, String content, String media, String path){
  super();
    this.id = id;
    this.userId = userId;
    this.username = username;
    this.blog = blog;
    this.timeStamp = timeStamp;
    this.category = category;
    this.userImage = userImage;
    this.title = title;
    this.content = content;
    this.media = media;
    this.path = path;
}

 public String getUsername(){return username;};
    public void setUsername(String username){this.username = username;};

 public String getId(){return id;}
    public void setId(String id){this.id = id;}

 public String getUserId(){return userId;}
    public void setUserId(String userId){this.userId = userId;}

 public String getBlog(){return blog;}
    public void setBlog(String blog){this.blog = blog;}

 public String getTimeStamp(){return timeStamp;}
    public void setTimeStamp(String timeStamp) {this.timeStamp = timeStamp;}

 public String getCategory(){return category;}
    public void setCategory(String category) {this.category = category;}

 public String getUserImage() { return userImage;}
    public void setUserImage(String userImage) {this.userImage = userImage;}

 public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

 public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

 public String getMedia() {return media;}
    public void setMedia(String media) {this.media = media;}

    public void setPath(String path) { this.path = path; }

    /**
     * Gets path.
     *
     * @return Value of path.
     */
    public String getPath() { return path; }

    @Override public String toString() {
        return "Title:" + title + "   ";
    }
}

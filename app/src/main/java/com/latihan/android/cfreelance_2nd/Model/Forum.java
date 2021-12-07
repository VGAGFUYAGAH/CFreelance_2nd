package com.latihan.android.cfreelance_2nd.Model;

public class Forum {
    private String forumPersonName;
    private String forumTitle;
    private String forumDescription;
    private String forumImageUrl;

    public Forum(String forumPersonName, String forumTitle, String forumDescription, String forumImageUrl) {
        this.forumPersonName = forumPersonName;
        this.forumTitle = forumTitle;
        this.forumDescription = forumDescription;
        this.forumImageUrl = forumImageUrl;
    }

    public Forum(String forumPersonName, String forumTitle, String forumImageUrl) {
        this.forumPersonName = forumPersonName;
        this.forumTitle = forumTitle;
        this.forumImageUrl = forumImageUrl;
    }

    public String getForumPersonName() {
        return forumPersonName;
    }

    public void setForumPersonName(String forumPersonName) {
        this.forumPersonName = forumPersonName;
    }

    public String getForumTitle() {
        return forumTitle;
    }

    public void setForumTitle(String forumTitle) {
        this.forumTitle = forumTitle;
    }

    public String getForumDescription() {
        return forumDescription;
    }

    public void setForumDescription(String forumDescription) {
        this.forumDescription = forumDescription;
    }

    public String getForumImageUrl() {
        return forumImageUrl;
    }

    public void setForumImageUrl(String forumImageUrl) {
        this.forumImageUrl = forumImageUrl;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumPersonName='" + forumPersonName + '\'' +
                ", forumTitle='" + forumTitle + '\'' +
                ", forumDescription='" + forumDescription + '\'' +
                ", forumImageUrl='" + forumImageUrl + '\'' +
                '}';
    }
}

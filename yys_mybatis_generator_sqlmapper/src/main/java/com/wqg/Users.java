package com.wqg;

import java.io.Serializable;

public class Users implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.face_image
     *
     * @mbggenerated
     */
    private String faceImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.fans_counts
     *
     * @mbggenerated
     */
    private Integer fansCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.follow_counts
     *
     * @mbggenerated
     */
    private Integer followCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.receive_like_counts
     *
     * @mbggenerated
     */
    private Integer receiveLikeCounts;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.face_image
     *
     * @return the value of users.face_image
     *
     * @mbggenerated
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.face_image
     *
     * @param faceImage the value for users.face_image
     *
     * @mbggenerated
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage == null ? null : faceImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.nickname
     *
     * @return the value of users.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.nickname
     *
     * @param nickname the value for users.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.fans_counts
     *
     * @return the value of users.fans_counts
     *
     * @mbggenerated
     */
    public Integer getFansCounts() {
        return fansCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.fans_counts
     *
     * @param fansCounts the value for users.fans_counts
     *
     * @mbggenerated
     */
    public void setFansCounts(Integer fansCounts) {
        this.fansCounts = fansCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.follow_counts
     *
     * @return the value of users.follow_counts
     *
     * @mbggenerated
     */
    public Integer getFollowCounts() {
        return followCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.follow_counts
     *
     * @param followCounts the value for users.follow_counts
     *
     * @mbggenerated
     */
    public void setFollowCounts(Integer followCounts) {
        this.followCounts = followCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.receive_like_counts
     *
     * @return the value of users.receive_like_counts
     *
     * @mbggenerated
     */
    public Integer getReceiveLikeCounts() {
        return receiveLikeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.receive_like_counts
     *
     * @param receiveLikeCounts the value for users.receive_like_counts
     *
     * @mbggenerated
     */
    public void setReceiveLikeCounts(Integer receiveLikeCounts) {
        this.receiveLikeCounts = receiveLikeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", faceImage=").append(faceImage);
        sb.append(", nickname=").append(nickname);
        sb.append(", fansCounts=").append(fansCounts);
        sb.append(", followCounts=").append(followCounts);
        sb.append(", receiveLikeCounts=").append(receiveLikeCounts);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

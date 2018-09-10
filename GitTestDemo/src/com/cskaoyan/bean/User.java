package com.cskaoyan.bean;

public class User {
    private String email;
    private String password;
    private String username;
    private String sex;
    private String year;
    private String month;
    private String day;
    private String job;
    private String checkCode;
    private String filePath;

    public User() {
    }

    public User(String email, String password, String username, String sex, String year, String month, String day,
                String job, String checkCode, String filePath) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.year = year;
        this.month = month;
        this.day = day;
        this.job = job;
        this.checkCode = checkCode;
        this.filePath = filePath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", job='" + job + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}

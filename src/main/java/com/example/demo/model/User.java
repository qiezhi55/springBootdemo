package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private Date updateTime;

    private String loginIp;

    private String groupId;

    private Boolean isEffect;

    private Boolean isDelete;

    private String email;

    private String idCardNo;

    private Date idcardPasstime;

    private String realName;

    private String mobile;

    private Date mobilePasstime;

    private Boolean mobileIspass;

    private Integer score;

    private BigDecimal money;

    private BigDecimal quota;

    private BigDecimal lockMoney;

    private Integer pid;

    private Date loginTime;

    private Integer nProvinceId;

    private Integer nCityId;

    private Integer provinceId;

    private Integer cityId;

    private Boolean sex;

    private Integer birthYear;

    private Integer birthMonth;

    private Integer birthDay;

    private String adress;

    private String phone;

    private String postalcode;

    private String payPassword;

    private Boolean idcarIspassed;

    private Integer creditLevelId;

    private String loginpassword;

    private Byte isblack;

    private String imgUrl;

    private BigDecimal currentMoney;

    private BigDecimal currentLockMoney;

    private Date lastLoginTime;

    private Date createTime;

    private BigDecimal pigticket;

    private Integer pignum;

    private String createfrom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public Boolean getIsEffect() {
        return isEffect;
    }

    public void setIsEffect(Boolean isEffect) {
        this.isEffect = isEffect;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    public Date getIdcardPasstime() {
        return idcardPasstime;
    }

    public void setIdcardPasstime(Date idcardPasstime) {
        this.idcardPasstime = idcardPasstime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getMobilePasstime() {
        return mobilePasstime;
    }

    public void setMobilePasstime(Date mobilePasstime) {
        this.mobilePasstime = mobilePasstime;
    }

    public Boolean getMobileIspass() {
        return mobileIspass;
    }

    public void setMobileIspass(Boolean mobileIspass) {
        this.mobileIspass = mobileIspass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public BigDecimal getLockMoney() {
        return lockMoney;
    }

    public void setLockMoney(BigDecimal lockMoney) {
        this.lockMoney = lockMoney;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getnProvinceId() {
        return nProvinceId;
    }

    public void setnProvinceId(Integer nProvinceId) {
        this.nProvinceId = nProvinceId;
    }

    public Integer getnCityId() {
        return nCityId;
    }

    public void setnCityId(Integer nCityId) {
        this.nCityId = nCityId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode == null ? null : postalcode.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public Boolean getIdcarIspassed() {
        return idcarIspassed;
    }

    public void setIdcarIspassed(Boolean idcarIspassed) {
        this.idcarIspassed = idcarIspassed;
    }

    public Integer getCreditLevelId() {
        return creditLevelId;
    }

    public void setCreditLevelId(Integer creditLevelId) {
        this.creditLevelId = creditLevelId;
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public Byte getIsblack() {
        return isblack;
    }

    public void setIsblack(Byte isblack) {
        this.isblack = isblack;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal currentMoney) {
        this.currentMoney = currentMoney;
    }

    public BigDecimal getCurrentLockMoney() {
        return currentLockMoney;
    }

    public void setCurrentLockMoney(BigDecimal currentLockMoney) {
        this.currentLockMoney = currentLockMoney;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPigticket() {
        return pigticket;
    }

    public void setPigticket(BigDecimal pigticket) {
        this.pigticket = pigticket;
    }

    public Integer getPignum() {
        return pignum;
    }

    public void setPignum(Integer pignum) {
        this.pignum = pignum;
    }

    public String getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(String createfrom) {
        this.createfrom = createfrom == null ? null : createfrom.trim();
    }
}
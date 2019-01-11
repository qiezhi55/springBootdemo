package com.example.demo.model;

import java.util.Date;

public class Product {
    private Integer id;

    private String name;

    private Integer deadline;

    private Double annualRate;

    private Integer repayment;

    private Double minamount;

    private Double tenderSumRatio;

    private String uploadInformationId;

    private String productNum;

    private Double serviceFee;

    private Double investorsManagementFee;

    private Double transferManagementFee;

    private Double investorsRebate;

    private Integer classify;

    private Integer addUersName;

    private Integer audit;

    private Date auditTime;

    private Date addTime;

    private String auditRemarks;

    private Date modifiedTime;

    private Integer status;

    private Integer tenderStatus;

    private Double amount;

    private String contractNo;

    private Integer period;

    private Integer levelId;

    private Byte recommendItem;

    private Integer financingDeadline;

    private Date fullDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDeadline() {
        return deadline;
    }

    public void setDeadline(Integer deadline) {
        this.deadline = deadline;
    }

    public Double getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(Double annualRate) {
        this.annualRate = annualRate;
    }

    public Integer getRepayment() {
        return repayment;
    }

    public void setRepayment(Integer repayment) {
        this.repayment = repayment;
    }

    public Double getMinamount() {
        return minamount;
    }

    public void setMinamount(Double minamount) {
        this.minamount = minamount;
    }

    public Double getTenderSumRatio() {
        return tenderSumRatio;
    }

    public void setTenderSumRatio(Double tenderSumRatio) {
        this.tenderSumRatio = tenderSumRatio;
    }

    public String getUploadInformationId() {
        return uploadInformationId;
    }

    public void setUploadInformationId(String uploadInformationId) {
        this.uploadInformationId = uploadInformationId == null ? null : uploadInformationId.trim();
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum == null ? null : productNum.trim();
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getInvestorsManagementFee() {
        return investorsManagementFee;
    }

    public void setInvestorsManagementFee(Double investorsManagementFee) {
        this.investorsManagementFee = investorsManagementFee;
    }

    public Double getTransferManagementFee() {
        return transferManagementFee;
    }

    public void setTransferManagementFee(Double transferManagementFee) {
        this.transferManagementFee = transferManagementFee;
    }

    public Double getInvestorsRebate() {
        return investorsRebate;
    }

    public void setInvestorsRebate(Double investorsRebate) {
        this.investorsRebate = investorsRebate;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getAddUersName() {
        return addUersName;
    }

    public void setAddUersName(Integer addUersName) {
        this.addUersName = addUersName;
    }

    public Integer getAudit() {
        return audit;
    }

    public void setAudit(Integer audit) {
        this.audit = audit;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAuditRemarks() {
        return auditRemarks;
    }

    public void setAuditRemarks(String auditRemarks) {
        this.auditRemarks = auditRemarks == null ? null : auditRemarks.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTenderStatus() {
        return tenderStatus;
    }

    public void setTenderStatus(Integer tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Byte getRecommendItem() {
        return recommendItem;
    }

    public void setRecommendItem(Byte recommendItem) {
        this.recommendItem = recommendItem;
    }

    public Integer getFinancingDeadline() {
        return financingDeadline;
    }

    public void setFinancingDeadline(Integer financingDeadline) {
        this.financingDeadline = financingDeadline;
    }

    public Date getFullDate() {
        return fullDate;
    }

    public void setFullDate(Date fullDate) {
        this.fullDate = fullDate;
    }
}
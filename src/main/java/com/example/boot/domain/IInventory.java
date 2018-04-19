package com.example.boot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018/2/22 16:58
 * @Version v.1.0.0
 */
public class IInventory implements Serializable {

    private String guid;

    private String customsCode;

    private String appType;

    private Date appTime;

    private String appStatus;

    private String appUid;

    private String appUname;

    private String copNo;

    private String preNo;

    private String orderNo;

    private String orderType;

    private String ebpCode;

    private String ebpName;

    private String ebcCode;

    private String ebcName;

    private String logisticsNo;

    private String logisticsCode;

    private String logisticsName;

    private String invtNo;

    private String ieFlag;

    private String portCode;

    private Date ieDate;

    private String ownerCode;

    private String ownerName;

    private String tradeCode;

    private String tradeName;

    private String agentCode;

    private String agentName;

    private String tradeMode;

    private String trafMode;

    private String trafName;

    private String voyageNo;

    private String billNo;

    private String loctNo;

    private String licenseNo;

    private String country;

    private String destinationPort;

    private BigDecimal freight;

    private String freightCurr;

    private String freightMark;

    private BigDecimal insuredFee;

    private String insuredFeeCurr;

    private String insuredFeeMark;

    private String wrapType;

    private Integer packNo;

    private BigDecimal weight;

    private BigDecimal netWeight;

    private String note;

    private String returnStatus;

    private Date returnTime;

    private String returnInfo;

    private String returnGuid;

    private Date createdDate;

    private String createdByCompany;

    private String clearanceNo;

    private Integer enterpriseId;

    private Date ciqAppTime;

    private String ciqFlag;

    private String ciqReturnStatus;

    private String ciqReturnInfo;

    private Date ciqReturnTime;

    private String ciqReturnName;

    private static final long serialVersionUID = 1L;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode == null ? null : customsCode.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus == null ? null : appStatus.trim();
    }

    public String getAppUid() {
        return appUid;
    }

    public void setAppUid(String appUid) {
        this.appUid = appUid == null ? null : appUid.trim();
    }

    public String getAppUname() {
        return appUname;
    }

    public void setAppUname(String appUname) {
        this.appUname = appUname == null ? null : appUname.trim();
    }

    public String getCopNo() {
        return copNo;
    }

    public void setCopNo(String copNo) {
        this.copNo = copNo == null ? null : copNo.trim();
    }

    public String getPreNo() {
        return preNo;
    }

    public void setPreNo(String preNo) {
        this.preNo = preNo == null ? null : preNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getEbpCode() {
        return ebpCode;
    }

    public void setEbpCode(String ebpCode) {
        this.ebpCode = ebpCode == null ? null : ebpCode.trim();
    }

    public String getEbpName() {
        return ebpName;
    }

    public void setEbpName(String ebpName) {
        this.ebpName = ebpName == null ? null : ebpName.trim();
    }

    public String getEbcCode() {
        return ebcCode;
    }

    public void setEbcCode(String ebcCode) {
        this.ebcCode = ebcCode == null ? null : ebcCode.trim();
    }

    public String getEbcName() {
        return ebcName;
    }

    public void setEbcName(String ebcName) {
        this.ebcName = ebcName == null ? null : ebcName.trim();
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo == null ? null : logisticsNo.trim();
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode == null ? null : logisticsCode.trim();
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName.trim();
    }

    public String getInvtNo() {
        return invtNo;
    }

    public void setInvtNo(String invtNo) {
        this.invtNo = invtNo == null ? null : invtNo.trim();
    }

    public String getIeFlag() {
        return ieFlag;
    }

    public void setIeFlag(String ieFlag) {
        this.ieFlag = ieFlag == null ? null : ieFlag.trim();
    }

    public String getPortCode() {
        return portCode;
    }

    public void setPortCode(String portCode) {
        this.portCode = portCode == null ? null : portCode.trim();
    }

    public Date getIeDate() {
        return ieDate;
    }

    public void setIeDate(Date ieDate) {
        this.ieDate = ieDate;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode == null ? null : ownerCode.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName == null ? null : tradeName.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getTradeMode() {
        return tradeMode;
    }

    public void setTradeMode(String tradeMode) {
        this.tradeMode = tradeMode == null ? null : tradeMode.trim();
    }

    public String getTrafMode() {
        return trafMode;
    }

    public void setTrafMode(String trafMode) {
        this.trafMode = trafMode == null ? null : trafMode.trim();
    }

    public String getTrafName() {
        return trafName;
    }

    public void setTrafName(String trafName) {
        this.trafName = trafName == null ? null : trafName.trim();
    }

    public String getVoyageNo() {
        return voyageNo;
    }

    public void setVoyageNo(String voyageNo) {
        this.voyageNo = voyageNo == null ? null : voyageNo.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getLoctNo() {
        return loctNo;
    }

    public void setLoctNo(String loctNo) {
        this.loctNo = loctNo == null ? null : loctNo.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(String destinationPort) {
        this.destinationPort = destinationPort == null ? null : destinationPort.trim();
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getFreightCurr() {
        return freightCurr;
    }

    public void setFreightCurr(String freightCurr) {
        this.freightCurr = freightCurr == null ? null : freightCurr.trim();
    }

    public String getFreightMark() {
        return freightMark;
    }

    public void setFreightMark(String freightMark) {
        this.freightMark = freightMark == null ? null : freightMark.trim();
    }

    public BigDecimal getInsuredFee() {
        return insuredFee;
    }

    public void setInsuredFee(BigDecimal insuredFee) {
        this.insuredFee = insuredFee;
    }

    public String getInsuredFeeCurr() {
        return insuredFeeCurr;
    }

    public void setInsuredFeeCurr(String insuredFeeCurr) {
        this.insuredFeeCurr = insuredFeeCurr == null ? null : insuredFeeCurr.trim();
    }

    public String getInsuredFeeMark() {
        return insuredFeeMark;
    }

    public void setInsuredFeeMark(String insuredFeeMark) {
        this.insuredFeeMark = insuredFeeMark == null ? null : insuredFeeMark.trim();
    }

    public String getWrapType() {
        return wrapType;
    }

    public void setWrapType(String wrapType) {
        this.wrapType = wrapType == null ? null : wrapType.trim();
    }

    public Integer getPackNo() {
        return packNo;
    }

    public void setPackNo(Integer packNo) {
        this.packNo = packNo;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus == null ? null : returnStatus.trim();
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo == null ? null : returnInfo.trim();
    }

    public String getReturnGuid() {
        return returnGuid;
    }

    public void setReturnGuid(String returnGuid) {
        this.returnGuid = returnGuid == null ? null : returnGuid.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedByCompany() {
        return createdByCompany;
    }

    public void setCreatedByCompany(String createdByCompany) {
        this.createdByCompany = createdByCompany == null ? null : createdByCompany.trim();
    }

    public String getClearanceNo() {
        return clearanceNo;
    }

    public void setClearanceNo(String clearanceNo) {
        this.clearanceNo = clearanceNo == null ? null : clearanceNo.trim();
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Date getCiqAppTime() {
        return ciqAppTime;
    }

    public void setCiqAppTime(Date ciqAppTime) {
        this.ciqAppTime = ciqAppTime;
    }

    public String getCiqFlag() {
        return ciqFlag;
    }

    public void setCiqFlag(String ciqFlag) {
        this.ciqFlag = ciqFlag == null ? null : ciqFlag.trim();
    }

    public String getCiqReturnStatus() {
        return ciqReturnStatus;
    }

    public void setCiqReturnStatus(String ciqReturnStatus) {
        this.ciqReturnStatus = ciqReturnStatus == null ? null : ciqReturnStatus.trim();
    }

    public String getCiqReturnInfo() {
        return ciqReturnInfo;
    }

    public void setCiqReturnInfo(String ciqReturnInfo) {
        this.ciqReturnInfo = ciqReturnInfo == null ? null : ciqReturnInfo.trim();
    }

    public Date getCiqReturnTime() {
        return ciqReturnTime;
    }

    public void setCiqReturnTime(Date ciqReturnTime) {
        this.ciqReturnTime = ciqReturnTime;
    }

    public String getCiqReturnName() {
        return ciqReturnName;
    }

    public void setCiqReturnName(String ciqReturnName) {
        this.ciqReturnName = ciqReturnName == null ? null : ciqReturnName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guid=").append(guid);
        sb.append(", customsCode=").append(customsCode);
        sb.append(", appType=").append(appType);
        sb.append(", appTime=").append(appTime);
        sb.append(", appStatus=").append(appStatus);
        sb.append(", appUid=").append(appUid);
        sb.append(", appUname=").append(appUname);
        sb.append(", copNo=").append(copNo);
        sb.append(", preNo=").append(preNo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", orderType=").append(orderType);
        sb.append(", ebpCode=").append(ebpCode);
        sb.append(", ebpName=").append(ebpName);
        sb.append(", ebcCode=").append(ebcCode);
        sb.append(", ebcName=").append(ebcName);
        sb.append(", logisticsNo=").append(logisticsNo);
        sb.append(", logisticsCode=").append(logisticsCode);
        sb.append(", logisticsName=").append(logisticsName);
        sb.append(", invtNo=").append(invtNo);
        sb.append(", ieFlag=").append(ieFlag);
        sb.append(", portCode=").append(portCode);
        sb.append(", ieDate=").append(ieDate);
        sb.append(", ownerCode=").append(ownerCode);
        sb.append(", ownerName=").append(ownerName);
        sb.append(", tradeCode=").append(tradeCode);
        sb.append(", tradeName=").append(tradeName);
        sb.append(", agentCode=").append(agentCode);
        sb.append(", agentName=").append(agentName);
        sb.append(", tradeMode=").append(tradeMode);
        sb.append(", trafMode=").append(trafMode);
        sb.append(", trafName=").append(trafName);
        sb.append(", voyageNo=").append(voyageNo);
        sb.append(", billNo=").append(billNo);
        sb.append(", loctNo=").append(loctNo);
        sb.append(", licenseNo=").append(licenseNo);
        sb.append(", country=").append(country);
        sb.append(", destinationPort=").append(destinationPort);
        sb.append(", freight=").append(freight);
        sb.append(", freightCurr=").append(freightCurr);
        sb.append(", freightMark=").append(freightMark);
        sb.append(", insuredFee=").append(insuredFee);
        sb.append(", insuredFeeCurr=").append(insuredFeeCurr);
        sb.append(", insuredFeeMark=").append(insuredFeeMark);
        sb.append(", wrapType=").append(wrapType);
        sb.append(", packNo=").append(packNo);
        sb.append(", weight=").append(weight);
        sb.append(", netWeight=").append(netWeight);
        sb.append(", note=").append(note);
        sb.append(", returnStatus=").append(returnStatus);
        sb.append(", returnTime=").append(returnTime);
        sb.append(", returnInfo=").append(returnInfo);
        sb.append(", returnGuid=").append(returnGuid);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", createdByCompany=").append(createdByCompany);
        sb.append(", clearanceNo=").append(clearanceNo);
        sb.append(", enterpriseId=").append(enterpriseId);
        sb.append(", ciqAppTime=").append(ciqAppTime);
        sb.append(", ciqFlag=").append(ciqFlag);
        sb.append(", ciqReturnStatus=").append(ciqReturnStatus);
        sb.append(", ciqReturnInfo=").append(ciqReturnInfo);
        sb.append(", ciqReturnTime=").append(ciqReturnTime);
        sb.append(", ciqReturnName=").append(ciqReturnName);
        sb.append("]");
        return sb.toString();
    }
}
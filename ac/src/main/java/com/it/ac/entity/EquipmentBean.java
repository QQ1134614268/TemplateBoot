package com.it.ac.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

/**
 * 设备bean
 * private String[] lanes;//车道号
 * private String[] directionId;//方向编码
 * private String[] way;//上下行方向
 * private String[] describe;//方向描述
 */
@Table(name = EquipmentBean.tableName, isSimple = true, excludeFields = {"tableName", "lanes", "directionId", "way", "describe"})
public class EquipmentBean {
	public static final String tableName = "equipment";
	private String id;//编号
	private String equipmentId;//设备编号
	private String longitude;//经度
	private String latitude;//纬度
	private String ip;//ip
	private String port;//端口
	private String equipmentType;//设备类型

	@Column(name = "Username")
	private String userName;//登陆名称
	private String password;//登陆密码
	private String producer;//生产厂家
	private String organization;//所属单位
	private String name;//设备名称
	private String position;//路段
	private String containdevice;//所包含设备
	@Column(name = "deploytime", type = MySqlTypeConstant.TIMESTAMP)
	private String deploytime;//安装时间
	private String equipmentState;//设备状态
	private String synchroState;//同步状态 
	private String recordType;//记录类型 0微波，1视频
	private String recordState;//记录状态 0可用 1 删除
	private String equipmentIdReport;//上报设备编号 
	private String positionCode;//道路编码

	private String[] lanes;//车道号
	private String[] directionId;//方向编码
	private String[] way;//上下行方向
	private String[] describe;//方向描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getContaindevice() {
		return containdevice;
	}

	public void setContaindevice(String containdevice) {
		this.containdevice = containdevice;
	}

	public String getEquipmentState() {
		return equipmentState;
	}

	public void setEquipmentState(String equipmentState) {
		this.equipmentState = equipmentState;
	}

	public String getSynchroState() {
		return synchroState;
	}

	public void setSynchroState(String synchroState) {
		this.synchroState = synchroState;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public String[] getLanes() {
		return lanes;
	}

	public void setLanes(String[] lanes) {
		this.lanes = lanes;
	}

	public String[] getDirectionId() {
		return directionId;
	}

	public void setDirectionId(String[] directionId) {
		this.directionId = directionId;
	}

	public String getDeploytime() {
		return deploytime;
	}

	public void setDeploytime(String deploytime) {
		this.deploytime = deploytime;
	}

	public String[] getWay() {
		return way;
	}

	public void setWay(String[] way) {
		this.way = way;
	}

	public String[] getDescribe() {
		return describe;
	}

	public void setDescribe(String[] describe) {
		this.describe = describe;
	}

	public String getEquipmentIdReport() {
		return equipmentIdReport;
	}

	public void setEquipmentIdReport(String equipmentIdReport) {
		this.equipmentIdReport = equipmentIdReport;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

}

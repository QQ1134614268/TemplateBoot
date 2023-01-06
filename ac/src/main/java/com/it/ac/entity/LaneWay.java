package com.it.ac.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import lombok.Data;

/**
 * 设备bean
 * private String[] lanes;//车道号
 * private String[] directionId;//方向编码
 * private String[] way;//上下行方向
 * private String[] describe;//方向描述
 */
@Data
@Table(name = LaneWay.tableName, isSimple = true, excludeFields = {"tableName",})
public class LaneWay {
	public static final String tableName = "Lane_Way";
	private String id;
	private String equiId;
	private String lane;
	private String directionId;
	private String way;
	private String describe;
}

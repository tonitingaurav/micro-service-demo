package com.tonitingaurav.microservice.model;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tonitingaurav.microservice.enums.AssetType;
import com.tonitingaurav.microservice.enums.Condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Asset {

	@Size(min = 6)
	@ApiModelProperty(value = "Asset unique ID", example = "ewrtr-gfhj-yytr-46ghp")
	private String assetId;

	// https://www.baeldung.com/javax-validations-enums -- Follow this to put enum
	// validations
	@NotNull
	@ApiModelProperty(value = "Type of the Asset", example = "LAPTOP")
	private AssetType assetType;

	@NotNull
	@ApiModelProperty(value = "Condition of the Asset", example = "NEW")
	private Condition assetCondition;

	@Past
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Purchase date of Asset", example = "2020-01-01")
	private Date purchaseDate;

	@FutureOrPresent
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "Expiry date of Asset", example = "2099-12-31")
	private Date expireDate;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public AssetType getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}

	public Condition getAssetCondition() {
		return assetCondition;
	}

	public void setAssetCondition(Condition assetCondition) {
		this.assetCondition = assetCondition;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
}

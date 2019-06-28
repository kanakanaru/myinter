package com.internousdev.green.dto;

public class MCategoryDTO {

	//カテゴリーマスタテーブルのカラム名に対応したフィールドです。
	private int id;              /* ID */
	private int categoryId;      /* カテゴリーID */
	private String categoryName; /* カテゴリー名 */
	private String categoryDesc; /* カテゴリー詳細 */

	//以下、各フィールドのgetterとsetterです。

	//id（ID）
	public int getId(){
		return this.id;
	}

	public void setId(int id){
		this.id =id;
	}

	//categoryId（カテゴリーID）
	public int getCategoryId(){
		return this.categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	//categoryName（カテゴリー名）
	public String getCategoryName(){
		return this.categoryName;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	//categoryDesc（カテゴリー詳細）
	public String getCategoryDesc(){
		return this.categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc){
		this.categoryDesc = categoryDesc;
	}

}

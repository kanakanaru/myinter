package com.internousdev.green.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.green.dao.MCategoryDAO;
import com.internousdev.green.dao.ProductInfoDAO;
import com.internousdev.green.dto.MCategoryDTO;
import com.internousdev.green.dto.ProductInfoDTO;
import com.internousdev.green.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;  /* セッション変数 */
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();  /* 商品情報のリスト（商品一覧用） */
	private List<String> keywordsErrorMessageList; /* 検索エラーメッセージ */
	private String keywords;   /* 検索ワード */
	private String categoryId; /* 商品カテゴリーID */

	public String execute(){

		ProductInfoDAO dao = new ProductInfoDAO();
		InputChecker ic = new InputChecker();

		//カテゴリー情報が受け取れなかった場合、「すべてのカテゴリー」と解釈する。
		if (categoryId == null) {
			categoryId = "1";
		}

		//検索ワードが受け取れなかった場合、空文字と解釈する。
		if(keywords == null){
			keywords = "";
		}

		//カテゴリーのセッションが切れている場合、カテゴリー情報を再取得する。
		if(!session.containsKey("mCategory")){
			MCategoryDAO Mdao = new MCategoryDAO();
			List<MCategoryDTO> mCategory =  Mdao.getCategoryInfo();
			session.put("mCategory", mCategory);
		}

		//検索ワードが入力されている場合、入力チェックを行う。
		//空文字検索の場合、全件検索させるために入力チェックは行わない。
		if (!keywords.equals("")) {
			keywordsErrorMessageList = ic.doCheck("検索ワード", keywords, 0, 50, true, true, true, true, false, true, true);
		}

		keywords = keywords.replaceAll("　+", " ").replaceAll(" +"," ").trim();    //全角スペース部分を半角スペースに置換。
		String[] keyword = keywords.split("\\s+");                                 //空白文字を区切りとして配列に格納。

		//カテゴリーIDと検索ワードを用いて商品情報を取得。
		if(categoryId.equals("1")){                                                //すべてのカテゴリーで検索している場合
			productInfoDTOList = dao.getProductInfoListByKeyword(keyword);
		}else{                                                                     //特定のカテゴリーを選んで検索している場合
			productInfoDTOList = dao.getProductInfoListByCategoryIdAndKeyword(keyword, categoryId);
		}

		return SUCCESS;  //商品一覧画面に遷移
	}

	//以下、各フィールドのgetterとsetterです。

	//session（セッション変数）
	public Map<String,Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	//productInfoDTOList（商品情報リスト）
	public List<ProductInfoDTO> getProductInfoDTOList(){
		return this.productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList){
		this.productInfoDTOList = productInfoDTOList;
	}

	//keywordsErrorMessage（検索エラーメッセージ）
	public List<String> getKeywordsErrorMessageList(){
		return this.keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	//keywords（検索ワード）
	public String getKeywords(){
		return this.keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	//categoryId（商品カテゴリーID）
	public String getCategoryId(){
		return this.categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
}

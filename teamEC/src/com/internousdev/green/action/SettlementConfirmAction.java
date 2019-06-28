package com.internousdev.green.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.green.dao.CartInfoDAO;
import com.internousdev.green.dao.DestinationInfoDAO;
import com.internousdev.green.dto.CartInfoDTO;
import com.internousdev.green.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;  /* セッション変数 */
	private ArrayList<DestinationInfoDTO> dtoList = new ArrayList<DestinationInfoDTO>();  /* 宛先情報のリスト */
	private DestinationInfoDAO Ddao = new DestinationInfoDAO(); /* DestinationInfoDAOのインスタンス */
	private CartInfoDAO Cdao = new CartInfoDAO();  /* CartInfoDAOのインスタンス */

	public String execute(){

		//未ログイン時はログイン画面へ、ログイン時は宛先情報テーブルに接続し、宛先情報を取得する。
		if(!session.containsKey("loginFlg")){
			session.put("fromCart", "fromCart");
			return "login";
		}else{
			//ユーザーIDを比較して宛先情報を取得
			dtoList = Ddao.getDestinationInfo(session.get("userId").toString());

			//ユーザーIDを比較してカート情報を取得
			ArrayList<CartInfoDTO> cartInfoList =Cdao.getCartInfoList(session.get("userId").toString());
			session.put("cartInfoList", cartInfoList);

			return SUCCESS; //宛先情報選択・削除画面に遷移
		}
	}

	//以下は、各フィールドのgetterとsetterです。

	//session（セッション変数）
	public Map<String,Object> getSession(){
		return this.session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	//dtoList（宛先情報のリスト）
	public ArrayList<DestinationInfoDTO> getDtoList(){
		return this.dtoList;
	}

	public void setDetList(ArrayList<DestinationInfoDTO> dtoList){
		this.dtoList = dtoList;
	}

}

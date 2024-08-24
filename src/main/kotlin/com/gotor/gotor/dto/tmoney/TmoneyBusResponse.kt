package com.gotor.gotor.dto.tmoney

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class TmoneyBusResponse(
    val code: String,
    val message: String,
    val response: Response
)

data class Response(
    @SerializedName("sub_result_list")
    val subResultList: List<SubResult>
)

data class SubResult(
    @SerializedName("rem_cnt")
    val remainingCount: String,
    @SerializedName("tck_pay")
    val ticketPay: String,
    @SerializedName("tim_tim")
    val departTime: String,
)

fun getMockData(): TmoneyBusResponse {
    val jsonData = """
{
  "code": "00000",
  "message": "정상",
  "response": {
    "sub_result_list": [
      {
        "chld_sfty_sats_yn": "N",
        "ter_to_i": "230",
        "rem_cnt": "28",
        "tck_pay": "Y",
        "tck_pay_mob": "N",
        "bus_gra_o": "1",
        "tic_cod": "Y",
        "message": "",
        "alcn_dvs_cd": "0",
        "ter_to_o": "230",
        "prvt_bbiz_emp_acmt_rt": "N",
        "ter_fr_i": "010",
        "dspr_sats_yn": "N",
        "ter_fr_o": "010",
        "ter_pfr": "N",
        "seq": "0",
        "sys_div": "K",
        "tim_tim_o": "1100",
        "cor_nam": "동부고속",
        "tim_dte": "20181024",
        "cor_cod_o": "02",
        "cty_prmm_dc_yn": "Y",
        "tim_tim": "1100",
        "alcn_rot_no": "0001",
        "app_div": "0",
        "web_cnt": "28"
      },
      {
        "chld_sfty_sats_yn": "N",
        "ter_to_i": "230",
        "rem_cnt": "28",
        "tck_pay": "Y",
        "tck_pay_mob": "N",
        "bus_gra_o": "1",
        "tic_cod": "Y",
        "message": "",
        "alcn_dvs_cd": "0",
        "ter_to_o": "230",
        "prvt_bbiz_emp_acmt_rt": "N",
        "ter_fr_i": "010",
        "dspr_sats_yn": "N",
        "ter_fr_o": "010",
        "ter_pfr": "Y",
        "seq": "1",
        "sys_div": "K",
        "tim_tim_o": "1130",
        "cor_nam": "동부고속",
        "tim_dte": "20181024",
        "cor_cod_o": "02",
        "cty_prmm_dc_yn": "Y",
        "tim_tim": "1130",
        "alcn_rot_no": "0002",
        "app_div": "0",
        "web_cnt": "28"
      },
      {
        "chld_sfty_sats_yn": "N",
        "ter_to_i": "230",
        "rem_cnt": "28",
        "tck_pay": "Y",
        "tck_pay_mob": "N",
        "bus_gra_o": "1",
        "tic_cod": "Y",
        "message": "",
        "alcn_dvs_cd": "0",
        "ter_to_o": "230",
        "prvt_bbiz_emp_acmt_rt": "N",
        "ter_fr_i": "010",
        "dspr_sats_yn": "N",
        "ter_fr_o": "010",
        "ter_pfr": "N",
        "seq": "2",
        "sys_div": "K",
        "tim_tim_o": "1200",
        "cor_nam": "동부고속",
        "tim_dte": "20181024",
        "cor_cod_o": "02",
        "cty_prmm_dc_yn": "Y",
        "tim_tim": "1200",
        "alcn_rot_no": "0001",
        "app_div": "0",
        "web_cnt": "28"
      }
    ]
  }
}
"""
    return Gson().fromJson(jsonData, TmoneyBusResponse::class.java)
}





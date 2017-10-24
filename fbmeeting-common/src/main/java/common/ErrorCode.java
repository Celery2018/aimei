package common;

/**
 * 错误码通用类
 * 请用如下格式命名：
 *
 * 业务层次_业务逻辑_序列号/业务说明
 */
public enum ErrorCode {
  NO_ERROR("success", 100),
  NO_ERROR_WITHPARAM("suc", 0),
  PARAM_ERROR("param error", 109),
  TIME_OUT("token is timeout! ",103),
  TOKEN_ERROR("token error!",102),
  CONF_NOT_EXIST("this conf is not exist!",104);




  private String errorMsg;
  private int errorCode;

  // 构造方法
  private ErrorCode(String errorMsg, int errorCode) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public int getErrorCode() {
    return errorCode;
  }

  //覆盖方法
  @Override
  public String toString() {
    return "{errorCode:" + this.errorCode + ",errorMsg:" + this.errorMsg + "}";
  }
}
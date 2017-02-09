package net.learn.util;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/* 错误码，默认为0 */
	private int errCode;

	/* 错误子码，自定义该值 */
	private String errSubCode;

	private String operate;

	public ServiceException() {
		super();
	}

	public ServiceException(String detail) {
		super(detail);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String errSubCode, String message) {
		super(message);
		this.setErrCode(0);
		this.setErrSubCode(errSubCode);
	}

	/**
	 * <默认构造函数>
	 */
	public ServiceException(int errCode, String errSubCode, String message) {
		super(message);
		this.setErrCode(errCode);
		this.setErrSubCode(errSubCode);
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrSubCode() {
		return errSubCode;
	}

	public void setErrSubCode(String errSubCode) {
		this.errSubCode = errSubCode;
	}

}

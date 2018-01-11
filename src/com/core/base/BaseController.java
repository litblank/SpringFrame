package core.base;


/**
 * 
 * @author chenyd
 * 2017年10月12日
 */
public abstract class BaseController {

	/**
	 * ajax失败
	 * 
	 * @param msg
	 *            失败的消息
	 * @return {Object}
	 */
	public Object renderError(String msg) {
		Result result = new Result();
		result.setMsg(msg);
		return result;
	}

	/**
	 * ajax失败
	 * 
	 * @param msg
	 *            失败的消息
	 * @return {Object}
	 */
	public Object renderError() {
		Result result = new Result();
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @return {Object}
	 */
	public Object renderSuccess() {
		Result result = new Result();
		result.setSuccess(true);
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @param msg
	 *            消息
	 * @return {Object}
	 */
	public Object renderSuccess(String msg) {
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(msg);
		return result;
	}

	/**
	 * ajax成功
	 * 
	 * @param obj
	 *            成功时的对象
	 * @return {Object}
	 */
	public Object renderSuccess(Object obj) {
		Result result = new Result();
		result.setSuccess(true);
		result.setObj(obj);
		return result;
	}
}

package mine.core.pictureCheckCode.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.core.pictureCheckCode.util.CreatePictureCheckCode;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CheckCodeAction extends ActionSupport {

	public void codePicture() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		// 设置不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expirs", 0);

		response.setContentType("image/jpeg");
		CreatePictureCheckCode.getPictureCheckCode(request, response);
	}

}

package mine.plugins.uploadify.servlet;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Uploadify extends HttpServlet {
	/**
	 * �ļ��ϴ�
	 */
	private static final long serialVersionUID = 2384326745121073713L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------------------UpLoadify-doPost");
		System.out.println("-------------------QueryString::::"+ request.getQueryString());
		System.out.println("*******************getParameter('folder'):::"+request.getParameter("folder"));
		/*���û������folder��return;��������*/
		if (request.getParameter("folder") == null|| request.getParameter("folder") == "") {
			System.out.println("-------------------request.getParameter('folder')::::"+ request.getParameter("folder") + " then return");
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		/*��ȡ��ʵ��Ŀ��·��*/
		String path = this.getServletContext().getRealPath("/");
		System.out.println("*******************getRealPath:::"+path);
		/*��ȡ�ļ�����ļ�������*/
		String fileD = request.getParameter("folder");
		/*��������ʼ���ļ���Դ���·��*/
		String sourcePath = path + "upload/source/";
		/*�����ϴ��ļ����·��*/
		path = path + "upload/" + fileD + "/";
		System.out.println("-------------------UpLoadify-path::::" + path);
		File folder = new File(path);
		File sourceFolder = new File(sourcePath);
		/*�ж��ļ��в��������½��ļ���*/
		if (!folder.exists()) {
			System.out.println("-------------------UpLoadify::::" + "�����ļ���"+ fileD);
			folder.mkdirs();
		}
		/*�ж���Դ�ļ��в��������½��ļ���*/
		if (!sourceFolder.exists()) {
			System.out.println("-------------------UpLoadify::::"+ "�����ļ���source");
			sourceFolder.mkdirs();
		}
		ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
		sfu.setHeaderEncoding("UFT-8");
		try {
			List<?> fileList = sfu.parseRequest(request);
			String sourceName = "";
			String extName = "";
			String name = "";
			String sfileName = "";
			for (int i = 0; i < fileList.size(); i++) {
				System.out.println("-------------------UpLoadify fileList[" + i
						+ "]::::" + fileList.get(i));
				FileItem fi = (FileItem) fileList.get(i);
				if (!fi.isFormField()) {
					sourceName = fi.getName();
					System.out.println("-------------------UpLoadify name::::"
							+ sourceName);
					if (sourceName == null || "".equals(sourceName.trim())) {
						continue;
					}
					if (sourceName.lastIndexOf(".") >= 0) {
						// ��չ��
						name = sourceName.substring(0,
								sourceName.lastIndexOf("."));
						extName = sourceName.substring(sourceName
								.lastIndexOf("."));
						System.out
								.println("-------------------UpLoadify extName::::"
										+ extName);
					}
					// �ļ������� ǰ׺ + ʱ�� + ��λ����� + �ļ�����(��ʶͼƬ�ߴ�) + ��չ��
					Calendar ca = Calendar.getInstance();
					DecimalFormat df = new DecimalFormat();
					df.setMinimumIntegerDigits(2);
					String st = "zxy";
					if (st != null && st.length() > 6) {
						st = st.substring(0, 6);
					}
					String dateTime = ca.get(Calendar.YEAR) + ""
							+ df.format(ca.get(Calendar.MONTH)) + ""
							+ df.format(ca.get(Calendar.DATE)) + ""
							+ df.format(ca.get(Calendar.HOUR)) + ""
							+ df.format(ca.get(Calendar.MINUTE)) + ""
							+ df.format(ca.get(Calendar.SECOND));
					Random rand = new Random();
					int rand_num = rand.nextInt(89) + 10;
					String fileName = st + "_" + dateTime + "_" + rand_num
							+ extName;
					sfileName = name + "_" + dateTime + "_" + rand_num
							+ extName;
					File saveSourceFile = new File(sourcePath + sfileName);
//					File saveFile = new File(path + fileName);
					System.out.println(sourcePath + sfileName);
					System.out.println(path + fileName);
					fi.write(saveSourceFile);
					// fi.write(saveFile);
					System.out
							.println("-------------------UpLoadify fileSourceName::::"
									+ sourceName);
					System.out
							.println("-------------------UpLoadify fileName::::"
									+ fileName);
				}
			}
			System.out.println("sfileName--" + sfileName);
			response.getWriter().println(sfileName);
		} catch (FileUploadException e) {
			response.getWriter().println("0");
			e.printStackTrace();
		} catch (Exception e) {
			response.getWriter().println("0");
			e.printStackTrace();
		}
	}
}

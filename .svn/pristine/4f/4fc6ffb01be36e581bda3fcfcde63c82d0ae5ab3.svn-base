/**   
* @Title: UploadController.java 
* @Package com.movingcq.controller 
* @Description: TODO(用一句话描述该文件做什么) 
* @author IsProjo
* @date 2016年12月9日 下午4:28:28 
* @version V1.0   
*/
package com.movingcq.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.movingcq.service.IDriverInfoService;
import com.movingcq.service.IRestInfoService;
import com.movingcq.util.ApiResult;
import com.movingcq.util.StringUtil;

/**
 * @ClassName: UploadController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author IsProjo
 * @date 2016年12月9日 下午4:28:28
 * 
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	Object rObject = null;
	int isSucc = 0;
	@Resource
	private IRestInfoService restInfoService;

	@Resource
	private IDriverInfoService driverInfoService;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */

	public UploadController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("toUpload")
	public Object toUpload(HttpServletRequest request) {
		String uuid = request.getParameter("code");
		String folderName = request.getParameter("folderName");
		String uploadNum = request.getParameter("uploadNum");
		String id = request.getParameter("id");
		String uploadType = request.getParameter("uploadType");
		try {
			folderName = new String(folderName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(uuid);
		request.setAttribute("uuid", uuid);
		request.setAttribute("folderName", folderName);
		request.setAttribute("uploadNum", uploadNum);
		request.setAttribute("id", id);
		request.setAttribute("uploadType", uploadType);
		return "upload";
	}

	@RequestMapping(path = "/start", method = RequestMethod.POST)
	public Object upload(@RequestParam("file") CommonsMultipartFile upfile, HttpServletRequest req, ModelMap model)
			throws IOException {

		String id = req.getParameter("id");
		String folderName = req.getParameter("folderName");
		String uuid = req.getParameter("code");
		String uploadType = req.getParameter("uploadType");
		// String path =
		// req.getSession().getServletContext().getRealPath("/file/" +
		// folderName);
		String basePath = getClass().getResource("/").getFile().toString();
		String path = basePath + "/file/" + folderName;
		String fileName = new Date().getTime() + "_" + upfile.getOriginalFilename();

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			upfile.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = "/file/" + folderName + "/" + fileName;

		if (uploadType.equals("pic")) {// 上传司机照片
			if (id == null || "".equals(id)) {
				isSucc = driverInfoService.insertByCode(uuid, fileName, filePath);
			} else {
				isSucc = driverInfoService.updateFilePath(uuid, fileName, filePath);
			}

		} else {// restInfo上传文件
			if (id == null || "".equals(id)) {
				isSucc = restInfoService.insertByCode(uuid, fileName, filePath);
			} else {
				isSucc = restInfoService.updateFilePath(uuid, fileName, filePath);
			}
		}

		if (isSucc > 0) {
			model.addAttribute("result", "<span class='succ'>上传成功</span>");
		} else {
			model.addAttribute("result", "<span class='fail'>上传失败</span>");
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("filePath", filePath);
		model.addAttribute("uuid", uuid);
		return "result";
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public Object update(@RequestParam("file") CommonsMultipartFile upfile, HttpServletRequest req, ModelMap model)
			throws IOException {

		String folderName = req.getParameter("folderName");
		String uuid = req.getParameter("code");
		String basePath = getClass().getResource("/").getFile().toString();
		String path = basePath + "/file/" + folderName;
		String fileName = new Date().getTime() + "_" + upfile.getOriginalFilename();
		String uploadType = req.getParameter("uploadType");
		System.out.println(path);

		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			upfile.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String filePath = "/file/" + folderName + "/" + fileName;

		if (uploadType.equals("pic")) {// 更新司机照片

			isSucc = driverInfoService.updateFilePath(uuid, fileName, filePath);
		} else {// restInfo更新文件
			isSucc = restInfoService.updateFilePath(uuid, fileName, filePath);
		}

		if (isSucc > 0) {
			model.addAttribute("result", "<span class='succ'>上传成功</span>");
		} else {
			model.addAttribute("result", "<span class='fail'>上传失败</span>");
		}
		model.addAttribute("fileName", fileName);
		model.addAttribute("filePath", filePath);
		model.addAttribute("uuid", uuid);
		return "result";
	}

	@ResponseBody
	@RequestMapping("delfile")
	public Object delfile(HttpServletRequest request) {

		String code = request.getParameter("uuid");
		String uploadType = request.getParameter("uploadType");
		if (uploadType != null && !"".equals(uploadType) && uploadType.equals("pic")) {
			isSucc = driverInfoService.updateFilePath(code, "", "");
		} else {
			isSucc = restInfoService.updateFilePath(code, "", "");
		}

		if (isSucc > 0) {
			rObject = new ApiResult("删除成功", ApiResult.CODE_SUCCESS);
		} else {
			rObject = new ApiResult("删除失败", ApiResult.CODE_FAIL);
		}
		return rObject;
	}

	@SuppressWarnings("resource")
	@RequestMapping("download")
	public void download(HttpServletResponse response, HttpServletRequest request) {
		String basePath = getClass().getResource("/").getFile().toString();
		String folderName = request.getParameter("folderName");
		String fileName = request.getParameter("name");
		try {
			folderName = new String(folderName.getBytes("ISO-8859-1"), "UTF-8");
			fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String path = basePath + "file/" + folderName + "/" + fileName;

		String gbkFileName = StringUtil.parseGBK(fileName);
		String gbkPath = basePath + "file/" + StringUtil.parseGBK(folderName) + "/" + gbkFileName;

		try {
			response.setContentType("application/x-msdownload;charset=uft-8");
			response.setHeader("Location", gbkPath);
			response.setHeader("Content-Disposition", "attachment; filename=" + gbkFileName);
			OutputStream outputStream = response.getOutputStream();
			InputStream inputStream = new FileInputStream(path);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e1) {
			System.out.println("没有找到您要的文件");
		} catch (Exception e) {
			System.out.println("系统错误，请及时与管理员联系");
		}
	}

	@RequestMapping("downFile")
	public void downFile(HttpServletResponse response, HttpServletRequest request) {

		String basePath = request.getSession().getServletContext().getRealPath("/");
		String folderName = request.getParameter("folderName");
		// 获得请求文件名
		String fileName = request.getParameter("name");
		fileName = toUtf8String(request, fileName);
		String filePath = basePath + "file/" + folderName + "/" + fileName;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			File fileInstance = new File(filePath);
			if (!fileInstance.exists()) {
				System.err.println("---------下载文件不存在，请联系管理员-------------");
			} else {
				bis = new BufferedInputStream(new FileInputStream(fileInstance));
				bos = new BufferedOutputStream(response.getOutputStream());

				byte[] buff = new byte[2048];

				response.setContentType("APPLICATION/OCTET-STREAM; charset=UTF-8");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

				int bytesRead;
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
				bos.close();
				bis.close();
			}

		} catch (IOException e) {
			System.err.println("文件下载出现Exception:" + e);
			try {
				throw new Exception("file【" + filePath + "】 not found" + e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if (bos != null) {
				IOUtils.closeQuietly(bos);
			}
			if (bis != null) {
				IOUtils.closeQuietly(bis);
			}
		}

	}

	/**
	 * 根据不同浏览器将文件名中的汉字转为UTF8编码的串,以便下载时能正确显示另存的文件名.
	 * 
	 * @param s
	 *            原文件名
	 * @return 重新编码后的文件名
	 */
	public static String toUtf8String(HttpServletRequest request, String s) {
		String agent = request.getHeader("User-Agent");
		try {
			boolean isFireFox = (agent != null && agent.toLowerCase().indexOf("firefox") != -1);
			if (isFireFox) {
				s = new String(s.getBytes("UTF-8"), "ISO8859-1");
			} else {
				s = toUtf8String_(s);
				if ((agent != null && agent.indexOf("MSIE") != -1)) {
					// see http://support.microsoft.com/default.aspx?kbid=816868
					if (s.length() > 150) {
						// 根据request的locale 得出可能的编码
						s = new String(s.getBytes("UTF-8"), "ISO8859-1");
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String toUtf8String_(String s) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					System.err.println("将文件名中的汉字转为UTF8编码的串时错误，输入的字符串为：" + s);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

}

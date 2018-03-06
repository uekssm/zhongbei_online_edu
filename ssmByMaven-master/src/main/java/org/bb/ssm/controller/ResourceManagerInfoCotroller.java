package org.bb.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bb.ssm.model.ResourceManager;
import org.bb.ssm.model.Role;
import org.bb.ssm.service.FirstBaseInfoService;
import org.bb.ssm.service.ResourceManagerInfoService;
import org.bb.ssm.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/resourceManager")
public class ResourceManagerInfoCotroller {

	@Autowired
	private ResourceManagerInfoService resourceManagerInfoService;

	@Autowired
	private RoleInfoService roleInfoService;

	@Autowired
	private FirstBaseInfoService firstBaseInfoService;

	/**
	 * 资源列表页
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String index(
			Map<String, Object> map,
			@RequestParam(value = "pid", required = false, defaultValue = "0") Integer pid,
			@RequestParam(value = "ppid", required = false, defaultValue = "0") Integer ppid) {

		System.out.println("---------------------"+pid);
		
		// 点击文件夹再次进入此方法会传入文件名及父目录，填充到页面，并在获取数据时充当参数
		List<ResourceManager> allResources = resourceManagerInfoService
				.finddir();

		List<ResourceManager> childResources = new ArrayList<ResourceManager>();
		for (ResourceManager resourceManager : allResources) {
			// 对象获取属性值为null时会出问题，待处理
			if (resourceManager.getId() == pid) {
				childResources.add(resourceManager);
				map.put("id", resourceManager.getPid());
				for (ResourceManager resourceManager1 : allResources) {
					// 对象获取属性值为null时会出问题，待处理
					if (resourceManager1.getId() == resourceManager.getPid()) {
						map.put("iid", resourceManager1.getPid());
						break;
					}

				}
				break;
			}

		}
		if(ppid!=0){
			childResources=dir(allResources, childResources, ppid);
		}
		
		Collections.reverse(childResources);
		System.out.println(childResources);
		map.put("folderList", childResources);
		
		
		map.put("pid", pid);
		map.put("ppid", ppid);

		return "bui/acdemic/resourceManagerList";
	}

	public List<ResourceManager> dir(List<ResourceManager> allResources,List<ResourceManager> childResources,Integer pid){
		for (ResourceManager resourceManager : allResources) {
			// 对象获取属性值为null时会出问题，待处理
			if (resourceManager.getId() == pid && resourceManager.getType()==0) {
				childResources.add(resourceManager);
				childResources=dir(allResources, childResources, resourceManager.getPid());
			}

		}
		return childResources;
		
	}
	
	
	// /**
	// * 资源列表页
	// * @param map
	// * @return
	// */
	// @RequestMapping(value="/index", method =
	// {RequestMethod.POST,RequestMethod.GET})
	// public String index(Map<String, Object>
	// map,@RequestParam(value="foldername", required = false, defaultValue =
	// "") String foldername,@RequestParam(value="pid", required = false,
	// defaultValue = "0") Integer pid) {
	// System.out.println(foldername);
	//
	// if(!foldername.isEmpty()){
	// //点击文件夹再次进入此方法会传入文件名及父目录，填充到页面，并在获取数据时充当参数
	// List<ResourceManager> list=resourceManagerInfoService.finddir();
	// List<ResourceManager> list1=new ArrayList<ResourceManager>();
	// for (ResourceManager resourceManager : list) {
	// //对象获取属性值为null时会出问题，待处理
	// if(resourceManager.getName().equals(foldername)==true &&
	// resourceManager.getPid().equals(pid)==true){
	// list1.add(resourceManager);
	//
	//
	// for (ResourceManager resourceManager1 : list) {
	// if(resourceManager1.getPid()==resourceManager.getId()){
	// list1.add(resourceManager1);
	// for (ResourceManager resourceManager2 : list) {
	// if(resourceManager2.getPid()==resourceManager.getId()){
	// list1.add(resourceManager2);
	//
	// break;
	// }
	// }
	// break;
	// }
	// }
	// break;
	// }
	//
	// }
	// System.out.println(list1);
	// map.put("folderList", list1);
	//
	// }
	//
	// return "bui/acdemic/resourceManagerList";
	// }

	@RequestMapping(value = "/makedir", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String makedir(
			@RequestParam(value = "pid", required = false, defaultValue = "0") Integer pid,
			@RequestParam("parentdir") String parentdir,
			@RequestParam("foldername") String foldername,
			HttpServletRequest request) throws IOException {

		String uploadPath = request.getSession().getServletContext()
				.getRealPath("");
		// String uploadPath =
		// request.getSession().getServletContext().getRealPath("http://localhost:8080/ssmStage/resourse/upload");
		String targetFile = uploadPath + "/" + parentdir + foldername;
		// targetFile = "http://localhost:8080/ssmStage/resourse/upload" + "/" +
		// "upload1.mp4";

		ResourceManager resourceManagerinfo = new ResourceManager();
		resourceManagerinfo.setName(foldername);
		resourceManagerinfo.setPid(pid);
		/* resourceManagerinfo.setSize(size); */
		resourceManagerinfo.setType(0);
		resourceManagerinfo.setUrl(parentdir + foldername);
		// resourceManagerinfo.setAddtime(addtime);
		Date date=new Date();  
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		resourceManagerinfo.setAddtime(format.getDateInstance().format(date));
		
		int result = resourceManagerInfoService.insert(resourceManagerinfo);

		File file = new File(targetFile);
		file.mkdir();
		// return "{\"url\" : \"" + fileName + "\"}";
		return "{\"url\" : \"/resourse/manager/" + foldername + "\"}";

	}

	@RequestMapping(value = "/fileUpload", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public String fileUpload(@RequestParam(value = "pid", required = false, defaultValue = "0") Integer pid,@RequestParam("parentdir") String parentdir,
			@RequestParam MultipartFile myfile, HttpServletRequest request)
			throws IOException {

		String uploadPath = request.getSession().getServletContext()
				.getRealPath("");
		// String uploadPath =
		// request.getSession().getServletContext().getRealPath("http://localhost:8080/ssmStage/resourse/upload");
		String fileName = myfile.getOriginalFilename();
		System.out.println(fileName);
		String targetFile = uploadPath + "/" + parentdir + fileName;
		// targetFile = "http://localhost:8080/ssmStage/resourse/upload" + "/" +
		// "upload1.mp4";

		ResourceManager resourceManagerinfo = new ResourceManager();
		resourceManagerinfo.setName(fileName);
		
		
		DecimalFormat df = new DecimalFormat("#.00"); 
        String fileSizeString = ""; 
        if (myfile.getSize() < 1024) { 
            fileSizeString = df.format((double) myfile.getSize()) + "B"; 
        } else if (myfile.getSize() < 1048576) { 
            fileSizeString = df.format((double) myfile.getSize() / 1024) + "K"; 
        } else if (myfile.getSize() < 1073741824) { 
            fileSizeString = df.format((double) myfile.getSize() / 1048576) + "M"; 
        } else { 
            fileSizeString = df.format((double) myfile.getSize() / 1073741824) + "G"; 
        } 
		resourceManagerinfo.setSize(fileSizeString);
		
		resourceManagerinfo.setPid(pid);
		resourceManagerinfo.setType(1);
		resourceManagerinfo.setUrl(parentdir + fileName);
		Date date=new Date();  
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		resourceManagerinfo.setAddtime(format.getDateInstance().format(date));
		int result = resourceManagerInfoService.insert(resourceManagerinfo);

		byte[] bs = myfile.getBytes();
		File file = new File(targetFile);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bs);
		fos.close();

		// return "{\"url\" : \"" + fileName + "\"}";
		return "{\"url\" : \"/resourse/manager/" + fileName + "\"}";

	}

	/**
	 * 得到所有资源信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/getAllResourceManager", method = {
			RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String getAllResourceManager(
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex,
			@RequestParam(value = "searchname", required = false) String searchname,
			@RequestParam(value = "pid", required = false, defaultValue = "0") Integer pid) {
		pageIndex = pageIndex * limit;
		List<ResourceManager> resourceManagerList = resourceManagerInfoService
				.findAll(limit, pageIndex, searchname, pid);

		HashMap<String, Object> tResourceManager = new HashMap<String, Object>();

		tResourceManager.put("rows", resourceManagerList);
		tResourceManager.put("results",
				resourceManagerInfoService.totalCount(searchname, pid));

		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsondata = mapper.writeValueAsString(tResourceManager);

			// System.out.println(jsondata);

			return jsondata;

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过handler前往添加资源页面
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addResourceManager", method = RequestMethod.GET)
	public String addResourceManager(Map<String, Object> map) {
		// 因为页面使用spring的form标签，其中属性modelAttribute需要存在bean 要不会报错
		map.put("command", new ResourceManager());
		return "addResourceManager";
	}

	/**
	 * 添加资源操作
	 * 
	 * @param resourceManagerinfo
	 * @return
	 */
	@RequestMapping(value = "/addResourceManager", method = RequestMethod.POST)
	public String save(ResourceManager resourceManagerinfo) {
		int result = resourceManagerInfoService.insert(resourceManagerinfo);
		System.out.println("添加资源的操作结果为：" + result);
		return "redirect:/resourceManager/getAllResourceManager";
	}

	/**
	 * 删除资源操作
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") int id) {
		int result = resourceManagerInfoService.deleteByPrimaryKey(id);
		System.out.println("删除资源的操作结果为：" + result + "传递进来的id为：" + id);
		return "redirect:/resourceManager/getAllResourceManager";
	}

	/**
	 * 更新前先根据id找到资源信息，回显到页面上
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String input(@PathVariable(value = "id") Integer id,
			Map<String, Object> map) {
		map.put("command", resourceManagerInfoService.selectByPrimaryKey(id));
		return "addResourceManager";
	}

	@ModelAttribute
	public void getResourceManagerInfo(
			@RequestParam(value = "resourceManagerId", required = false) Integer id,
			Map<String, Object> map) {
		System.out.println("每个controller 方法都会先调用我哦");
		if (id != null) {
			System.out.println("update 操作");
			map.put("resourceManagerInfo",
					resourceManagerInfoService.selectByPrimaryKey(id));
		}
		System.out.println("insert  操作");
	}

	@RequestMapping(value = "/addResourceManager", method = RequestMethod.PUT)
	public String update(ResourceManager resourceManagerinfo) {
		resourceManagerInfoService.updateByPrimaryKey(resourceManagerinfo);
		return "redirect:/resourceManager/getAllResourceManager";
	}
}

package com.mobilecity.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobilecity.bean.LoaiSanPhamBean;
import com.mobilecity.bean.MobileBean;
import com.mobilecity.bo.BinhLuanBo;
import com.mobilecity.bo.LoaiSanPhamBo;
import com.mobilecity.bo.MobileBo;
import com.mobilecity.common.DataUntils;
import com.mobilecity.common.Pagination;

@Controller

public class MobileController {

	MobileBo mBo = new MobileBo();

	@GetMapping("/mobile")
	public String index(Model model, HttpServletRequest request) throws Exception {

		LoaiSanPhamBo lBo = new LoaiSanPhamBo();

		List<MobileBean> ds;
		String ml = request.getParameter("ml");
		String value = request.getParameter("value");
		String sapXep = request.getParameter("sapxep");
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		// lấy tổng số hàng
		int rowCount = mBo.countByKey((ml == null) ? "" : ml, (value == null) ? "" : value);
		if(rowCount ==0) {
			model.addAttribute("errTimKiem", "Không tìm thấy sản phẩm nào");
		}
		System.out.println("rowcont:" + rowCount);
		// tạo serch phân trang
		Pagination pagination = new Pagination();
		pagination.setMaLoai((ml == null) ? "" : ml);
		pagination.setSapXep(sapXep);
		pagination.setSearchValues((value == null) ? "" : value);
		pagination.setPage(page);
		pagination.setRowCount(rowCount);
		pagination.setPageSize(15);// 1 trang 9 quyển
		// System.out.println("sl dtttttttttt:"+ pagination.getPageSize());
		ds = mBo.getMobile(pagination.getMaLoai(), pagination.getSearchValues(), page, pagination.getPageSize(), sapXep);
		
		request.setAttribute("listPage", pagination.paginationResult(page));
		request.setAttribute("pagination", pagination);
		request.setAttribute("listMobile", ds);
		model.addAttribute("listLoai", lBo.getAll());
		// request.setAttribute("slSachGio",(ghBo != null)?ghBo.list.size():0);
		// request.setAttribute("dangnhap", sesion.getAttribute("dangnhap"));

		
		return "mobile/index";
	}

	@GetMapping("/mobile/detail")
	public String detail(Model model, @RequestParam(name = "id", required = false, defaultValue = "0") int id)
			throws Exception {
		
		BinhLuanBo bLuanBo = new BinhLuanBo();
		
		MobileBean mobile = mBo.getById(id);
		//lấy list bình luận theo điện thoại
		model.addAttribute("listComment", bLuanBo.getBinhLuanById(id));
		model.addAttribute("dd", LocalDateTime.now());
		
		model.addAttribute("mobile", mobile);
		return "mobile/mobile-detail";
	}

	@PostMapping("/mobile/save")
	public String save(Model model,HttpServletRequest req, RedirectAttributes redirect,
			@RequestParam(name = "edit", required = false ,defaultValue = "") String eidt ) {
		
		System.out.println("edit::"+ eidt);
		//DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = req.getServletContext().getRealPath("") + File.separator + "images_mobile";
		System.out.println(dirUrl1);
		
		 String ten =null;
		 int id =0;
		 long giaBan =0;
		 long giaNhap =0;
		 int soluong=0;
		 String mausac=null;
		 String	cameraTruoc =null;
		 String cameraSau =null;
		 String pin =null;
		 String ram =null;
		 String anh =null;
		 String anhcu =null;
		 String ngaynhap =null;
		 String cpu =null;
		 String bonho =null;
		 String manhinh =null;
		 String maloai =null;
		 boolean baohanh=false;
		
		try {			
			List<FileItem> fileItems = upload.parseRequest(req);// Lấy về các đối tượng gửi lên			
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					
					if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						System.out.println("anh:"+nameimg);
						anh = nameimg;
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = req.getServletContext().getRealPath("") + File.separator + "images_mobile";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								// kiểm tra xem ảnh đó có tồn tại trong hệ thống ko
								if(!file.exists()) {
									fileItem.write(file);// lưu file
									System.out.println("UPLOAD THÀNH CÔNG...!");
									System.out.println("Đường dẫn lưu file là: " + dirUrl);
								}
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else// Neu la control
					{
						try {
							String tentk = fileItem.getFieldName();
							switch (tentk) {
							case "ten":
								ten=  fileItem.getString("utf-8");
								break;
							case "giaBan":
								giaBan= Long.parseLong(fileItem.getString()) ;
								break;
							case "giaNhap":
								giaNhap= Long.parseLong(fileItem.getString()) ;
								break;
							case "soluong":
								soluong=  Integer.parseInt(fileItem.getString());
								break;
							case "cpu":
								cpu =  fileItem.getString("utf-8");
								break;
							case "ram":
								ram =  fileItem.getString("utf-8");
								break;
							case "bonho":
								bonho =  fileItem.getString("utf-8");
								break;
							case "pin":
								pin =  fileItem.getString("utf-8");
								break;
							case "manhinh":
								manhinh =  fileItem.getString("utf-8");
								break;
							case "cameraTruoc":
								cameraTruoc =  fileItem.getString("utf-8");
								break;
							case "cameraSau":
								cameraSau =  fileItem.getString("utf-8");
								break;
							case "baohanh":
								baohanh =  Integer.parseInt(fileItem.getString()) ==1?true:false;
								break;
							case "ngaynhap":
								ngaynhap =  fileItem.getString();
								break;
							case "maloai":
								maloai =  fileItem.getString();
								break;
							case "mausac":
								mausac =  fileItem.getString();
								break;
							case "id":
								id=  Integer.parseInt(fileItem.getString());
								break;
							case "anh":
								anhcu=  fileItem.getString();
								break;
							default:
								break;
							}
						} catch (Exception e) {
							System.out.println("lỗi:"+ e.getMessage());
						}
						
					}				
				
				}
				//thêm sách vào cơ sở dữ liệu
				try {
					System.out.println("anhcu:"+anhcu);
					SimpleDateFormat ff= new SimpleDateFormat("yyyy-MM-dd");
					 
					
					if(id == 0) {
						MobileBean m = new MobileBean(ten, giaBan,giaNhap, soluong, mausac, cameraTruoc, cameraSau, pin, ram, anh, 
								ff.parse(ngaynhap), cpu, bonho, manhinh, maloai, baohanh);
						mBo.add(m);
						System.out.println("thêm thành công");
					}else {
						MobileBean m = new MobileBean(id,ten, giaBan,giaNhap, soluong, mausac, cameraTruoc, cameraSau, pin, ram, (anh==null || anh =="")?anhcu:anh, 
								ff.parse(ngaynhap), cpu, bonho, manhinh, maloai, baohanh);
						mBo.edit(m);
						System.out.println("sua thành công");
					}
					
					
				} catch (Exception e) {
					System.out.println("lỗi: "+e.getMessage());
				}
				
				
		}catch (FileUploadException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/mobile";
	}
	
	@RequestMapping("/mobile/edit")
	public String add(Model model,HttpServletRequest req, RedirectAttributes redirect,
			@RequestParam(name = "idMobile", required = false , defaultValue = "0") int idMobile) throws Exception{
			
		LoaiSanPhamBo lBoo = new LoaiSanPhamBo();
		
		model.addAttribute("title", "Sửa thông tin điện thoại");
		model.addAttribute("mobile", mBo.getById(idMobile));
		model.addAttribute("listLoai", lBoo.getAll());	
		return "admin/quanly-mobile-add";
		
	}
	@RequestMapping("/mobile/add")
	public String add(Model model,HttpServletRequest req) throws Exception {
		
		LoaiSanPhamBo lBoo = new LoaiSanPhamBo();
		model.addAttribute("title", "Thêm mới điện thoại");
		model.addAttribute("listLoai", lBoo.getAll());
		return "admin/quanly-mobile-add";
		
	}
	@RequestMapping("/mobile/delete")
	public String delete(Model model, HttpServletRequest req,  RedirectAttributes redirect,
			@RequestParam (name = "id",required = false, defaultValue = "" ) int id,
			@RequestParam (name = "anh",required = false, defaultValue = "" ) String anh) throws Exception {
		
		
		// kiểm tra xem ảnh có tồn tại trong thư mục không nếu có thì xóa
		String dirUrl1 = req.getServletContext().getRealPath("")  + "images_mobile"+File.separator + anh ;
		System.out.println(dirUrl1);
		File file = new File(dirUrl1);
		
			if(file.delete()) {
				System.out.println("xóa file thành công");
			}else {
				System.out.println("ảnh ko tồn tại");
			}
		
		mBo.delete(id);
		return "redirect:/admin/mobile";
		
	}
}

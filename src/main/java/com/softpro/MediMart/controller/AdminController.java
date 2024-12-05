package com.softpro.MediMart.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softpro.MediMart.Doa.ProductDao;
import com.softpro.MediMart.model.Product;
import com.softpro.MediMart.model.Registration;
import com.softpro.MediMart.services.AdminLoginRepository;
import com.softpro.MediMart.services.ProductRepository;
import com.softpro.MediMart.services.RegistrationRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RegistrationRepository arrepo;
	
	@Autowired
	AdminLoginRepository aerepo;
	
	@Autowired
	ProductRepository prepo;
	
	
	@GetMapping("/home")
	public String ShowDashboard(HttpSession session, Model model, HttpServletResponse response)
	
	{
		try {
			if(session.getAttribute("userid")!=null)
			{
				
				model.addAttribute("userid", session.getAttribute("userid").toString());
				int ccount = (int)arrepo.count();
				int ecount = (int)aerepo.count();
				
				model.addAttribute("ccount", ccount);
				model.addAttribute("ecount",ecount);
				return "/admin/admindashboard";
			
			}
			else {
			       return "redirect:/adminlogin";
			}
		}
		catch (Exception e) {
			return "/admin/admindashboard";
		}
		
	}
	
	@GetMapping("/viewcustomer")
	public String ShowViewCustomer(HttpSession session, Model model, HttpServletResponse response)
	{
		try {
			
			if(session.getAttribute("userid")!=null)
			{
				model.addAttribute("userid", session.getAttribute("userid").toString());
				List<Registration> clist = arrepo.findAll();
				model.addAttribute("clist",clist);
				return "admin/viewcustomer";
				
			}
			else
			{
				return "redirect:/adminlogin";
			}
		} catch (Exception e) {
			return "redirect:/adminlogin";
		}
		
	}
	
	
	
	
	
	
	
	//add products
	@GetMapping("/addproduct")
	public String ShowAddProduct(HttpSession session, Model model, HttpServletResponse response)
	{
		try {
			ProductDao productDao = new ProductDao();
			model.addAttribute("productDao", productDao);
			if(session.getAttribute("userid")!=null)
			{
				model.addAttribute("userid", session.getAttribute("userid").toString());
			    return "/admin/addproduct";	
			}
			else {
				return"redirect:/adminlogin";
			}
		} catch (Exception e) {
			return "/admin/addproduct";
		}
		
	}
	
    @PostMapping("/addproduct")
	public String AddProducts(HttpSession session, Model model, @ModelAttribute ProductDao productDao, RedirectAttributes redirectAttributes, HttpServletResponse response)
    
	{
    	try {
			
    		if(session.getAttribute("userid")!=null)
    		{
    			model.addAttribute("userid", session.getAttribute("userid").toString());
    			MultipartFile image = productDao.getPimage();
    			String storageFileName = new Date().getTime()+"-"+image.getOriginalFilename();
    			String UploadDir = "public/products/";
    			Path uploadPath = Paths.get(UploadDir);
    			
    			if(!Files.exists(uploadPath))
    			{
    				Files.createDirectories(uploadPath);
    			}
    			try(InputStream inputStream = image.getInputStream())
    			{
    				Files.copy(inputStream, Paths.get(UploadDir+storageFileName), StandardCopyOption.REPLACE_EXISTING);
    			}
    			
    			Product product = new Product();
    			product.setPid(productDao.getPid());
    			product.setPname(productDao.getPname());
    			product.setPdesc(productDao.getPdesc());
    			product.setPprice(productDao.getPprice());
    			product.setPimage(storageFileName);
    			prepo.save(product);
    			redirectAttributes.addFlashAttribute("message","product Added Successful");
    			return "/admin/addproduct";
    		}
    		else {
    			return "redirect:/adminlogin";
    		}
		} catch (Exception e) {
			return "redirect:/adminlogin";
		}
    	
	}
    @GetMapping("/adminlogout")
    public String AdminLogout(HttpSession session)
    {
    	session.invalidate();
    	return"redirect:/adminlogin";
    }
}

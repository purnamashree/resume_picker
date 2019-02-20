package com.sagarsoft.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.beans.Statement;
import java.io.*;
import com.sagarsoft.common.DBConnection;
@WebServlet("/downloadFileServlet")
public class UploadResumeService extends HttpServlet{
	public Connection connection;
	SuperAdminService superAdminService;
	// size of byte buffer to send file
    private static final int BUFFER_SIZE = 4096;   
     
	public void init() throws ServletException{
		connection=DBConnection.getCon();
		superAdminService = new SuperAdminService();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String resume_id = null;
		
		
		File file=new File(req.getParameter("fileupload"));
		//Part filePart = req.getPart("fileupload"); // Retrieves <input type="file" name="file">
	    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    //InputStream fileContent = filePart.getInputStream();
		try {
			
			PreparedStatement preparedStatement2 = connection.prepareStatement("select seq_resume.nextval from dual");
			ResultSet resultSet2=preparedStatement2.executeQuery();
			while(resultSet2.next()) {
				resume_id=resultSet2.getString(1);
			}
			
			
			
			PreparedStatement preparedStatement = connection.prepareStatement("insert into resumes values(?,?)");
			preparedStatement.setInt(1,Integer.parseInt(resume_id));
			FileInputStream fileInputStream = new FileInputStream(file);
			preparedStatement.setBinaryStream(2,fileInputStream,(int)file.length());
		
			
			int k = preparedStatement.executeUpdate();
			if(k>=0) {
				pw.println("File uploaded");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*try {
			String sql= "select * from resumes";
			java.sql.Statement statement = connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next()) {
				String fileName = resultSet.getString("file_name");
				Blob blob = resultSet.getBlob("resume");
                InputStream inputStream = blob.getBinaryStream();
                int fileLength = inputStream.available();
                 
                System.out.println("fileLength = " + fileLength);
 
                ServletContext context = getServletContext(); // sets MIME type for the file download
                String mimeType = context.getMimeType(fileName);
                if (mimeType == null) {        
                    mimeType = "application/octet-stream";
                }              
                 
                // set content properties and header attributes for the response
                res.setContentType(mimeType);
                res.setContentLength(fileLength);
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
                res.setHeader(headerKey, headerValue);
 
                // writes the file to the client
                OutputStream outStream = res.getOutputStream();
                 
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
                 
                inputStream.close();
                outStream.close();             
            } else {
                // no file found
                res.getWriter().print("File not found" );  
            }
		}catch (SQLException ex) {
            ex.printStackTrace();
            res.getWriter().print("SQL Error: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            res.getWriter().print("IO Error: " + ex.getMessage());
        }*/
		
	}
}

<%@ page language="java" import="java.util.*,java.sql.*,com.jspsmart.upload.*" pageEncoding="gbk"%>
<%@page import="java.text.SimpleDateFormat"%>
<%		
	SmartUpload su = new SmartUpload();
	//��ʼ��SmartUpload����
	su.initialize(pageContext);
	com.jspsmart.upload.File file = null;
	//�����ϴ�����
	String allowed = "gif,jpg,doc,rar";
	//�����ϴ�����
	String denied = "jsp,asp,php,aspx,html,htm,exe,bat";
	com.jspsmart.upload.Request req  = null;
	//�����ϴ��ļ���С
	int file_size = 2*1024*1024;
	String exceptionMsg = null;
	int i = 0;
	try {
			//���������ϴ��ļ�����   
			su.setAllowedFilesList(allowed);
			//�������ϴ��ļ�����   
			su.setDeniedFilesList(denied);		
			//�����ļ��������   
			su.setMaxFileSize(file_size);						
			su.setCharset("GBK");
			//ִ���ϴ�
			su.upload();
			//�õ������ϴ��ļ�����Ϣ
			file = su.getFiles().getFile(0);
			String filepath = null;
			if(!file.isMissing()){
				//�����ļ��ڷ������ı���λ��
				filepath = "upload\\";
				filepath += file.getFileName();
				//�ļ����Ϊ   
				file.setCharset("gbk");
				
				System.out.println(filepath);
				
				file.saveAs(filepath, SmartUpload.SAVE_VIRTUAL);
			}
			
		} catch (Exception e) {
			exceptionMsg = e.getMessage();
			e.printStackTrace();
		}	

%>
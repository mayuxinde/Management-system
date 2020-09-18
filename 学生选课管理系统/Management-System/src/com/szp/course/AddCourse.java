package com.szp.course;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddCourse extends JFrame implements ActionListener{
	// 用于课程信息管理中增加或修改某条记录的界面
	JLabel lcno = new JLabel("课程号：");
	JLabel lcname = new JLabel("课程名：");
	JLabel lcteacher = new JLabel("任课老师：");
	JLabel lcplace = new JLabel("地点：");
	JLabel lctime = new JLabel("时间：");
	JLabel lccredit = new JLabel("学分：");
	JTextField tcno = new JTextField(10);
	JTextField tcname = new JTextField(10);
	JTextField tcteacher = new JTextField(10);
	JTextField tcplace = new JTextField(10);
	JTextField tctime = new JTextField(10);
	JTextField tccredit = new JTextField(10);
	JButton btnOK = new JButton("确定");
	JButton btnCancel = new JButton("取消");
	JPanel p = new JPanel();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean isNewsm = true;// 用于判断是否显示课程信息管理的界面
	int id =0;//通过此id修改课程信息

	public AddCourse(int id) {// 构造方法
		this.id=id;
		this.setTitle("增加");
		this.setBounds(200, 200, 346, 235);
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(lcno);
		p.add(tcno);
		p.add(lcname);
		p.add(tcname);
		p.add(lcteacher);
		p.add(tcteacher);
		
		p.add(lctime);
		p.add(tctime);
		
		p.add(lcplace);
		p.add(tcplace);
		
		p.add(lccredit);
		p.add(tccredit);
		
		p.add(btnOK);
		p.add(btnCancel);
		this.add(p);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOK.addActionListener(this);
		btnCancel.addActionListener(this);
		this.show();
	}
    public static final String url="jdbc:mysql://localhost:3306/courses?characterEncoding=utf-8";
	public void connDB() { // 连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url,"root", "root");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choosecourse?useUnicode=true&characterEncoding=utf-8&useSSL=false","root", "123456");
			
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeDB() // 关闭连接
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//ResultSet rset;
	//PreparedStatement psm;
	public void insertst() throws SQLException { // 插入记录
		String kch = null;
		String kcm = null;
        String xxkch=null;
		kch = tcno.getText();
		kcm = tcname.getText();
		//xxkch=tpcno.getText();
	
			if (this.getTitle() == "修改") {// 如果是修改记录，先删除再增加
				try {
					this.connDB();
					//rs = stmt.executeQuery("select id from courses where ")
					int rs1 = stmt.executeUpdate("UPDATE courses SET cid='"+kch+"',cname='"+kcm+"',cteacher='"+tcteacher.getText().trim()+"',cplace='"+tcplace.getText().trim()+"',ctime='"+tctime.getText().trim()+"',ccredit="+tccredit.getText().trim()+" where cid="+id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
			String str = "insert into Courses(cid,cname,cteacher,cplace,ctime,ccredit) values ('" + kch + "','" + kcm + "','"+tcteacher.getText()+"','"+tcplace.getText()+"','"+tctime.getText()+"',"+tccredit.getText()+")";
			this.connDB();// 连接数据库
			try {
				stmt.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "成功");
				this.setVisible(true);
			}

			catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "课程号已存在！");
				tcno.setText("");
				e.printStackTrace();
			}
			}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "确定") {
			try {
				this.insertst();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (isNewsm) {
				new CourseManager("课程信息管理").display();
			}
			isNewsm = true;
		}
		if (e.getActionCommand() == "取消") {
			this.setVisible(false);
			new CourseManager("课程信息管理").display();
		}

	}

}


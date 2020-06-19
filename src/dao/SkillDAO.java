package dao;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO
{
	static List<Skill> list=new ArrayList<Skill>();
	public List< Skill >listAllSkills() throws IOException, SQLException
	{
		Connection con =ConnectionManager.getConnection();
		
	          String skillquery="select * from SKILL order by NAME";
		PreparedStatement st = con.prepareStatement(skillquery);
        
		ResultSet rs = st.executeQuery();
		rs.next();
//		System.out.println(rs.next());
//		while(rs.next())
//		{
		Skill skill =new Skill(rs.getLong(1),rs.getString(2));
		
		list.add(skill);
//		}
		return list;
	}
	
	}

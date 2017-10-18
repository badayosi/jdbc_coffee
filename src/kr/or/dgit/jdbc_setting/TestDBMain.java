package kr.or.dgit.jdbc_setting;

import java.sql.Connection;

import kr.or.dgit.jdbc_setting.jdbc.DBCon;
import kr.or.dgit.jdbc_setting.jdbc.jdbcUtil;
import kr.or.dgit.jdbc_setting.service.DbService;
import kr.or.dgit.jdbc_setting.service.ExportService;
import kr.or.dgit.jdbc_setting.service.ImportService;
import kr.or.dgit.jdbc_setting.service.InitService;

public class TestDBMain {

	public static void main(String[] args) {
		DBCon dbCon = DBCon.getInstance();
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		DbService service = InitService.getInstance();
		service.service();
		service = ImportService.getInstance();
		service.service();
		service = ExportService.getInstance();
		service.service();
		
		jdbcUtil.close(connection);
		System.out.println("close!");
	}
}

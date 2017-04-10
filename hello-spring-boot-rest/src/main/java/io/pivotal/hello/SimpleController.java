package io.pivotal.hello;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	DBInfo dbInfo;
	
	public SimpleController (DBInfo dbInfo) {
		this.dbInfo = dbInfo;
	}
	
	@RequestMapping("/dbinfo")
	public DBInfo getInfo() {
		return this.dbInfo;
	}
	
}

@Component
class DBInfo {
	private String url;
	
	public DBInfo (DataSource dataSorce) throws SQLException {
		this.url = dataSorce.getConnection().getMetaData().getURL();
	}
	
	public String getUrl() {
		return url;
	}

}
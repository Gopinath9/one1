package com.mkyong.customer.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class CustomerResultSetExtractor implements ResultSetExtractor {
	
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = null;
		
		while (rs.next()) {
			customer = new Customer();
			customer.setCustId(rs.getInt("CUST_ID"));
			customer.setName(rs.getString("NAME"));
			customer.setAge(rs.getInt("AGE"));
			customers.add(customer);
		}

		return customers;
	}

}

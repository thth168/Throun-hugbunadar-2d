package com.hi.d.throbo.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WebMaster extends User {
    public WebMaster(ResultSet rs) throws SQLException{
        super(rs);
    }
}

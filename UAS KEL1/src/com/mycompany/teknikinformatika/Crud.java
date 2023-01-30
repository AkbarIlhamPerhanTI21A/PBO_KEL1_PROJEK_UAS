/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.teknikinformatika;

import java.sql.SQLException;

/**
 *
 * @author Kii
 */
public interface Crud {

    public boolean create() throws SQLException;

    public boolean update(Object id) throws SQLException;

    public boolean delete() throws SQLException;

    public void find(Object id) throws SQLException;

}

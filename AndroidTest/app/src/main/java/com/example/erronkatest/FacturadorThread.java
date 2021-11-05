/*package com.example.erronkatest;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Semaphore;

public class FacturadorThread extends Thread{
    Semaphore semaphore = new Semaphore(1,true);
    Factura factura;
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String Insert_sale_order_QUERY;
    String Get_max_id_QUERY="SELECT TOP 1 id from sale_order ORDER BY id DESC";
    String Insert_sale_order_line_QUERY;
    Integer max_id;
    Connection conn;
    Statement stmt;

    @Override
    public void run() {
        Log.i("facturas", "doInBackground: "+facturas[0]);
        factura = facturas[0];
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            try{
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(Get_max_id_QUERY);
                while (rs.next()) {
                    // Retrieve by column name
                    Log.i("TAG", "getArrayList: "+rs.getString("name"));
                    max_id = rs.getInt("id");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            insert_sale_order_hacerSQL();
            insert_sale_order_line_hacerSQL();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insert_sale_order_hacerSQL() throws InterruptedException {
        semaphore.acquire();
        Insert_sale_order_QUERY =  "insert into sale_order( require_signature, require_payment, partner_id," +
                "partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status," +
                "amount_untaxed, amount_tax, amount_total, currency_rate, company_id, team_id, " +
                "create_uid, write_uid, write_date, picking_policy, warehouse_id)" +
                "values (true, false, " + factura.persona.getID() + ", " + factura.persona.getID() + ", " +
                factura.persona.getID() + ", 1 , 1, 'mobileapp'"+(max_id+1)+",'draft', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "'no', " + factura.precio + ","+(factura.precio *0.21)+" , " + (factura.precio*1.21) + ", 1, 1, 1, 2, 2, " +
                "CURRENT_TIMESTAMP, 'direct', 1)";
        try {
            stmt.executeUpdate(Insert_sale_order_QUERY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        semaphore.release();
    }

    public void insert_sale_order_line_hacerSQL() throws InterruptedException {
        semaphore.acquire();
        Insert_sale_order_line_QUERY = "insert into sale_order_line(order_id, name, sequence, invoice_status, " +
                "price_unit,price_subtotal, price_total, price_reduce, price_reduce_taxinc, " +
                "price_reduce_taxexcl, discount, product_id, product_uom, product_uom_qty, " +
                "qty_delivered_method, qty_delivered, qty_delivered_manual, qty_to_invoice, " +
                "qty_invoiced,untaxed_amount_invoiced, untaxed_amount_to_invoice, currency_id, " +
                "company_id, order_partner_id, state, customer_lead, create_uid, create_date, " +
                "write_uid, write_date)" +
                "values(" + (max_id+1) + ", '" + factura.producto.getName() +
                "' , 10, 'no', " + factura.producto.getList_price() + ", " + factura.precio +
                ", " + factura.precio + ", " + factura.precio + ", " + factura.precio +
                ", " + factura.precio + ", 0, " + factura.producto.getID() + ", 1, " +
                factura.getCantidad() + ", 'stock_move', 0, 0, 0, 0, 0, " + factura.precio +
                ", 1, 1, " + factura.persona.getID() + ", 'draft', 0, 2, CURRENT_TIMESTAMP, 2, " +
                "CURRENT_TIMESTAMP)";
        try {
            stmt.executeUpdate(Insert_sale_order_QUERY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        semaphore.release();
    }
}
*/
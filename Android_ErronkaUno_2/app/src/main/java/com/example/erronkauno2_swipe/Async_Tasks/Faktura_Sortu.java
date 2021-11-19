package com.example.erronkauno2_swipe.Async_Tasks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;

import com.example.erronkauno2_swipe.Classes.Factura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Semaphore;

public class Faktura_Sortu extends AsyncTask<Factura,Void,Void> {
    Semaphore semaphore = new Semaphore(1,true);
    Factura factura;
    String DB_URL = "jdbc:postgresql://192.168.65.21/ErronkaUno";
    String USER = "openpg";
    String PASS = "openpgpwd";
    String Insert_sale_order_QUERY;
    String Get_max_id_QUERY="SELECT MAX(id) as id FROM sale_order";
    String Insert_sale_order_line_QUERY;
    Integer max_id;
    Connection conn;
    Statement stmt;
    @SuppressLint("StaticFieldLeak")
    ViewGroup this_view;
    AlertDialog.Builder alerta;

    public Faktura_Sortu(ViewGroup this_view)
    {
        this.this_view = this_view;
    }

    @Override
    protected Void doInBackground(Factura... facturas) {
        alerta = new AlertDialog.Builder(this_view.getContext());

        factura = facturas[0];
        try {
            doConnection();
            insert_sale_order_hacerSQL();
            insert_sale_order_line_hacerSQL();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void doConnection() throws InterruptedException {
        semaphore.acquire();
        try {

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            try{
                stmt = conn.createStatement();
                ResultSet  rs = stmt.executeQuery(Get_max_id_QUERY);
                while (rs.next()) {
                    // Retrieve by column name
                    max_id = rs.getInt("id");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }

    public void insert_sale_order_hacerSQL() throws InterruptedException {
        semaphore.acquire();
        Insert_sale_order_QUERY =  "insert into sale_order( require_signature, require_payment, partner_id," +
                "partner_invoice_id, partner_shipping_id, pricelist_id, currency_id," +
                "name, state, date_order, create_date, invoice_status," +
                "amount_untaxed, amount_tax, amount_total, currency_rate, company_id, team_id, " +
                "create_uid, write_uid, write_date, picking_policy, warehouse_id)" +
                "values (true, false, " + factura.getPersona().getID() + ", " + factura.getPersona().getID() + ", " +
                factura.getPersona().getID() + ", 1 , 1, 'mobileapp"+(max_id+1)+"','draft', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, " +
                "'no', " + factura.getPrecio() + ","+(factura.getPrecio() *0.21)+" , " + (factura.getPrecio()*1.21) + ", 1, 1, 1, 2, 2, " +
                "CURRENT_TIMESTAMP, 'direct', 1)";
        try {
            stmt.executeUpdate(Insert_sale_order_QUERY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.i("TAG", "insert_sale_order_hacerSQL: "+throwables);
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
                "values(" + (max_id+1) + ", '" + factura.getProducto().getName() +
                "' , 10, 'no', " + factura.getProducto().getList_price() + ", " + factura.getPrecio() +
                ", " + factura.getPrecio() + ", " + factura.getPrecio() + ", " + factura.getPrecio() +
                ", " + factura.getPrecio() + ", 0, " + factura.getProducto().getID() + ", 1, " +
                factura.getCantidad() + ", 'stock_move', 0, 0, 0, 0, 0, " + factura.getPrecio() +
                ", 1, 1, " + factura.getPersona().getID() + ", 'draft', 0, 2, CURRENT_TIMESTAMP, 2, " +
                "CURRENT_TIMESTAMP)";
        try {
            stmt.executeUpdate(Insert_sale_order_line_QUERY);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        semaphore.release();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }
}

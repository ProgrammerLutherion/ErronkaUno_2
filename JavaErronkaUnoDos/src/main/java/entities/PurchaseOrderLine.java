package entities;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the purchase_order_line database table.
 * 
 */
@Entity
@Table(name="purchase_order_line")
@NamedQuery(name="PurchaseOrderLine.findAll", query="SELECT p FROM PurchaseOrderLine p")
public class PurchaseOrderLine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="account_analytic_id")
	private Integer accountAnalyticId;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	@Column(name="date_planned")
	private Timestamp datePlanned;

	@Column(name="display_type")
	private String displayType;

	private String name;

	@Column(name="orderpoint_id")
	private Integer orderpointId;

	@Column(name="price_subtotal")
	private BigDecimal priceSubtotal;

	@Column(name="price_tax")
	private double priceTax;

	@Column(name="price_total")
	private BigDecimal priceTotal;

	@Column(name="price_unit")
	private BigDecimal priceUnit;

	@Column(name="product_description_variants")
	private String productDescriptionVariants;

	@Column(name="product_id")
	private Integer productId;

	@Column(name="product_qty")
	private int productQty;

	@Column(name="product_uom")
	private Integer productUom;

	@Column(name="product_uom_qty")
	private double productUomQty;

	@Column(name="propagate_cancel")
	private Boolean propagateCancel;

	@Column(name="qty_invoiced")
	private BigDecimal qtyInvoiced;

	@Column(name="qty_received")
	private BigDecimal qtyReceived;

	@Column(name="qty_received_manual")
	private BigDecimal qtyReceivedManual;

	@Column(name="qty_received_method")
	private String qtyReceivedMethod;

	@Column(name="qty_to_invoice")
	private BigDecimal qtyToInvoice;

	@Column(name="sale_line_id")
	private Integer saleLineId;

	private Integer sequence;

	private String state;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to PurchaseOrder
	@ManyToOne
	@JoinColumn(name="order_id")
	private PurchaseOrder purchaseOrder;

	//bi-directional many-to-one association to ResPartner
	@ManyToOne
	@JoinColumn(name="partner_id")
	private ResPartner resPartner;

	//bi-directional many-to-one association to SaleOrder
	@ManyToOne
	@JoinColumn(name="sale_order_id")
	private SaleOrder saleOrder;

	public PurchaseOrderLine() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountAnalyticId() {
		return this.accountAnalyticId;
	}

	public void setAccountAnalyticId(Integer accountAnalyticId) {
		this.accountAnalyticId = accountAnalyticId;
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUid() {
		return this.createUid;
	}

	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	public Integer getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	public Timestamp getDatePlanned() {
		return this.datePlanned;
	}

	public void setDatePlanned(Timestamp datePlanned) {
		this.datePlanned = datePlanned;
	}

	public String getDisplayType() {
		return this.displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderpointId() {
		return this.orderpointId;
	}

	public void setOrderpointId(Integer orderpointId) {
		this.orderpointId = orderpointId;
	}

	public BigDecimal getPriceSubtotal() {
		return this.priceSubtotal;
	}

	public void setPriceSubtotal(BigDecimal priceSubtotal) {
		this.priceSubtotal = priceSubtotal;
	}

	public double getPriceTax() {
		return this.priceTax;
	}

	public void setPriceTax(double priceTax) {
		this.priceTax = priceTax;
	}

	public BigDecimal getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public BigDecimal getPriceUnit() {
		return this.priceUnit;
	}

	public void setPriceUnit(BigDecimal priceUnit) {
		this.priceUnit = priceUnit;
	}

	public String getProductDescriptionVariants() {
		return this.productDescriptionVariants;
	}

	public void setProductDescriptionVariants(String productDescriptionVariants) {
		this.productDescriptionVariants = productDescriptionVariants;
	}

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public int getProductQty() {
		return this.productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public Integer getProductUom() {
		return this.productUom;
	}

	public void setProductUom(Integer productUom) {
		this.productUom = productUom;
	}

	public double getProductUomQty() {
		return this.productUomQty;
	}

	public void setProductUomQty(double productUomQty) {
		this.productUomQty = productUomQty;
	}

	public Boolean getPropagateCancel() {
		return this.propagateCancel;
	}

	public void setPropagateCancel(Boolean propagateCancel) {
		this.propagateCancel = propagateCancel;
	}

	public BigDecimal getQtyInvoiced() {
		return this.qtyInvoiced;
	}

	public void setQtyInvoiced(BigDecimal qtyInvoiced) {
		this.qtyInvoiced = qtyInvoiced;
	}

	public BigDecimal getQtyReceived() {
		return this.qtyReceived;
	}

	public void setQtyReceived(BigDecimal qtyReceived) {
		this.qtyReceived = qtyReceived;
	}

	public BigDecimal getQtyReceivedManual() {
		return this.qtyReceivedManual;
	}

	public void setQtyReceivedManual(BigDecimal qtyReceivedManual) {
		this.qtyReceivedManual = qtyReceivedManual;
	}

	public String getQtyReceivedMethod() {
		return this.qtyReceivedMethod;
	}

	public void setQtyReceivedMethod(String qtyReceivedMethod) {
		this.qtyReceivedMethod = qtyReceivedMethod;
	}

	public BigDecimal getQtyToInvoice() {
		return this.qtyToInvoice;
	}

	public void setQtyToInvoice(BigDecimal qtyToInvoice) {
		this.qtyToInvoice = qtyToInvoice;
	}

	public Integer getSaleLineId() {
		return this.saleLineId;
	}

	public void setSaleLineId(Integer saleLineId) {
		this.saleLineId = saleLineId;
	}

	public Integer getSequence() {
		return this.sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getWriteDate() {
		return this.writeDate;
	}

	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}

	public Integer getWriteUid() {
		return this.writeUid;
	}

	public void setWriteUid(Integer writeUid) {
		this.writeUid = writeUid;
	}

	public PurchaseOrder getPurchaseOrder() {
		return this.purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public ResPartner getResPartner() {
		return this.resPartner;
	}

	public void setResPartner(ResPartner resPartner) {
		this.resPartner = resPartner;
	}

	public SaleOrder getSaleOrder() {
		return this.saleOrder;
	}

	public void setSaleOrder(SaleOrder saleOrder) {
		this.saleOrder = saleOrder;
	}

}
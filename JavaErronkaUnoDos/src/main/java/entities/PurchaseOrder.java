package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the purchase_order database table.
 * 
 */
@Entity
@Table(name="purchase_order")
@NamedQuery(name="PurchaseOrder.findAll", query="SELECT p FROM PurchaseOrder p")
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="access_token")
	private String accessToken;

	@Column(name="amount_tax")
	private BigDecimal amountTax;

	@Column(name="amount_total")
	private long amountTotal;

	@Column(name="amount_untaxed")
	private BigDecimal amountUntaxed;

	@Column(name="company_id")
	private Integer companyId;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_uid")
	private Integer createUid;

	@Column(name="currency_id")
	private Integer currencyId;

	@Column(name="currency_rate")
	private double currencyRate;

	@Column(name="date_approve")
	private Timestamp dateApprove;

	@Column(name="date_calendar_start")
	private Timestamp dateCalendarStart;

	@Column(name="date_order")
	private Timestamp dateOrder;

	@Column(name="date_planned")
	private Timestamp datePlanned;

	@Column(name="dest_address_id")
	private Integer destAddressId;

	@Column(name="effective_date")
	private Timestamp effectiveDate;

	@Column(name="fiscal_position_id")
	private Integer fiscalPositionId;

	@Column(name="group_id")
	private Integer groupId;

	@Column(name="incoterm_id")
	private Integer incotermId;

	@Column(name="invoice_count")
	private Integer invoiceCount;

	@Column(name="invoice_status")
	private String invoiceStatus;

	@Column(name="mail_reception_confirmed")
	private Boolean mailReceptionConfirmed;

	@Column(name="mail_reminder_confirmed")
	private Boolean mailReminderConfirmed;

	@Column(name="message_main_attachment_id")
	private Integer messageMainAttachmentId;

	private String name;

	private String notes;

	private String origin;

	@Column(name="partner_id")
	private Integer partnerId;

	@Column(name="partner_ref")
	private String partnerRef;

	@Column(name="payment_term_id")
	private Integer paymentTermId;

	@Column(name="picking_count")
	private Integer pickingCount;

	@Column(name="picking_type_id")
	private Integer pickingTypeId;

	private String priority;

	private String state;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="write_date")
	private Timestamp writeDate;

	@Column(name="write_uid")
	private Integer writeUid;

	//bi-directional many-to-one association to PurchaseOrderLine
	@OneToMany(mappedBy="purchaseOrder")
	private List<PurchaseOrderLine> purchaseOrderLines;

	public PurchaseOrder() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public BigDecimal getAmountTax() {
		return this.amountTax;
	}

	public void setAmountTax(BigDecimal amountTax) {
		this.amountTax = amountTax;
	}

	public long getAmountTotal() {
		return this.amountTotal;
	}

	public void setAmountTotal(long amountTotal) {
		this.amountTotal = amountTotal;
	}

	public BigDecimal getAmountUntaxed() {
		return this.amountUntaxed;
	}

	public void setAmountUntaxed(BigDecimal amountUntaxed) {
		this.amountUntaxed = amountUntaxed;
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

	public double getCurrencyRate() {
		return this.currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	public Timestamp getDateApprove() {
		return this.dateApprove;
	}

	public void setDateApprove(Timestamp dateApprove) {
		this.dateApprove = dateApprove;
	}

	public Timestamp getDateCalendarStart() {
		return this.dateCalendarStart;
	}

	public void setDateCalendarStart(Timestamp dateCalendarStart) {
		this.dateCalendarStart = dateCalendarStart;
	}

	public Timestamp getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public Timestamp getDatePlanned() {
		return this.datePlanned;
	}

	public void setDatePlanned(Timestamp datePlanned) {
		this.datePlanned = datePlanned;
	}

	public Integer getDestAddressId() {
		return this.destAddressId;
	}

	public void setDestAddressId(Integer destAddressId) {
		this.destAddressId = destAddressId;
	}

	public Timestamp getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Integer getFiscalPositionId() {
		return this.fiscalPositionId;
	}

	public void setFiscalPositionId(Integer fiscalPositionId) {
		this.fiscalPositionId = fiscalPositionId;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getIncotermId() {
		return this.incotermId;
	}

	public void setIncotermId(Integer incotermId) {
		this.incotermId = incotermId;
	}

	public Integer getInvoiceCount() {
		return this.invoiceCount;
	}

	public void setInvoiceCount(Integer invoiceCount) {
		this.invoiceCount = invoiceCount;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Boolean getMailReceptionConfirmed() {
		return this.mailReceptionConfirmed;
	}

	public void setMailReceptionConfirmed(Boolean mailReceptionConfirmed) {
		this.mailReceptionConfirmed = mailReceptionConfirmed;
	}

	public Boolean getMailReminderConfirmed() {
		return this.mailReminderConfirmed;
	}

	public void setMailReminderConfirmed(Boolean mailReminderConfirmed) {
		this.mailReminderConfirmed = mailReminderConfirmed;
	}

	public Integer getMessageMainAttachmentId() {
		return this.messageMainAttachmentId;
	}

	public void setMessageMainAttachmentId(Integer messageMainAttachmentId) {
		this.messageMainAttachmentId = messageMainAttachmentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Integer getPartnerId() {
		return this.partnerId;
	}

	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerRef() {
		return this.partnerRef;
	}

	public void setPartnerRef(String partnerRef) {
		this.partnerRef = partnerRef;
	}

	public Integer getPaymentTermId() {
		return this.paymentTermId;
	}

	public void setPaymentTermId(Integer paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public Integer getPickingCount() {
		return this.pickingCount;
	}

	public void setPickingCount(Integer pickingCount) {
		this.pickingCount = pickingCount;
	}

	public Integer getPickingTypeId() {
		return this.pickingTypeId;
	}

	public void setPickingTypeId(Integer pickingTypeId) {
		this.pickingTypeId = pickingTypeId;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public List<PurchaseOrderLine> getPurchaseOrderLines() {
		return this.purchaseOrderLines;
	}

	public void setPurchaseOrderLines(List<PurchaseOrderLine> purchaseOrderLines) {
		this.purchaseOrderLines = purchaseOrderLines;
	}

	public PurchaseOrderLine addPurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().add(purchaseOrderLine);
		purchaseOrderLine.setPurchaseOrder(this);

		return purchaseOrderLine;
	}

	public PurchaseOrderLine removePurchaseOrderLine(PurchaseOrderLine purchaseOrderLine) {
		getPurchaseOrderLines().remove(purchaseOrderLine);
		purchaseOrderLine.setPurchaseOrder(null);

		return purchaseOrderLine;
	}

}